package io.ddd.framework.coreclient.dto.sys.log;

import io.ddd.framework.coreclient.dto.common.command.PageQuery;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 系统日志
 * @author mikey
 * @date 2021-11-20 23:04:11
 */
@Data
@Accessors(chain = true)
public class LogPageQry extends PageQuery {

    private LogDTO logDTO;

}
