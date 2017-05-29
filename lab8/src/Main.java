/**
 * Created by Krszysztof Adamczyk on 22.05.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            PhoneBook phoneBook = new PhoneBook();
            for(int i = 0; i < 10; i++) {
                phoneBook.add(new PhoneEntry("Imie" + i, "Nazwisko" + i, Integer.toString(i), "adres"+ i));
            }
            System.out.println("Po dodaniu");
            phoneBook.printAll();
            phoneBook.remove(new PhoneEntry("Imie0", "Nazwisko0", Integer.toString(0), "adres0"));
            System.out.println("Po usunieciu");
            phoneBook.printAll();
            PhoneEntry old = new PhoneEntry("Imie1", "Nazwisko1", Integer.toString(1), "adres1");
            PhoneEntry newEntry = new PhoneEntry("Imie111", "Nazwisko111", Integer.toString(1111), "adres1111");
            phoneBook.update(old, newEntry);
            System.out.println("Po aktualizacji");
            phoneBook.printAll();
            phoneBook.searchByNumber("5");
            phoneBook.searchBySurname("Nazwisko3");
            System.out.println("Wypisanie wszystkiego");
            phoneBook.printAll();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
