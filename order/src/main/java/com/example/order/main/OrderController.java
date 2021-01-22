package com.example.order.main;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @GetMapping(path = "/order/{name}/{count}")
    public String helloWorld(@PathVariable String name, @PathVariable String count){
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // parameter 세팅
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("order_name", name);
        map.add("order_count", count);

        // REST API 호출
        String result = restTemplate.postForObject("http://localhost:8091/order-menu/", map, String.class);
        System.out.println("------------------ TEST 결과 ------------------");
        System.out.println(result);

        return result+"won";
    }
}
