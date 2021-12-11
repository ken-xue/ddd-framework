package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * UserAddCmd
 *
 * @date 2019-02-28 6:20 PM
 */
@Data
public class UserAddCmd extends CommonCommand {

    @NotNull
    private UserDTO userDTO;
}
