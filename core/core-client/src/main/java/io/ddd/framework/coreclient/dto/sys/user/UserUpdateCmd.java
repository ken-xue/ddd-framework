package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserUpdateCmd extends CommonCommand {

    @NotNull
    private UserDTO userCO;
    private String bCryptPassword;
}
