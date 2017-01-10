/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.Note;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author wezza
 */

public class CommentaireHandler extends DefaultHandler {

    private Vector commentaires;
    String idTag = "close";
    String commentaireTag = "close";
    String noteTag = "close";
    String idoffreTag = "close";
    String statutTag = "close";

    public CommentaireHandler() {
        commentaires = new Vector();
    }

    public Note[] getCommentaire() {
        Note[] commentairess = new Note[commentaires.size()];
        commentaires.copyInto(commentairess);
        return commentairess;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Note currentCommentaire;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qTexte, Attributes attributes) throws SAXException {
        if (qTexte.equals("commentaire")) {
            currentCommentaire = new Note();
            //2ème methode pour parser les attributs
            currentCommentaire.setCommentaire(attributes.getValue("commentaire"));
            currentCommentaire.setNote(Integer.parseInt(attributes.getValue("note")));
            if (attributes.getValue("statut") != null) {
                currentCommentaire.setStatut(Integer.parseInt(attributes.getValue("statut")));
            }else{
                currentCommentaire.setStatut(0);
            }
            if (attributes.getValue("idoffre") != null) {
                currentCommentaire.setIdoffre(Integer.parseInt(attributes.getValue("idoffre")));
            }
            currentCommentaire.setId(Integer.parseInt(attributes.getValue("id")));

        } else if (qTexte.equals("commentaire")) {
            commentaireTag = "open";
        } else if (qTexte.equals("note")) {
            noteTag = "open";
        } else if (qTexte.equals("statut")) {
            statutTag = "open";
        } else if (qTexte.equals("idoffre")) {
            idoffreTag = "open";
        } else if (qTexte.equals("id")) {
            idTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qTexte) throws SAXException {

        if (qTexte.equals("commentaire")) {
            // we are no longer processing a <reg.../> tag
            commentaires.addElement(currentCommentaire);
            currentCommentaire = null;
        } else if (qTexte.equals("commentaire")) {
            commentaireTag = "close";
        } else if (qTexte.equals("note")) {
            noteTag = "close";
        } else if (qTexte.equals("statut")) {
            statutTag = "close";
        } else if (qTexte.equals("idoffre")) {
            idoffreTag = "close";
        } else if (qTexte.equals("id")) {
            idTag = "close";
        }
    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentCommentaire != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (commentaireTag.equals("open")) {
                String texte = new String(ch, start, length).trim();
                currentCommentaire.setCommentaire(texte);
            }
        }
    }
}
