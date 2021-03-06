package io.ddd.framework.infrastructure.repositoryimpl.sys.database.convertor;

import io.ddd.framework.domain.domain.sys.RoleOfMenu;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.RoleOfMenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-12-03 17:39:58
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleOfMenu2DOMapStruct {

    RoleOfMenu2DOMapStruct INSTANCE = Mappers.getMapper(RoleOfMenu2DOMapStruct.class);

    @Mappings({})
    RoleOfMenuDO toDO(RoleOfMenu roleOfMenu);


    List<RoleOfMenuDO> toDOList(List<RoleOfMenu> roleOfMenuList);

    @Mappings({})
    RoleOfMenu toDomain(RoleOfMenuDO roleOfMenuDO);


    List<RoleOfMenu> toDomainList(List<RoleOfMenuDO> roleOfMenuDOList);
}
