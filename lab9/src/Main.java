import java.util.Date;
import java.util.TreeSet;

/**
 * Created by Krszysztof Adamczyk on 29.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            BookSet bookSet = new BookSet();
            for(int i = 0; i < 10; i++) {
                bookSet.add(new Book(i+1, "Title" + i, "Autor Name" + i, "Autor surname" + i, new Date(), "Gatunek"+i));
            }
            System.out.println("***************************");
            bookSet.printByTitle();
            bookSet.add(new Book(111, null, "sdfdsfsdf", "dsfsdfsd", new Date(), "dfsdfdsfsd"));
            System.out.println("**********************");
            bookSet.printByTitle();
            bookSet.remove(666);
            TreeSet<Book> tmp = bookSet.searchByAuthorSurname("Autor surname 1");
            tmp.forEach(System.out::println);
            tmp = bookSet.searchByNrKs(1);
            tmp.forEach(System.out::println);
            bookSet.update(new Book(3, "dsfsdfsdf", "fdsfsdfsdf", "sdfdsfsdf", new Date(), "fdfsdfds"));
            bookSet.printByTitle();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
