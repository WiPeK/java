import java.util.Random;

/**
 * Created by Acer on 13.03.2017.
 */
public class Kupon {

    final static int winValue = 10000;

    private int kuponId;
    private int value;
    private Boolean won;

    Kupon(int kuponId,int value){
        this.kuponId = kuponId;
        this.value = value;
        Random r = new Random();
        int tmp = r.nextInt(100);
        if(tmp > 50)
            this.won = true;
        else
            this.won = false;
    }

    public Boolean isWiner(){
        return this.won;
    }

    public double getWonValue()
    {
        return this.winValue * this.value;
    }
}
