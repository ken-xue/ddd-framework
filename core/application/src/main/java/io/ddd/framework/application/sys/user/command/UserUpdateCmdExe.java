package io.ddd.framework.application.sys.user.command;

import io.ddd.framework.application.sys.user.assembler.User2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.domain.repository.sys.UserRepository;
import io.ddd.framework.domain.domain.sys.User;
import io.ddd.framework.coreclient.dto.sys.user.UserUpdateCmd;
import io.ddd.framework.domain.repository.sys.UserOfRoleRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserUpdateCmdExe {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserOfRoleRepository userOfRoleRepository;
    @Resource
    private User2DTOAssembler user2DTOAssembler;

    public Response execute(UserUpdateCmd cmd) {
        User user = user2DTOAssembler.toDomain(cmd.getUserCO());
        //是否更新密码
        User oldUser = userRepository.getByUserId(cmd.getUserCO().getUserId());
        if (!StringUtils.equals(oldUser.getUserPassword(),cmd.getUserCO().getUserPassword())){
            user.setUserPassword(cmd.getBCryptPassword());
        }
        userRepository.update(user);
        //是否更新角色
        List<String> roleIdList = cmd.getUserCO().getRoleIdList();
        userOfRoleRepository.removeByUserUuid(oldUser.getUuid());
        userOfRoleRepository.save(roleIdList,user.getUuid());
        return Response.success();
    }
}