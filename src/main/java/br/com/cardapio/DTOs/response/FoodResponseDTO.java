package br.com.cardapio.DTOs.response;

import br.com.cardapio.Entities.Category;
import br.com.cardapio.Entities.Food;

public record FoodResponseDTO(Long cdFood, String title, String image, Double price, Category cdCategory) {

    public FoodResponseDTO(Food food) {
        this(food.getCdFood(),
                food.getTitle(),
                food.getImage(),
                food.getPrice(),
                food.getCdCategory());
    }

}
