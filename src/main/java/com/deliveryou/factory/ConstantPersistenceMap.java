package com.deliveryou.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public final class ConstantPersistenceMap {
    private static Map<Object, Object> map = new HashMap<>();

    private ConstantPersistenceMap() {
    }

    public static Object access(Object obj) {
        if (obj != null) {
            if (map.containsKey(obj))
                return map.get(obj);
            map.put(obj, obj);
            return obj;
        }
        return null;
    }

    public static Object remove(Object obj) {
        return obj == null ? null : map.remove(obj);
    }

    public static void clear() {
        map.clear();
    }
}
