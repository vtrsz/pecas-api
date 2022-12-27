package com.mesttra.pecasapi.entity;

import com.mesttra.pecasapi.enums.Category;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Entity(name = "part")
@Table(name = "part")
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Part implements Serializable {
    @Serial
    private static final long serialVersionUID = -2602900653737263641L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long barCode;

    @Column(nullable = false)
    private String name;

    @Column(name = "car_model", nullable = false)
    private String carModel;

    @Column(name = "cost_price", nullable = false)
    private double costPrice;

    @Column(name = "sell_price", nullable = false)
    private double sellPrice;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;
}
