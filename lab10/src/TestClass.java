import java.io.Serializable;

/**
 * Created by Krzysztof Adamczyk on 05.06.2017.
 */
public class TestClass extends ParentTestClass implements Serializable {

    private String aa;

    private String bb;

    private String cc;

    public TestClass(String aa, String bb, String cc) {
        this.aa = aa;
        this.bb = bb;
        this.cc = cc;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getBb() {
        return bb;
    }

    public void setBb(String bb) {
        this.bb = bb;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "aa='" + aa + '\'' +
                ", bb='" + bb + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}
