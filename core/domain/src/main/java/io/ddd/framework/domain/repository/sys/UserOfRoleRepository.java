package io.ddd.framework.domain.repository.sys;

import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRoleListQry;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRolePageQry;
import io.ddd.framework.domain.domain.sys.Role;
import io.ddd.framework.domain.domain.sys.UserOfRole;

import java.util.List;
import java.util.Set;

/**
 * 用户关联角色表
 * @author mikey
 * @date 2021-11-19 15:22:41
 */
public interface UserOfRoleRepository {
    void create(UserOfRole userOfRole);
    void update(UserOfRole userOfRole);
    UserOfRole getById(long id);
    Set<Role> getByUserId(String userUUID);
    void removeByUserUuid(String uuid);
    void save(List<String> roleIdList, String uuid);
    List<UserOfRole> list(UserOfRoleListQry qry);
    Page<UserOfRole> page(UserOfRolePageQry qry);
}
