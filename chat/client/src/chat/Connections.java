package chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

/**
 * Created by Acer on 27.02.2017.
 */
public abstract class Connections{

    //private Consumer<Serializable> onReceiveCallback;

    private ConnectionThread connThread = new ConnectionThread();

    public Connections(){//Consumer<Serializable> onReceiveCallback
        //this.onReceiveCallback = onReceiveCallback;
        connThread.setDaemon(true);
    }

    public void startConnection() throws Exception{
        connThread.start();
    }

    private void closeConnection() throws Exception{
        try{
            connThread.socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void send(Message msg) throws Exception{
        connThread.output.writeObject(msg);
    }

    protected abstract boolean isServer();

    protected abstract String getIP();

    protected abstract int getPort();

    private class ConnectionThread extends Thread{

        private ObjectInputStream input;

        private ObjectOutputStream output;

        private Socket socket;

        @Override
        public void run(){
            try{
                ServerSocket server = isServer() ? new ServerSocket(getPort()) : null;
                socket = isServer() ? server.accept() : new Socket(getIP(), getPort());
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                socket.setTcpNoDelay(true);

                while(true){
                    Message msg = (Message)input.readObject();
                    System.out.println(msg.nick + " " + msg.msg);
                    //onReceiveCallback.accept(msg);
                }
            }
            catch(Exception e){
                e.printStackTrace();
                //onReceiveCallback.accept("Connection closed");
            }
        }

    }
}
