package br.gov.mt.seguranca.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Request.Body;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configurable
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
	@Autowired
	private ObjectMapper objectMapper;

	public FeignBasicAuthRequestInterceptor() {
	}

	@Override
	public void apply(RequestTemplate template) {
		if (template.method().equals("GET") && template.requestBody().asBytes() != null) {
			try {
				JsonNode jsonNode = new ObjectMapper().readTree(template.requestBody().asBytes());
				Map<String, Collection<String>> queries = new HashMap<>();
				buildQuery(jsonNode, "", queries);
				template.queries(queries);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		template.body(Body.empty());
	}

	private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
		if (!jsonNode.isContainerNode()) { 

			if (jsonNode.isNull()) {
				return;
			}
			Collection<String> values = queries.get(path);
			if (null == values) {
				values = new ArrayList<>();
				queries.put(path, values);
			}
			values.add(jsonNode.asText());
			return;
		}
		if (jsonNode.isArray()) { 
			Iterator<JsonNode> it = jsonNode.elements();
			while (it.hasNext()) {
				buildQuery(it.next(), path, queries);
			}
		} else {
			Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
			while (it.hasNext()) {
				Map.Entry<String, JsonNode> entry = it.next();
				if (StringUtils.hasText(path)) {
					buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
				} else { 
					buildQuery(entry.getValue(), entry.getKey(), queries);
				}
			}
		}
	}
}