package br.com.cardapio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EntityScan(basePackages = "br.com.cardapio.Entities")
public class CardapioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardapioApplication.class, args);
	}

}
