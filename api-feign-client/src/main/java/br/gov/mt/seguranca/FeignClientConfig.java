package br.gov.mt.seguranca;

import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.Logger;
import feign.Retryer;
import feign.querymap.BeanQueryMapEncoder;

@Configuration
public class FeignClientConfig {

	/*
	 * @Autowired private ObjectFactory<HttpMessageConverters> messageConverters;
	 */

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
				// .decoder(new JacksonDecoder())
				// .encoder(new JacksonEncoder());
				//.encoder(new SpringEncoder(messageConverters)).decoder(new SpringDecoder(messageConverters))
				.queryMapEncoder(new BeanQueryMapEncoder())
				//.queryMapEncoder(new FieldQueryMapEncoder())
				//.contract(new SpringMvcContract())
				.retryer(Retryer.NEVER_RETRY);
	}

}
