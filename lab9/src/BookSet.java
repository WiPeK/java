import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Krszysztof Adamczyk on 29.05.2017.
 */
public class BookSet {

    private TreeSet<Book> treeSet = new TreeSet<>();

    public void add(Book book){
        this.treeSet.add(book);
    }

    public void remove(int nrKs) throws Exception {
        Optional<Book> book = this.treeSet.stream().filter(i -> i.getNr_ks() == nrKs).findFirst();
        if(book.isPresent()) {
            this.treeSet.remove(book.get());
        } else {
            throw new Exception("Brak ksiazki do usuniecia");
        }
    }

    public void remove(Book book) throws Exception {
        if(this.treeSet.contains(book)) {
            this.treeSet.remove(book);
        } else {
            throw new Exception("Brak ksiazki do usuniecia");
        }
    }

    public void update(int nr_ks, String title, String authorName, String authorSurname, Date publication, String type) throws Exception {
        Optional<Book> tmp = this.treeSet.stream().filter(i -> i.getNr_ks() == nr_ks).findFirst();
        if(tmp.isPresent()) {
            this.treeSet.remove(tmp.get());
            this.treeSet.add(new Book(nr_ks, title, authorName, authorSurname, publication, type));
        } else {
            throw new Exception("Brak ksiazki do aktualizacji");
        }
    }

    public void update(Book book) throws Exception {
        Optional<Book> tmp = this.treeSet.stream().filter(i -> i.getNr_ks() == book.getNr_ks()).findFirst();
        if(tmp.isPresent()) {
            this.treeSet.remove(tmp.get());
            this.treeSet.add(book);
        } else {
            throw new Exception("Brak ksiazki do aktualizacji");
        }
    }

    public TreeSet<Book> searchByNrKs(int nrKs) throws Exception {
        TreeSet<Book> tmp = this.treeSet.stream().filter(i -> i.getNr_ks() == nrKs).collect(Collectors.toCollection(TreeSet::new));
        if(tmp.size() == 0) {
            throw new Exception("Zbiór ksiazek jest pusty");
        }
        return tmp;
    }

    public TreeSet<Book> searchByNrKs(Book book) throws Exception {
        TreeSet<Book> tmp = this.treeSet.stream().filter(i -> i.getNr_ks() == book.getNr_ks()).collect(Collectors.toCollection(TreeSet::new));
        if(tmp.size() == 0) {
            throw new Exception("Zbiór ksiazek jest pusty");
        }
        return tmp;
    }

    public TreeSet<Book> searchByAuthorSurname(Book book) throws Exception {
        TreeSet<Book> tmp = this.treeSet.stream().filter(i -> i.getAuthorSurname().equals(book.getAuthorSurname())).collect(Collectors.toCollection(TreeSet::new));
        if(tmp.size() == 0) {
            throw new Exception("Zbiór ksiazek jest pusty");
        }
        return tmp;
    }

    public TreeSet<Book> searchByAuthorSurname(String surname) throws Exception {
        TreeSet<Book> tmp = this.treeSet.stream().filter(i -> i.getAuthorSurname().equals(surname)).collect(Collectors.toCollection(TreeSet::new));
        if(tmp.size() == 0) {
            throw new Exception("Zbiór ksiazek jest pusty");
        }
        return tmp;
    }

    public void printByTitle() throws Exception {
        TreeSet<Book> tmp = this.treeSet.stream().sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toCollection(TreeSet::new));
        if(tmp.size() == 0) {
            throw new Exception("Zbiór ksiazek jest pusty");
        }
        tmp.forEach(System.out::println);
    }
}
