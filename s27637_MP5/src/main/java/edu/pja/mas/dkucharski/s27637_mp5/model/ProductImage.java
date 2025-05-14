package edu.pja.mas.dkucharski.s27637_mp5.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "URL must not be null!")
    @Size(min = 2, max = 255)
    private String url;

    @NotBlank(message = "Text must not be null!")
    @Size(max = 10000)
    private String text;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false, updatable = false)
    private Product product;
}
