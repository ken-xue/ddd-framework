package io.ddd.framework.coreclient.dto.sys.dictionary;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@Accessors(chain = true)
public class DictionaryDeleteCmd extends CommonCommand {
    @NotNull
    private Long[] ids;
}
