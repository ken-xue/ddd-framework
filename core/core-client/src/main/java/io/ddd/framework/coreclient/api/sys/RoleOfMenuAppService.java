package io.ddd.framework.coreclient.api.sys;


import io.ddd.framework.coreclient.dto.sys.roleofmenu.*;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;


/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-11-19 14:47:31
 */
public interface RoleOfMenuAppService {
    Response add(RoleOfMenuAddCmd cmd);
    Response update(RoleOfMenuUpdateCmd cmd);
    Response delete(RoleOfMenuDeleteCmd userDeleteCmd);
    SingleResponse<RoleOfMenuDTO> getById(RoleOfMenuGetQry qry);
    MultiResponse<RoleOfMenuDTO> list(RoleOfMenuListQry qry);
    PageResponse<RoleOfMenuDTO> page(RoleOfMenuPageQry userPageQry);
}
