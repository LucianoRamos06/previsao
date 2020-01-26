package br.com.previsao.model.generic;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class GenericRequest<O> {

    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<O> get(String url, HttpHeaders headers, Class<O> oClass) {
        final HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(null, headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, oClass);
    }
}
