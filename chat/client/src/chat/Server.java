package chat;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Acer on 27.02.2017.
 */
public class Server extends Thread{

    private int port;

    private ObjectInputStream input;

    private Socket socket;

    private Controller ctrl;

    public Server(int port, Controller ctrl){
        this.port = port;
        this.ctrl = ctrl;
    }

    @Override
    public void run(){
        try{
            ServerSocket server =  new ServerSocket(this.port);
            this.socket = server.accept();
            input = new ObjectInputStream(socket.getInputStream());

            while(true){
                Message msg = (Message)input.readObject();
                this.ctrl.receivedMessageTextArea.setStyle("-fx-font-alignment: left");
                this.ctrl.receivedMessageTextArea.appendText(msg.nick + " " + msg.msg + "\n");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                this.closeConnection();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void closeConnection() throws Exception{
        try{
            this.socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}