import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Acer on 05.04.2017.
 */

class Test implements Serializable {

    private String name;

    private String surname;

    Test(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname;
    }
}

public class Example {

    public static void main(String[] args) {
        Test t = new Test("Janusz", "Kowalski");
        byte[] bytes = null;
        try(ByteArrayOutputStream bout = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bout)) {
            out.writeObject(t);
            out.flush();
            bytes = bout.toByteArray();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        Test tt = null;
        Test ttt = null;
        try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInput in = new ObjectInputStream(bis)) {
            tt = (Test)in.readObject();
            //ttt = (Test)in.readObject();
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(tt.toString());
        //System.out.println(ttt.toString());

    }
}
