package io.ddd.framework.domain.factory;

import io.ddd.framework.domain.domain.sys.User;
import io.ddd.framework.domain.domain.sys.UserOfRole;

public class DomainFactory {

    public static User getUser(){
        return new User();
    }

    public static UserOfRole getUserOfRole(){
        return new UserOfRole();
    }
}
