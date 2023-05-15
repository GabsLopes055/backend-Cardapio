package br.com.cardapio.Entities;

import br.com.cardapio.DTOs.request.CategoryRequestDTO;
import br.com.cardapio.DTOs.response.CategoryResponseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdCategory;

    private String category;

    @JsonManagedReference
    @OneToMany(mappedBy = "cdCategory")
    public List<Food> foods = new ArrayList<>();

    public Category(CategoryRequestDTO data){
        this.category = data.category();
    }

}
