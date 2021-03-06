package io.ddd.framework.infrastructure.repositoryimpl.sys.database.convertor;

import io.ddd.framework.domain.domain.sys.User;
import io.ddd.framework.infrastructure.common.convector.Convector;
import io.ddd.framework.infrastructure.repositoryimpl.sys.database.dataobject.UserDO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class User2DOConvector implements Convector<User,UserDO> {

    public UserDO toDO(User user) {
        return User2DOMapStruct.INSTANCE.toDO(user);
    }

    public User toDomain(UserDO userDO) {
        return User2DOMapStruct.INSTANCE.toDomain(userDO);
    }

    @Override
    public List<UserDO> toDOList(List<User> userList) {
        return User2DOMapStruct.INSTANCE.toDOList(userList);
    }

    @Override
    public List<User> toDomainList(List<UserDO> userDOList) {
        return User2DOMapStruct.INSTANCE.toDomainList(userDOList);
    }
}
