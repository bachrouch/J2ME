/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import entities.User;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author maher
 */
public class UserHandler extends DefaultHandler{

    private User current;
    private Vector user;
    String idTag = "close";
    String nomTag = "close";
    String prenTag = "close";
    String telephoneTag = "close";
    String emailTag = "close";
    String statusTag = "close";
    String loginTag = "close";
    String pwdTag = "close";
    public UserHandler() {
        user = new Vector();
    }
     public User[] getPersonne() {
        User[] personness = new User[user.size()];
        user.copyInto(personness);
        return personness;
    }
    
    
     public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("user")) {
            current =new User();
            
            
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
        } else if (qName.equals("status")) {
            statusTag = "open";
        }else if (qName.equals("login")) {
            loginTag = "open";
        } else if (qName.equals("pwd")) {
            pwdTag = "open";
        }
    
            
        }
       
    

    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("maher"+qName);
        if (qName.equals("user")) {
            // we are no longer processing a <reg.../> tag
           user.addElement(current);
            current = null;
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
        else if (qName.equals("status")) {
            statusTag = "close";
        }
         else if (qName.equals("login")) {
            loginTag = "close";
        }
         else if (qName.equals("pwd")) {
            pwdTag = "close";
        }
    }
 public void characters(char[] ch, int start, int length) throws SAXException {
        // we're only interested in this inside a <phone.../> tag
        if (current != null) {
            // don't forget to trim excess spaces from the ends of the string
            if (idTag.equals("open")) {
                String id = new String(ch, start, length).trim();
                current.setId(Integer.parseInt(id));
            } else
                if (nomTag.equals("open")) {
                String nom = new String(ch, start, length).trim();
                current.setNom(nom);
            } else
                if (prenTag.equals("open")) {
                String pren = new String(ch, start, length).trim();
                current.setPrenom(pren);
            }else
                if (telephoneTag.equals("open")) {
                String telephone = new String(ch, start, length).trim();
                current.setTelephone(Integer.parseInt(telephone));
            } else
                if (emailTag.equals("open")) {
                String email = new String(ch, start, length).trim();
                current.setEmail(email);
            }else
                if (statusTag.equals("open")) {
                String status = new String(ch, start, length).trim();
                current.setStatus(Integer.parseInt(status));
            } else
                if (loginTag.equals("open")) {
                String login = new String(ch, start, length).trim();
                current.setLogin(login);
            }else
                if (pwdTag.equals("open")) {
                String pwd = new String(ch, start, length).trim();
                current.setPwd(pwd);
            }
        }
    }
    public Vector getUser() {
        return user;
    }
    public User getUsers() {
        return current;
    }
    

}
