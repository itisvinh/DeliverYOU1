package com.deliveryou.service.interfaces;

import com.deliveryou.pojo.Category;

public interface CategoryService {
    Category getCategory(int id);
    Category getCategory(String name);
}
