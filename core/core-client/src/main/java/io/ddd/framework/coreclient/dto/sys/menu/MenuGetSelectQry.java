package io.ddd.framework.coreclient.dto.sys.menu;

import io.ddd.framework.coreclient.dto.common.command.CommonCommand;
import lombok.Data;
/**
 * @Author: 麦奇
 * @Date: 21-11-28 上午10:20
 */
@Data
public class MenuGetSelectQry extends CommonCommand {
    private String excludeTypes;
    private String includeTypes;
    private Boolean needRoot;
}
