import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Acer on 04.04.2017.
 */
public class Example {

    static void reverseBytesInLine(String filePath) {
        try(RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            final int BLOCKSIZE = 6144;
            byte[] bytesReaded = new byte[BLOCKSIZE];
            int length;
            while((length = file.read(bytesReaded)) != -1) {
                bytesReaded = reverseArray(bytesReaded);
                System.out.println(Arrays.toString(bytesReaded));
                System.out.println(file.getFilePointer());
                file.seek(file.getFilePointer() - length);
                file.write(bytesReaded, 0, length);
                file.seek(file.getFilePointer() + length);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static byte[] reverseArray(byte[] array) {
        byte[] tmp = new byte[array.length];
        int j = 0;
        for(int i = array.length-1; i >= 0; i--) {
            tmp[j++] = array[i];
        }
        return tmp;
    }

    public static void main(String[] args) {
        String filePath = "./resources/audi.bmp";
        reverseBytesInLine(filePath);
    }
}
