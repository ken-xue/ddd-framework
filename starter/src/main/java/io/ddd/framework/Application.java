package io.ddd.framework;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = { "io.ddd.framework"})
@MapperScan("io.ddd.framework.infrastructure")
@EnableEncryptableProperties
public class Application {
    @RequestMapping({"/ok", "/ok.htm"})
    @ResponseBody
    public String ok() {
        return "ok";
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
