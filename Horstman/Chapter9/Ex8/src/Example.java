import java.io.File;
import java.net.URI;
import java.nio.file.*;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * Created by Acer on 05.04.2017.
 */
public class Example {

    static void createZip(String resultFilePath, String rootPath) {
        Path zipPath = Paths.get(resultFilePath);
        try {
            URI uri = new URI("jar", zipPath.toUri().toString(), null);
            FileSystem zipfs = FileSystems.newFileSystem(uri, Collections.singletonMap("create", "true"));

            Stream<Path> entries = Files.walk(Paths.get(rootPath));
            entries.forEach((e) -> {
                if(Files.isRegularFile(e) && !e.toString().equals(resultFilePath)) {
                    try{
                        System.out.println(e);
                        Files.copy(e, zipfs.getPath(resultFilePath), StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (Exception er) {
                        er.printStackTrace();
                    }
                }
            });


            entries.close();
            zipfs.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filename = "E:/java/Horstman/Chapter9/Ex8/resources/file.zip";
        String rootPath = "E:/java/Horstman/Chapter9/Ex8/resources/";
        createZip(filename, rootPath);
    }
}
