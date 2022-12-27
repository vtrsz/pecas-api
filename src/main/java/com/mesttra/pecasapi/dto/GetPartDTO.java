package com.mesttra.pecasapi.dto;

import com.mesttra.pecasapi.entity.Part;
import com.mesttra.pecasapi.enums.Category;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPartDTO {
    @NotBlank(message = "name cannot be blank")
    private String name;

    @NotBlank(message = "carModel cannot be blank")
    private String carModel;

    @NotNull(message = "sellPrice cannot be null")
    private double sellPrice;

    @NotNull(message = "stockQuantity cannot be null")
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private Category category;
}
