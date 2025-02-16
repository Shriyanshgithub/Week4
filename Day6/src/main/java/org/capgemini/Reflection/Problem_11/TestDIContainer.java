package org.capgemini.Reflection.Problem_11;

public class TestDIContainer {
    public static void main(String[] args) throws Exception {
        SimpleDIContainer container = new SimpleDIContainer();

        // Register services in the DI container
        container.register(ServiceA.class);
        container.register(ServiceB.class);

        // Create ClientClass instance and inject dependencies
        ClientClass client = new ClientClass();
        container.injectDependencies(client);

        // Use the injected dependencies
        client.performOperations();
    }
}

