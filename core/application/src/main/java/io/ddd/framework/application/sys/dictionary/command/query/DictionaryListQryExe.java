package io.ddd.framework.application.sys.dictionary.command.query;

import io.ddd.framework.application.sys.dictionary.assembler.Dictionary2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDTO;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryListQry;
import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class DictionaryListQryExe {
    @Resource
    private DictionaryRepository dictionaryRepository;
    @Resource
    private Dictionary2DTOAssembler dictionary2DTOAssembler;

    public MultiResponse<DictionaryDTO> execute(DictionaryListQry qry) {
        List<Dictionary> dictionaryDTOList = dictionaryRepository.list(qry);
        return MultiResponse.of(dictionary2DTOAssembler.toDTOList(dictionaryDTOList));
    }
}
