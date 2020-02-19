/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testlogin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PageAccueilAdministrateurController implements Initializable {
   @FXML
    private JFXTextField tnom1;

    @FXML
    private BorderPane borderpane;

    @FXML
    private AnchorPane ap;

    @FXML
    private VBox vbox;

    @FXML
    private JFXButton utilisateur;

    @FXML
    private JFXButton centre;

    @FXML
    private JFXButton challenge;

    @FXML
    private JFXButton centre11;

    @FXML
    private JFXButton centre111;

    @FXML
    private JFXButton centre1111;

    /**
     * Initializes the controller class.
     */
       public void setTnom1(JFXTextField tnom1) {
        this.tnom1.setText(tnom1.getText());    }

    public JFXTextField getTnom1() {
        return tnom1;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /*  @FXML
    void GestionUtilisateurAction(MouseEvent event) {
 try {
        
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            
            
            Parent root = (Parent) fxmlLoader.load();
            FXMLDocumentController apc=fxmlLoader.getController();
           apc.setTnom((JFXTextField)tnom1);
           
           tnom1.getScene().setRoot(root);
          
              } catch (IOException e) {
            System.out.println("can't load new window");
        }
        
        
    }*/
     @FXML
 public   void GestionUtilisateurAction(MouseEvent event) throws IOException {
  Parent root =null; 
  
        try {
        root=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
          
              } catch (IOException ex) {
                  
Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
              }
        
         borderpane.setRight(root);
    }
     @FXML
 public   void GestionCentreAction(MouseEvent event) throws IOException {
  Parent root =null; 
  
        try {
        root=FXMLLoader.load(getClass().getResource("GestionCentre.fxml"));
          
              } catch (IOException ex) {
                  
Logger.getLogger(GestionCentreController.class.getName()).log(Level.SEVERE,null,ex);
              }
        
         borderpane.setRight(root);
    }

    @FXML
    private void GestionFormation(MouseEvent event) throws IOException {
                  Parent root =null; 
  
        try {
        root=FXMLLoader.load(getClass().getResource("GestionFormation.fxml"));
          
              } catch (IOException ex) {
                  
Logger.getLogger(GestionFormationController.class.getName()).log(Level.SEVERE,null,ex);
              }
        
         borderpane.setRight(root);
    }
           

   

    
   

}
