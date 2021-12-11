package io.ddd.framework.application.application.sys.log.command.query;

import io.ddd.framework.application.application.sys.log.assembler.Log2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.sys.log.LogDTO;
import io.ddd.framework.coreclient.dto.sys.log.LogPageQry;
import io.ddd.framework.domain.domain.sys.Log;
import io.ddd.framework.domain.repository.sys.LogRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 系统日志
 * @author mikey
 * @date 2021-11-20 23:04:11
 */
@Component
public class LogPageQryExe {

    @Resource
    private LogRepository logRepository;
    @Resource
    private Log2DTOAssembler log2DTOAssembler;

    public PageResponse<LogDTO> execute(LogPageQry qry) {
        Page<Log> page = logRepository.page(qry);
        return PageResponse.of(log2DTOAssembler.toDTOPage(page));
    }

}

