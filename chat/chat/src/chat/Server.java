package chat;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Acer on 01.03.2017.
 */
public class Server extends Thread{

    private Socket socket;

    private int port;

    private Controller ctrl;

    private ObjectInputStream input;

    private ServerSocket server;

    Server(int port, Controller ctrl){
        this.port = port;
        this.ctrl = ctrl;
    }

    @Override
    public void run(){
        try{
            this.server = new ServerSocket(this.port);

            while(true)
            {
                this.socket = server.accept();
                this.input = new ObjectInputStream(this.socket.getInputStream());
                Message msg = (Message)this.input.readObject();
                this.ctrl.appendMessage(msg);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                this.server.close();
                this.socket.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
