package io.ddd.framework.application.sys.dictionary.assembler;

import io.ddd.framework.application.common.assembler.Assembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDTO;
import io.ddd.framework.domain.domain.sys.Dictionary;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Component
public class Dictionary2DTOAssembler implements Assembler<DictionaryDTO, Dictionary> {

    @Override
    public DictionaryDTO toDTO(Dictionary dictionary) {
        return Dictionary2DTOMapStruct.INSTANCE.toDTO(dictionary);
    }

    @Override
    public Dictionary toDomain(DictionaryDTO dictionaryDTO) {
        return Dictionary2DTOMapStruct.INSTANCE.toDomain(dictionaryDTO);
    }

    @Override
    public List<DictionaryDTO> toDTOList(List<Dictionary> dictionaryList) {
        return Dictionary2DTOMapStruct.INSTANCE.toDTOList(dictionaryList);
    }

    @Override
    public List<Dictionary> toDomainList(List<DictionaryDTO> dictionaryDTOList) {
        return Dictionary2DTOMapStruct.INSTANCE.toDomainList(dictionaryDTOList);
    }

    @Override
    public Page<DictionaryDTO> toDTOPage(Page<Dictionary> page){
        return new Page<>(page.getCurrent(), page.getSize(), page.getTotal(), Dictionary2DTOMapStruct.INSTANCE.toDTOList(page.getRecords()));
    }
}
