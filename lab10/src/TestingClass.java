import java.io.Serializable;

/**
 * Created by Krzysztof Adamczyk on 05.06.2017.
 */
public class TestingClass extends ParentTestClass implements Serializable {

    private String dd;

    private String ee;

    private String ff;

    public TestingClass(String dd, String ee, String ff) {
        this.dd = dd;
        this.ee = ee;
        this.ff = ff;
    }

    public String getDd() {
        return dd;
    }

    public void setDd(String dd) {
        this.dd = dd;
    }

    public String getEe() {
        return ee;
    }

    public void setEe(String ee) {
        this.ee = ee;
    }

    public String getFf() {
        return ff;
    }

    public void setFf(String ff) {
        this.ff = ff;
    }

    @Override
    public String toString() {
        return "TestingClass{" +
                "dd='" + dd + '\'' +
                ", ee='" + ee + '\'' +
                ", ff='" + ff + '\'' +
                '}';
    }
}
