package io.github.emircakmakgil.productservice.dto.ProductDto;

import io.github.emircakmakgil.productservice.model.enums.ProductType;
import io.github.emircakmakgil.productservice.model.enums.Status;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {
    
    @NotBlank(message = "Product name is required")
    @Size(min = 2, max = 255, message = "Product name must be between 2 and 255 characters")
    private String name;
    
    @Size(max = 2000, message = "Description cannot exceed 2000 characters")
    private String description;
    
    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @DecimalMax(value = "999999.99", message = "Price cannot exceed 999999.99")
    private BigDecimal price;
    
    @NotNull(message = "Stock quantity is required")
    @Min(value = 0, message = "Stock quantity cannot be negative")
    @Max(value = 999999, message = "Stock quantity cannot exceed 999999")
    private Integer stockQuantity;

    @DecimalMin(value = "0.0", message = "Weight cannot be negative")
    private Double weight;


    private Status status;


    @NotNull(message = "Product type is required")
    private ProductType productType; // PHYSICAL, DIGITAL, SERVICE, etc.

}
