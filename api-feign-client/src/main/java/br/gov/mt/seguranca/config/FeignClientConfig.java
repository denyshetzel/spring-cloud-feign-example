package br.gov.mt.seguranca.config;

import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;

@Configuration
public class FeignClientConfig {

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder()
				//.requestInterceptor(new BasicAuthenticationInterceptor("user", "password"))
				.requestInterceptor(new FeignBasicAuthRequestInterceptor())
				.contract(new SpringMvcContract()); 
	}

}
