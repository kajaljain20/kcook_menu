package com.kcook.menu.foodItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

    @Autowired
    private FoodItemRepository repository;

    @RequestMapping("/food-items")
    public FoodItemResponse getFoodItems() {
        return foodItemService.getFoodItems();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/food-items")
    public FoodItemResponse addFoodItems(@RequestBody FoodItem foodItem) {
        return foodItemService.addFoodItem(foodItem);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/food-items/{id}")
    public FoodItemResponse updateFoodItem(@RequestBody FoodItem foodItem, @PathVariable int id) {
        return foodItemService.updateFoodItem(id, foodItem);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/food-items/{id}")
    public FoodItemResponse deleteFoodItems(@PathVariable int id) {
        return foodItemService.deleteFoodItem(id);
    }
}
