/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author maher
 */
public class Note {
    private int id;
    private int note;
    private String commentaire;
    private int statut;
    private  int idoffre;

    
    public Note(){
        
    }

    public Note(int id, int note, String commentaire, int statut, int idoffre) {
        this.id = id;
        this.note = note;
        this.commentaire = commentaire;
        this.statut = statut;
        this.idoffre = idoffre;
    }

    public Note(int note, String commentaire, int idoffre) {
        this.note = note;
        this.commentaire = commentaire;
        this.idoffre = idoffre;
    }

    public Note(String commentaire, int statut, int idoffre) {
        this.commentaire = commentaire;
        this.statut = statut;
        this.idoffre = idoffre;
    }

    public Note(int note, String commentaire, int statut, int idoffre) {
        this.note = note;
        this.commentaire = commentaire;
        this.statut = statut;
        this.idoffre = idoffre;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdoffre() {
        return idoffre;
    }

    public void setIdoffre(int idoffre) {
        this.idoffre = idoffre;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String toString() {
        return "Note{" + "id=" + id + ", note=" + note + ", commentaire=" + commentaire + ", statut=" + statut + ", idoffre=" + idoffre + '}';
    }

    
}
