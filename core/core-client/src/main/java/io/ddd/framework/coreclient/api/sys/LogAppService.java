package io.ddd.framework.coreclient.api.sys;


import io.ddd.framework.coreclient.dto.sys.log.*;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;

/**
 * 系统日志
 * @author mikey
 * @date 2021-11-20 23:04:11
 */
public interface LogAppService {
    Response add(LogAddCmd cmd);
    Response update(LogUpdateCmd cmd);
    Response delete(LogDeleteCmd userDeleteCmd);
    SingleResponse<LogDTO> getById(LogGetQry qry);
    MultiResponse<LogDTO> list(LogListQry qry);
    PageResponse<LogDTO> page(LogPageQry userPageQry);
}
