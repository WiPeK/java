package chat;

import java.io.Serializable;

/**
 * Created by Acer on 01.03.2017.
 */
public class Message implements Serializable{

    public String nick;

    public String message;

    Message(String nick, String message){
        this.nick = nick;
        this.message = message;
    }
}
