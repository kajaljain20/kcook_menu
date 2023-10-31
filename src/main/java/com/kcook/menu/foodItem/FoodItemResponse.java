package com.kcook.menu.foodItem;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class FoodItemResponse {

    StandardResponse standardResponse;
    ContentResponse contentResponse;

}
