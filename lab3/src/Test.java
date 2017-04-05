import java.util.Scanner;

/**
 * Created by Acer on 03.04.2017.
 */
public class Test {

    static void displayMenu() {
        System.out.println("1. Dodaj studenta");
        System.out.println("2. Usun studenta");
        System.out.println("3. Wylicz srednie");
        System.out.println("4, Zmodyfikuj srednie");
        System.out.println("5. Modyfikuj studenta");
        System.out.println("6. Wyświetl wszystkich");
        System.out.println("7. Wyjdz");
    }

    public static void main(String[] args) {
        int numberOfStudents = Integer.parseInt(args[0]);
        Manager man = new Manager(numberOfStudents);
        try(Scanner in = new Scanner(System.in)) {
            int res = 0;
            //while(res != 7) {
                displayMenu();
                res = in.nextInt();
                if(res == 1) {
                    man.addStudent();
                }
                else if(res == 2) {
                    man.deleteStudent();
                }
                else if(res == 3) {
                    man.countAverages();
                }
                else if(res == 4) {
                    man.modifyAverages();
                }
                else if(res == 5) {
                    man.modifyStudent();
                }
                else if(res == 6) {
                    man.displayAll();
                }
                else {
                    break;
                }
                res = 0;
            }
        }
    }
}
