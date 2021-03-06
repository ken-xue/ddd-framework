package io.ddd.framework.application.sys.roleofmenu.service;

import io.ddd.framework.application.sys.roleofmenu.command.query.RoleOfMenuListQryExe;
import io.ddd.framework.application.sys.roleofmenu.command.query.RoleOfMenuPageQryExe;
import io.ddd.framework.coreclient.api.sys.RoleOfMenuAppService;
import io.ddd.framework.application.sys.roleofmenu.command.RoleOfMenuAddCmdExe;
import io.ddd.framework.application.sys.roleofmenu.command.RoleOfMenuDeleteCmdExe;
import io.ddd.framework.application.sys.roleofmenu.command.RoleOfMenuUpdateCmdExe;
import io.ddd.framework.application.sys.roleofmenu.command.query.RoleOfMenuGetQryExe;
import io.ddd.framework.coreclient.dto.sys.roleofmenu.*;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-11-19 14:47:31
 */
@Service
public class RoleOfMenuAppAppServiceImpl implements RoleOfMenuAppService {
    @Resource
    private RoleOfMenuAddCmdExe roleOfMenuAddCmdExe;
    @Resource
    private RoleOfMenuUpdateCmdExe roleOfMenuUpdateCmdExe;
    @Resource
    private RoleOfMenuGetQryExe roleOfMenuGetQryExe;
    @Resource
    private RoleOfMenuListQryExe roleOfMenuListQryExe;
    @Resource
    private RoleOfMenuPageQryExe roleOfMenuPageQryExe;
    @Resource
    private RoleOfMenuDeleteCmdExe roleOfMenuDeleteCmdExe;

    
    public Response add(RoleOfMenuAddCmd roleOfMenuAddCmd) {
        return  roleOfMenuAddCmdExe.execute(roleOfMenuAddCmd);
    }

    
    public Response update(RoleOfMenuUpdateCmd cmd) {
        return roleOfMenuUpdateCmdExe.execute(cmd);
    }

    
    public SingleResponse<RoleOfMenuDTO> getById(RoleOfMenuGetQry qry) {
        return roleOfMenuGetQryExe.execute(qry);
    }

    
    public MultiResponse<RoleOfMenuDTO> list(RoleOfMenuListQry qry) {
        return roleOfMenuListQryExe.execute(qry);
    }
    
    public Response delete(RoleOfMenuDeleteCmd roleOfMenuDeleteCmd) {
        return roleOfMenuDeleteCmdExe.execute(roleOfMenuDeleteCmd);
    }

    
    public PageResponse<RoleOfMenuDTO> page(RoleOfMenuPageQry roleOfMenuPageQry) {
        return roleOfMenuPageQryExe.execute(roleOfMenuPageQry);
    }

}
