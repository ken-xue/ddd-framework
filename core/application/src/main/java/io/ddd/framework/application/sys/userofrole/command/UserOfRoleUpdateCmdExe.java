package io.ddd.framework.application.sys.userofrole.command;

import io.ddd.framework.application.sys.userofrole.assembler.UserOfRole2DTOAssembler;
import io.ddd.framework.domain.domain.sys.UserOfRole;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRoleUpdateCmd;
import io.ddd.framework.domain.repository.sys.UserOfRoleRepository;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
/**
 * 用户关联角色表
 * @author mikey
 * @date 2021-11-19 15:22:41
 */
@Component
public class UserOfRoleUpdateCmdExe {

    @Resource
    private UserOfRoleRepository userOfRoleRepository;
    @Resource
    private UserOfRole2DTOAssembler userOfRole2DTOAssembler;

    public Response execute(UserOfRoleUpdateCmd cmd) {
        UserOfRole userOfRole = userOfRole2DTOAssembler.toDomain(cmd.getUserOfRoleDTO());
        userOfRoleRepository.update(userOfRole);
        return Response.success();
    }
}