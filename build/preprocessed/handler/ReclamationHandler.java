/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;


import entities.Reclamation;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author 
 */
public class ReclamationHandler extends DefaultHandler{

    private Vector reclamations;
    String idTag = "close";
    String nomTag = "close";
    String prenomTag = "close";
    String sujetTag = "close";
    String texteTag = "close";
    String dateTag = "close";
    

    public ReclamationHandler() {
        reclamations = new Vector();
    }

    public Reclamation[] getReclamation() {
        Reclamation[] reclamationss = new Reclamation[reclamations.size()];
        reclamations.copyInto(reclamationss);
        return reclamationss;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Reclamation currentReclamation;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("reclamation")) {
            currentReclamation = new Reclamation();
        } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenomTag = "open";
        } else if (qName.equals("sujet")) {
            sujetTag = "open";
        } else if (qName.equals("texte")) {
            texteTag = "open";
        }
         else if (qName.equals("date_reclamation")) {
            dateTag = "open";
        }
       
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("reclamation")) {
            // we are no longer processing a <reg.../> tag
            reclamations.addElement(currentReclamation);
            currentReclamation = null;
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenomTag = "close";
        } else if (qName.equals("sujet")) {
            sujetTag = "close";
        } else if (qName.equals("texte")) {
            texteTag = "close";
        }
        else if (qName.equals("date_reclamation")) {
            dateTag = "close";
        }
       

    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentReclamation != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentReclamation.setId(Integer.parseInt(id));
            } else if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentReclamation.setNom(nom);
            } else if (prenomTag.equals("open")) {
                String prenom = new String(ch, start, length).trim();
                currentReclamation.setPrenom(prenom);
            } else if (sujetTag.equals("open")) {
                String sujet = new String(ch, start, length).trim();
                currentReclamation.setSujet(sujet);
            } else if (texteTag.equals("open")) {
                String texte = new String(ch, start, length).trim();
                currentReclamation.setTexte(texte);
            }
            else if (dateTag.equals("open")) {
                String date = new String(ch, start, length).trim();
                currentReclamation.setDate_reclamation(date);
            }
            
            
        }
    }

}
