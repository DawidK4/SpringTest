package edu.pja.mas.dkucharski.s27637_mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@Table(name = "app_user") // has to be added because USER is a reserved word in SQL
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@ToString
public abstract class User {
    /*
    🧠 Justification for JOINED strategy:
    Clear normalization between User, Customer, and Employee; avoids data duplication and keeps integrity.
    💡 Counter-example: SINGLE_TABLE may lead to many nullable columns and data redundancy in large systems.
    SINGLE_TABLE is suitable when the tables do not differ much due to little null column values
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Email must not be null!")
    private String email;

    @NotBlank(message = "Password must not be empty!")
    private String passwordHash;
}
