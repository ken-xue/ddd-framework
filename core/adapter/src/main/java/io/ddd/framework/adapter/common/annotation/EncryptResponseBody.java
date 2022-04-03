package io.ddd.framework.adapter.common.annotation;

import java.lang.annotation.*;

/**
 * 加密响应体
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EncryptResponseBody {

	String value() default "";

}
