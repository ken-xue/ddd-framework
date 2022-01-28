package io.ddd.framework.application.application.sys.dictionary.command;

import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDeleteCmd;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class DictionaryDeleteCmdExe {
    @Resource
    private DictionaryRepository dictionaryRepository;

    public Response execute(DictionaryDeleteCmd cmd) {
        for(Long id:cmd.getIds()) {
            Dictionary dictionary =dictionaryRepository.getById(id);
            dictionary.deleted(UserThreadContext.get());
            dictionaryRepository.update(dictionary);
        }
        return Response.success();
    }
}
