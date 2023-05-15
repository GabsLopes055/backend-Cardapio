package br.com.cardapio.DTOs.request;

import br.com.cardapio.Entities.Food;

import java.util.List;

public record CategoryRequestDTO(Long cdCategory, String category, List<Food> foods) {
}
