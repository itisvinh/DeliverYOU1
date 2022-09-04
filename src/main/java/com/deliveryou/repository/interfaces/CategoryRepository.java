package com.deliveryou.repository.interfaces;

import com.deliveryou.pojo.Category;

public interface CategoryRepository {
    Category getCategory(int id);
    Category getCategory(String name);
}
