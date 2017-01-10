/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entitys;

/**
 *
 * @author Zeineb
 */
public class fos_user {
    private String nom;
    private String prenom;
    private int cin;
    private String adresse;
    private String username;
    private String password;
    private String email;
    private String nompatisserie;

    public String getNompatisserie() {
        return nompatisserie;
    }

    public void setNompatisserie(String nompatisserie) {
        this.nompatisserie = nompatisserie;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return  password;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public void setPassword(String password) {
        this. password=  password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public fos_user(String nom, String prenom, int cin, String adresse, String username, String password, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.username = username;
        this. password =  password;
        this.email = email;
    }

    public fos_user(String nom, String prenom, int cin, String adresse, String username, String password, String email, String nompatisserie) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.adresse = adresse;
        this.username = username;
        this. password =  password;
        this.email = email;
        this.nompatisserie = nompatisserie;
    }

    public fos_user() {
    }
    
    
    
    
}
