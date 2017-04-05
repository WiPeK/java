import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Acer on 04.04.2017.
 */
public class Example {

    private static void copyFromInputToOutput(String inputPath, String outputPath) {
        try(
                InputStream in = Files.newInputStream(Paths.get(inputPath));
                OutputStream out = Files.newOutputStream(Paths.get(outputPath))
        ) {
            final int BLOCKSIZE = 1024;
            byte[] bytesReaded = new byte[BLOCKSIZE];
            int length;
            while((length = in.read(bytesReaded)) != -1) {
                out.write(bytesReaded, 0, length);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void copyWithFiles(String inputPath, String outputPath) {
        try(OutputStream out = Files.newOutputStream(Paths.get(outputPath))) {
            Files.copy(Paths.get(inputPath), out);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void createToc(String inputPath, String outputPath) {
        try(Scanner in = new Scanner(Paths.get(inputPath), "UTF-8");
            Writer out = new OutputStreamWriter(Files.newOutputStream(Paths.get(outputPath)), "UTF-8")
        ) {
            Map<String, Integer> toToc = new TreeMap<>();
            int i = 1;
            while(in.hasNext()) {
                toToc.put(in.next(), i++);
            }
            toToc.forEach((a, b) -> {
                try{
                    out.write(b + " " + a + System.lineSeparator());
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            });
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String inputPath = "./resources/nicknames.txt";
        String outputPath = "./resources/newfile.txt";
        Example.copyFromInputToOutput(inputPath, outputPath);
        Example.copyWithFiles(inputPath, "./resources/newfile2.txt");
        Example.createToc(inputPath, "./resources/nicknames.toc");
    }
}
