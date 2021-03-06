package io.ddd.framework.application.sys.roleofmenu.command.query;

import io.ddd.framework.application.sys.roleofmenu.assembler.RoleOfMenu2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.RoleOfMenuDTO;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.RoleOfMenuPageQry;
import io.ddd.framework.domain.domain.sys.RoleOfMenu;
import io.ddd.framework.domain.repository.sys.RoleOfMenuRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-11-19 14:47:31
 */
@Component
public class RoleOfMenuPageQryExe {

    @Resource
    private RoleOfMenuRepository roleOfMenuRepository;
    @Resource
    private RoleOfMenu2DTOAssembler roleOfMenu2DTOAssembler;

    public PageResponse<RoleOfMenuDTO> execute(RoleOfMenuPageQry qry) {
        Page<RoleOfMenu> page = roleOfMenuRepository.page(qry);
        return PageResponse.of(roleOfMenu2DTOAssembler.toDTOPage(page));
    }

}

