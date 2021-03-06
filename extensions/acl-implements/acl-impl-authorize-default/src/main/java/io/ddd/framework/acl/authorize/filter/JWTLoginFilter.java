package io.ddd.framework.acl.authorize.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.ddd.framework.acl.authorize.AuthorizeService;
import io.ddd.framework.acl.authorize.config.JWTConfig;
import io.ddd.framework.acl.authorize.dto.CaptchaValidateDTO;
import io.ddd.framework.acl.authorize.util.ResponseUtil;
import io.ddd.framework.acl.authorize.constant.Constant;
import io.ddd.framework.acl.cache.CacheService;
import io.ddd.framework.coreclient.dto.sys.user.UserDTO;
import io.ddd.framework.coreclient.dto.common.response.Response;
import io.ddd.framework.coreclient.exception.BizException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
/**
 * @author mikey
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    private AuthorizeService authorizeService;

    private CacheService cacheService;

    public JWTLoginFilter(AuthenticationManager authenticationManager, AuthorizeService authorizeService,CacheService cacheService) {
        this.authenticationManager = authenticationManager;
        this.authorizeService = authorizeService;
        this.cacheService = cacheService;
    }

    // 尝试身份认证(接收并解析用户凭证)
    
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        try {
            UserDTO user = new ObjectMapper().readValue(req.getInputStream(), UserDTO.class);
            if (StringUtils.isBlank(user.getUserId()))throw new BizException("账号不能为空");
            if (StringUtils.isBlank(user.getUserPassword()))throw new BizException("密码不能为空");
            if (StringUtils.isBlank(user.getUuid()))throw new BizException("UUID不能为空");
            if (StringUtils.isBlank(user.getCode()))throw new BizException("验证码不能为空");
            if (!authorizeService.captchaValidate(new CaptchaValidateDTO().setCode(user.getCode()).setUuid(user.getUuid()))){
                throw new BizException("验证码错误");
            }
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUserId(),
                            user.getUserPassword(),
                            new ArrayList<>())
            );
        } catch (Exception e) {
            ResponseUtil.add(res, Response.error(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage()));
            return null;
        }
    }

    // 认证成功(用户成功登录后，这个方法会被调用，我们在这个方法里生成token)
    
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) {
        // builder the token
        String token;
        try {
            //存储到缓存中
            cacheService.set(auth.getName(),auth.getAuthorities());
            // 生成token start
            Calendar calendar = Calendar.getInstance();
            Date now = calendar.getTime();
            // 设置签发时间
            calendar.setTime(new Date());
            // 设置过期时间
            calendar.add(Calendar.MINUTE, JWTConfig.getJwtTokenExpireTime());// 50分钟
            Date time = calendar.getTime();
            token = Jwts.builder()
                    .setSubject(auth.getName())
                    .setIssuedAt(now)//签发时间
                    .setExpiration(time)//过期时间
                    .signWith(SignatureAlgorithm.HS512, Constant.SIGNING_KEY) //采用什么算法是可以自己选择的，不一定非要采用HS512
                    .compact();
            // 生成token end
            // 登录成功后，返回token到header里面
            response.setHeader("Access-Control-Expose-Headers",Constant.AUTHORIZATION);
            response.addHeader(Constant.AUTHORIZATION, Constant.PREFIX + token);
            ResponseUtil.add(response, Response.success());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
