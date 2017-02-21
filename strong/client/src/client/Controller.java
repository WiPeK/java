package client;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.awt.*;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.*;
import javafx.scene.control.*;


public class Controller {

    @FXML
    private Button countButton;

    @FXML
    public javafx.scene.control.TextField toCountTextBox;

    @FXML
    private javafx.scene.control.Label resultLabel;

    @FXML
    public void countButtonAction(){

        try{
            String val = this.toCountTextBox.getText();
            Socket socket = new Socket("127.0.0.1", 54322);
            socket.getOutputStream().write(Integer.parseInt(val));
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            this.resultLabel.setText(Long.toString(input.readLong()));
            socket.close();
            //int res;
            //while(true){
            //    if((res = socket.getInputStream().read()) != 0){
            //        this.resultLabel.setText(Integer.toString(socket.getInputStream().read()));
            //        socket.close();
            //        break;
            //    }
            //}
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
