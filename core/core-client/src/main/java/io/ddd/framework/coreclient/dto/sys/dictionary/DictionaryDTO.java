package io.ddd.framework.coreclient.dto.sys.dictionary;

import io.ddd.framework.coreclient.dto.common.command.CommonDTO;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@Accessors(chain = true)
public class DictionaryDTO extends CommonDTO {
    /**
     * 查询的key
     */
    private String uniqueKey;
    /**
     * 字典值
     */
    private String value;
    /**
     * 是否可更改
     */
    private Integer fixed;
    /**
     * 备注
     */
    private String remark;
}
