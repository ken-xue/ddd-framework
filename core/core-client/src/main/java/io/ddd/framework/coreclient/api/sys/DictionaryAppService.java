package io.ddd.framework.coreclient.api.sys;

import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import io.ddd.framework.coreclient.dto.sys.dictionary.*;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
public interface DictionaryAppService {
    Response add(DictionaryAddCmd cmd);
    Response update(DictionaryUpdateCmd cmd);
    Response delete(DictionaryDeleteCmd userDeleteCmd);
    SingleResponse<DictionaryDTO> getById(DictionaryGetQry qry);
    MultiResponse<DictionaryDTO> list(DictionaryListQry qry);
    PageResponse<DictionaryDTO> page(DictionaryPageQry userPageQry);
}
