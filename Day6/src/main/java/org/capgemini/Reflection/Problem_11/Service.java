package org.capgemini.Reflection.Problem_11;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
// ServiceA: A dependency that needs to be injected
class ServiceA {
    public void doSomething() {
        System.out.println("ServiceA is doing something...");
    }
}

// ServiceB: Another service to be injected
class ServiceB {
    public void execute() {
        System.out.println("ServiceB is executing...");
    }
}
// Class that requires Dependency Injection
class ClientClass {
    @Inject  // Mark ServiceA for injection
    private ServiceA serviceA;

    @Inject  // Mark ServiceB for injection
    private ServiceB serviceB;

    // Method to use the injected services
    public void performOperations() {
        serviceA.doSomething();
        serviceB.execute();
    }
}

class SimpleDIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    // Register classes in the DI container
    public void register(Class<?> clazz) throws Exception {
        Object instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);
    }

    // Perform dependency injection
    public void injectDependencies(Object object) throws Exception {
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                Class<?> fieldType = field.getType();
                Object dependency = instances.get(fieldType);

                if (dependency == null) {
                    dependency = fieldType.getDeclaredConstructor().newInstance();
                    instances.put(fieldType, dependency);
                }

                field.setAccessible(true);
                field.set(object, dependency);
            }
        }
    }
}

