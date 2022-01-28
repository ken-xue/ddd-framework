package io.ddd.framework.infrastructure.repositoryimpl.sys.database.convertor;

import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.DictionaryDO;
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
public interface Dictionary2DOMapStruct {

    Dictionary2DOMapStruct INSTANCE = Mappers.getMapper(Dictionary2DOMapStruct.class);

    @Mappings({})
    DictionaryDO toDO(Dictionary dictionary);

    @Mappings({})
    Dictionary toDomain(DictionaryDO dictionaryDO);

    List<DictionaryDO> toDOList(List<Dictionary> dictionaryList);

    List<Dictionary> toDomainList(List<DictionaryDO> dictionaryDOList);
}
