package io.ddd.framework.application.application.sys.log.command.query;

import io.ddd.framework.application.application.sys.log.assembler.Log2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.sys.log.LogDTO;
import io.ddd.framework.coreclient.dto.sys.log.LogListQry;
import io.ddd.framework.domain.domain.sys.Log;
import io.ddd.framework.domain.repository.sys.LogRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统日志
 * @author mikey
 * @date 2021-11-20 23:04:11
 */
@Component
public class LogListQryExe {
    @Resource
    private LogRepository logRepository;
    @Resource
    private Log2DTOAssembler log2DTOAssembler;
    public MultiResponse<LogDTO> execute(LogListQry qry) {
        List<Log> logDTOList = logRepository.list(qry);
        return MultiResponse.of(log2DTOAssembler.toDTOList(logDTOList));
    }
}

