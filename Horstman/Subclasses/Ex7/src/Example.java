/**
 * Created by Acer on 16.03.2017.
 */

enum Colors{
    BLACK, RED, BLUE, GREEN, CYAN, MAGENTA, YELLOW, WHITE;

    public Colors getRed(){
        return RED;
    }

    public Colors getGreen(){
        return GREEN;
    }

    public Colors getBlue(){
        return BLUE;
    }
}

public class Example {

    public static void main(String[] args) {
        Colors[] col = Colors.values();
        System.out.println(col[0].getRed());
        System.out.println(col[0].getGreen());
        System.out.println(col[0].getBlue());
    }
}
