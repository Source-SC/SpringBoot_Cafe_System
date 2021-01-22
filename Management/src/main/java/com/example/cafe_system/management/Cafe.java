package com.example.cafe_system.management;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Cafe {
    private static List<Coffee> menu = new ArrayList();

    private static int menuCount = 5;

    static{
        menu.add(new Coffee(1,"espresso", 2000));
        menu.add(new Coffee(2,"americano", 1000));
        menu.add(new Coffee(3,"cappuccino", 1500));
        menu.add(new Coffee(4,"cafelatte", 1700));
        menu.add(new Coffee(5,"cafemocha", 1900));
        menu.add(new Coffee(6,"macchiato", 2500));
        menu.add(new Coffee(7,"cake", 8000));
    }

    public Coffee find(String name){
        for(Coffee coffee : menu){
            if(coffee.getName().equals(name)){
                return coffee;
            }
        }
        return null;
    }

}
