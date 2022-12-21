package com.elcom.firstproject.service.imp;

import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.dto.CategoryDto;
import com.elcom.firstproject.exception.NoSuchElementException;
import com.elcom.firstproject.model.Category;
import com.elcom.firstproject.repository.CategoryRepository;
import com.elcom.firstproject.service.CategoryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<CategoryDto> getListCategory() {
        List<CategoryDto> result = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        if (!categories.isEmpty()) {
            for (Category category : categories) {
                result.add(mapper.toCategoryDto(category));
            }
        }
        return result;
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).get();
        CategoryDto categoryDto = new CategoryDto();
        if(category != null){
            categoryDto = mapper.toCategoryDto(category);
            return categoryDto;
        }
          throw new NoSuchElementException("The loai khong ton tai");
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = new Category();
        if(categoryDto != null){
            category = mapper.toCategory(categoryDto);
            category.setCreatedDate(new Date());
            categoryRepository.save(category);
        }
        return mapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long id) {
        Category oldCategory = categoryRepository.findById(id).get();
        Category category = new Category();
        if(oldCategory != null){
            category = mapper.toCategory(oldCategory, categoryDto);
            category.setId(id);
            category.setModifiedDate(new Date());
            categoryRepository.save(category);
            return mapper.toCategoryDto(category);
        }
         throw new NoSuchElementException("The loai khong ton tai");
    }

    @Override
    public CategoryDto deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).get();
        if(category != null){
            categoryRepository.deleteById(id);
            return mapper.toCategoryDto(category);
        }
        throw new NoSuchElementException("The loai khong ton tai");
    }

}
