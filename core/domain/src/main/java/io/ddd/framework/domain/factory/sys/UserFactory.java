package io.ddd.framework.domain.factory.sys;

import io.ddd.framework.domain.domain.sys.User;

public class UserFactory {

    public static User getUser(){
        //init the domain object
        return new User();
    }

}
