import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Acer on 17.02.2017.
 */

class Server{

    public void startServer(){
        final ExecutorService pool = Executors.newFixedThreadPool(10);

        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                    ServerSocket server = new ServerSocket(54322);
                    while(true){
                        Socket socket = server.accept();
                        pool.submit(new ClientTask(socket));
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }
}

class ClientTask implements Runnable{
    private final Socket socket;

    ClientTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        System.out.println("Połączono");
        try{
            //ObjectInputStream input = new ObjectInputStream(this.socket.getInputStream());
            System.out.println(socket.getRemoteSocketAddress().toString());
            int in = socket.getInputStream().read();
            long st = Strongserver.countStrong(in);
            System.out.println(in + " " + st);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeLong(st);
            output.flush();
            //socket.getOutputStream().write(123);
            this.socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

public class Strongserver {

    public static long countStrong(int n){
        if (n<2) return 1;
        return n* Strongserver.countStrong(n-1);
    }

    public static void main(String[] args) throws Exception {
        new Server().startServer();
    }
}
