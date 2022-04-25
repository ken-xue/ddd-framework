package io.ddd.framework.coreclient.dto.sys.user;

import io.ddd.framework.coreclient.dto.common.command.CommonDTO;
import io.ddd.framework.coreclient.dto.sys.menu.MenuDTO;
import io.ddd.framework.coreclient.dto.sys.role.RoleDTO;
import io.ddd.framework.sharedataobject.common.validator.group.Insert;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class UserDTO extends CommonDTO {
    @NotEmpty(message = "用户账号不能为空",groups = {Insert.class})
    private String userId;
    @NotEmpty(message = "密码不能为空",groups = {Insert.class})
    private String userPassword;
    private String userName;
    //验证码
    private String code;
    private String email;
    private String avatar;
    private Integer status;
    private Set<RoleDTO> roles;
    private Set<MenuDTO> menus;
    //角色uuid
    private List<String> roleIdList;
}
