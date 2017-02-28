package chat;

import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    public TextArea receivedMessageTextArea;

    @FXML
    private Button launchServerButton;

    private String nick;

    private Server connectionServer;

    private Client connectionClient;

    private boolean serverOn = false;

    private boolean connectWithServer = false;

    @FXML
    public void launchServerButtonAction(){
        receivedMessageTextArea.setEditable(false);
        this.serverOn = true;
        this.launchServerButton.setDisable(true);
        this.connectionServer = new Server(Integer.parseInt(serverPortTextBox.getText()), this);
        this.connectionServer.start();
        //this.writeMessage();
    }

    @FXML
    private void connectButtonAction(){
        nick = nickTextBox.getText();
        ipTextBox.setDisable(true);
        portTextBox.setDisable(true);
        nickTextBox.setDisable(true);
        this.connectWithServer = true;
        this.connectionClient = new Client(ipTextBox.getText(), Integer.parseInt(portTextBox.getText()));
        this.connectionClient.start();
    }

    @FXML
    private void sendMessageButtonAction(){
        if(this.serverOn && this.connectWithServer){
            try{
                Message ms = new Message(nick, this.messageTextArea.getText());
                connectionClient.send(ms);
                this.receivedMessageTextArea.setStyle("-fx-font-alignment: right");
                this.receivedMessageTextArea.appendText("me: " + ms.msg + "\n");
                this.messageTextArea.clear();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            System.out.println("First you must connect with other client");
        }
    }

}