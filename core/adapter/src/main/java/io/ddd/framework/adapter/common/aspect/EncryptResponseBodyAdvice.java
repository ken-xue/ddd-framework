package io.ddd.framework.adapter.common.aspect;

import com.alibaba.fastjson.JSON;
import io.ddd.framework.adapter.common.annotation.EncryptResponseBody;
import io.ddd.framework.adapter.util.AesEncryptUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 加密响应结果
 */
@Component
@ControllerAdvice(basePackages = "io.ddd.framework.adapter.rest")
@Slf4j
public class EncryptResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    public static final String ENCRYPT_HEAD = "ENCRYPT";

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasMethodAnnotation(EncryptResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> sct, ServerHttpRequest req,
                                  ServerHttpResponse res) {
        ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) req;
        HttpServletRequest request = servletServerHttpRequest.getServletRequest();
        log.info("request path : {}", request.getRequestURI());
        String encrypt = "";
        try {
            //添加标志位 encrypt header 告知前端数据需要解密
            res.getHeaders().add(ENCRYPT_HEAD, "true");
            String originData = JSON.toJSONString(obj);
            log.info("origin data : {}", originData);
            //加密
            encrypt = AesEncryptUtils.encrypt(originData);
            log.info("encrypt result : {}", encrypt);
        } catch (Exception e) {
            log.error("encrypt error : {}", e.getMessage());
        }
        return encrypt;
    }


}