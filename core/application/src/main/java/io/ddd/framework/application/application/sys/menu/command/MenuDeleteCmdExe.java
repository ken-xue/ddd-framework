package io.ddd.framework.application.application.sys.menu.command;

import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.Menu;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.menu.MenuDeleteCmd;
import io.ddd.framework.domain.repository.sys.MenuRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * 菜单表
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Component
public class MenuDeleteCmdExe {
    @Resource
    private MenuRepository menuRepository;

    public Response execute(MenuDeleteCmd cmd) {
        Stream.of(cmd.getIds()).forEach(id->{
            Menu menu = menuRepository.getById(id);
            menu.deleted(UserThreadContext.get());
            menuRepository.update(menu);
        });
        return Response.success();
    }
}
