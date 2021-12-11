package io.ddd.framework.domain.repository.sys;

import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.role.RolePageQry;
import io.ddd.framework.domain.domain.sys.Role;

import java.util.List;

/**
 * 角色表
 * @author mikey
 * @date 2021-11-17 14:27:15
 */
public interface RoleRepository {
    void create(Role role);
    void update(Role role);
    Role getById(Long id);
    Page<Role> page(RolePageQry qry);
    List<Role> list(String roleName);
}
