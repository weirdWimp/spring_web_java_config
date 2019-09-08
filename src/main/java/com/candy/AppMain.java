package com.candy;

import com.candy.entity.MessageEntity;
import com.candy.exception.NameNotFoundException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class AppMain {

    public static void main(String[] args) {
        NameNotFoundException notFoundException = new NameNotFoundException("Jason");
        String message = notFoundException.getMessage();
        System.out.println(message);

        String name = "Guoph";
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("name", name);
        RestTemplate template = new RestTemplate();
        // MessageEntity messageEntity = template.getForObject("http://localhost:8080/rest/blog/responseEntity/{name}", MessageEntity.class, uriVariables);
        String messageEntity = template.getForObject("http://localhost:8080/rest/blog/responseEntity/{name}", String.class, uriVariables);
        System.out.println(messageEntity);
    }
}
