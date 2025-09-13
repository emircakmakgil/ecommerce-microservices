package io.github.emircakmakgil.productservice.dto.CategoryDto;

import io.github.emircakmakgil.productservice.model.enums.Status;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Getter
@Setter
public class CategoryListiningDto {
    private String name;
    private String description;
    private String imageUrl;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public CategoryListiningDto(String name, String description, String imageUrl, Status status, LocalDateTime createdAt,
                              LocalDateTime updatedAt) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
