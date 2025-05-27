import java.lang.reflect.*;
public class reflection {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("hello");
        Object obj = cls.getDeclaredConstructor().newInstance();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            System.out.println("Parameters: " + method.getParameterCount());
        }
        Method greetMethod = cls.getMethod("greet", String.class);
        greetMethod.invoke(obj, "Saravanan");
        Method secretMethod = cls.getDeclaredMethod("secret");
        secretMethod.setAccessible(true);
        secretMethod.invoke(obj);
    }
}
