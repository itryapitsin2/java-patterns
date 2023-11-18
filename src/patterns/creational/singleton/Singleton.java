package patterns.creational.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if (Singleton.instance != null) {
            return Singleton.instance;
        }

        return new Singleton();
    }
}