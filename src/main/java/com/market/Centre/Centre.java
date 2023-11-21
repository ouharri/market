package com.market.Centre;

import com.market.City.City;
import com.market.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Centre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Centre name cannot be blank")
    @NotNull(message = "Centre name must be provided")
    private String centreName;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToOne
    @JoinColumn(name = "admin_id")
    private User admin;
}
