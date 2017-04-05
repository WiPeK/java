import java.util.ArrayList;

/**
 * Created by Acer on 03.04.2017.
 */
public class Student {

    private String name;
    private String surname;
    private int studyYear;
    private String groupId;
    private ArrayList<Double> averages;

    Student(String name, String surname, int studyYear, String groupId, ArrayList<Double> averages) {
        this.name = name;
        this.surname = surname;
        this.studyYear = studyYear;
        this.groupId = groupId;
        this.averages = averages;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getStudyYear() {
        return studyYear;
    }

    public String getGroupId() {
        return groupId;
    }

    public ArrayList<Double> getAverages() {
        return averages;
    }

    public void setAverages(ArrayList<Double> averages) {
        this.averages = averages;
    }

    @Override
    public String toString() {
        return this.name + " " + this.surname + " rok studiów: " + this.studyYear + " grupa dziekanska: " + this.groupId + " srednie: " + averages.toString();
    }
}
