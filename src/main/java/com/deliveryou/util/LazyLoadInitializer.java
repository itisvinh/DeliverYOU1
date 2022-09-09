package com.deliveryou.util;

import org.hibernate.Hibernate;

import java.util.List;

public final class LazyLoadInitializer {
    public static void lazyLoad(Object obj) {
        Hibernate.initialize(obj);
    }

    public static void lazyLoad(List<Object> list) {
        list.forEach(o -> lazyLoad(o));
    }

}
