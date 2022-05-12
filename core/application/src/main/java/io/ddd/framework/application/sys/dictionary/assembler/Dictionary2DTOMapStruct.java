package io.ddd.framework.application.sys.dictionary.assembler;

import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryDTO;
import io.ddd.framework.domain.domain.sys.Dictionary;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import java.util.List;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface Dictionary2DTOMapStruct {

    Dictionary2DTOMapStruct INSTANCE = Mappers.getMapper(Dictionary2DTOMapStruct.class);

    @Mappings({})
    DictionaryDTO toDTO(Dictionary dictionary);

    @Mappings({})
    Dictionary toDomain(DictionaryDTO dictionaryDTO);

    List<DictionaryDTO> toDTOList(List<Dictionary> DictionaryList);

    List<Dictionary> toDomainList(List<DictionaryDTO> DictionaryDTOList);
}
