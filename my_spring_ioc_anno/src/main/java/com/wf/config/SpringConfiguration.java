package com.wf.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//标志该类是Spring的核心配置类
//<context:component-scan base-package="com.wf"></context:component-scan>

@Configuration
@ComponentScan("com.wf")
@Import({DataSourceConfiguration.class})
public class SpringConfiguration {

}
