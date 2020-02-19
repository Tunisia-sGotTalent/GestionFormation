/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.tgt.Service.Notification;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.tgt.Service.SendMail;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SignalerFormationController implements Initializable {

    @FXML
    private TextField txtfObjet;
    @FXML
    private TextField txtfCorp;
    @FXML
    private Button btnEnvoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Envoyer(ActionEvent event) throws IOException {
        SendMail.sendMail("medmehdi.acheche@esprit.tn", txtfObjet.getText(), txtfCorp.getText());
        Notification.showNotif("Mail envoyée","Veuillez attendre un retour");
    
    }

  
}
