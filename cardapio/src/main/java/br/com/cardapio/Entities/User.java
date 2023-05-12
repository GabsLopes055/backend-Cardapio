package br.com.cardapio.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Table(name = "tbl-user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cdUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cdUser;

    @NotBlank(message = "O nome não pode ser vazio")
    private String name;

    @Email
    @NotBlank(message = "O email não pode ser vazio")
    private String email;

    @NotBlank(message = "A senha não pode estar vazia")
    private String password;

    @NotBlank
    private String statusUser;



}
