/**
 * Created by Acer on 23.03.2017.
 */
public class Employee implements Comparable<Employee> {

    public double salary;

    @Override
    public int compareTo(Employee o) {
        if(this.salary > o.salary) {
            return 1;
        }
        else if(this.salary < o.salary) {
            return -1;
        }
        return 0;
    }
}
