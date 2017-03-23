import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Acer on 20.03.2017.
 */
public class Example {

    public static void main(String[] args) {
        try{
            Class<?> cl = Class.forName("java.lang.System");
            Field f = cl.getField("out");
            Method m = f.getType().getDeclaredMethod("println", String.class);
            Object obj = f.get(null);
            m.invoke(obj, "Hello world");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
