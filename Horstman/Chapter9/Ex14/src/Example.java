import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Acer on 05.04.2017.
 */

class Point implements Serializable {

    private double x;

    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x: " + x + " y:" + y;
    }
}

class Point2D implements Serializable {

    private static final long serialVersionUID = 2L;

    private double[] point;

    Point2D(double[] point) {
        this.point = point;
    }

    public void setPoint(double[] point) {
        this.point = point;
    }

    public double[] getPoint() {
        return point;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.point);
    }
}

public class Example {

    static Point[] generatePoints(int numberOfElements) {
        Point[] points = new Point[numberOfElements];
        Random generator = new Random();
        for(int i = 0; i < numberOfElements; i++) {
            points[i] = new Point(generator.nextDouble(), generator.nextDouble());
        }
        return points;
    }

    static Point2D[] generatePoints2D(int numberOfElements) {
        Point2D[] points = new Point2D[numberOfElements];
        Random generator = new Random();
        for(int i = 0; i < numberOfElements; i++) {
            double[] tmp = {generator.nextDouble(), generator.nextDouble()};
            points[i] = new Point2D(tmp);
        }
        return points;
    }

    static void serialize(String filePath, Point[] points) {
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)))) {
            out.writeInt(points.length);
            for(Point x: points) {
                out.writeObject(x);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void serialize2D(String filePath, Point2D[] points) {
        try(ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(filePath)))) {
            out.writeInt(points.length);
            for(Point2D x: points) {
                out.writeObject(x);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Point[] deserialize(String filePath) {
        Point[] points = null;
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)))) {
            int size = in.readInt();
            points = new Point[size];
            for(int i = 0; i < size; i++) {
                points[i] = (Point)in.readObject();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return points;
    }

    static Point2D[] deserialize2D(String filePath) {
        Point2D[] points = null;
        try(ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(filePath)))) {
            int size = in.readInt();
            points = new Point2D[size];
            for(int i = 0; i < size; i++) {
                points[i] = (Point2D)in.readObject();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return points;
    }

    public static void main(String[] args) {
        final int numberOfElements = 100;
        Point[] points = generatePoints(numberOfElements);
        String filePath = "./resources/result.txt";
        serialize(filePath, points);
        for(Point x: deserialize(filePath)) {
            System.out.println(x.toString());
        }

        System.out.println("***********************************************");
        Point2D[] pnts = generatePoints2D(numberOfElements);
        String filePath2D = "./resources/result2D.txt";
        serialize2D(filePath2D, pnts);
        for(Point2D x: deserialize2D(filePath2D)) {
            System.out.println(x.toString());
        }
    }
}
