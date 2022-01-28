package io.ddd.framework.codegenerator.execute;

import io.ddd.framework.codegenerator.handler.CodeGeneratorHandler;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class CodeGenerateExecutor {

    @Resource
    private CodeGeneratorHandler codeGeneratorHandler;

    @PostConstruct
    private void execute() throws ConfigurationException {
        PropertiesConfiguration configuration = new PropertiesConfiguration("generator.properties");
        codeGeneratorHandler.execute(configuration);
    }
}
