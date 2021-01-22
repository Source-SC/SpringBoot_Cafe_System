package com.example.cafe_system.management;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Coffee {
    private Integer id;
    private String name;
    private Integer price;
}
