/**
 * Created by Acer on 13.03.2017.
 */
public class Player {

    private String name;

    private int kuponId;

    Player(String name, int kuponId){
        this.name = name;
        this.kuponId = kuponId;
    }

    public String getName()
    {
        return this.name;
    }
}
