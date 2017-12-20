package com.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class ProjetoBaseApplication extends SpringBootServletInitializer {
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(ProjetoBaseApplication.class);
//	}
//
//	public static void main(String[] args) throws Exception {
//		SpringApplication.run(ProjetoBaseApplication.class, args);
//	}
//}

@SpringBootApplication
public class ProjetoBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoBaseApplication.class, args);
	}
}
