package patterns.creational.factorymethod;

public class Example1Factory implements ExampleBaseFactory {

    @Override
    public ExampleBase createExample() {
        return new Example1();
    }
}
