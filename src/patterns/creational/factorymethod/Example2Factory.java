package patterns.creational.factorymethod;

public class Example2Factory implements ExampleBaseFactory {

    @Override
    public ExampleBase createExample() {
        return new Example2();
    }
}
