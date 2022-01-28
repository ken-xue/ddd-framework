package io.ddd.framework.coreclient.dto.sys.dictionary;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@Accessors(chain = true)
public class DictionaryListQry extends CommonCommand {
    /**
     * 查询的key
     */
    private String key;
    /**
     * 字典值
     */
    private String value;
    /**
     * 是否可更改
     */
    private Integer fixed;
}
