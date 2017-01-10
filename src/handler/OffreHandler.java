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
 * @author ASUS
 */
public class OffreHandler extends DefaultHandler {

    private Vector offres;
    String titreTag = "close";
    String nbrepieceTag = "close";
    String dateDebutTag = "close";
     String dateFinTag = "close";
    String superficieTag = "close";
    String prixTag = "close";
    String descriptionTag = "close";
    String gouvernoratTag = "close";
    String delegationTag = "close";
    String localiteTag = "close";
    String codePostalTag = "close";

    public OffreHandler() {
        offres = new Vector();
    }

    public Offre[] getOffre() {
        Offre[] offress = new Offre[offres.size()];
        offres.copyInto(offress);
        return offress;
    }
    // VARIABLES TO MAINTAIN THE PARSER'S STATE DURING PROCESSING
    private Offre currentOffre;

    // XML EVENT PROCESSING METHODS (DEFINED BY DefaultHandler)
    // startElement is the opening part of the tag "<tagname...>"
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("Offre")) {
            currentOffre = new Offre();
        } else if (qName.equals("titre")) {
            titreTag = "open";
        } else if (qName.equals("nbrepiece")) {
            nbrepieceTag = "open";
             } else if (qName.equals("datedebut")) {
            dateDebutTag = "open";
             } else if (qName.equals("datefin")) {
            dateFinTag = "open";
        } else if (qName.equals("superficie")) {
            superficieTag = "open";
        } else if (qName.equals("prix")) {
            prixTag = "open";
        } else if (qName.equals("description")) {
            descriptionTag = "open";

        } else if (qName.equals("gouvernorat")) {
            gouvernoratTag = "open";

        } 
//        else if (qName.equals("delegation")) {
//            delegationTag = "open";
//
//        } 
        else if (qName.equals("localite")) {
            localiteTag = "open";
        } else if (qName.equals("codepostal")) {
            codePostalTag = "open";
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("Offre")) {
            // we are no longer processing a <reg.../> tag
            offres.addElement(currentOffre);
            currentOffre = null;
        } else if (qName.equals("titre")) {
            titreTag = "close";
        } else if (qName.equals("nbrepiece")) {
            nbrepieceTag = "close";
        } else if (qName.equals("datedebut")) {
            dateDebutTag = "close";
            } else if (qName.equals("datefin")) {
            dateFinTag = "close";
        } else if (qName.equals("superficie")) {
            superficieTag = "close";
        } else if (qName.equals("prix")) {
            prixTag = "close";
        } else if (qName.equals("description")) {
            descriptionTag = "close";
        } else if (qName.equals("gouvernorat")) {
            gouvernoratTag = "close";
        }
//        } else if (qName.equals("delegation")) {
//            delegationTag = "close";
//
//         
            else if (qName.equals("localite")) {
            localiteTag = "close";
        } else if (qName.equals("codepostal")) {
            codePostalTag = "close";
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
            } else if (nbrepieceTag.equals("open")) {
                String nbrepiece = new String(ch, start, length).trim();
                currentOffre.setNbrepiece(Integer.parseInt(nbrepiece));
                
            } else if (dateDebutTag.equals("open")) {
                String dateDebut = new String(ch, start, length).trim();
                currentOffre.setDateDebut1(dateDebut);
            } else if (dateFinTag.equals("open")) {
                String dateFin= new String(ch, start, length).trim();
                currentOffre.setDateFin1(dateFin);
            } else if (superficieTag.equals("open")) {
                String superficie = new String(ch, start, length).trim();
                currentOffre.setSuperFicie(Float.parseFloat(superficie));
            } else if (prixTag.equals("open")) {
                String prix = new String(ch, start, length).trim();
                currentOffre.setPrix(Float.parseFloat(prix));
            } else if (descriptionTag.equals("open")) {
                String description = new String(ch, start, length).trim();
                currentOffre.setDescription(description);
            } else if (gouvernoratTag.equals("open")) {
                String gouvernorat = new String(ch, start, length).trim();
                currentOffre.setGouvernorat(gouvernorat);
            }
//            } else if (delegationTag.equals("open")) {
//                String delegation = new String(ch, start, length).trim();
//                currentOffre.setDelegation(delegation);
             else if (localiteTag.equals("open")) {
                String localite = new String(ch, start, length).trim();
                currentOffre.setLocalite(localite);
            } else if (codePostalTag.equals("open")) {
                String codePostal = new String(ch, start, length).trim();
                currentOffre.setCodePostal(Integer.parseInt(codePostal));

            }
        }
    }
}
