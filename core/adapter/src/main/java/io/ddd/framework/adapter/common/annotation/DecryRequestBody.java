package io.ddd.framework.adapter.common.annotation;

import java.lang.annotation.*;

/**
 * 解密参数请求体
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DecryRequestBody {

	String value() default "";

}
