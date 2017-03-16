import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Acer on 15.03.2017.
 */
public class Example {

    /**
     * zad10a method print all directories with children directories from path using lambda expression
     * @author wipek.pl
     * @param catalog
     */
    static void printDirectoriesWithLambda(File catalog){
        for(final File f: catalog.listFiles((File f) -> {
            return f.isDirectory();
        })){
            System.out.println(f.getName());
            printDirectoriesWithLambda(f);
        };
    }

    /**
     * zad10b method print all directories with children directories from path using anonymous class
     * @author wipek.pl
     * @param catalog
     */
    static void printDirectoriesWithAnonymousClass(File catalog){
        for(final File f: catalog.listFiles(
            new FileFilter(){
                @Override
                public boolean accept(File pathname) {
                    return pathname.isDirectory();
                }
            }
        )){
            System.out.println(f.getName());
            printDirectoriesWithAnonymousClass(f);
        }
    }

    /**
     * zad11 method print files from path and choosen extension
     * @author wipek.pl
     * @param catalog
     * @param extension
     */
    static void printFileFromCatalogWithExtension(File catalog, String extension)
    {
        for(final File f: catalog.listFiles((File f) -> {
            return f.isFile() && f.getName().toLowerCase().endsWith(extension);
        })){
            System.out.println(f.getName());
        }
    }

    /**
     * zad12 method sort array of Files and Directories
     * @author wipek.pl
     * @param catalog
     */
    static void sortInDirectory(File[] catalog)
    {
        Arrays.sort(catalog, new Comparator<File>() {
            @Override
            public int compare(File f, File g){
                if((f.isDirectory() && g.isDirectory()) || (f.isFile() && g.isFile()))
                {
                    return f.getName().compareTo(g.getName());
                }
                else if(f.isDirectory() && g.isFile())
                {
                    return -1;
                }
                else if(f.isFile() && g.isDirectory())
                {
                    return 1;
                }
                return 0;
            }
        });

        for(File x: catalog)
            System.out.println(x.getName());
    }

    public static void main(String[] args) {
        printDirectoriesWithLambda(new File("E:\\java"));
        printDirectoriesWithAnonymousClass(new File("E:\\java"));
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter path:");
        String path = sc.next();
        System.out.println("Enter file extension:");
        String extension = sc.next().toLowerCase();
        printFileFromCatalogWithExtension(new File(path), extension);
        sortInDirectory(new File("C:\\Users/Acer/Pictures").listFiles());
    }
}
