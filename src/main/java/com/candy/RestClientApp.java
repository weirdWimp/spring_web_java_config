package com.candy;

import com.candy.entity.MessageEntity;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClientApp {

    private static final RestTemplate template = new RestTemplate();

    public static void main(String[] args) {
        // getRestfulResource();
        // exchangeGetRestfulResource();
        // postRestfulResource();

        MediaType contentType = new HttpHeaders().getContentType();
        System.out.println(contentType);
    }

    public static void getRestfulResource() {
        String parameterUri = "http://localhost:8080/rest/blog/responseEntity/{name}";
        MessageEntity messageEntity = template.getForObject(parameterUri, MessageEntity.class, "Guoph");
        System.out.println(messageEntity);
    }

    public static void postRestfulResource() {
        String parameterUri = "http://localhost:8080/rest/blog/save";
        MessageEntity entity = new MessageEntity("Guoph", "2019-08-13 21:35:00", "Hi there!");

        ResponseEntity<MessageEntity> responseEntity = template.postForEntity(parameterUri, entity, MessageEntity.class);
        System.out.println(responseEntity.getHeaders().getLocation().toString());
    }

    public static void exchangeGetRestfulResource() {
        String parameterUri = "http://localhost:8080/rest/blog/responseEntity/{name}";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<MessageEntity> responseEntity = template.exchange(parameterUri, HttpMethod.GET, httpEntity,
                MessageEntity.class, "Guoph");

        System.out.println(responseEntity);
    }

}
