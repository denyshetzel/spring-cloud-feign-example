package br.gov.mt.seguranca;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.querymap.BeanQueryMapEncoder;

@Configuration
public class FeignClientConfig {

	@Autowired private ObjectFactory<HttpMessageConverters> messageConverters;
	 

	@Bean
	public Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	
	/*
	 * @Bean public Encoder feignFormEncoder() { return new SpringFormEncoder(new
	 * SpringEncoder(messageConverters)); }
	 */

	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder()
				.requestInterceptor(new FeignBasicAuthRequestInterceptor())
				//.decoder(new JacksonDecoder())
				//.encoder(new JacksonEncoder());
				//.contract(new SpringMvcContract()); 
				//.encoder(new SpringEncoder(messageConverters))
				//.decoder(new SpringDecoder(messageConverters))
				//.decoder(new ResponseEntityDecoder(new SpringDecoder(messageConverters)))
				.queryMapEncoder(new BeanQueryMapEncoder());
				//.queryMapEncoder(new FieldQueryMapEncoder());
				//.contract(new SpringMvcPojoObjectQueryContract());
				//.contract(new SpringMvcPojoObjectQueryContract());
	}

}
