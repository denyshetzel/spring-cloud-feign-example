package br.gov.mt.seguranca.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class ForwardedForInterceptor implements RequestInterceptor {
  @Override public void apply(RequestTemplate template) {
    System.out.println(template);
  }
}