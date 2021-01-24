package com.example.preuser.main;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {


    @GetMapping(path = "/hello")
    public String helloWorld(){
        return "welcome";
    }

    @GetMapping(path = "/plus/{str1}")
    public String calculate(@PathVariable String str1){
        List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(converters);

        // parameter 세팅
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("str1", str1);

        // REST API 호출
//        String result = restTemplate.postForObject("http://localhost:9001/request-calculate/", map, String.class);
        String result = restTemplate.postForObject("http://localhost:9010/test/request-calculate/", map, String.class);
        System.out.println("------------------ TEST 결과 ------------------");
        System.out.println(result);

        return result;
    }
}
