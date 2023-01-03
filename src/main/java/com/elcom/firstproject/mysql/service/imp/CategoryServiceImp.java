package com.elcom.firstproject.mysql.service.imp;

import com.elcom.firstproject.auth.jwt.JwtTokenProvider;
import com.elcom.firstproject.convert.Mapper;
import com.elcom.firstproject.mysql.dto.CategoryDto;
import com.elcom.firstproject.exception.NoSuchElementException;
import com.elcom.firstproject.mysql.model.Category;
import com.elcom.firstproject.mysql.repository.CategoryRepository;
import com.elcom.firstproject.mysql.service.CategoryService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);

    @Autowired
    Mapper mapper;
    
    @Autowired
    private RedisTemplate template;

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
        Category category = categoryRepository.findById(id).orElse(null);
        CategoryDto categoryDto = new CategoryDto();
        if(category != null){
            template.opsForHash().put("category", category.getId(), category);
            template.expire("UniqueKey",30, TimeUnit.SECONDS);
            LOGGER.info("them cache category co id: " + id);
            LOGGER.info(template.opsForHash().get("category", category.getId()).toString());
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
        Category oldCategory = categoryRepository.findById(id).orElse(null);
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
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null){
            categoryRepository.deleteById(id);
            return mapper.toCategoryDto(category);
        }
        throw new NoSuchElementException("The loai khong ton tai");
    }

}
