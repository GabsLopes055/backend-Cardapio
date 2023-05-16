package br.com.cardapio.controller;

import br.com.cardapio.Entities.Food;
import br.com.cardapio.DTOs.response.FoodResponseDTO;
import br.com.cardapio.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/food")
public class FoodController {


    @Autowired
    private FoodService service;

    //metodo para retornar todas as comidas
    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<Food>> getAllFoods(){
        return ResponseEntity.ok().body(service.getAllFood());
    }

    //metodo para retornar uma comida por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Food>> getFoodById(@PathVariable Long id){
        if(service.getFoodById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(service.getFoodById(id));
    }

    //metodo para salvar uma comida
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Food> saveNewFood(@RequestBody FoodResponseDTO data){
        return ResponseEntity.ok().body(service.saveFood(data));
    }

    //metodo para deletar uma comida
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Optional<String>> deleteFood(@PathVariable Long id) {
        if(service.deleteFoodById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(service.deleteFoodById(id));
        }
    }

    //metodo para editar uma comida
    @PutMapping(value = "/{FoodId}")
    public ResponseEntity<Food> updateFood(@PathVariable Long FoodId, @RequestBody FoodResponseDTO data) {
        return ResponseEntity.ok().body(service.updateFood(FoodId, data));
    }








//    @GetMapping
//    @CrossOrigin(origins = "*", allowedHeaders = "*")
//


}
