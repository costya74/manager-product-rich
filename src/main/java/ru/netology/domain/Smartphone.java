package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
private String marker;

    public Smartphone(int id, String name, int price, String marker) {
        super(id, name, price);
        this.marker = marker;
    }
}
