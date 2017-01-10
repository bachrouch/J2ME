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
public class CommentaireAfficherHandler extends DefaultHandler{
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    private Vector commentaires;

    public CommentaireAfficherHandler() {
        commentaires = new Vector();
    }

    public Note[] getCommentaires() {
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
            currentCommentaire.setCommentaire(attributes.getValue("commentaire"));
            currentCommentaire.setIdoffre(Integer.parseInt(attributes.getValue("idoffre")));
            currentCommentaire.setNote(Integer.parseInt(attributes.getValue("note")));
            currentCommentaire.setStatut(Integer.parseInt(attributes.getValue("statut")));
        }
    }

    public void endElement(String uri, String localName, String qTexte) throws SAXException {

        if (qTexte.equals("commentaire")) {
            // we are no longer processing a <reg.../> tag
            commentaires.addElement(currentCommentaire);
            currentCommentaire = null;
        }
    }
}
