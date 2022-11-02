package com.deliveryou.service.implementations;

import com.deliveryou.pojo.Category;
import com.deliveryou.repository.interfaces.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements com.deliveryou.service.interfaces.CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    @Override
    public Category getCategory(String name) {
        name = name.trim();
        Category category = categoryRepository.getCategory(name);
        return category;
    }

    @Override
    public List<Object[]> postsPerCategory(String phoneNumber) {
        return categoryRepository.postsPerCategory(phoneNumber);
    }
}
