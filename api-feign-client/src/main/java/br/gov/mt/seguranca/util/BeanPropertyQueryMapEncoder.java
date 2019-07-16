package br.gov.mt.seguranca.util;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.QueryMapEncoder;
import feign.codec.EncodeException;

/**
 * the query map will be generated using java beans accessible getter property
 * as query parameter names.
 *
 * eg: "/uri?name={name}&number={number}"
 *
 * order of included query parameters not guaranteed, and as usual, if any value
 * is null, it will be left out
 */
public class BeanPropertyQueryMapEncoder implements QueryMapEncoder {

	@Override
	public Map<String, Object> encode(Object object) throws EncodeException {
			Map<String, Object> objectMaps = new ObjectMapper().convertValue(object, new TypeReference<Map<String, Object>>() {} );
			
			Map<String, Object> propertyNameToValue = new HashMap<String, Object>();
			objectMaps.entrySet().forEach(p -> propertyNameToValue.put(p.getKey(), p.getValue()));
			
			return propertyNameToValue;
	}

}
