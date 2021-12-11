package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;

@Data
public class UserListQry extends CommonCommand {
    private String email;
}
