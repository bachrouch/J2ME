/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Elène
 */
public class Reclamation {

    private String texte, sujet;
    private int id;
    private String nom;
    private String prenom;
    String date_reclamation;

    public Reclamation() {
    }

    public Reclamation(String texte, String sujet, int id, String nom, String prenom) {
        this.texte = texte;
        this.sujet = sujet;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Reclamation(String texte, String sujet, String nom, String prenom) {
        this.texte = texte;
        this.sujet = sujet;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Reclamation(String texte, String sujet, String nom, String prenom, String date_reclamation) {
        this.texte = texte;
        this.sujet = sujet;
        this.nom = nom;
        this.prenom = prenom;
        this.date_reclamation = date_reclamation;
    }

    public Reclamation(String texte, String sujet, int id, String nom, String prenom, String date_reclamation) {
        this.texte = texte;
        this.sujet = sujet;
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.date_reclamation = date_reclamation;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_reclamation() {
        return date_reclamation;
    }

    public void setDate_reclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public String toString() {
        return "Reclamation{" + "texte=" + texte + ", sujet=" + sujet + ", id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", date_reclamation=" + date_reclamation + '}';
    }

    
}