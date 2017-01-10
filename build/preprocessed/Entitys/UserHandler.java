/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entitys;

import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Zeineb
 */
public class UserHandler extends DefaultHandler{
    Vector Utilisateurs;
    fos_user currentUser;
    String email = "close";
    String password = "close";
   
     public UserHandler() {
        Utilisateurs = new Vector();
    }
    
    public fos_user[] getUtilisateurs() {
        fos_user[] list = new fos_user[Utilisateurs.size()];
        Utilisateurs.copyInto(list);
        return list;
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("fos_user")) {
            currentUser = new fos_user();
        }else if (qName.equals("password")) {
            password = "open";
        }else if (qName.equals("email")) {
            email = "open";
        }
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("fos_user")) {
            Utilisateurs.addElement(currentUser);
            currentUser = null;
        }else if (qName.equals("password")) {
            password = "close";
        }else if (qName.equals("email")) {
            email = "close";
        }
    }
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentUser != null) {
            if (password.equals("open")) {
                String pass = new String(ch, start, length).trim();
                currentUser.setPassword(pass);
            }else if (email.equals("open")) {
                String mail = new String(ch, start, length).trim();
                currentUser.setEmail(mail);
            }
        }
    }
}
