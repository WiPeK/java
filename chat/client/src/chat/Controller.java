package chat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.xml.soap.Text;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Message implements Serializable{
    public String nick;
    public String msg;

    public Message(String nick, String msg){
        this.nick = nick;
        this.msg = msg;
    }
}

class ServerClient{

    private int port;

    private final static int defaultPort = 54321;

    private ServerSocket server;

    private Message ms;

    public ServerClient(){}

    public ServerClient(int port){
        this.port = port;
    }

    public void start(){
        final ExecutorService pool = Executors.newFixedThreadPool(10);

        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                        if(port > 0)
                        {
                            server = new ServerSocket(port);
                        }else
                            server = new ServerSocket(defaultPort);
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

    public static void send(String ip, int port, Message ms){
        try {
            Socket socket = new Socket(ip, port);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(ms);
            output.flush();
            socket.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class ClientTask implements Runnable{
    private final Socket socket;

    ClientTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message)input.readObject();
            new Controller().writeMessage(msg);
            socket.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}

public class Controller {

    @FXML
    private TextField ipTextBox;

    @FXML
    private TextField portTextBox;

    @FXML
    private Button connectButon;

    @FXML
    private TextArea messageTextArea;

    @FXML
    private Button sendMessageButton;

    @FXML
    private TextField nickTextBox;

    @FXML
    private TextField serverPortTextBox;

    @FXML
    private TextField mesageTextField;

    @FXML
    private Button launchServerButon;

    private boolean connectionStatus;

    private ServerClient serCl;

    private String nick;

    private String ip;

    private int port;

    @FXML
    public void launchServerButtonAction(){
        serCl = new ServerClient(Integer.parseInt(serverPortTextBox.getText()));
        serCl.start();
    }

    @FXML
    public void writeMessage(Message ms){
        System.out.println(ms.nick + " " + ms.msg);
        this.mesageTextField.setText(ms.nick + " " + ms.msg);
    }

    @FXML
    private void connectButtonAction(){
        ip = ipTextBox.getText();
        port = Integer.parseInt(portTextBox.getText());
        nick = nickTextBox.getText();
        ipTextBox.setDisable(true);
        portTextBox.setDisable(true);
        nickTextBox.setDisable(true);
    }

    @FXML
    private void sendMessageButtonAction(){
        Message ms = new Message(nick, this.messageTextArea.getText());
        ServerClient.send(ip, port, ms);
    }

}