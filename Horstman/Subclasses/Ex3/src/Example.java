import sun.security.provider.SHA;

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

abstract class Shape{

    private double x;

    private double y;

    Shape(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public void moveBy(double dx, double dy){
        this.x += dx;
        this.y += dy;
    }

    abstract public Point getCenter();
}

class Circle extends Shape{

    private double radius;

    public Circle(Point center, double radius){
        super(center.getX(), center.getY());
        this.radius = radius;
    }

    public Point getCenter(){
        return new Point(super.getX(), super.getY());
    }
}

public class Example {

}
