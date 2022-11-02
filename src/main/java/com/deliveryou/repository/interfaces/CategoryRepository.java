package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Category;

import java.util.List;

public interface CategoryRepository {
    Category getCategory(int id);
    Category getCategory(String name);
    List<Object[]> postsPerCategory(String phoneNumber);
}
