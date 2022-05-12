package io.ddd.framework.application.sys.dictionary.command;

import io.ddd.framework.application.sys.dictionary.assembler.Dictionary2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryAddCmd;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class DictionaryAddCmdExe {

    @Resource
    private DictionaryRepository dictionaryRepository;
    @Resource
    private Dictionary2DTOAssembler dictionary2DTOAssembler;

    public Response execute(DictionaryAddCmd cmd) {
        Dictionary dictionary = dictionary2DTOAssembler.toDomain(cmd.getDictionaryDTO());
        dictionaryRepository.create(dictionary);
        return Response.success();
    }
}
