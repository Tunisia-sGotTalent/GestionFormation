/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testlogin;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.tgt.Entite.Centre;
import com.tgt.Entite.Formation;
import com.tgt.Service.ServiceCentre;
import com.tgt.Service.ServiceFormation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.tgt.Utils.DataBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionFormationController implements Initializable {

    @FXML
    private Button supprimer;
    @FXML
    private Button ajouter1;
    @FXML
    private TableView<Formation> table;
    @FXML
    private TableColumn<Formation, String> col_nom;
    @FXML
    private TableColumn<Formation, String> col_type;
    @FXML
    private TableColumn<Formation, Integer> col_nb;
    @FXML
    private Button modifier;
    @FXML
    private Button rechercher1;
    @FXML
    private JFXTextField tnom;
    @FXML
    private JFXTextField rechercher;
    @FXML
    private JFXTextField tnb;

    public void setTnb(JFXTextField tnb) {
        this.tnb = tnb;
    }
     @FXML
    private JFXComboBox <String> ttype;
    ObservableList<String> l = FXCollections.observableArrayList("musique","dance","theatre","others");
    
    ObservableList<Formation> arr = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Formation, Integer> col_id;
    @FXML
    private Button telecharger;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Formation f =new Formation();
            ServiceFormation ser = new ServiceFormation();
        col_id.setCellValueFactory(new PropertyValueFactory<>("id_formation"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom_formation"));
            col_type.setCellValueFactory(new PropertyValueFactory<>("type_formation"));
            col_nb.setCellValueFactory(new PropertyValueFactory<>("nb_participant"));
            
        try {
            ttype.setItems(l);
         
            
          
            arr = ser.readAll();
            System.out.println(arr.size());
        } catch (SQLException ex) {
            System.out.println(ex);        }
        
        table.setItems((ObservableList<Formation>) arr);
        table.setEditable(true);
        
        col_nom.setCellFactory(TextFieldTableCell.forTableColumn());
       col_type.setCellFactory(ComboBoxTableCell.forTableColumn(l));
       
       
      //  col_nb.setCellFactory(TextFieldTableCell.forTableColumn());
        
        


    }    



    @FXML
    private void supprimer(ActionEvent event) throws SQLException {
        if (event.getSource() == supprimer) {

            if (JOptionPane.showConfirmDialog(null, "Attention vous allez supprimer la formation, êtes  vous sur?", "Confirmer ta suppression", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
                ServiceFormation ser = new ServiceFormation();
                Formation f = table.getSelectionModel().getSelectedItem();
                ser.delete(f);
                arr.clear();
                arr.addAll(ser.readAll());
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez selectionner le centre à supprimer");
            }

        }

    }

    @FXML
    private void ajouter(ActionEvent event) throws SQLException {
        ServiceFormation ser = new ServiceFormation();

        Formation f = new Formation();
        f.setNom_formation(tnom.getText());
        f.setType_formation(ttype.getValue());
        f.setNb_participant(Integer.parseInt(tnb.getText()));

        if (JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter ce formation?", "Confirmer votre ajout", JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
            try {

                System.out.println(f);
                ser.ajouter(f);
               // List<Formation> list = ser.readAll();
              //  System.out.println(list);

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
arr.clear();
      arr.addAll(ser.readAll());

    }
    
    
    
    @FXML
    public void modifierNomformatioln(TableColumn.CellEditEvent editcell) throws SQLException {
        ServiceFormation ser = new ServiceFormation();
        Formation formationselectionne = table.getSelectionModel().getSelectedItem();
        formationselectionne.setNom_formation(editcell.getNewValue().toString());
        System.out.println(formationselectionne);
        ser.update(formationselectionne);

    }
    
    @FXML
    public void modifiertypeformation(TableColumn.CellEditEvent editcell) throws SQLException {
        ServiceFormation ser = new ServiceFormation();
        Formation formationselectionne = table.getSelectionModel().getSelectedItem();
        formationselectionne.setType_formation(editcell.getNewValue().toString());
        System.out.println(formationselectionne);
        ser.update(formationselectionne);

    }
    
    
    
    
    @FXML
    private void rechercher(ActionEvent event) {
        
        try {
            Formation f = new Formation();
            f.setNom_formation(rechercher.getText());
            System.out.println(f);
            ServiceFormation ser = new ServiceFormation();
            if (!(ser.rechercher(f).isEmpty())) {
                arr.clear();
                arr.addAll(ser.rechercher(f));
            } else if (ser.rechercher(f).isEmpty()) {
                System.out.println("vide");
                JOptionPane.showMessageDialog(null, "Veuillez sélectionner le nom du centre à chercher");
                arr = ser.readAll();
                table.setItems((ObservableList<Formation>) arr);
            }
            System.out.println(ser.rechercher(f));
        } catch (SQLException ex) {
            System.out.println(ex);        }

    }

    @FXML
    private void Signaler(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignalerFormation.fxml"));
        Parent root = loader.load();
        ajouter1.getScene().setRoot(root);
    }
    
    
    
    
    @FXML
    private void telecharger(ActionEvent event) throws IOException,FileNotFoundException, DocumentException, SQLException  {
        try {
            String file_name="N:\\PDF\\mehdi.pdf";
            Document document = new Document();
            
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            document.open();
            DataBase db = new DataBase();
            Connection cnx = db.getConnection();
            PreparedStatement ps =null;
            ResultSet rs =null;
            String req = "Select * from formation";
            ps = cnx.prepareCall(req);
            rs=ps.executeQuery();
            PdfPTable t = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Id"));
            t.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Nom"));
            t.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Type"));
            t.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Nb"));
            t.addCell(c4);
            t.setHeaderRows(1);
            while(rs.next()){
                t.addCell(rs.getString(1));
                t.addCell(rs.getString(2));
                t.addCell(rs.getString(3));
                t.addCell(rs.getString(4));
                document.add(t);
            }
            document.close();
            System.out.println("finished");
        } catch (DocumentException ex) {
            System.out.println(ex); 
        }
    }

    
}
