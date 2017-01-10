/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.Offre;
import java.io.DataInputStream;
import java.io.IOException;
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
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;

/**
 *
 * @author ASUS
 */
public class ModifierOffre  extends Form implements CommandListener, Runnable{
    Display disp;

    Offre off;
   
    TextField tftitre= new TextField("titre", null, 100, TextField.ANY);
    TextField tfnbrepiece = new TextField("nbrepiece", null, 100, TextField.NUMERIC);
    TextField tfsuperficie = new TextField("superficie", null, 20, TextField.NUMERIC);
    TextField tfprix = new TextField("prix", null, 100, TextField.NUMERIC);
    TextField tfgouvernorat = new TextField("gouvernorat", null, 100, TextField.ANY);
   
    TextField tfcodePostal = new TextField("codePostal", null, 100, TextField.ANY);

    Command cmdValider = new Command("Valider", Command.SCREEN, 0);
      Player player2;
    Player player;
   
    String url = "http://localhost/parsingdarkom/offre/modifierOffre.php?";
    StringBuffer sb;

    public ModifierOffre(String title, Offre d,Display disp) {
        super(title);
        
        this.off=d;
        this.disp = disp;
        this.append(tftitre);
        tftitre.setString(off.getTitre());
        this.append(tfnbrepiece);
        tfnbrepiece.setString(off.getNbrepiece()+"");
        this.append(tfsuperficie);
        tfsuperficie.setString(off.getSuperFicie()+"");
        this.append(tfprix);
        tfprix.setString(off.getPrix()+"");
        this.append(tfgouvernorat);
        tfgouvernorat.setString(off.getGouvernorat()+"");
      
//      tflocalite.setString(off.getLocalite());
        this.append(tfcodePostal);
        tfcodePostal.setString(off.getCodePostal()+"");

        addCommand(cmdValider);
        setCommandListener(this);
        
    }

   
    
    public void commandAction(Command c, Displayable d) {
     
             if (c == cmdValider) {
//          try {
                Thread th = new Thread(this);
                th.start();
                
                
//                player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/audio.wav"), "audio/x-wav");
//                player2.setLoopCount(1);
//                player2.start();
//                //Thread.sleep(10000);//set for 5 seconds
//                player.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            } catch (MediaException ex) {
//                ex.printStackTrace();
//            }
    }
        
    }

    public void run() {
         try {
            Offre offre = new Offre (tftitre.getString().trim(),Integer.parseInt(tfnbrepiece.getString().trim()),
                   Float.parseFloat(tfsuperficie.getString().trim()),Float.parseFloat(tfprix.getString().trim()),tfgouvernorat.getString().trim(),
                    Integer.parseInt(tfcodePostal.getString().trim())
                    );
             //System.out.println(offre.getDateFin());
            
             //System.out.println(off.getNbrepiece());
            url +="titre=" + offre.getTitre() + "&nbrepiece=" + Integer.parseInt(tfnbrepiece.getString().trim())
                    + "&superficie=" + Integer.parseInt(tfsuperficie.getString().trim())
                    
                   + "&prix=" + Float.parseFloat(tfprix.getString().trim())+ "&gouvernorat=" + off.getGouvernorat() +"&codePostal=" +Integer.parseInt(tfcodePostal.getString().trim())
                   ;
             System.out.println(url);
            HttpConnection hc = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            int ch;
            sb = new StringBuffer();
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }

            if ((sb.toString().trim()).equals("Valide")) {
                Form fS = new Form("-Succés!-");
                fS.append("Annonce  modifié avec succés!");
                disp.setCurrent(fS);

                Alert msg = new Alert("Succés!", "Annonce modifié avec succés!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);
            } else {

                Form fErreur = new Form("-Erreur-");
                fErreur.append(sb.toString());

                disp.setCurrent(fErreur);
                Alert msg = new Alert("Erreur!", "Une erreur est survenue!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);

            }
            sb = new StringBuffer();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
     public Display getScreen() {
        return disp;
    }


}
