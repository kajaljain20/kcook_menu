package com.kcook.menu.foodItem;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class FoodItem {
    @Id
    private Integer id;

    private String dishName;

    private Double price;

    private String category;

    private String details;

}
