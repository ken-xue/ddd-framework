package io.ddd.framework.application.sys.userofrole.service;

import io.ddd.framework.application.sys.userofrole.command.UserOfRoleAddCmdExe;
import io.ddd.framework.application.sys.userofrole.command.UserOfRoleDeleteCmdExe;
import io.ddd.framework.application.sys.userofrole.command.UserOfRoleUpdateCmdExe;
import io.ddd.framework.application.sys.userofrole.command.query.UserOfRoleGetQryExe;
import io.ddd.framework.application.sys.userofrole.command.query.UserOfRoleListQryExe;
import io.ddd.framework.coreclient.api.sys.UserOfRoleAppService;
import io.ddd.framework.coreclient.dto.sys.userofrole.*;
import io.ddd.framework.application.sys.userofrole.command.query.UserOfRolePageQryExe;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户关联角色表
 * @author mikey
 * @date 2021-11-19 15:22:41
 */
@Service
public class UserOfRoleAppAppServiceImpl implements UserOfRoleAppService {
    @Resource
    private UserOfRoleAddCmdExe userOfRoleAddCmdExe;
    @Resource
    private UserOfRoleUpdateCmdExe userOfRoleUpdateCmdExe;
    @Resource
    private UserOfRoleGetQryExe userOfRoleGetQryExe;
    @Resource
    private UserOfRoleListQryExe userOfRoleListQryExe;
    @Resource
    private UserOfRolePageQryExe userOfRolePageQryExe;
    @Resource
    private UserOfRoleDeleteCmdExe userOfRoleDeleteCmdExe;

    
    public Response add(UserOfRoleAddCmd userOfRoleAddCmd) {
        return  userOfRoleAddCmdExe.execute(userOfRoleAddCmd);
    }

    
    public Response update(UserOfRoleUpdateCmd cmd) {
        return userOfRoleUpdateCmdExe.execute(cmd);
    }

    
    public SingleResponse<UserOfRoleDTO> getById(UserOfRoleGetQry qry) {
        return userOfRoleGetQryExe.execute(qry);
    }

    
    public MultiResponse<UserOfRoleDTO> list(UserOfRoleListQry qry) {
        return userOfRoleListQryExe.execute(qry);
    }
    
    public Response delete(UserOfRoleDeleteCmd userOfRoleDeleteCmd) {
        return userOfRoleDeleteCmdExe.execute(userOfRoleDeleteCmd);
    }

    
    public PageResponse<UserOfRoleDTO> page(UserOfRolePageQry userOfRolePageQry) {
        return userOfRolePageQryExe.execute(userOfRolePageQry);
    }

}
