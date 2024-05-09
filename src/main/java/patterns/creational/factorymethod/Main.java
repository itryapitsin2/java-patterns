package patterns.creational.factorymethod;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ExampleBaseFactory exampleBaseFactory = createExampleBaseFactoryByParams("Example1");
        ExampleBase example = exampleBaseFactory.createExample();
        example.someExampleMethod();

        exampleBaseFactory = createExampleBaseFactoryByParams("Example2");
        example = exampleBaseFactory.createExample();
        example.someExampleMethod();
    }

    public static ExampleBaseFactory createExampleBaseFactoryByParams(String param) {
        if (Objects.equals(param, "Example1")) {
            return new Example1Factory();
        } else if (Objects.equals(param, "Example2")) {
            return new Example2Factory();
        } else {
            throw new RuntimeException("Unknown " + param);
        }
    }
}
