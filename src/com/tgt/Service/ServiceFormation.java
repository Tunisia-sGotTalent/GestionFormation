/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Service;

import com.tgt.Entite.Formation;
import com.tgt.IService.IServiceFormation;
import com.tgt.Utils.DataBase;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import com.tgt.Utils.DataBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class ServiceFormation implements IServiceFormation<Formation>{
    private Connection con;
    private Statement ste;

    public ServiceFormation() {
        con = DataBase.getInstance().getConnection();
    }
    

    @Override
    /*public void ajouter(Formation t) throws SQLException {
   PreparedStatement pre=con.prepareStatement("INSERT INTO formation (`id_formation`,`nom_formation`,`type_formation`,`nb_participant`) VALUES (NULL,'"+t.getNom_formation()+"','"+t.getType_formation()+"',"'+t.get');");
    pre.setInt(1, t.getId_formation());
   pre.setString(2, t.getNom_formation());
    pre.setString(3, t.getType_formation());
     pre.setInt(4, t.getNbparticpant_formation());
    pre.executeUpdate();
        
    }*/
public void ajouter(Formation t) throws SQLException
{ste=con.createStatement();

String requetInsert="INSERT INTO formation (`id_formation`,`nom_formation`,`type_formation`,`nb_participant`) VALUES (NULL,'"+t.getNom_formation()+"','"+t.getType_formation()+"','"+t.getNb_participant()+"');";
   ste.executeUpdate(requetInsert);
   
}
    @Override
    public boolean delete(Formation t) throws SQLException {
            ste = con.createStatement();
  String requeteDelete ="DELETE FROM formation WHERE nom_formation = ? ;";
  PreparedStatement pst = con.prepareStatement(requeteDelete);
  pst.setString(1,t.getNom_formation());
  pst.executeUpdate();
       return true;
    }

    @Override
   /* public boolean update(Formation t) throws SQLException {
  ste = con.createStatement();
  String requeteUpdate="update FROM formation ( `nom_formation`, `type_formation`) VALUES ( ?, ?) WHERE id_formation = ? ;";
  PreparedStatement pst = con.prepareStatement(requeteUpdate);
  pst.setString(1,t.getNom_formation());
  pst.setString(2,t.getType_formation());
  pst.setInt(3,t.getId_formation());
  pst.executeUpdate();
        return true;
    }*/
    public boolean update(Formation t) throws SQLException
    {
        ste=con.createStatement();
        String requeteUpdate="UPDATE `formation` SET `nom_formation`='"+t.getNom_formation()+"',`type_formation`='"+t.getType_formation()+"' WHERE id_formation='" +t.getId_formation()+ "';";
        return ste.executeUpdate(requeteUpdate)!=0;

    }

    @Override
    public ObservableList<Formation> readAll() throws SQLException {
ObservableList<Formation> arr=FXCollections.observableArrayList();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from formation");
     while (rs.next()) {      
                int id=rs.getInt("id_formation");
               int nb=rs.getInt("nb_participant");
               String nom=rs.getString("nom_formation");
               String type=rs.getString("type_formation");
               Formation f=new Formation(id,nom, type, nb);
     arr.add(f);
     }
    return arr;
    }

    @Override
    public List<Formation> readAllTrie() throws SQLException {
        List<Formation> list=new ArrayList<>();
        String req = "select * from formation order by nom_formation";
       
        try
        {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next())
                list.add(new Formation (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public List<Formation> rechercher(Formation t) throws SQLException {
        List<Formation> list=new ArrayList<>();
        String req = "select * from `formation` where `nom_formation` = '"+t.getNom_formation()+"';";
        try {
            ste = con.createStatement();
            ResultSet rs = ste.executeQuery(req);
            while(rs.next()){
               list.add(new Formation (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex);        
        }
        return list;
}
    
    
    @Override
            public  ObservableList<Formation> afficher(Formation E) throws SQLException {
           
       ObservableList<Formation> arr =FXCollections.observableArrayList();
   ste = con.createStatement();
        ResultSet rs = ste.executeQuery("select * from formation");
        while (rs.next()) {                
               int id=rs.getInt("id_formation");
               String nom=rs.getString("nom_formation");
               String type=rs.getString("type_formation");
               int nb=rs.getInt("nb_participant");
               Formation f=new Formation(id,nom, type, nb);
               System.out.println(f);
     arr.add(f);
     }
        return arr;

    }
    
    
}
