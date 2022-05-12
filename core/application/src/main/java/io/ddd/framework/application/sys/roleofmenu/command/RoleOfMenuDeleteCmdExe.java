package io.ddd.framework.application.sys.roleofmenu.command;

import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.RoleOfMenu;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.RoleOfMenuDeleteCmd;
import io.ddd.framework.domain.repository.sys.RoleOfMenuRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-11-19 14:47:31
 */
@Component
public class RoleOfMenuDeleteCmdExe {
    @Resource
    private RoleOfMenuRepository roleOfMenuRepository;

    public Response execute(RoleOfMenuDeleteCmd cmd) {
        RoleOfMenu roleOfMenu = roleOfMenuRepository.getById(cmd.getId());
        roleOfMenu.deleted(UserThreadContext.get());
        roleOfMenuRepository.update(roleOfMenu);
        return Response.success();
    }
}
