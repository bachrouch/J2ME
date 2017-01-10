/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.*;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author maher
 */
public class AjoutAnnonceur implements CommandListener, Runnable {

    Display disp;

    Form f1 = new Form("Inscription ");

    
    TextField tfNom = new TextField("Nom", null, 100, TextField.ANY);
    TextField tfPrenom = new TextField("Prenom", null, 100, TextField.ANY);
    TextField tfTel = new TextField("telephone", null, 100, TextField.NUMERIC);
    TextField tfEmail = new TextField("Email", null, 100, TextField.ANY);
    int status;
    TextField tfLogin = new TextField("Login", null, 100, TextField.ANY);
    TextField tfPwd = new TextField("Mot de passe", null, 100, TextField.PASSWORD);

    Command cmdValider = new Command("Valider", Command.SCREEN, 0);
    Command cmdBack = new Command("Retour", Command.BACK, 0);
    String url = "http://localhost/parsingdarkom/insert.php";
    StringBuffer sb;

    public AjoutAnnonceur(Display disp) {
        this.disp = disp;
        
        f1.append(tfPrenom);
        f1.append(tfNom); 
        f1.append(tfTel);
        f1.append(tfEmail);
        f1.append(tfLogin);
        f1.append(tfPwd);
        f1.addCommand(cmdValider);
        f1.setCommandListener(this);
        f1.addCommand(cmdBack);
        f1.setCommandListener(this);
        disp.setCurrent(f1);
    }


    public void commandAction(Command c, Displayable d) {
        if (c == cmdValider) {
            Thread th = new Thread(this);
            th.start();
        }
        if(c== cmdBack){
            new Inscription(disp);
        }
    }

    public void run() {
        try {

            fos_user user = new fos_user(
                    tfNom.getString().trim(),
                    tfPrenom.getString().trim(),
                    Integer.parseInt(tfTel.getString().trim()),
                    tfEmail.getString().trim(),
                    "a:1:{i:0;s:14:\"ROLE_ANNONCEUR\";}",
                    tfLogin.getString().trim(),
                    tfPwd.getString().trim());

            url = url + "?nom=" + user.getNom() + "&prenom=" + user.getPrenom()
                    + "&telephone=" + user.getTelephone()
                    + "&email=" + user.getEmail()
                    + "&roles=" + user.getRoles()
                    + "&username=" + user.getUsername()
                    + "&password=" + user.getPassword();
            
            System.out.println(url);
            HttpConnection hc = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            hc.close();
            int ch;
            sb = new StringBuffer();
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }

            if ((sb.toString().trim()).equals("OK")) {
                Form fS = new Form("-Succs!-");
                fS.append("vous etes ajoutée avec succèes!");
                disp.setCurrent(fS);

                Alert msg = new Alert("Succès!", " vous êtes ajouté avec succès!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);
                Thread.sleep(2000);
                new Login(disp);
            } else {

                Form fErreur = new Form("-Erreur-");
                fErreur.append(sb.toString());

                disp.setCurrent(fErreur);
                Alert msg = new Alert("Erreur!", "Une erreur a survenue!", null, AlertType.CONFIRMATION);
                disp.setCurrent(msg);

            }
            sb = new StringBuffer();

        } catch (Exception e) {
        }
    }

    public Display getScreen() {
        return disp;
    }

}