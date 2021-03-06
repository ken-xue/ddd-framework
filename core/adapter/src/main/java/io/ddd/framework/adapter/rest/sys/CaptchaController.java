package io.ddd.framework.adapter.rest.sys;

import io.ddd.framework.acl.authorize.AuthorizeService;
import io.ddd.framework.acl.authorize.dto.CaptchaGetDTO;
import io.ddd.framework.adapter.rest.common.BasicController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

@RestController
@Api(tags = "验证模块",description = "获取验证码")
@RequestMapping("/captcha")
public class CaptchaController extends BasicController {
    @Resource
    private AuthorizeService authorizeService;
    /**
     * 获取验证码
     */
    @GetMapping("/get")
    @ApiOperation(value = "获取验证码",httpMethod = "GET")
    public void info(@ModelAttribute CaptchaGetDTO captchaGetDTO, HttpServletResponse response) throws Exception{
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        BufferedImage image = authorizeService.generateCaptcha(captchaGetDTO);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }
}
