package io.ddd.framework.application.application.sys.role.command;

import io.ddd.framework.application.application.sys.role.assembler.Role2DTOAssembler;
import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.Role;
import io.ddd.framework.domain.domain.sys.RoleOfMenu;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.role.RoleAddCmd;
import io.ddd.framework.domain.factory.sys.RoleOfMenuFactory;
import io.ddd.framework.domain.repository.sys.RoleRepository;
import io.ddd.framework.domain.repository.sys.RoleOfMenuRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 角色表
 * @author mikey
 * @date 2021-11-17 14:27:15
 */
@Component
public class RoleAddCmdExe {
    @Resource
    private RoleRepository roleRepository;
    @Resource
    private RoleOfMenuRepository roleOfMenuRepository;
    @Resource
    private Role2DTOAssembler role2DTOAssembler;

    public Response execute(RoleAddCmd cmd) {
        Role role = role2DTOAssembler.toDomain(cmd.getRoleDTO());
        role.create(UserThreadContext.get());
        roleRepository.create(role);
        cmd.getRoleDTO().getMenuList().forEach(v->{
            RoleOfMenu roleOfMenu = RoleOfMenuFactory.getRoleOfMenu();
            roleOfMenu.create(UserThreadContext.get(),role.getUuid(),v);
            roleOfMenuRepository.create(roleOfMenu);
        });
        return Response.success();
    }
}
