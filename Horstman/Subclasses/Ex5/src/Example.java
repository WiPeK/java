import java.util.Objects;

/**
 * Created by Acer on 16.03.2017.
 */

class Item{

    private String description;

    private double price;

    public Item(String description, double price){
        this.description = description;
        this.price = price;
    }

    public boolean equals(Object otherObject){
        // Szybkie sprawdzenie, czy obiekty są identyczne
        if (this == otherObject) return true;
        // Musi zwrócić false, jeśli parametrem jest null
        if (otherObject == null) return false;
        // Sprawdzenie, czy otherObject jest klasy Item
        if (getClass() != otherObject.getClass()) return false;
        // Sprawdzenie, czy zmienne instancji mają identyczne wartości
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description)
                && price == other.price;
    }
}

class DiscountedItem extends Item {
    public double discount;

    public DiscountedItem(String description, double price, double discount){
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {

        if(otherObject instanceof Item){
            if(super.equals(otherObject)){
                if(otherObject instanceof DiscountedItem){
                    if(((DiscountedItem) otherObject).discount == discount){
                        return true;
                    }
                    else
                    {
                        return false;
                    }
                }
                else{
                    return false;
                }
            }else
            {
                return false;
            }
        }else{
            return false;
        }
    }
}

public class Example {
    public static void main(String[] args) {
        Item a = new DiscountedItem("aaaa", 10.10, 0.90);
        Item b = new DiscountedItem("aaaa", 10.10, 0.90);
        Item c = new DiscountedItem("bbbb", 10.10, 0.80);
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.equals(c));
    }
}
