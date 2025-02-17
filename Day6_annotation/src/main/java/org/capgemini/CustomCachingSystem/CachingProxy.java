package org.capgemini.CustomCachingSystem;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CachingProxy implements InvocationHandler {
    private final Object target;

    public CachingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CacheResult.class)) {
            SimpleCache.CacheKey key = new SimpleCache.CacheKey(args);
            Object cachedResult = SimpleCache.get(key);
            if (cachedResult != null) {
                System.out.println("Returning cached result for " + method.getName());
                return cachedResult;
            }
            Object result = method.invoke(target, args);
            SimpleCache.put(key, result);
            return result;
        }
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new CachingProxy(target)
        );
    }
}

