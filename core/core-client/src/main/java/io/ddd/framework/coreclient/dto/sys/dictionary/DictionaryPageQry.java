package io.ddd.framework.coreclient.dto.sys.dictionary;

import io.ddd.framework.coreclient.dto.common.command.PageQuery;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@Accessors(chain = true)
public class DictionaryPageQry extends PageQuery {

    private DictionaryDTO dictionaryDTO;

}
