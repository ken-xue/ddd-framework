package io.ddd.framework.application.sys.user.command.query;

import io.ddd.framework.application.sys.user.assembler.User2DTOAssembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.coreclient.dto.sys.user.UserDTO;
import io.ddd.framework.coreclient.dto.common.response.PageResponse;
import io.ddd.framework.coreclient.dto.sys.user.UserPageQry;
import io.ddd.framework.domain.domain.sys.User;
import io.ddd.framework.domain.repository.sys.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserPageQryExe {
    @Resource
    private User2DTOAssembler user2DTOAssembler;
    @Resource
    private UserRepository userRepository;

    public PageResponse<UserDTO> execute(UserPageQry qry) {
        Page<User> page = userRepository.page(qry);
        return PageResponse.of(user2DTOAssembler.toDTOPage(page));}

}

