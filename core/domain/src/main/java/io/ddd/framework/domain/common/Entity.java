package io.ddd.framework.domain.common;

import java.io.Serializable;

/**
 * @Author: 麦奇
 * @Date: 21-11-13 下午11:35
 */
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    public Entity() {
    }

    public void validate() throws Exception {
    }
}
