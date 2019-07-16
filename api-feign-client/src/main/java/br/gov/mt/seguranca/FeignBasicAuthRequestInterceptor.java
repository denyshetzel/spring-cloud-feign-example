package br.gov.mt.seguranca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Configurable
public class FeignBasicAuthRequestInterceptor implements RequestInterceptor {
    public FeignBasicAuthRequestInterceptor() {}

    @Override
    public void apply(RequestTemplate template) {
        ///**get-pojo贯穿*/
        if (template.method().equals("GET") && template.requestBody().asBytes() != null) {
            try {
                JsonNode jsonNode = new ObjectMapper().readTree(template.requestBody().asBytes());
                //template.body(null);
                Map<String, Collection<String>> queries = new HashMap<>();
                //feign 不支持 GET 方法传 POJO, json body转query
                buildQuery(jsonNode, "", queries);
                template.queries(queries);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //处理 get-pojo贯穿
    private void buildQuery(JsonNode jsonNode, String path, Map<String, Collection<String>> queries) {
        if (!jsonNode.isContainerNode()) { //叶子节点
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
        if (jsonNode.isArray()) { //数组节点
            Iterator<JsonNode> it = jsonNode.elements();
            while (it.hasNext()) {
                buildQuery(it.next(), path, queries);
            }
        } else {
            Iterator<Map.Entry<String, JsonNode>> it = jsonNode.fields();
            while (it.hasNext()) {
                Map.Entry<String, JsonNode> entry = it.next();
                if (org.springframework.util.StringUtils.hasText(path)) {
                    buildQuery(entry.getValue(), path + "." + entry.getKey(), queries);
                } else { //根节点
                    buildQuery(entry.getValue(), entry.getKey(), queries);
                }
            }
        }
    }
}