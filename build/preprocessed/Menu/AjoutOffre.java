/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author maher
 */
public class AjoutOffre  extends Form implements CommandListener, Runnable{

     Display disp ;
fos_user u;
    
    TextField tfTitre = new TextField("titre", null, 100, TextField.ANY);
   
    TextField tfnbrepiece = new TextField("nbrepiece", null, 100, TextField.ANY);
       DateField tfDateFin = new DateField("datefin", DateField.DATE);
      DateField tfDateDebut = new DateField("datedebut", DateField.DATE);
    //TextField tfDatedebut = new TextField("dateDebut", null, 100, TextField.ANY);
    TextField tfsuperficie = new TextField("superficie", null, 100, TextField.ANY);
    //TextField tfphoto1 = new TextField("photo1", null, 100, TextField.ANY);
   // TextField tfphoto2 = new TextField("photo1", null, 100, TextField.ANY);
   // TextField tfphoto3 = new TextField("photo1", null, 100, TextField.ANY);
    TextField tfprix = new TextField("prix", null, 100, TextField.ANY);
    TextField tfdescription = new TextField("description", null, 100, TextField.ANY);
    TextField tfgouvernorat = new TextField("gouvernorat", null, 100, TextField.ANY);
    TextField tfdelegation = new TextField("delegation", null, 100, TextField.ANY);
    TextField tflocalite = new TextField("localite", null, 100, TextField.ANY);
    TextField tfcodePostal = new TextField("codePostal", null, 100, TextField.ANY);
    Command cmdValider = new Command("valider", Command.SCREEN, 0);
    Command cmdBack = new Command("cmdBack", Command.BACK, 0);
    HttpConnection hc;
    DataInputStream dis;
    String url = "http://localhost/parsingdarkom/offre/ajoutOffre.php?";
    StringBuffer sb = new StringBuffer();
    int ch;
    
    Player player2;
    Player player;
    
    
    public AjoutOffre(String title,Display disp) {
        super(title);
        this.disp = disp;
        append(tfTitre);
       
        append(tfnbrepiece);
        append(tfDateFin);
        append(tfDateDebut);
        append(tfsuperficie);
       // f1.append(tfphoto1);
        //f1.append(tfphoto2);
        //f1.append(tfphoto3);
        append(tfprix);
        append(tfdescription);
        append(tfgouvernorat);
        append(tfdelegation);
        append(tflocalite);
        append(tfcodePostal);
      
        addCommand(cmdValider);
        setCommandListener(this);

     
    }
    
    

    public void commandAction(Command c, Displayable d) {
          if (c == cmdValider) {
          try {
                Thread th = new Thread(this);
                th.start();
                
                
                player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/welcome.wav"), "audio/x-wav");
                player2.setLoopCount(1);
                player2.start();
                //Thread.sleep(10000);//set for 5 seconds
                player.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (MediaException ex) {
                ex.printStackTrace();
            }
    }
    }

    public void run() {
        
        
        try {
            
            
            
            
            
             Calendar cal= Calendar.getInstance();
     cal.setTime(tfDateDebut.getDate());
          cal.setTime(tfDateFin.getDate());
     
    String date = cal.get(Calendar.YEAR) + "-" + ( cal.get(Calendar.MONTH) + 1 ) + "-" + cal.get(Calendar.DAY_OF_MONTH);
               
            url +=  "&titre="+ tfTitre.getString()  +
                    "&nbrepiece="+Integer.parseInt(tfnbrepiece.getString())+"&dateDebut="+date+"&dateFin="+date+"&superficie="+Integer.parseInt(tfsuperficie.getString())
                   
            +"&prix="+Float.parseFloat(tfprix.getString())+"&description="+ tfdescription.getString()+"&gouvernorat="+ tfgouvernorat.getString()+"&delegation="+tfdelegation.getString()+"&localite="+tflocalite.getString()+"&codePostal="+Integer.parseInt(tfcodePostal.getString());
            
            System.out.println(url);
            HttpConnection hc = (HttpConnection) Connector.open(url);

            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            
            int ch;
            sb = new StringBuffer();
            
            while ((ch = dis.read()) != -1) 
            {
                sb.append((char)ch);
            }
              System.out.println(sb.toString().trim());
            if((sb.toString().trim()).equals("Valide"))
            {
                Form fS = new Form("-Succés!-");
                fS.append("Annonce ajoutée avec succés!");
                disp.setCurrent(fS);
                Thread.sleep(3000);
                new AccueilAnnonceur(disp,u);
                Alert msg = new Alert("Succés!", "Annonce ajouté avec succés!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);
            }
            else
            {        
                Form fErreur = new Form("-Ajoutée-");
                Image c = Image.createImage("ok.jpg");
                fErreur.append(c);
                
                disp.setCurrent(fErreur);
            }
            sb = new StringBuffer();
            
        } catch (Exception e) {
        }
     
    }
     public Display getScreen() {
        return disp;
     }
     
     
     
     
    
}
    
    

