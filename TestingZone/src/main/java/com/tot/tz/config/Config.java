package com.tot.tz.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:upload.properties") 
public class Config {
	
	@Value("${uploaddir}")
	public String UPLOADDIR;
}
