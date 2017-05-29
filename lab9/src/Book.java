import java.util.Date;

/**
 * Created by Krszysztof Adamczyk on 29.05.2017.
 */
public class Book implements Comparable {

    private int nr_ks;

    private String title;

    private String authorName;

    private String authorSurname;

    private Date publication;

    private String type;

    public int getNr_ks() {
        return nr_ks;
    }

    public void setNr_ks(int nr_ks) {
        this.nr_ks = nr_ks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorSurname() {
        return authorSurname;
    }

    public void setAuthorSurname(String authorSurname) {
        this.authorSurname = authorSurname;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (nr_ks != book.nr_ks) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (authorName != null ? !authorName.equals(book.authorName) : book.authorName != null) return false;
        if (authorSurname != null ? !authorSurname.equals(book.authorSurname) : book.authorSurname != null)
            return false;
        if (publication != null ? !publication.equals(book.publication) : book.publication != null) return false;
        return type != null ? type.equals(book.type) : book.type == null;
    }

    @Override
    public int hashCode() {
        int result = nr_ks;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorSurname != null ? authorSurname.hashCode() : 0);
        result = 31 * result + (publication != null ? publication.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "nr_ks=" + nr_ks +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorSurname='" + authorSurname + '\'' +
                ", publication=" + publication +
                ", type='" + type + '\'' +
                '}';
    }

    public Book(int nr_ks, String title, String authorName, String authorSurname, Date publication, String type) throws Exception {
        if(nr_ks < 1) {
            throw new Exception("Numer ksiazki nie moze byc mniejszy od 1");
        }
        this.nr_ks = nr_ks;
        if(title == null) {
            throw new Exception("Tytul jest nullem");
        }
        this.title = title;
        if(authorName == null) {
            throw new Exception("Imie autora jest nullem");
        }
        this.authorName = authorName;
        if(authorSurname == null) {
            throw new Exception("Nazwisko autora jest nullem");
        }
        this.authorSurname = authorSurname;
        if(publication == null) {
            throw new Exception("Data publikacji jest nullem");
        }
        this.publication = publication;
        if(type == null) {
            throw new Exception("Typ jest nullem");
        }
        this.type = type;
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     * <p>
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     * <p>
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     * <p>
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     * <p>
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     * <p>
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
