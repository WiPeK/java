package chat;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Acer on 27.02.2017.
 */
public class Client extends Thread{

    private String ip;

    private int port;

    private ObjectOutputStream output;

    private Socket socket;

    public Client(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

    public void send(Message msg) throws Exception{
        try{
            output.writeObject(msg);
            output.flush();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run(){
        try{
            socket = new Socket(this.ip, this.port);
            output = new ObjectOutputStream(socket.getOutputStream());
            socket.setTcpNoDelay(true);
            while(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}
