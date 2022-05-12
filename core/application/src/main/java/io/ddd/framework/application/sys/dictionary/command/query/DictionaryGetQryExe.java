package io.ddd.framework.application.sys.dictionary.command.query;

import io.ddd.framework.application.sys.dictionary.assembler.Dictionary2DTOAssembler;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDTO;
import io.ddd.framework.coreclient.dto.common.response.SingleResponse;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryGetQry;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class DictionaryGetQryExe {

    @Resource
    private DictionaryRepository dictionaryRepository;
    @Resource
    private Dictionary2DTOAssembler dictionary2DTOAssembler;

    public SingleResponse<DictionaryDTO> execute(DictionaryGetQry qry) {
        return SingleResponse.of(dictionary2DTOAssembler.toDTO(dictionaryRepository.getById(qry.getId())));
    }

}
