package io.ddd.framework.domain.domain.sys;

import io.ddd.framework.domain.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dictionary extends CommonEntity {
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
