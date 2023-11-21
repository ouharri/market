package com.market.Product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.Promotion.Promotion;
import com.market.SubCategoryProduct.SubCategoryProduct;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private Integer quantity;

    @NotBlank(message = "Product name cannot be blank")
    @NotNull(message = "Product name must be provided")
    private String productName;

    @NotBlank(message = "Product description cannot be blank")
    @NotNull(message = "Product description must be provided")
    private String productDescription;

    @NotBlank(message = "Product image cannot be blank")
    @NotNull(message = "Product image must be provided")
    private String productImage;

    @NotBlank(message = "Product price cannot be blank")
    @NotNull(message = "Product price must be provided")
    private String productPrice;

    @ManyToOne
    @JoinColumn(name = "sub_category_id", nullable = false)
    private SubCategoryProduct subCategory;

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Promotion> promotion;
}