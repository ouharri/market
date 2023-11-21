package com.market.SubCategoryProduct;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.CategoryProduct.CategoryProduct;
import com.market.Product.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String subCategoryName;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private CategoryProduct category;

    @OneToMany(mappedBy = "subCategory")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Product> products;
}