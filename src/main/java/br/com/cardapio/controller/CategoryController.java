package br.com.cardapio.controller;

import br.com.cardapio.DTOs.request.CategoryRequestDTO;
import br.com.cardapio.DTOs.response.CategoryResponseDTO;
import br.com.cardapio.Entities.Category;
import br.com.cardapio.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    //metodo para buscar todas as categorias
    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<List<CategoryResponseDTO>> listAllCategory(){
        return new ResponseEntity<>(service.listAllCategory(), HttpStatus.OK);
    }

    //metodo para buscar categoria pelo id
    @GetMapping(value = "/{cdCategory}")
    public ResponseEntity<Optional<CategoryResponseDTO>> findCategoryById(@PathVariable Long cdCategory){
        if(service.listCategoryById(cdCategory).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(service.listCategoryById(cdCategory));
    }

    //metodo para salvar uma nova categoria
    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<CategoryResponseDTO> createNewCategory(@RequestBody CategoryRequestDTO save){
        Category category = service.createNewCategory(save);
        return new ResponseEntity(category, HttpStatus.CREATED);
    }

    //metodo para editar uma categoria
    @PutMapping(value = "{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Optional<Category>> updateCategoryById(@PathVariable Long id, @RequestBody CategoryRequestDTO category){
        if(service.updateCategoryById(id, category).isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(service.updateCategoryById(id, category));
    }

    //metodo para excluir uma categoria
    @DeleteMapping(value = "{id}")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Optional<String>> deleteCategoryById(@PathVariable Long id){
        if(service.deleteCategoryById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(service.deleteCategoryById(id));

    }





}
