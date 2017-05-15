import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Acer on 06.04.2017.
 */
public class Example {

    public static void main(String[] args) {
        String rootPath = "E:/java";
        String searchPhrase = "Example";
        try(Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
            Stream<Path> filesContained = paths.parallel().filter(s -> s.toString().contains(searchPhrase));
            Iterator<Path> it = filesContained.iterator();
            it.forEachRemaining(e -> System.out.println(e));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("*****************************************************");
        try(Stream<Path> paths = Files.walk(Paths.get(rootPath))) {
            Stream<Path> filesContained = paths.parallel().filter(s -> s.toString().contains(searchPhrase)).limit(1);
            Iterator<Path> it = filesContained.iterator();
            it.forEachRemaining(e -> System.out.println(e));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
