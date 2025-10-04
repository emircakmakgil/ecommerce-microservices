package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.CategoryDto.CreateCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.DeleteCategoryDto;
import io.github.emircakmakgil.productservice.dto.CategoryDto.UpdateCategoryDto;
import io.github.emircakmakgil.productservice.entity.Category;
import io.github.emircakmakgil.productservice.mapper.CategoryMapper;
import io.github.emircakmakgil.productservice.model.enums.Status;
import io.github.emircakmakgil.productservice.repository.CategoryRepository;
import io.github.emircakmakgil.productservice.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    private CategoryService categoryService;
    @Mock
    private CategoryRepository categoryRepository;
    @Mock
    private CategoryMapper categoryMapper;
    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    private UUID id;
    private Category category;
    private CreateCategoryDto createCategoryDto;
    private UpdateCategoryDto updateCategoryDto;
    private DeleteCategoryDto deleteCategoryDto;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        category=new Category();
        category.setId(id);
        category.setName("Test Category");
        category.setDescription("This is a test category");
        category.setStatus(Status.ACTIVE);
        category.setImageUrl("https://example.com/image.png");

        createCategoryDto=new CreateCategoryDto();
        createCategoryDto.setName("Test Category");
        createCategoryDto.setDescription("This is a test category");
        createCategoryDto.setStatus(Status.ACTIVE);
        createCategoryDto.setImageUrl("https://example.com/image.png");

        updateCategoryDto=new UpdateCategoryDto();
        updateCategoryDto.setId(id);
        updateCategoryDto.setName("Updated Test Category");
        updateCategoryDto.setDescription("This is an updated test category");
        updateCategoryDto.setStatus(Status.INACTIVE);
        updateCategoryDto.setImageUrl("https://example.com/updated-image.png");

        deleteCategoryDto=new DeleteCategoryDto();
        deleteCategoryDto.setId(id);
    }
    @Test
    void whenFindByIdCalledWithValidId_itShouldReturnCategory(){
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        Category foundCategory = categoryServiceImpl.findById(id);
        assertNotNull(foundCategory);
        assertEquals(category.getId(), foundCategory.getId());
        assertEquals(category.getName(), foundCategory.getName());
        assertEquals(category.getDescription(), foundCategory.getDescription());
        assertEquals(category.getStatus(), foundCategory.getStatus());
        assertEquals(category.getImageUrl(), foundCategory.getImageUrl());
        verify(categoryRepository, times(1)).findById(id);
    }
    @Test
    void whenAddCalledWithValidRequest_itShouldSaveCategoryToRepository(){
        when(categoryMapper.createCategoryFromCreateCategoryDto(createCategoryDto)).thenReturn(category);
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // Act: Calling the add method
        categoryServiceImpl.add(createCategoryDto);

        // Assert: Verifying the interactions
        verify(categoryRepository, times(1)).save(any(Category.class));
        verify(categoryMapper, times(1)).createCategoryFromCreateCategoryDto(createCategoryDto);
    }
    @Test
    void whenUpdateCalledWithValidRequest_itShouldUpdateCategoryInRepository(){
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // Act: Calling the update method
        categoryServiceImpl.update(updateCategoryDto);

        // Assert: Verifying the interactions
        verify(categoryRepository, times(1)).findById(id);
        verify(categoryRepository, times(1)).save(any(Category.class));
    }
    @Test
    void whenDeleteCalledWithValidRequest_itShouldDeleteCategoryFromRepository() {
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));
        categoryServiceImpl.delete(deleteCategoryDto);
        verify(categoryRepository, times(1)).findById(id);
    }

}
