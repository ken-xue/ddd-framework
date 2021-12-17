package io.ddd.framework.infrastructure.repositoryimpl.sys.rpc;

import io.ddd.framework.infrastructure.repositoryimpl.sys.rpc.dataobject.UserDO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {
    /**
     *  Dummy RPC Call
     */
    public List<UserDO> listByUserId(String userId){
        List<UserDO> userDOList = new ArrayList<>();
        UserDO userDO1 = new UserDO();
        userDO1.setUsername("mikey");
        return userDOList;
    }
}
