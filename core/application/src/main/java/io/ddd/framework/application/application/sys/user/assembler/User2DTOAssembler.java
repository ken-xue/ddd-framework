package io.ddd.framework.application.application.sys.user.assembler;

import io.ddd.framework.application.common.assembler.Assembler;
import io.ddd.framework.coreclient.dto.common.page.Page;
import io.ddd.framework.domain.domain.sys.User;
import io.ddd.framework.coreclient.dto.sys.user.UserDTO;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 麦奇
 * @Date: 21-11-26 下午9:38
 */
@Component
public class User2DTOAssembler implements Assembler<UserDTO, User> {

    public UserDTO toDTO(User dO) {
        return User2DTOMapStruct.INSTANCE.toDTO(dO);
    }

    public User toDomain(UserDTO dTO) {
        return User2DTOMapStruct.INSTANCE.toDomain(dTO);
    }

    @Override
    public List<UserDTO> toDTOList(List<User> userList) {
        return User2DTOMapStruct.INSTANCE.toDTOList(userList);
    }

    @Override
    public List<User> toDomainList(List<UserDTO> dTOList) {
        return User2DTOMapStruct.INSTANCE.toDomainList(dTOList);
    }

    @Override
    public Page<UserDTO> toDTOPage(Page<User> page) {
        return new Page<>(page.getCurrent(), page.getSize(), page.getTotal(), User2DTOMapStruct.INSTANCE.toDTOList(page.getRecords()));
    }
}
