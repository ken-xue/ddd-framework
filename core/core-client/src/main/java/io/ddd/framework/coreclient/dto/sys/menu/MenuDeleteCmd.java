package io.ddd.framework.coreclient.dto.sys.menu;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * ่ๅ่กจ
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Data
public class MenuDeleteCmd extends CommonCommand {
    @NotNull
    private Long[] ids;
}
