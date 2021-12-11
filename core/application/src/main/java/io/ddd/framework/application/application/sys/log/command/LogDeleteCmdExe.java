package io.ddd.framework.application.application.sys.log.command;

import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.Log;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.log.LogDeleteCmd;
import io.ddd.framework.domain.repository.sys.LogRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
/**
 * 系统日志
 * @author mikey
 * @date 2021-11-20 23:04:11
 */
@Component
public class LogDeleteCmdExe {
    @Resource
    private LogRepository logRepository;

    public Response execute(LogDeleteCmd cmd) {
        for(Long id:cmd.getIds()) {
            Log log = logRepository.getById(id);
            log.deleted(UserThreadContext.get());
            logRepository.update(log);
        }
        return Response.success();
    }
}
