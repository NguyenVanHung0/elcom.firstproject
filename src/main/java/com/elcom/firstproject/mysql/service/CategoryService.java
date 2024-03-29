
package com.elcom.firstproject.mysql.service;

import com.elcom.firstproject.mysql.dto.CategoryDto;
import java.util.List;

public interface CategoryService{
    List<CategoryDto> getListCategory();
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, Long id);
    CategoryDto deleteCategory(Long id);
}
