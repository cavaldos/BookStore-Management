
package store;

public class Singleton {
    private static Singleton instance = null;
    private String name = "Singleton";

    private Singleton( ) {
    }

    private Singleton(String name) {
        this.name = name;
    }
    public void login (String name ) {
        name = name;
    }

    public static Singleton getInstance(String name) {
        if (instance == null) {
            instance = new Singleton(name);
        }
        return instance;
    }

    public String getName() {
        return name;
    }

}
