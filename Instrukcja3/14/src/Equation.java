/**
 * Created by Krzysztof Adamczyk on 12.02.2017.
 */
import java.lang.Math;

class Quadratic{
    double a,b,c,x1,x2, delta;

    /*
    * @params double a, b,c
    * @return void
    * Constructor set private firlds: a,b,c
     */
    Quadratic(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /*
    * @params void
    * @return void
    * count delta root and set delta field
     */
    private void countDelta(){
        this.delta = Math.sqrt((this.b*this.b)-4*this.a*this.c);
    }

    /*
    * @params void
    * @return void
    * count x1 field result and set it
     */
    private void countX1(){
        if(this.a != 0) this.x1 = ((-this.b - this.delta)/2*this.a);
        else this.x1 = 0.0;
    }

    /*
    * @params void
    * @return void
    * count x2 field result and set it
     */
    private void countX2(){
        if(this.a !=0) this.x2 = ((-this.b + this.delta)/2*this.a);
        else this.x2 = 0.0;
    }

    /*
    * @params void
    * @return double[]
    * return result of quadratic equation
     */
    public double[] getResults(){
        this.countDelta();
        if(this.delta == 0){
            this.countX1();
            double[] arr = new double[3];
            arr[0] = 0.0;
            arr[1] = this.x1;
            arr[2] = 0.0;
            return arr;
        }
        else if(this.delta < 0)
        {
            double[] arr = new double[1];
            arr[0] = 2.0;
            return arr;
        }
        this.countX1();
        this.countX2();
        double[] arr = new double[3];
        arr[0] = 1.0;
        arr[1] = this.x1;
        arr[2] = this.x2;
        return arr;
    }
}

public class Equation {
    public static void main(String[] args) {
        Quadratic qr = new Quadratic(Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        double[] arr = qr.getResults();
        if(arr[0] == 0.0)
        {
            System.out.println("Result x0 = " + arr[1]);
        }
        else if(arr[0] == 1.0){
            System.out.println("Result x1= " + arr[1] + " x2= " + arr[2]);
        }
        else if(arr[0] == 2.0){
            System.out.println("Delta < 0");
        }
    }
}
