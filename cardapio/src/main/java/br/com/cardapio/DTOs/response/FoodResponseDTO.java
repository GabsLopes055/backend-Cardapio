package br.com.cardapio.DTOs.response;

import br.com.cardapio.Entities.Food;

public record FoodResponseDTO(Long cdFood, String title, String image, Double price) {

    public FoodResponseDTO(Food food) {
        this(food.getCdFood(),
                food.getTitle(),
                food.getImage(),
                food.getPrice());
    }

}
