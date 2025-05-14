package edu.pja.mas.dkucharski.s27637_mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name must not be null!")
    @Size(min = 2, max = 255)
    private String name;

    @Min(1)
    private double price;

    @Min(1)
    private Long quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private Set<OrderDetails> isContainedBy = new HashSet<>();
}
