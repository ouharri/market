package com.market.Promotion;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.market.CategoryProduct.CategoryProduct;
import com.market.Product.Product;
import com.market.SubCategoryProduct.SubCategoryProduct;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Temporal(TemporalType.DATE)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Date createdAt;

    @Temporal(TemporalType.DATE)
    @ColumnDefault("CURRENT_TIMESTAMP")
    private Date updatedAt;

    private Double percentage;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    private Date dateFin;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<CategoryProduct> categoryProducts = new ArrayList<>();

    @ManyToMany
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<SubCategoryProduct> subCategoryProducts = new ArrayList<>();
}
