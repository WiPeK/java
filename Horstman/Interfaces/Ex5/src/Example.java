import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Acer on 16.03.2017.
 */

class Employee{
    public String name;
    public int reward;

    Employee(String name, int reward)
    {
        this.name = name;
        this.reward = reward;
    }

    public String toString(){
        return Integer.toString(this.reward) + " " + this.name;
    }
}

public class Example {

    public static void main(String[] args) {
        Employee[] emp = new Employee[10];
        emp[0] = new Employee("Adsfgdsg", 1000);
        emp[1] = new Employee("Bdsfgdsg", 2000);
        emp[2] = new Employee("Cdsfgdsg", 3000);
        emp[3] = new Employee("Ddsfgdsg", 3000);
        emp[4] = new Employee("Edsfgdsg", 2000);
        emp[5] = new Employee("Fdsfgdsg", 1000);
        emp[6] = new Employee("Gdsfgdsg", 1000);
        emp[7] = new Employee("Hdsfgdsg", 2000);
        emp[8] = new Employee("AAdsfgds", 3000);
        emp[9] = new Employee("BBdsfgds", 4000);

        Arrays.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.reward - o2.reward;
            }

            public int thenComparing(Employee o1, Employee o2){
                return o1.name.compareTo(o2.name);
            }
        });

        for(Employee x: emp)
            System.out.println(x.toString());

        Arrays.sort(emp, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return -(o1.reward - o2.reward);
            }

            public int thenComparing(Employee o1, Employee o2){
                return -(o1.name.compareTo(o2.name));
            }
        });

        for(Employee x: emp)
            System.out.println(x.toString());
    }

}
