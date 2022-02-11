package io.ddd.framework.domain.domain.sys;

import io.ddd.framework.coreclient.dto.sys.menu.enums.MenuEnum;
import io.ddd.framework.domain.common.CommonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.util.Assert;

/**
 * 菜单表
 * @author mikey
 * @date 2021-11-17 14:43:50
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Menu extends CommonEntity {
    /**
     * 父菜单uuid
     */
    private String menuParentUuid;
    /**
     * 菜单名
     */
    private String menuName;
    /**
     * 菜单url
     */
    private String menuUrl;
    /**
     * 授权标识
     */
    private String menuPerms;
    /**
     * 0:目录 1:菜单 2:按钮
     */
    private Integer menuType;
    /**
     * 图标
     */
    private String menuIcon;
    /**
     * 排序
     */
    private Integer menuOrder;
    /**
     * 备注
     */
    private String menuRemark;
    /**
     *
     */
    private Boolean hasChildren;

    @Override
    public void validate(){
        //菜单路径必须以/开头
        if (MenuEnum.MENU.getCode()==menuType)
        Assert.isTrue(menuUrl.startsWith("/"),"菜单路径必须以/开头");
    }
}
