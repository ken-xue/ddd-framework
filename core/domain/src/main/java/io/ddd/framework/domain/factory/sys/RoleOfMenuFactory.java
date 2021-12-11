package io.ddd.framework.domain.factory.sys;

import io.ddd.framework.domain.domain.sys.RoleOfMenu;
/**
 * 角色关联菜单表
 * @author mikey
 * @date 2021-12-03 17:39:58
 */
public class RoleOfMenuFactory {
    public static RoleOfMenu getRoleOfMenu(){
        return new RoleOfMenu();
    }
}
