package br.com.cardapio.DTOs.response;

import br.com.cardapio.Entities.Category;
import br.com.cardapio.Entities.Food;

import java.util.List;

public record CategoryResponseDTO(Long cdCategory, String category, List<Food> foods) {

    public CategoryResponseDTO(Category category) {
        this(category.getCdCategory(), category.getCategory(), category.getFoods());
    }
}
