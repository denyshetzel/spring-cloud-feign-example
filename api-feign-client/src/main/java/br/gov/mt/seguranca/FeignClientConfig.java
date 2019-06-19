package br.gov.mt.seguranca;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import feign.querymap.BeanQueryMapEncoder;

@Configuration
public class FeignClientConfig {

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Encoder feignFormEncoder() {
		return new SpringFormEncoder(new SpringEncoder(messageConverters));
	}

	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder().encoder(new SpringEncoder(messageConverters)).decoder(new SpringDecoder(messageConverters)).queryMapEncoder(new BeanQueryMapEncoder()).retryer(Retryer.NEVER_RETRY);
	}

}
