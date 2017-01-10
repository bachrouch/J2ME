/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;




/**
 *
 * @author maher
 */
public class Offre extends fos_user{
    private byte photo1;
     private byte photo2;
      private byte photo3;
    private int id;
    private String titre;
    private String type;//on doit changer ce type à la base de données
    private int nbrepiece;
    private Date dateDebut;
    private Date dateFin;
    private String dateDebut1;
    private String dateFin1;
    
    private float superFicie;
    private float prix;
    private String description;
    private String gouvernorat;
    private String delegation;
    private String localite;
    private int codePostal;
    private boolean publication;
    private float noteMoy;
    private int iduser;
    public Offre(){
        
    }

    public Offre(int id, String titre, String type, int nbrepiece, Date dateDebut, Date dateFin, float superFicie, float prix, String description, String gouvernorat, String delegation, String localite, int codePostal, boolean publication, float noteMoy,int iduser) {
        this.id = id;
        this.titre = titre;
        this.type = type;
        this.nbrepiece = nbrepiece;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.superFicie = superFicie;
        this.prix = prix;
        this.description = description;
        this.gouvernorat = gouvernorat;
        this.delegation = delegation;
        this.localite = localite;
        this.codePostal = codePostal;
        this.publication = publication;
        this.noteMoy = noteMoy;
        this.iduser=iduser;
    }
public Offre(String titre,int nbrepiece,float superFicie, float prix,String gouvernorat, int codePostal) {
        
        this.titre = titre;
        
        this.nbrepiece = nbrepiece;
      
        this.superFicie = superFicie;
        this.prix = prix;

        this.gouvernorat = gouvernorat;
        
       
        this.codePostal = codePostal;
     
    }
    public String getDateDebut1() {
        
        return dateDebut1;
    }

    public void setDateDebut1(String dateDebut1) {
        this.dateDebut1 = dateDebut1;
    }

    public String getDateFin1() {
        return dateFin1;
    }

    public void setDateFin1(String dateFin1) {
        this.dateFin1 = dateFin1;
    }



  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }
    
    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNbrepiece() {
        return nbrepiece;
    }

    public void setNbrepiece(int nbrepiece) {
        this.nbrepiece = nbrepiece;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    
    
    

    public float getSuperFicie() {
        return superFicie;
    }

    public void setSuperFicie(float superFicie) {
        this.superFicie = superFicie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getDelegation() {
        return delegation;
    }

    public void setDelegation(String delegation) {
        this.delegation = delegation;
    }

    public String getLocalite() {
        return localite;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }

    public float getNoteMoy() {
        return noteMoy;
    }

    public void setNoteMoy(float noteMoy) {
        this.noteMoy = noteMoy;
    }

    public String toString() {
        return "Offre{" + "id=" + id + ", titre=" + titre + ", type=" + type + ", nbrepiece=" + nbrepiece + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", datePublication=" + iduser + ", superFicie=" + superFicie + ", prix=" + prix + ", description=" + description + ", gouvernorat=" + gouvernorat + ", delegation=" + delegation + ", localite=" + localite + ", codePostal=" + codePostal + ", publication=" + publication + ", noteMoy=" + noteMoy + '}';
    }

    public byte getPhoto1() {
        return photo1;
    }

    public void setPhoto1(byte photo1) {
        this.photo1 = photo1;
    }

    public byte getPhoto2() {
        return photo2;
    }

    public void setPhoto2(byte photo2) {
        this.photo2 = photo2;
    }

    public byte getPhoto3() {
        return photo3;
    }

    public void setPhoto3(byte photo3) {
        this.photo3 = photo3;
    }

   
    
}
