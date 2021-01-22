package com.example.cafe_system.management;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManageController {

    private Cafe menu;

    public ManageController(Cafe menu){ this.menu = menu; }

    @RequestMapping("/price")
    public int get_price(@RequestParam String order_name){
        Coffee coffee = menu.find(order_name);
        return coffee.getPrice();
    }
}
