package io.ddd.framework.codegenerator.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    /**
     * 获取模板
     * @return
     */
    public static Map<String, String> getTemplates() {
        //key:模板路径,value:生成后的路径
        Map<String, String> templates = new HashMap<>();
        templates.put("DomainMenu.sql.vm", "core/infrastructure/src/main/resources/script/");
        templates.put("Domain.java.vm", "core/domain/src/main/java/io/ddd/framework/domain/domain/{moduleName}/");
        //exe
        templates.put("DomainAddCmdExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/");
        templates.put("DomainDeleteCmdExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/");
        templates.put("DomainGetQryExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/query/");
        templates.put("DomainListQryExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/query/");
        templates.put("DomainUpdateCmdExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/");
        templates.put("DomainPageQryExe.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/command/query/");
        //service
        templates.put("DomainAppAppServiceImpl.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/service/");
        templates.put("DomainAppService.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/api/{moduleName}/");
        //dto
        templates.put("DomainDTO.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        //do
        templates.put("DomainDO.java.vm", "core/infrastructure/src/main/java/io/ddd/framework/infrastructure/repositoryimpl/{moduleName}/database/dataobject/");
        //Repository
        templates.put("DomainRepository.java.vm", "core/domain/src/main/java/io/ddd/framework/domain/repository/{moduleName}/");
        templates.put("DomainRepositoryImpl.java.vm", "core/infrastructure/src/main/java/io/ddd/framework/infrastructure/repositoryimpl/{moduleName}/");
        //mapper
        templates.put("DomainMapper.java.vm", "core/infrastructure/src/main/java/io/ddd/framework/infrastructure/repositoryimpl/{moduleName}/database/mapper/");
        templates.put("DomainMapper.xml.vm", "core/infrastructure/src/main/resources/mybatis/");
        //controller
        templates.put("DomainController.java.vm", "core/adapter/src/main/java/io/ddd/framework/adapter/rest/{moduleName}/");
        //cmd
        templates.put("DomainAddCmd.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        templates.put("DomainDeleteCmd.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        templates.put("DomainUpdateCmd.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        templates.put("DomainPageQry.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        templates.put("DomainListQry.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        templates.put("DomainGetQry.java.vm", "core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/");
        //domain factory
        templates.put("DomainFactory.java.vm", "core/domain/src/main/java/io/ddd/framework/domain/factory/{moduleName}/");
        //do convert
        templates.put("Domain2DOConvector.java.vm", "core/infrastructure/src/main/java/io/ddd/framework/infrastructure/repositoryimpl/{moduleName}/database/convertor/");
        templates.put("Domain2DOMapStruct.java.vm", "core/infrastructure/src/main/java/io/ddd/framework/infrastructure/repositoryimpl/{moduleName}/database/convertor/");
        //dto assembler
        templates.put("Domain2DTOAssembler.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/assembler/");
        templates.put("Domain2DTOMapStruct.java.vm", "core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/assembler/");
        //event handler
        templates.put("DomainDeleteEventHandler.java.vm","core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/handler/");
        templates.put("DomainUpdateEventHandler.java.vm","core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/handler/");
        templates.put("DomainCreateEventHandler.java.vm","core/application/src/main/java/io/ddd/framework/application/application/{moduleName}/{classLowName}/handler/");
        //event
        templates.put("DomainCreateEvent.java.vm","core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/event/");
        templates.put("DomainDeleteEvent.java.vm","core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/event/");
        templates.put("DomainUpdateEvent.java.vm","core/core-client/src/main/java/io/ddd/framework/coreclient/dto/{moduleName}/{classLowName}/event/");
        return templates;
    }

}
