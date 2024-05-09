package patterns.creational.factorymethod;

public class Example2 implements ExampleBase {
    @Override
    public void someExampleMethod() {
        System.out.println(this.getClass().getName());
    }
}
