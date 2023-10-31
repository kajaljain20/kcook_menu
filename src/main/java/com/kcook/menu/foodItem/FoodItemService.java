package com.kcook.menu.foodItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepository foodItemRepository;

    public FoodItemResponse getFoodItems() {
        Iterable<FoodItem> foodItems = foodItemRepository.findAll();

        FoodItemResponse foodItemResponse = new FoodItemResponse();

        ContentResponse contentResponse = new ContentResponse();
        contentResponse.setFoodItems(foodItems);

        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setCode(200);
        standardResponse.setMessage("SUCCESS");
        standardResponse.setDescription("List retrieved successfully");

        foodItemResponse.setStandardResponse(standardResponse);
        foodItemResponse.setContentResponse(contentResponse);

        return foodItemResponse;
    }

    public FoodItemResponse addFoodItem(final FoodItem foodItem) {
        foodItemRepository.save(foodItem);

        FoodItemResponse foodItemResponse = new FoodItemResponse();

        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setCode(200);
        standardResponse.setMessage("SUCCESS");
        standardResponse.setDescription("Food item created successfully");

        foodItemResponse.setStandardResponse(standardResponse);

        return foodItemResponse;
    }

    public FoodItemResponse deleteFoodItem(int id) {
        foodItemRepository.deleteById(id);

        FoodItemResponse foodItemResponse = new FoodItemResponse();

        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setCode(200);
        standardResponse.setMessage("SUCCESS");
        standardResponse.setDescription("Food item deleted successfully");

        foodItemResponse.setStandardResponse(standardResponse);

        return foodItemResponse;
    }

    public FoodItemResponse updateFoodItem(int id, FoodItem foodItem) {
        foodItemRepository.save(foodItem);

        FoodItemResponse foodItemResponse = new FoodItemResponse();

        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setCode(200);
        standardResponse.setMessage("SUCCESS");
        standardResponse.setDescription("Food item updated successfully");

        foodItemResponse.setStandardResponse(standardResponse);

        return foodItemResponse;
    }


}
