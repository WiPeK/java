import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

/**
 * Created by Krszysztof Adamczyk on 22.05.2017.
 */
public class PhoneBook {

    private Set<PhoneEntry> phoneEntrySet = new HashSet<>(0);

    public void add(PhoneEntry phoneEntry) {
        this.phoneEntrySet.add(phoneEntry);
    }

    public void remove(PhoneEntry phoneEntry) throws Exception {
        if(this.phoneEntrySet.contains(phoneEntry)) {
            this.phoneEntrySet.remove(phoneEntry);
        }else {
            throw new Exception("Brak elementu do usuniecia");
        }
    }

    public void update(PhoneEntry phoneEntry, PhoneEntry newEntry) {
        if(this.phoneEntrySet.contains(phoneEntry)) {
            this.phoneEntrySet.remove(phoneEntry);
            this.phoneEntrySet.add(newEntry);
        }
    }

    public void searchByNumber(String number) throws Exception {
        Optional<PhoneEntry> result = this.phoneEntrySet.stream().filter(i -> i.getPhoneNumber().equals(number)).findFirst();
        if(result.isPresent()) {
            System.out.println("Znaleziono po numerze: " + result.get());
        }else {
            throw new Exception("Nic nie znaleziono");
        }
    }

    public void searchBySurname(String surname) throws Exception {
        Optional<PhoneEntry> result = this.phoneEntrySet.stream().filter(i -> i.getSurname().equals(surname)).findFirst();
        if(result.isPresent()) {
            System.out.println("Znaleziono po nazwisku: " + result.get());
        }else {
            throw new Exception("Nic nie znaleziono");
        }
    }

    public void printAll() {
        this.phoneEntrySet.forEach(System.out::println);
    }
}
