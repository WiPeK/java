/**
 * Created by Acer on 16.03.2017.
 */

class Point{
    //for zad1
    //private double x;
    //for zad1
    //private double y;

    //for zad3
    protected double x;

    //for zad3
    protected double y;


    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
}

class LabeledPoint extends Point{

    private String label;

    public LabeledPoint(String label, double x, double y){
        //for zad2
        super(x,y);
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public String toString(){
        //for zad2
        //return "Label: " + this.label + " x: " + super.getX() + " y: " + super.getY();
        //for zad3
        return "Label: " + this.label + " x: " + super.x + " y: " + super.y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

public class Example {

    public static void main(String[] args) {
        LabeledPoint lp = new LabeledPoint("Test", 10.2, 33.9);
        System.out.println(lp.toString());
        System.out.println("Hashcode: " + lp.hashCode());

    }
}
