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

class Circle extends Shape implements Cloneable{

    private double radius;

    public Circle(Point center, double radius){
        super(center.getX(), center.getY());
        this.radius = radius;
    }

    public Point getCenter(){
        return new Point(super.getX(), super.getY());
    }

    public String toString(){
        return "x: " + super.getX() + " y: " + super.getY() + " radius: " + this.radius;
    }

    public Circle clone() throws CloneNotSupportedException{
        return this;
    }
}

class Rectangle extends Shape{

    private double width;

    private double height;

    public Rectangle(Point topLeft, double width, double height){
        super(topLeft.getX(), topLeft.getY());
        this.width = width;
        this.height = height;
    }

    public Point getCenter(){
        return new Point(super.getX(), super.getY());
    }

    public String toString(){
        return "x: " + super.getX() + " y: " + super.getY() + " width: " + this.width + " height: " + this.height;
    }

    public Rectangle clone() throws CloneNotSupportedException{
        return this;
    }
}

class Line extends Shape{

    private Point to;

    public Line(Point from, Point to){
        super(from.getX(), from.getY());
        this.to = to;
    }

    public Point getCenter(){
        return new Point(super.getX(), super.getY());
    }

    public String toString(){
        return "x: " + super.getX() + " y: " + super.getY() + " Point to x: " + to.getX() + " Point to y: " + to.getY();
    }

    public Line clone() throws CloneNotSupportedException{
        return this;
    }
}

public class Example {

    public static void main(String[] args) {
        Circle c = new Circle(new Point(10.3, 20.4), 5.4);
        System.out.println(c.toString());
        Rectangle r = new Rectangle(new Point(56.89, 34.6), 56.3, 67.9);
        System.out.println(r.toString());
        Line l = new Line(new Point(34.6, 32.7), new Point(78.5, 23.7));
        System.out.println(l.toString());
        try{
            Line ll = l.clone();
            System.out.println(ll.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
