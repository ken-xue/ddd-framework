package io.ddd.framework.codegenerator.handler;

import io.ddd.framework.codegenerator.constant.Constant;
import io.ddd.framework.codegenerator.database.ColumnDO;
import io.ddd.framework.codegenerator.database.TableDO;
import io.ddd.framework.codegenerator.mapper.CodeGeneratorMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: 麦奇
 * @Date: 21-11-13 下午7:58
 * @Desc: 代码生成器
 */
@Component
@Slf4j
public class CodeGeneratorHandler {

    @Resource
    private CodeGeneratorMapper codeGeneratorMapper;

    public void execute(Configuration configuration) {
        //2.查询表结构
        Map<String, String> table = codeGeneratorMapper.queryTable(configuration.getString("tableName"));
        //3.查询列信息
        List<Map<String, String>> columns = codeGeneratorMapper.queryColumns(configuration.getString("tableName"));
        //4.排除字段
        List<String> exclude = Arrays.asList(configuration.getStringArray("exclude"));
        columns.removeIf(map -> exclude.contains(map.get("columnName")));
        //5.生成文件
        generatorCode(table, columns, configuration);
    }


    public void generatorCode(Map<String, String> table, List<Map<String, String>> columns, Configuration config) {
        //配置信息
        boolean hasBigDecimal = false;
        boolean hasList = false;
        //表信息
        TableDO tableDO = new TableDO();
        tableDO.setTableName(table.get("tableName"));
        tableDO.setComments(table.get("tableComment"));
        //表名转换成Java类名
        String className = table2Java(tableDO.getTableName(), config.getStringArray("tablePrefix"));
        tableDO.setClassName(className);
        tableDO.setClassname(StringUtils.uncapitalize(className));
        tableDO.setAllLowName(StringUtils.lowerCase(className));
        //列信息
        List<ColumnDO> columsList = new ArrayList<>();
        for (Map<String, String> column : columns) {
            ColumnDO columnDO = new ColumnDO();
            columnDO.setColumnName(column.get("columnName"));
            columnDO.setDataType(column.get("dataType"));
            columnDO.setComments(column.get("columnComment"));
            columnDO.setExtra(column.get("extra"));
            //列名转换成Java属性名
            String attrName = column2Java(columnDO.getColumnName());
            columnDO.setAttrName(attrName);
            columnDO.setAttrname(StringUtils.uncapitalize(attrName));

            //列的数据类型，转换成Java类型
            String attrType = config.getString(columnDO.getDataType(), column2Java(columnDO.getDataType()));
            columnDO.setAttrType(attrType);

            if (!hasBigDecimal && attrType.equals("BigDecimal")) {
                hasBigDecimal = true;
            }
            if (!hasList && "array".equals(columnDO.getExtra())) {
                hasList = true;
            }
            //是否主键
            if ("PRI".equalsIgnoreCase(column.get("columnKey")) && tableDO.getPk() == null) {
                tableDO.setPk(columnDO);
            }

            columsList.add(columnDO);
        }
        tableDO.setColumns(columsList);

        //没主键，则第一个字段为主键
        if (tableDO.getPk() == null) {
            tableDO.setPk(tableDO.getColumns().get(0));
        }

        //设置velocity资源加载器
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        Velocity.init(prop);
        //封装模板数据
        Map<String, Object> map = new HashMap<>();
        map.put("tableName", tableDO.getTableName());
        map.put("comments", tableDO.getComments());
        map.put("pk", tableDO.getPk());
        map.put("className", tableDO.getClassName());
        map.put("classname", tableDO.getClassname());
        map.put("allLowName", tableDO.getAllLowName());
        map.put("pathName", tableDO.getClassname().toLowerCase());
        map.put("columns", tableDO.getColumns());
        map.put("hasBigDecimal", hasBigDecimal);
        map.put("hasList", hasList);
        map.put("package", config.getString("package"));
        map.put("moduleName", config.getString("moduleName"));
        map.put("author", config.getString("author"));
        map.put("email", config.getString("email"));
        map.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        VelocityContext context = new VelocityContext(map);

        //获取模板列表
        Map<String, String> templates = Constant.getTemplates();
        List fileNames = new ArrayList<String>();
        for (String template : templates.keySet()) {
            //渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate("template/" + template, "UTF-8");
            tpl.merge(context, sw);
            try {
                String fileAbsolutePath = templates.get(template)
                        .replace("{moduleName}", config.getString("moduleName"))
                        .replace("{classLowName}",tableDO.getAllLowName())
                        + template.replace(".vm", "")
                        .replace("Domain", tableDO.getClassName());
                //判断文件夹是否存在,不存在则创建
                String sourcePath = config.getString("sourcePath");
                String dir = fileAbsolutePath.substring(0, fileAbsolutePath.lastIndexOf("/"));
                if (StringUtils.isNotBlank(sourcePath)){
                    if (sourcePath.charAt(sourcePath.length()-1)!='/')sourcePath+="/";
                    dir = sourcePath+dir;
                }
                File folder = new File(dir);
                if (!folder.exists())folder.mkdirs();
                fileNames.add(fileAbsolutePath);
                IOUtils.write(sw.toString(), new FileOutputStream(fileAbsolutePath), "UTF-8");
                IOUtils.closeQuietly(sw);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        storeFileNames(fileNames);
    }


    /**
     * 列名转换成Java属性名
     */
    public String column2Java(String columnName) {
        return WordUtils.capitalizeFully(columnName, new char[]{'_'}).replace("_", "");
    }

    /**
     * 表名转换成Java类名
     */
    public String table2Java(String tableName, String[] tablePrefixArray) {
        if (null != tablePrefixArray && tablePrefixArray.length > 0) {
            for (String tablePrefix : tablePrefixArray) {
                if (tableName.startsWith(tablePrefix)) {
                    tableName = tableName.replaceFirst(tablePrefix, "");
                }
            }
        }
        return column2Java(tableName);
    }


    private void storeFileNames(List<String> fileNames) {
        try {
            FileWriter fw = new FileWriter("/tmp/fileNameList.txt");
            for (String s : fileNames) {
                s="/Users/biaoyang/IdeaProjects/ddd-framework"+s.replace("..","");
                fw.write(s+"\n");
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除上次生成的文件
     * @return
     */
    public void deleteGenFile() {
        try {
            FileInputStream inputStream = new FileInputStream("/tmp/fileNameList.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String fileName = null;
            while ((fileName = bufferedReader.readLine()) != null) {
                File file = new File(fileName);
                if (!file.exists()) {
                    log.error("删除文件失败：{} 文件不存在", fileName);
                } else {
                    file.delete();
                }
            }
            inputStream.close();
            bufferedReader.close();
        }catch (Exception e){
            log.error("执行删除异常：{} ", e.getMessage());
        }
    }
}

