package io.ddd.framework.application.sys.roleofmenu.command.query;

import io.ddd.framework.application.sys.roleofmenu.assembler.RoleOfMenu2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.RoleOfMenuDTO;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.RoleOfMenuListQry;
import io.ddd.framework.domain.domain.sys.RoleOfMenu;
import io.ddd.framework.domain.repository.sys.RoleOfMenuRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-11-19 14:47:31
 */
@Component
public class RoleOfMenuListQryExe {

    @Resource
    private RoleOfMenuRepository roleOfMenuRepository;
    @Resource
    private RoleOfMenu2DTOAssembler roleOfMenu2DTOAssembler;

    public MultiResponse<RoleOfMenuDTO> execute(RoleOfMenuListQry qry) {
        List<RoleOfMenu> roleOfMenuList = roleOfMenuRepository.list(qry);
        return MultiResponse.of(roleOfMenu2DTOAssembler.toDTOList(roleOfMenuList));
    }

}

