package com.kcook.menu.foodItem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends CrudRepository<FoodItem, Integer> {
}
