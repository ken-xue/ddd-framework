package io.ddd.framework.application.sys.role.command;

import io.ddd.framework.coreclient.context.UserThreadContext;
import io.ddd.framework.domain.domain.sys.Role;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.dto.sys.role.RoleDeleteCmd;
import io.ddd.framework.domain.repository.sys.RoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.stream.Stream;

/**
 * 角色表
 * @author mikey
 * @date 2021-11-17 14:27:15
 */
@Component
public class RoleDeleteCmdExe {
    @Resource
    private RoleRepository roleRepository;

    public Response execute(RoleDeleteCmd cmd) {
        Stream.of(cmd.getIds()).forEach(v->{
            Role role = roleRepository.getById(v);
            role.deleted(UserThreadContext.get());
            roleRepository.update(role);
        });
        return Response.success();
    }
}
