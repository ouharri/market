package com.market.Loyalty;

import com.market.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Loyalty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID loyaltyId;

    @OneToOne
    private User user;

    private int points;
}
