package com.market.City;

import com.market.Centre.Centre;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "City name cannot be blank")
    @NotNull(message = "City name must be provided")
    private String cityName;

    @NotBlank(message = "Country cannot be blank")
    @NotNull(message = "Country must be provided")
    private String country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Centre> centres;
}