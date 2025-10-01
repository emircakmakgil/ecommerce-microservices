package io.github.emircakmakgil.productservice.service.impl;

import io.github.emircakmakgil.productservice.dto.BrandDto.BrandListiningDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.CreateBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.DeleteBrandDto;
import io.github.emircakmakgil.productservice.dto.BrandDto.UpdateBrandDto;
import io.github.emircakmakgil.productservice.entity.Brand;
import io.github.emircakmakgil.productservice.mapper.BrandMapper;
import io.github.emircakmakgil.productservice.repository.BrandRepository;
import io.github.emircakmakgil.productservice.service.BrandService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static io.github.emircakmakgil.productservice.constant.GeneralConstant.BRAND_NOT_FOUND;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final BrandMapper brandMapper;

    public BrandServiceImpl(BrandRepository brandRepository, BrandMapper brandMapper) {
        this.brandRepository = brandRepository;
        this.brandMapper = brandMapper;
    }

    //TODO: Add logging
    //TODO: ADD EXCEPTION HANDLING
    @Override
    public List<Brand> findAll(List<UUID> brand) {
        List<Brand> brands = brandRepository.findAllById(brand);
        return brands;
    }

    @Override
    public Brand findById(UUID id) {
        Brand brand=brandRepository.findById(id).orElseThrow(()->new RuntimeException(BRAND_NOT_FOUND+id));
        return brand;
    }

    @Override
    public void add(CreateBrandDto createBrandDto) {
        Brand brand=brandMapper.createBrandFromCreateBrandDto(createBrandDto);
        brandRepository.save(brand);

    }

    @Override
    public List<BrandListiningDto> getAll() {
        List<Brand> brands=brandRepository.findAll();
        List<BrandListiningDto> brandListiningDtos=brands
                .stream()
                .map(brandMapper::toBrandListiningDto)
                .collect(Collectors.toList());
        return brandListiningDtos;
    }

    @Override
    public Brand update(UpdateBrandDto updateBrandDto) {
            Brand updatedBrand=brandMapper.updateBrandFromUpdateBrandDto(updateBrandDto);
            brandRepository.save(updatedBrand);
            return updatedBrand;
    }

    @Override
    public void delete(DeleteBrandDto deleteBrandDto) {
        Brand brand=brandRepository.findById(deleteBrandDto.getId()).orElseThrow(()->new RuntimeException(BRAND_NOT_FOUND+deleteBrandDto.getId()));
        brandRepository.delete(brand);
    }
}
