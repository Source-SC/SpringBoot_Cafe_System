package com.example.pretestserver.Main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/request-calculate")
    public String calculate(@RequestParam String str1){
        return str1.concat(" : successed!");
    }
}
