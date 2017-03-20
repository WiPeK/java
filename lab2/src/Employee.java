/**
 * Created by Acer on 20.03.2017.
 */
public class Employee {
    public String name;
    public String surname;
    public int age;
    public String position;
    public double salary;

    Employee(String name, String surname, int age, String position, double salary)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    Employee(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

//    public boolean equals(Employee obj) {
//        if(obj.name.equals(this.name) && obj.surname.equals(this.surname) && obj.age == this.age && obj.position.equals(this.position) && obj.salary == this.salary){
//            return true;
//        }
//        return false;
//    }

    public boolean equals(Employee obj) {
        if(obj.name.equals(this.name) && obj.surname.equals(this.surname) && obj.age == this.age){
            return true;
        }
        return false;
    }

    public boolean equals(String cr){
        return (cr.equals(this.name) || cr.equals(this.surname) || cr.equals(this.position));
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.surname + " " + this.age + " " + this.position + " " + this.salary;
    }
}
