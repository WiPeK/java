package chat;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Acer on 01.03.2017.
 */
public class Client{

    private String ip;

    private int port;

    private Socket socket;

    private ObjectOutputStream output;

    Client(String ip, int port)
    {
        this.ip = ip;
        this.port = port;
    }

    public void send(Message msg){
        try{
            this.socket = new Socket(this.ip, this.port);
            this.output = new ObjectOutputStream(socket.getOutputStream());
            this.socket.setTcpNoDelay(true);
            this.output.writeObject(msg);
            this.output.flush();
            this.socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
