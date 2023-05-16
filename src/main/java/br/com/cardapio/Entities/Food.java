package br.com.cardapio.Entities;


import br.com.cardapio.DTOs.response.FoodResponseDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cdFood")
@Entity
@Table(name = "tbl_food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdFood;

    private String title;

    private String image;

    private Double price;


    @ManyToOne
    @JsonBackReference
    private Category cdCategory;

    public Food(FoodResponseDTO data){
        this.image = data.image();
        this.title = data.title();
        this.price = data.price();
        this.cdCategory = data.cdCategory();
    }


}
