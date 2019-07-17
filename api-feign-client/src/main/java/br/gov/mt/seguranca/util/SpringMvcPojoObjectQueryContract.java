package br.gov.mt.seguranca.util;
import java.lang.annotation.Annotation;

import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.web.bind.annotation.RequestBody;

import feign.MethodMetadata;

/**
* Created by jiangyu on 2019-01-10 22:52.
*/
public class SpringMvcPojoObjectQueryContract extends SpringMvcContract {

	/*
	 * public SpringMvcPojoObjectQueryContract(List<AnnotatedParameterProcessor>
	 * annotatedParameterProcessors, ConversionService conversionService) {
	 * super(annotatedParameterProcessors, conversionService); }
	 */

@Override
protected boolean processAnnotationsOnParameter(MethodMetadata data, Annotation[] annotations, int paramIndex) {
  boolean httpAnnotation = super.processAnnotationsOnParameter(data, annotations, paramIndex);
  //在springMvc中如果是Get请求且参数中是对象 没有声明为@RequestBody 则默认为Param
  if (!httpAnnotation && "GET".equalsIgnoreCase(data.template().method())) {
    for (Annotation parameterAnnotation : annotations) {
      if (!(parameterAnnotation instanceof RequestBody)) {
        return false;
      }
    }
    data.queryMapIndex(paramIndex);
    return true;
  }
  return httpAnnotation;
}
}