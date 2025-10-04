package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.DeleteBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.mapper.BrandMapper;
import io.github.emircakmakgil.productservice.repository.BrandRepository;
import io.github.emircakmakgil.productservice.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.github.emircakmakgil.productservice.model.enums.Status.ACTIVE;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class BrandServiceImplTest {
    @Mock
    private BrandRepository brandRepository;
    @Mock
    private BrandMapper brandMapper;
    @InjectMocks
    private BrandServiceImpl brandServiceImpl;

    private UUID id;
    private Brand brand;
    private CreateBrandDto createBrandDto;
    private UpdateBrandDto updateBrandDto;
    private DeleteBrandDto deleteBrandDto;

    @BeforeEach
    void setUp() {
        id = UUID.randomUUID();
        brand=new Brand();
        brand.setId(id);
        brand.setName("Test Brand");
        brand.setDescription("This is a test brand");
        brand.setLogoUrl("https://example.com/logo.png");
        brand.setWebsiteUrl("https://example.com");
        brand.setCountryOfOrigin("USA");
        brand.setFoundedYear(1990);

        createBrandDto=new CreateBrandDto();
        createBrandDto.setName("Test Brand");
        createBrandDto.setDescription("This is a test brand");
        createBrandDto.setLogoUrl("https://example.com/logo.png");
        createBrandDto.setWebsiteUrl("https://example.com");
        createBrandDto.setCountryOfOrigin("USA");
        createBrandDto.setFoundedYear(1990);
        createBrandDto.setStatus(ACTIVE);

        updateBrandDto=new UpdateBrandDto();
        updateBrandDto.setId(id);
        updateBrandDto.setName("Updated Brand");
        updateBrandDto.setDescription("This is an updated test brand");
        updateBrandDto.setLogoUrl("https://example.com/updated_logo.png");
        updateBrandDto.setWebsiteUrl("https://example.com/updated");
        updateBrandDto.setCountryOfOrigin("Canada");
        updateBrandDto.setFoundedYear(2000);
        updateBrandDto.setStatus(ACTIVE);

        deleteBrandDto=new DeleteBrandDto();
        deleteBrandDto.setId(id);
    }
    @Test
    void whenFindByIdCalled_itShouldReturnBrand() {
        when(brandRepository.findById(id)).thenReturn(java.util.Optional.of(brand));

        Brand foundBrand = brandServiceImpl.findById(id);

        assertNotNull(foundBrand);
        assertEquals(id, foundBrand.getId());
        assertEquals("Test Brand", foundBrand.getName());
        assertEquals("This is a test brand", foundBrand.getDescription());
        assertEquals("https://example.com/logo.png", foundBrand.getLogoUrl());
        assertEquals("https://example.com", foundBrand.getWebsiteUrl());
        assertEquals("USA", foundBrand.getCountryOfOrigin());
        assertEquals(1990, foundBrand.getFoundedYear());

        verify(brandRepository, times(1)).findById(id);
    }
    @Test
    void whenAddCalled_itShouldSaveBrandToRepository() {
    when(brandMapper.createBrandFromCreateBrandDto(createBrandDto)).thenReturn(brand);
    when(brandRepository.save(any(Brand.class))).thenReturn(brand);
    brandServiceImpl.add(createBrandDto);
    verify(brandRepository, times(1)).save(any(Brand.class));
    }
    @Test
    void whenUpdateCalled_itShouldUpdateBrandInRepository() {
        when(brandRepository.findById(id)).thenReturn(Optional.of(brand));
        brandServiceImpl.update(updateBrandDto);
        verify(brandRepository, times(1)).save(any(Brand.class));
    }
    @Test
    void whenDeleteCalled_itShouldDeleteBrandFromRepository() {
        when(brandRepository.findById(id)).thenReturn(Optional.of(brand));
        brandServiceImpl.delete(deleteBrandDto);
        verify(brandRepository, times(1)).delete(any(Brand.class));
    }
   @Test
    void whenGetAllCalled_itShouldReturnListOfBrands() {
         brandServiceImpl.getAll();
         verify(brandRepository, times(1)).findAll();
    }
}




