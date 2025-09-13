package io.github.emircakmakgil.productservice.service;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.DeleteBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;

import java.util.List;
import java.util.UUID;

public interface BrandService {
    List<Brand> findAll(List<UUID> brand);
    Brand findById(UUID id);
    void add(CreateBrandDto createBrandDto);
    List<BrandListiningDto> getAll();
    Brand update(UpdateBrandDto updateBrandDto);
    void delete(DeleteBrandDto deleteBrandDto);
}
