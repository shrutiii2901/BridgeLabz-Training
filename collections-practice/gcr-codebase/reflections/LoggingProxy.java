import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello!");
    }
}

public class LoggingProxy {
    public static void main(String[] args) {
        Greeting obj = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                (proxyObj, method, args1) -> {
                    System.out.println("Calling: " + method.getName());
                    return method.invoke(obj, args1);
                }
        );

        proxy.sayHello();
    }
}
