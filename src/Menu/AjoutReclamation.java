/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.Reclamation;
import java.io.DataInputStream;
import java.util.Calendar;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author pc
 */
public class AjoutReclamation extends Form implements CommandListener, Runnable{
    Display disp ;

    
    
    TextField tfNom = new TextField("nom", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("prenom", null, 100, TextField.ANY);
    TextField tfSujet = new TextField("sujet", null, 100, TextField.ANY);
    TextField tfTexte = new TextField("texte", null, 100, TextField.ANY);
    
    Command cmdValider = new Command("Valider", Command.SCREEN, 0);
    
    String url = "http://localhost/parsingDarkom/Reclamation/ajout.php?";
    StringBuffer sb;

    public AjoutReclamation(String title,Display disp) {
        super(title);
        this.disp=disp;
        append(tfNom);
        append(tfPrenom);
        append(tfSujet);
        append(tfTexte);
        
       addCommand(cmdValider);
       setCommandListener(this);

        
    }

    public void commandAction(Command c, Displayable d) {
        
        if (c == cmdValider) {
            
            
            Thread th = new Thread(this);
            th.start();
           
        }
    }

    public void run() {
        try {
           
            Calendar currentDate = Calendar.getInstance();
            int month = currentDate.get(Calendar.MONTH) + 1;
            int year = currentDate.get(Calendar.YEAR);
            int day = currentDate.get(Calendar.DAY_OF_MONTH);
            
            Reclamation rec = new Reclamation(tfNom.getString().trim(), tfPrenom.getString().trim(),
                    tfSujet.getString().trim(),tfTexte.getString().trim()            );   
                     
            
           url +=  "&nom="+ rec.getNom()+"&prenom="+ rec.getPrenom()+
                    "&sujet="+ rec.getSujet()+"&texte="+ rec.getTexte()+ "&date_reclamation=" + year + "-" + month + "-" + day;
                   
            System.out.println(url);
            HttpConnection hc = (HttpConnection) Connector.open(url+"http://localhost/parsingDarkom/Reclamation/ajout.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            
            int ch;
            sb = new StringBuffer();
            while ((ch = dis.read()) != -1) 
            
            {
                sb.append((char)ch);
            }
            
            if((sb.toString().trim()).equals("Valide"))
            {
                Form fS = new Form("-Succés!-");
                fS.append("Reclamation ajoutée avec succés!");
                disp.setCurrent(fS);
                
                Alert msg = new Alert("Succés!", "Reclamation ajoutée avec succés!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);
                Thread.sleep(3000);
               new AccueilClient(disp);
            }
            else
            {
                              
                Form fErreur = new Form("-Erreur-");
                fErreur.append(sb.toString());
                
                disp.setCurrent(fErreur);
                Alert msg = new Alert("Erreur!", "Une erreur a survenue!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);
                
            }
            sb = new StringBuffer();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     
}
