import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by Acer on 03.04.2017.
 */
public class Manager {

    private int numberOfStudents;

    private Student[] students;

    private int counter = 0;

    Manager(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
        students = new Student[numberOfStudents];
    }

    public void addStudent() {
        if(this.students.length-1 < this.numberOfStudents && this.counter < this.numberOfStudents) {
            try(Scanner in = new Scanner(System.in)) {
                System.out.println("Podaj imie studenta");
                String name = in.next();
                System.out.println("Podaj nazwisko studenta");
                String surname = in.next();
                System.out.println("Podaj rok studiów");
                int studyYear = in.nextInt();
                System.out.println("Podaj grupe dziekańską");
                String groupId = in.next();
                ArrayList<Double> averages = new ArrayList<>();
                if(studyYear > 1) {
                    for(int i = 0; i < studyYear; i++) {
                        System.out.println("Podaj srednia za " + (i+1) + "rok");
                        averages.add(in.nextDouble());
                    }
                }
                this.students[this.counter] = new Student(name, surname, studyYear, groupId, averages);
                this.counter++;
            }
            catch(Exception e) {
                e.printStackTrace();
            }

        }
        else {
            System.out.println("Max number of students");
        }
    }

    public void deleteStudent() {
        String name = "";
        String surname = "";
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Podaj imie");
            name = in.next();
            System.out.println("Podaj nazwisko");
            surname = in.next();
        }catch(Exception e) {
            e.printStackTrace();
        }

        int i = 0;
        for(Student x: students) {
            if(x.getName().equals(name) && x.getSurname().equals(surname)) {
                break;
            }
            i++;
        }

        Student st[] = new Student[this.students.length -1];
        System.arraycopy(this.students, 0, st, 0, i);
        System.arraycopy(this.students, i+1, st, i, this.students.length - i - 1);
        this.students = st;
        this.counter--;
    }

    public void countAverages() {
        for(int i = 0;i < this.students.length-1;i++) {
            double sm = 0.0;
            for(Double s: students[i].getAverages()) {
                sm += s;
            }
            if(students[i].getStudyYear() > 1) {
                System.out.println(students[i].getName() + " " + students[i].getSurname() + " srednia: " + (sm/(students[i].getStudyYear())));
            }
            else {
                System.out.println("Student 1 roku");
            }
        }
    }

    public void modifyAverages() {
        String name = "";
        String surname = "";
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Podaj imie");
            name = in.next();
            System.out.println("Podaj nazwisko");
            surname = in.next();
        }catch(Exception e) {
            e.printStackTrace();
        }

        int i = 0;
        for(Student x: students) {
            if(x.getName().equals(name) && x.getSurname().equals(surname)) {
                break;
            }
            i++;
        }
        ArrayList<Double> avgs = students[i].getAverages();
        if(students[i].getStudyYear() > 1) {
            try(Scanner in = new Scanner(System.in)) {
                for(int j = 0; j < avgs.size(); j++) {
                    System.out.println("Podaj srednia za " + (i+1) + " rok");
                    avgs.add(j, in.nextDouble());
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
            students[i].setAverages(avgs);
        }
    }

    public void modifyStudent() {
        this.displayAll();
        String name = "";
        String surname = "";
        try(Scanner in = new Scanner(System.in)){
            System.out.println("Podaj imie");
            name = in.next();
            System.out.println("Podaj nazwisko");
            surname = in.next();
        }catch(Exception e) {
            e.printStackTrace();
        }

        int i = 0;
        for(Student x: students) {
            if(x.getName().equals(name) && x.getSurname().equals(surname)) {
                break;
            }
            i++;
        }

        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Podaj imie studenta");
            String nname = in.next();
            System.out.println("Podaj nazwisko studenta");
            String nsurname = in.next();
            System.out.println("Podaj rok studiów");
            int nstudyYear = in.nextInt();
            System.out.println("Podaj grupe dziekańską");
            String ngroupId = in.next();
            ArrayList<Double> averages = new ArrayList<>();
            if(nstudyYear > 1) {
                for(int j = 0; j < nstudyYear-1; j++) {
                    System.out.println("Podaj srednia za " + (j+1) + "rok");
                    averages.add(in.nextDouble());
                }
            }

            this.students[i] = new Student(nname, nsurname, nstudyYear, ngroupId, averages);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void displayAll() {
        for(Student x: students) {
            System.out.println(x.toString());
        }
    }
}
