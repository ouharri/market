package com.market.Promotion;

import com.market.CategoryProduct.CategoryProduct;
import com.market.Product.Product;
import com.market.SubCategoryProduct.SubCategoryProduct;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link Promotion}
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDto {

    @NotNull @Min(10) @Max(70) Double percentage;
    String description;
    @NotNull Date dateDebut;
    @NotNull Date dateFin;
    List<UUID> productIds = new ArrayList<>();
    List<UUID> categoryProductIds = new ArrayList<>();
    List<UUID> subCategoryProductIds = new ArrayList<>();

    public Promotion toModel() {
        List<Product> products = new ArrayList<>();
        List<SubCategoryProduct> subCategoryProducts = new ArrayList<>();
        List<CategoryProduct> categoryProducts = new ArrayList<>();
        this.productIds.forEach(productId -> products.add(Product.builder().id(productId).build()));
        this.subCategoryProductIds.forEach(subCategoryId -> subCategoryProducts.add(SubCategoryProduct.builder().id(subCategoryId).build()));
        this.categoryProductIds.forEach(categoryProductId -> categoryProducts.add(CategoryProduct.builder().id(categoryProductId).build()));
        return Promotion
                .builder()
                .percentage(this.percentage)
                .description(this.description)
                .dateDebut(this.dateDebut)
                .dateFin(this.dateFin)
                .categoryProducts(categoryProducts)
                .products(products)
                .subCategoryProducts(subCategoryProducts)
                .build();
    }
}