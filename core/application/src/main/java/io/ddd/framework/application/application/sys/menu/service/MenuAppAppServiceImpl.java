package io.ddd.framework.application.application.sys.menu.service;

import io.ddd.framework.application.application.sys.menu.command.MenuAddCmdExe;
import io.ddd.framework.application.application.sys.menu.command.MenuDeleteCmdExe;
import io.ddd.framework.application.application.sys.menu.command.MenuUpdateCmdExe;
import io.ddd.framework.application.application.sys.menu.command.query.*;
import io.ddd.framework.coreclient.api.sys.MenuAppService;
import io.ddd.framework.coreclient.dto.sys.menu.*;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 菜单表
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Service
public class MenuAppAppServiceImpl implements MenuAppService {
    @Resource
    private MenuAddCmdExe menuAddCmdExe;
    @Resource
    private MenuUpdateCmdExe menuUpdateCmdExe;
    @Resource
    private MenuGetQryExe menuGetQryExe;
    @Resource
    private MenuListQryExe menuListQryExe;
    @Resource
    private MenuPageQryExe menuPageQryExe;
    @Resource
    private MenuDeleteCmdExe menuDeleteCmdExe;
    @Resource
    private MenuSelectQryExe menuSelectQryExe;
    @Resource
    private AuthMenuGetQryExe authMenuGetQryExe;

    
    public Response add(MenuAddCmd menuAddCmd) {
        return  menuAddCmdExe.execute(menuAddCmd);
    }

    
    public Response update(MenuUpdateCmd cmd) {
        return menuUpdateCmdExe.execute(cmd);
    }

    
    public SingleResponse<MenuDTO> getById(MenuGetQry qry) {
        return menuGetQryExe.execute(qry);
    }

    
    public MultiResponse<MenuDTO> list(MenuListQry qry) {
        return menuListQryExe.execute(qry);
    }

    
    public Response delete(MenuDeleteCmd menuDeleteCmd) {
        return menuDeleteCmdExe.execute(menuDeleteCmd);
    }

    
    public PageResponse<MenuDTO> page(MenuPageQry menuPageQry) {
        return menuPageQryExe.execute(menuPageQry);
    }

    
    public Response select(MenuGetSelectQry menuGetSelectQry) {
        return menuSelectQryExe.execute(menuGetSelectQry);
    }

    
    public Response getAuthMenu(AuthMenuGetQry authMenuGetQry) {
        return authMenuGetQryExe.execute(authMenuGetQry);
    }

}
