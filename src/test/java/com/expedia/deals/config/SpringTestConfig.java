package com.expedia.deals.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({ "com.expedia" })
@PropertySource("classpath:/test-config.properties")
@Profile(SpringProfiles.PROFILE_TEST)
public class SpringTestConfig extends WebMvcConfigurerAdapter {

}