package io.ddd.framework.application.application.sys.dictionary.service;

import io.ddd.framework.coreclient.api.sys.DictionaryAppService;
import io.ddd.framework.coreclient.dto.sys.dictionary.*;
import io.ddd.framework.application.application.sys.dictionary.command.DictionaryAddCmdExe;
import io.ddd.framework.application.application.sys.dictionary.command.DictionaryDeleteCmdExe;
import io.ddd.framework.application.application.sys.dictionary.command.DictionaryUpdateCmdExe;
import io.ddd.framework.application.application.sys.dictionary.command.query.DictionaryGetQryExe;
import io.ddd.framework.application.application.sys.dictionary.command.query.DictionaryListQryExe;
import io.ddd.framework.application.application.sys.dictionary.command.query.DictionaryPageQryExe;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Service
public class DictionaryAppAppServiceImpl implements DictionaryAppService {
    @Resource
    private DictionaryAddCmdExe dictionaryAddCmdExe;
    @Resource
    private DictionaryUpdateCmdExe dictionaryUpdateCmdExe;
    @Resource
    private DictionaryGetQryExe dictionaryGetQryExe;
    @Resource
    private DictionaryListQryExe dictionaryListQryExe;
    @Resource
    private DictionaryPageQryExe dictionaryPageQryExe;
    @Resource
    private DictionaryDeleteCmdExe dictionaryDeleteCmdExe;

    public Response add(DictionaryAddCmd dictionaryAddCmd) {
        return  dictionaryAddCmdExe.execute(dictionaryAddCmd);
    }

    public Response update(DictionaryUpdateCmd cmd) {
        return dictionaryUpdateCmdExe.execute(cmd);
    }

    public SingleResponse<DictionaryDTO> getById(DictionaryGetQry qry) {
        return dictionaryGetQryExe.execute(qry);
    }

    public MultiResponse<DictionaryDTO> list(DictionaryListQry qry) {
        return dictionaryListQryExe.execute(qry);
    }

    public Response delete(DictionaryDeleteCmd dictionaryDeleteCmd) {
        return dictionaryDeleteCmdExe.execute(dictionaryDeleteCmd);
    }

    public PageResponse<DictionaryDTO> page(DictionaryPageQry dictionaryPageQry) {
        return dictionaryPageQryExe.execute(dictionaryPageQry);
    }

}
