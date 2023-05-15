package br.com.cardapio.DTOs.request;

import br.com.cardapio.Entities.Category;

public record FoodRequestDTO(Long cdFood, String title, String image, Double price, Category cdCategory) {
}
