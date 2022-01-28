package io.ddd.framework.application.application.sys.dictionary.command.query;

import io.ddd.framework.application.application.sys.dictionary.assembler.Dictionary2DTOAssembler;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDTO;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryPageQry;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import org.springframework.stereotype.Component;
import io.ddd.framework.domain.domain.sys.Dictionary;
import javax.annotation.Resource;
import io.ddd.framework.coreclient.dto.common.page.Page;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class DictionaryPageQryExe {

    @Resource
    private DictionaryRepository dictionaryRepository;
    @Resource
    private Dictionary2DTOAssembler dictionary2DTOAssembler;

    public PageResponse<DictionaryDTO> execute(DictionaryPageQry qry) {
        Page<Dictionary> page = dictionaryRepository.page(qry);
        return PageResponse.of(dictionary2DTOAssembler.toDTOPage(page));
    }
}
