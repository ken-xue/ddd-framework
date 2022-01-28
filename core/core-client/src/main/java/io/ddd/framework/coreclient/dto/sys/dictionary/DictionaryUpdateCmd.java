package io.ddd.framework.coreclient.dto.sys.dictionary;

import lombok.Data;
import javax.validation.constraints.NotNull;
import lombok.experimental.Accessors;
import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
/**
 * 
 * @author mikey
 * @date 2022-01-28 21:50:48
 */
@Data
@Accessors(chain = true)
public class DictionaryUpdateCmd extends CommonCommand {

    @NotNull
    private DictionaryDTO dictionaryDTO;
}
