import java.util.Scanner;

/**
 * Created by Acer on 20.03.2017.
 */
public class Company {

    private static int counter = 0;

    private static Employee addEmployee()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name");
        String name = sc.next();
        System.out.println("Enter employee surname");
        String surname = sc.next();
        System.out.println("Enter employee age");
        Integer age = sc.nextInt();
        System.out.println("Enter employee position");
        String position = sc.next();
        System.out.println("Enter employee salary");
        Double salary = sc.nextDouble();
        return new Employee(name, surname, age, position, salary);
    }

    private static Employee[] deleteEmployee(Employee[] emp)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name");
        String name = sc.next();
        System.out.println("Enter employee surname");
        String surname = sc.next();
        System.out.println("Enter employee age");
        Integer age = sc.nextInt();
        int index = -1;
        for(int i = 0; i < counter; i++){
            if(emp.equals(new Employee(name, surname, age)));
                index = i;
                break;
        }

        if(index >= 0)
        {
            Employee[] em = new Employee[emp.length -1];
            System.arraycopy(emp, 0, em, 0, index);
            System.arraycopy(emp, index+1, em, index, emp.length - index-1);
            return em;
        }
        return null;
    }

    private static void printAllEmployees(Employee[] emp)
    {
        for(int i = 0; i < counter; i++)
        {
            System.out.println(emp[i].toString());
        }
    }

    private static void searchBy(Employee[] emp)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name, surname or position");
        String cr = sc.next();
        for(int i = 0; i < counter; i++)
        {
            if(emp[i].equals(cr)){
                System.out.println("Match result" + emp[i].toString());
            }

        }
    }

    public static void main(String[] args) {
        int howManyEmployees = Integer.parseInt(args[0]);
        Employee[] emp = new Employee[howManyEmployees];
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1. Add new employee");
            System.out.println("2. Delete employee");
            System.out.println("3. Display all employees");
            System.out.println("4. Search employee");
            System.out.println("5. Exit");
            int res = sc.nextInt();
            if(res == 1)
            {
                if(counter == howManyEmployees)
                {
                    System.out.println("Array of employees is full");
                    continue;
                }
                emp[counter] = addEmployee();
                counter++;
            }
            else if(res == 2)
            {
                emp = deleteEmployee(emp);
                if(emp != null){
                    counter--;
                }
                else
                {
                    System.out.println("Error removing employee");
                }

            }
            else if(res == 3)
            {
                printAllEmployees(emp);
            }
            else if(res == 4)
            {
                searchBy(emp);
            }
            else if(res == 5)
            {
                return;
            }
        }
    }
}
