package br.com.cardapio.service;

import br.com.cardapio.DTOs.request.CategoryRequestDTO;
import br.com.cardapio.DTOs.response.CategoryResponseDTO;
import br.com.cardapio.Entities.Category;
import br.com.cardapio.FoodRepository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    //metodo para listar todas as categorias
    public List<CategoryResponseDTO> listAllCategory(){
        List<Category> categories;
        categories = repository.findAll();
        return categories.stream().map(CategoryResponseDTO::new).collect(Collectors.toList());
    }

    //metodo para buscar categoria por id
    public Optional<CategoryResponseDTO> listCategoryById(Long cdCategory){

        Optional<Category> category = repository.findById(cdCategory);

        if(category.isEmpty()) {
            return Optional.empty();
        }

        return category.map(findCategory -> new CategoryResponseDTO(findCategory.getCdCategory(), findCategory.getCategory(), findCategory.getFoods()));

    }


    //metodo para salvar uma nova categoria
    public Category createNewCategory(CategoryRequestDTO categoryDTO) {
        Category categoryData = new Category(categoryDTO);
        return repository.save(categoryData);
    }

}
