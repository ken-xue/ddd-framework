package io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import io.ddd.framework.domain.common.CommonEntity;
import lombok.Data;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@TableName("sys_dictionary")
public class DictionaryDO extends CommonEntity {
    /**
     * 查询的key
     */
    private String uniqueKey;
    /**
     * 字典值
     */
    private String value;
    /**
     * 备注
     */
    private String remark;
    /**
     * 是否可更改
     */
    private Integer fixed;
}
