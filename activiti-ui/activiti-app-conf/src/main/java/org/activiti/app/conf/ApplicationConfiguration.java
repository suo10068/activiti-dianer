package org.activiti.app.conf;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySources({
	@PropertySource("classpath:activiti-app.properties"),
	@PropertySource(value = "classpath:activiti-app.properties", ignoreResourceNotFound = true),
})
@ComponentScan(basePackages = {
        "org.activiti.app.conf",
        "org.activiti.app.repository",
        "org.activiti.app.service",
        "org.activiti.app.security",
        "org.activiti.app.model.component"})
public class ApplicationConfiguration {
	
	/**
	 * This is needed to make property resolving work on annotations ...
	 * (see http://stackoverflow.com/questions/11925952/custom-spring-property-source-does-not-resolve-placeholders-in-value) 
	 * 
	 * @Scheduled(cron="${someProperty}")
	 */
	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
}
