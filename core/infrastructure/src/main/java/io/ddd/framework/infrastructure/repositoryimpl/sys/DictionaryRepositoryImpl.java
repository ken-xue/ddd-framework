package io.ddd.framework.infrastructure.repositoryimpl.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryListQry;
import io.ddd.framework.domain.domain.sys.Dictionary;
import io.ddd.framework.domain.repository.sys.DictionaryRepository;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.convertor.Dictionary2DOConvector;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.DictionaryDO;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryPageQry;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.mapper.DictionaryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.ddd.framework.coreclient.dto.common.page.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Slf4j
@Component
public class DictionaryRepositoryImpl implements DictionaryRepository {

    @Resource
    private DictionaryMapper dictionaryMapper;
    @Resource
    private Dictionary2DOConvector dictionary2DOConvector;

    public void create(Dictionary dictionary){
            dictionaryMapper.insert(dictionary2DOConvector.toDO(dictionary));
    }

    public void update(Dictionary dictionary){
            dictionaryMapper.updateById(dictionary2DOConvector.toDO(dictionary));
    }

    public Dictionary getById(Long id){
        return dictionary2DOConvector.toDomain(dictionaryMapper.selectById(id));
    }

    @Override
    public List<Dictionary> list(DictionaryListQry dictionaryListQry) {
        return dictionary2DOConvector.toDomainList(dictionaryMapper.selectList(new QueryWrapper<>()));
    }

    @Override
    public Page<Dictionary> page(DictionaryPageQry qry) {
        QueryWrapper<DictionaryDO> qw = new QueryWrapper<>();
        IPage doPage = dictionaryMapper.selectPage(new PageDTO(qry.getPageIndex(), qry.getPageSize()), qw);
        return Page.of(doPage.getCurrent(),doPage.getSize(),doPage.getTotal(),dictionary2DOConvector.toDomainList(doPage.getRecords()));
    }
}
