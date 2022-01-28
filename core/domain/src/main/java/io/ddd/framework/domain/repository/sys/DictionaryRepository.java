package io.ddd.framework.domain.repository.sys;

import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryListQry;
import io.ddd.framework.coreclient.dto.sys.dictionary.DictionaryPageQry;
import io.ddd.framework.domain.domain.sys.Dictionary;
import java.util.List;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
public interface DictionaryRepository {
    void create(Dictionary dictionary);
    void update(Dictionary dictionary);
    Dictionary getById(Long id);
    List<Dictionary> list(DictionaryListQry dictionaryListQry);
    Page<Dictionary> page(DictionaryPageQry qry);
}
