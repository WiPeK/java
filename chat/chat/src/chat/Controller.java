package chat;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Controller {

    @FXML private Label ipAddressLabel;

    @FXML private TextField portTextField;

    @FXML private Button launchServerButton;

    @FXML private TextField ipAddressTextField;

    @FXML private TextField clientPortTextField;

    @FXML private TextField nickTextField;

    @FXML private Button connectButton;

    @FXML private TextArea sendMessageTextArea;

    @FXML private Button sendButton;

    @FXML ScrollPane messageScrollPane;

    @FXML VBox content = new VBox();

    private Server srv;

    private Client clnt;

    private String myNick;


    @FXML private void launchServerButtonAction(){
        try{
            this.fillIpAddressLabel();
            this.portTextField.setDisable(true);
            this.launchServerButton.setDisable(true);
            this.srv = new Server(Integer.parseInt(this.portTextField.getText()), this);
            this.ipAddressTextField.setDisable(false);
            this.clientPortTextField.setDisable(false);
            this.nickTextField.setDisable(false);
            this.connectButton.setDisable(false);
            this.messageScrollPane.setContent(this.content);
            this.srv.start();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML void fillIpAddressLabel(){
        try{
            URL url = new URL("http://bot.whatismyipaddress.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            this.ipAddressLabel.setText(in.readLine().trim() + " / " + InetAddress.getLocalHost().getHostAddress());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML private void connectButtonAction(){
        try{
            this.ipAddressTextField.setDisable(true);
            this.clientPortTextField.setDisable(true);
            this.nickTextField.setDisable(true);
            this.connectButton.setDisable(true);
            this.myNick = this.nickTextField.getText();
            this.clnt = new Client(this.ipAddressTextField.getText(), Integer.parseInt(this.clientPortTextField.getText()));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML private void sendButtonAction(){
        try{
            Message msg = new Message(this.myNick, this.sendMessageTextArea.getText());
            this.clnt.send(msg);
            this.appendMessage(msg);
            this.sendMessageTextArea.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML void appendMessage(Message msg){
        try{
            Platform.runLater(
                    () -> {
                        Label lab = new Label(msg.nick + ": " + msg.message);
                        this.content.getChildren().add(lab);
                    }
            );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
