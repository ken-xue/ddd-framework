package io.ddd.framework.infrastructure.repositoryimpl.sys.database.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.DictionaryDO;
import org.apache.ibatis.annotations.Mapper;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<DictionaryDO> {

}
