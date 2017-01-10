/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

//import Entitys.*;

/**
 *
 * @author 
 */
public class fos_user {
    
    private int id;
    private String nom;
    private String prenom;
    private int telephone;
    private String username;
    private String password;
    private String email;
    private String roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
    
    

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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

    public void setUsername(String login) {
        this.username = login;
    }

    public void setPassword(String password) {
        this. password=  password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public fos_user(int id, String nom, String prenom, int telephone, String username, String password, String email,String roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public fos_user(int id, String nom, String prenom, String username, String password, String roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public fos_user(String nom, String prenom, int telephone, String username, String email, String roles) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public fos_user(String nom, String prenom, int telephone, String username, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.username = username;
        this.email = email;
    }

    public fos_user(String nom, String prenom, int telephone,String email ,String roles,String username, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    

    public fos_user() {
        
    }
    
    
    
    
}
