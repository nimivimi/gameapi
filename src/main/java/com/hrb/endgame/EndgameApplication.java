package com.hrb.endgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
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
