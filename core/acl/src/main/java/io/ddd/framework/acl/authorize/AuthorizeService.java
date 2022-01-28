package io.ddd.framework.acl.authorize;

import io.ddd.framework.acl.authorize.dto.CaptchaGetDTO;
import io.ddd.framework.acl.authorize.dto.CaptchaValidateDTO;

import java.awt.image.BufferedImage;
import java.util.List;

public interface AuthorizeService {
    /**
     * 获取用户授权列表
     * @return
     */
    List<String> getPermissions();

    /**
     * 生成验证码
     * @param captchaGetQry
     * @return
     */
    BufferedImage generateCaptcha(CaptchaGetDTO captchaGetQry);

    /**
     * 验证验证码
     */
    Boolean captchaValidate(CaptchaValidateDTO captchaValidateDTO);

}
