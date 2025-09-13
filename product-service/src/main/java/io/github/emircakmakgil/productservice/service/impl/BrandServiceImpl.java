package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.DeleteBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService {
    @Override
    public List<Brand> findAll(List<UUID> brand) {
        return List.of();
    }

    @Override
    public Brand findById(UUID id) {
        return null;
    }

    @Override
    public void add(CreateBrandDto createBrandDto) {

    }

    @Override
    public List<BrandListiningDto> getAll() {
        return List.of();
    }

    @Override
    public Brand update(UpdateBrandDto updateBrandDto) {
        return null;
    }

    @Override
    public void delete(DeleteBrandDto deleteBrandDto) {

    }
}
