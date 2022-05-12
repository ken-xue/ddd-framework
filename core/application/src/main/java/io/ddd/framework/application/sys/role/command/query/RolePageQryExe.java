package io.ddd.framework.application.sys.role.command.query;

import io.ddd.framework.application.sys.role.assembler.Role2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.sys.role.RoleDTO;
import io.ddd.framework.coreclient.dto.sys.role.RolePageQry;
import io.ddd.framework.domain.domain.sys.Role;
import io.ddd.framework.domain.repository.sys.RoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 角色表
 * @author mikey
 * @date 2021-11-17 14:27:15
 */
@Component
public class RolePageQryExe {

    @Resource
    private RoleRepository roleRepository;
    @Resource
    private Role2DTOAssembler role2DTOAssembler;

    public PageResponse<RoleDTO> execute(RolePageQry qry) {
        Page<Role> page = roleRepository.page(qry);
        return PageResponse.of(role2DTOAssembler.toDTOPage(page));
    }

}

