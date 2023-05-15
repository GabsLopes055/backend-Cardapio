package br.com.cardapio.FoodRepository;

import br.com.cardapio.Entities.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository  extends JpaRepository<Food, Long> {
}
