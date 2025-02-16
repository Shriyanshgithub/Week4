package org.capgemini.Reflection.Advance_Level.Problem_10;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an interface
interface Greeting {
    void sayHello(String name);
}

// Step 2: Implement the interface
class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

// Step 3: Create a Dynamic Proxy with Logging
class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method invocation
        System.out.println("Method called: " + method.getName());

        // Execute the actual method
        return method.invoke(target, args);
    }
}

// Step 4: Generate a Proxy Instance
public class DynamicProxyExample {
    public static void main(String[] args) {
        // Create real object
        Greeting realGreeting = new GreetingImpl();

        // Create proxy instance
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                realGreeting.getClass().getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxy(realGreeting)
        );

        // Call method via proxy
        proxyInstance.sayHello("Alice");
    }
}
