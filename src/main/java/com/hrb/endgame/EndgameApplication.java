package com.hrb.endgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages={"com.hrb.endgame"})
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EndgameApplication extends SpringBootServletInitializer{

	@Override
    protected SpringApplicationBuilder configure(
      SpringApplicationBuilder builder) {
        return builder.sources(EndgameApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(EndgameApplication.class, args);
	}

}
