package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class UserGetQry extends CommonCommand {
    private String userId;
    private Long id;
    private String uuid;
}