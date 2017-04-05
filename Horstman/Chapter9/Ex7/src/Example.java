import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Acer on 05.04.2017.
 */
public class Example {

    public static void main(String[] args) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] bt = {12, 45, 45, 89, 56, 78, 45, 67, 111, 25, 0};
            md.update(bt);
            byte[] tmp = md.digest();
            System.out.println(md.toString());
            System.out.println(Arrays.toString(tmp));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
