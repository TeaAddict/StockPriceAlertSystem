package ooo.stock.StockPriceAlertSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PriceCondition priceCondition;

    private BigDecimal targetPrice;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
