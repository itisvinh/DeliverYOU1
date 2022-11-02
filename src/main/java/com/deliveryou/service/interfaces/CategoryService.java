package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(int id);
    Category getCategory(String name);

    List<Object[]> postsPerCategory(String phoneNumber);
}
