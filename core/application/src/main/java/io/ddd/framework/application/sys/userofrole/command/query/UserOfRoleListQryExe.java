package io.ddd.framework.application.sys.userofrole.command.query;

import io.ddd.framework.application.sys.userofrole.assembler.UserOfRole2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.response.MultiResponse;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRoleDTO;
import io.ddd.framework.coreclient.dto.sys.userofrole.UserOfRoleListQry;
import io.ddd.framework.domain.repository.sys.UserOfRoleRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户关联角色表
 * @author mikey
 * @date 2021-11-19 15:22:41
 */
@Component
public class UserOfRoleListQryExe {

    @Resource
    private UserOfRoleRepository userOfRoleRepository;
    @Resource
    private UserOfRole2DTOAssembler userOfRole2DTOAssembler;

    public MultiResponse<UserOfRoleDTO> execute(UserOfRoleListQry qry) {
        return MultiResponse.of(userOfRole2DTOAssembler.toDTOList(userOfRoleRepository.list(qry)));
    }

}

