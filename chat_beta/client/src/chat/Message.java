package chat;

import java.io.Serializable;

/**
 * Created by Acer on 27.02.2017.
 */
public class Message implements Serializable {
    public String nick;
    public String msg;

    public Message(String nick, String msg){
        this.nick = nick;
        this.msg = msg;
    }
}
