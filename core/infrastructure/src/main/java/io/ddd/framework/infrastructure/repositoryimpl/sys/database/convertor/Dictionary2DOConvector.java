package io.ddd.framework.infrastructure.repositoryimpl.sys.database.convertor;

import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.DictionaryDO;
import org.springframework.stereotype.Component;
import java.util.List;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class Dictionary2DOConvector implements Convector<Dictionary,DictionaryDO>{
    
    public DictionaryDO toDO(Dictionary dictionary) {
        return Dictionary2DOMapStruct.INSTANCE.toDO(dictionary);
    }

    public Dictionary toDomain(DictionaryDO dictionaryDO) {
        return Dictionary2DOMapStruct.INSTANCE.toDomain(dictionaryDO);
    }

    public List<DictionaryDO> toDOList(List<Dictionary> dictionaryList) {
        return Dictionary2DOMapStruct.INSTANCE.toDOList(dictionaryList);
    }

    public List<Dictionary> toDomainList(List<DictionaryDO> dictionaryDOList) {
        return Dictionary2DOMapStruct.INSTANCE.toDomainList(dictionaryDOList);
    }
}
