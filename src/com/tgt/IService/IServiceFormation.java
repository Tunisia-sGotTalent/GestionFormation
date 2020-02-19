/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.IService;



import com.tgt.Entite.Formation;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;
/**
 *
 * @author ASUS
 * @param <T>
 */
public interface IServiceFormation<T> {
    void ajouter(T t) throws SQLException;
    boolean delete(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    List<T> readAll() throws SQLException;
    List<T> readAllTrie() throws SQLException;
    List<T> rechercher(T t) throws SQLException;
    List<T> afficher(T t) throws SQLException ;

    
    
}
