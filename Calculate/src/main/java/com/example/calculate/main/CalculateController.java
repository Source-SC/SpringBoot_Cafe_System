package com.example.calculate.main;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CalculateController {

    private static int totalPrice = 0;

    @RequestMapping("order-menu")
    public String send_total_price(@RequestParam String order_name, @RequestParam String order_count){
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // parameter 세팅
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("order_name", order_name);

        // REST API 호출
        String result = restTemplate.postForObject("http://menu-service/price/", map, String.class);
        totalPrice = totalPrice + Integer.valueOf(order_count) * Integer.valueOf(result);
        return String.valueOf(totalPrice);
    }
}
