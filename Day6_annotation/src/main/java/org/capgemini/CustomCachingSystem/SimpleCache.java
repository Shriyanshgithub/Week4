package org.capgemini.CustomCachingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class SimpleCache {
    private static final Map<CacheKey, Object> cache = new HashMap<>();

    public static Object get(CacheKey key) {
        return cache.get(key);
    }

    public static void put(CacheKey key, Object value) {
        cache.put(key, value);
    }

    // A simple key class to handle method arguments as cache keys
    public static class CacheKey {
        private final Object[] params;

        public CacheKey(Object... params) {
            this.params = params;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CacheKey cacheKey = (CacheKey) o;
            return Arrays.equals(params, cacheKey.params);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(params);
        }
    }
}

