/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Menu.Login;

import entities.Offre;
import entities.*;
import handler.OffreHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author ASUS
 */
public class ListeOffre extends Form implements Runnable, CommandListener {

    Command cmModif = new Command("Modif", Command.SCREEN, 0);
    Command cmdBack = new Command("retour", Command.BACK, 0);
    Offre[] offres;
    Display disp;
    StringBuffer sb = new StringBuffer();
    Player player2;
    Player player;
    fos_user m;
    Offre off;

    public ListeOffre(String title, Display d, fos_user u) {
        super(title);
        disp = d;
        m = u;

        Thread th = new Thread(this);
        th.start();
        addCommand(cmModif);
        setCommandListener(this);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void run() {

        setCommandListener(this);
        try {
            OffreHandler arth = new OffreHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();

            String url = "http://localhost/parsingdarkom/offre/getXmlOffre_Characters.php" + "?ids=" + m.getId();
            System.out.println(url);
            HttpConnection ht = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(ht.openDataInputStream());
            parser.parse(dis, arth);
            offres = arth.getOffre();

//           for (int i = 0; i < offres.length; i++) {
            append("titre:" + offres[0].getTitre());
            append("nombre_piece:" + offres[0].getNbrepiece() + "\n");
            append("superficie:" + offres[0].getSuperFicie() + "\n");
            append("prix:" + offres[0].getPrix() + "\n");
//                  append(offres[0].getDescription());
            append("gouvernorat:" + offres[0].getGouvernorat() + "\n");
//

            append("localite:" + offres[0].getLocalite() + "\n");
            append("codePostal:" + offres[0].getCodePostal() + "\n");
            append("DateDebut:" + offres[0].getDateDebut1() + "\n");
            append("DateFin:" + offres[0].getDateFin1() + "\n");
//           }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {

            try {
//                Thread th = new Thread(this);
//                th.start();
//                

                player2 = Manager.createPlayer(getClass().getResourceAsStream("/audio/audio.WAV"), "audio/x-WAV");
                player2.setLoopCount(1);
                player2.start();
                Thread.sleep(10000);//set for 5 seconds
                new AccueilAnnonceur(disp, m);
                player.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (MediaException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        if (c == cmModif) {
            off = offres[0];
            ModifierOffre mo;
            mo = new ModifierOffre("modifier", off, disp);
            disp.setCurrent(mo);

        }
    }

    public Display getScreen() {
        return disp;
    }

}
