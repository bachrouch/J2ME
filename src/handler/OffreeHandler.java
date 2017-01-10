/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;


import entities.Offre;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author 
 */
public class OffreeHandler extends DefaultHandler{

    Vector offres;
    String idTag = "close";
    String titreTag = "close";
    String prixTag = "close";
    String localiteTag = "close";
    
    
    

    public OffreeHandler() {
        offres = new Vector();
    }

    public Offre[] getOffre() {
        Offre[] offress = new Offre[offres.size()];
        System.out.println(offres.size());
        offres.copyInto(offress);
        ///System.out.println(offress);
        return offress;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Offre currentOffre;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("offre")) {
            currentOffre = new Offre();
        }
        else if (qName.equals("id")) {
            idTag = "open";
        }
        else if (qName.equals("titre")) {
            titreTag = "open";
        }
         else if (qName.equals("prix")) {
            prixTag = "open";
        }
        else if (qName.equals("localite")) {
            localiteTag = "open";
        }
       
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("offre")) {
            // we are no longer processing a <reg.../> tag
            offres.addElement(currentOffre);
            currentOffre = null;
        }
        else if (qName.equals("id")) {
            idTag = "close";
        }
        else if (qName.equals("titre")) {
            titreTag = "close";
        }

         else if (qName.equals("prix")) {
            prixTag = "close";
        }
        else if (qName.equals("localite")) {
            localiteTag = "close";
        }
       

    }
    // "characters" are the text between tags

    public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (currentOffre != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (titreTag.equals("open")) {
                String titre = new String(ch, start, length).trim();
                currentOffre.setTitre(titre);
            }
            else if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentOffre.setId(Integer.parseInt(id));
            }
            
           
            else if (prixTag.equals("open")) {
                String prix = new String(ch, start, length).trim();
                currentOffre.setPrix(Float.parseFloat(prix));            }
            else if (localiteTag.equals("open")) {
                String localite = new String(ch, start, length).trim();
                currentOffre.setLocalite(localite);
            }
            
            
        }
    }

}