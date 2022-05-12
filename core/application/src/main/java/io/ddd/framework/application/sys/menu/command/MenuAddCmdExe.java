package io.ddd.framework.application.sys.menu.command;

import io.ddd.framework.application.sys.menu.assembler.Menu2DTOAssembler;
import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.Menu;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.menu.MenuAddCmd;
import io.ddd.framework.domain.repository.sys.MenuRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 菜单表
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Component
public class MenuAddCmdExe {

    @Resource
    private MenuRepository menuRepository;
    @Resource
    private Menu2DTOAssembler menu2DTOAssembler;

    public Response execute(MenuAddCmd cmd) {
        Menu menu = menu2DTOAssembler.toDomain(cmd.getMenuDTO());
        menu.create(UserThreadContext.get());
        menu.validate();
        menuRepository.create(menu);
        return Response.success();
    }
}
