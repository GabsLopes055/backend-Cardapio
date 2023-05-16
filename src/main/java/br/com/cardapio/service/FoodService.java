package br.com.cardapio.service;

import br.com.cardapio.DTOs.response.FoodResponseDTO;
import br.com.cardapio.Entities.Food;
import br.com.cardapio.FoodRepository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    //metodo para retornar todas as comidas
    public List<Food> getAllFood() {

        return repository.findAll();

    }

    //metodo para retornar uma comida pelo id
    public Optional<Food> getFoodById(Long id) throws RuntimeException {

        Optional<Food> food = repository.findById(id);

        if(food.isEmpty()) {
            return food;
        }
        return food;
    }

    //metodo para salvar uma comida
    public Food saveFood(FoodResponseDTO data) {
        Food foodData = new Food(data);
        return repository.save(foodData);
    }

    //metodo para deletar uma comida
    public Optional<String> deleteFoodById(Long foodId) {

        Optional<Food> food = repository.findById(foodId);

        if(food.isEmpty()){
            return Optional.empty();
        } else {
            repository.deleteById(foodId);
            return Optional.of("Excluído com sucesso");
        }
    }

    //metodo para editar uma comida
    public Food updateFood(Long FoodId, FoodResponseDTO data) {

        Optional<Food> foodData = repository.findById(FoodId);

        if(foodData.isEmpty()){
            return (Food) ResponseEntity.noContent();
        }
        Food food = foodData.get();
        food.setTitle(data.title());
        food.setPrice(data.price());
        food.setImage(data.image());
        repository.save(food);
        return new ResponseEntity<Food>(food, HttpStatus.OK).getBody();
    }

}
