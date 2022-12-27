package com.mesttra.pecasapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdatePartDTO {
    @NotNull(message = "costPrice cannot be null")
    private double costPrice;

    @NotNull(message = "sellPrice cannot be null")
    private double sellPrice;

    @NotNull(message = "stockQuantity cannot be null")
    private int stockQuantity;
}