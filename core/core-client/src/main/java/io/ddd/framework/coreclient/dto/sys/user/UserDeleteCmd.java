package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Author: 麦奇
 * @Date: 21-11-13 下午11:17
 */
@Data
public class UserDeleteCmd extends CommonCommand {
    @NotNull
    private Long[] ids;
}
