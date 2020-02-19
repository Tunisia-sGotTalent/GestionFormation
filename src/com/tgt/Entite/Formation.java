/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tgt.Entite;

/**
 *
 * @author ASUS
 */
public class Formation {

    private int id_formation;
    private String nom_formation;
    private String type_formation;
    private int nb_participant;

    public int getId_formation() {
        return id_formation;
    }

    public String getNom_formation() {
        return nom_formation;
    }

    public String getType_formation() {
        return type_formation;
    }

    public int getNb_participant() {
        return nb_participant;
    }

    public void setNb_participant(int nb_participant) {
        this.nb_participant = nb_participant;
    }
     
    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public void setNom_formation(String nom_formation) {
        this.nom_formation = nom_formation;
    }

    public void setType_formation(String type_formation) {
        this.type_formation = type_formation;
    }

 

    
    public Formation() {
    }

    public Formation(int id_formation, String nom_formation, String type_formation) {
        this.id_formation = id_formation;
        this.nom_formation = nom_formation;
        this.type_formation = type_formation;
    }

    public Formation(String nom_formation, String type_formation) {
        this.nom_formation = nom_formation;
        this.type_formation = type_formation;
    }

    public Formation(int id_formation, String nom_formation, String type_formation, int nb_participant) {
        this.id_formation = id_formation;
        this.nom_formation = nom_formation;
        this.type_formation = type_formation;
        this.nb_participant = nb_participant;
    }

    public Formation(String nom_formation, String type_formation, int nb_participant) {
        this.nom_formation = nom_formation;
        this.type_formation = type_formation;
        this.nb_participant = nb_participant;
    }

    @Override
    public String toString() {
        return "Formation{" + "id_formation=" + id_formation + ", nom_formation=" + nom_formation + ", type_formation=" + type_formation + ", nb_participant =" + nb_participant + '}';
    }

    
 

}
