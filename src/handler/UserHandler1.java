/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import entities.*;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Zeineb
 */
public class UserHandler1 extends DefaultHandler{
    Vector Utilisateurs;
    fos_user currentUser;
//    String email = "close";
//    String password = "close";
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";
    String telephoneTag = "close";
    String emailTag = "close";
    String statusTag = "close";
    String loginTag = "close";
    String pwdTag = "close";
   
     public UserHandler1() {
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
//        }else if (qName.equals("password")) {
//            password = "open";
//        }else if (qName.equals("email")) {
//            email = "open";
//        }
            } else if (qName.equals("id")) {
            idTag = "open";
        } else if (qName.equals("nom")) {
            nomTag = "open";
        } else if (qName.equals("prenom")) {
            prenTag = "open";
        }else if (qName.equals("telephone")) {
            telephoneTag = "open";
        } else if (qName.equals("email")) {
            emailTag = "open";
        } else if (qName.equals("roles")) {
            statusTag = "open";
        }else if (qName.equals("username")) {
            loginTag = "open";
        } else if (qName.equals("password")) {
            pwdTag = "open";
        }
    
    }
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("fos_user")) {
            Utilisateurs.addElement(currentUser);
            currentUser = null;
//        }else if (qName.equals("password")) {
//            password = "close";
//        }else if (qName.equals("email")) {
//            email = "close";
//        }
            
        } else if (qName.equals("id")) {
            idTag = "close";
        } else if (qName.equals("nom")) {
            nomTag = "close";
        } else if (qName.equals("prenom")) {
            prenTag = "close";
        }
        else if (qName.equals("telephone")) {
            telephoneTag = "close";
        }
        else if (qName.equals("email")) {
            emailTag = "close";
        }
        else if (qName.equals("roles")) {
            statusTag = "close";
        }
         else if (qName.equals("username")) {
            loginTag = "close";
        }
         else if (qName.equals("password")) {
            pwdTag = "close";
        }
            
    }
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentUser != null) {
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                currentUser.setId(Integer.parseInt(id));
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                currentUser.setNom(nom);
            } else
                if (prenTag.equals("open")) {
                String pren = new String(ch, start, length).trim();
                currentUser.setPrenom(pren);
            }else
                if (telephoneTag.equals("open")) {
                String telephone = new String(ch, start, length).trim();
                currentUser.setTelephone(Integer.parseInt(telephone));
            } else
                if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                currentUser.setEmail(email);
            }else
                if (statusTag.equals("open")) {
                String status = new String(ch, start, length).trim();
                currentUser.setRoles(status);
            } else
                if (loginTag.equals("open")) {
                String login = new String(ch, start, length).trim();
                currentUser.setUsername(login);
            }else
                if (pwdTag.equals("open")) {
                String pwd = new String(ch, start, length).trim();
                currentUser.setPassword(pwd);
            }
        }
    }
    
}
