package io.ddd.framework.coreclient.dto.sys.menu;

import io.ddd.framework.coreclient.dto.common.command.PageQuery;
import lombok.Data;

/**
 * 菜单表
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Data
public class MenuPageQry extends PageQuery {

    private MenuDTO menuCO;

}
