/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.*;
import handler.UserHandler1;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
/**
 *
 * @author maher
 */
public class Login implements CommandListener {
public  fos_user user;
    Display disp;
    Form f1 = new Form("Authentification");
    Command cmdBack = new Command("Retour", Command.BACK, 0);
    Command cmdNext = new Command("Suivant", Command.SCREEN, 0);
fos_user[] personnes;
    //MidletAuthentification ma = new MidletAuthentification();
    TextField tfLogin = new TextField("Login", null, 100, TextField.ANY);

    TextField tfMdp = new TextField("Mode de passe", null, 100, TextField.PASSWORD);

    Image img;
    ImageItem imgItem;

    public Login() {
    }

    public Login(Display disp) {
        try {
            this.disp = disp;

            //f1.append(new MyCustumItem("Authentification", "Form"));
            f1.append(tfLogin);
            f1.append(tfMdp);
            img = Image.createImage("/Images/connexion.png");
            imgItem = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "");
            f1.append(imgItem);
            f1.addCommand(cmdBack);
            f1.setCommandListener(this);
            f1.addCommand(cmdNext);
            f1.setCommandListener(this);

            disp.setCurrent(f1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdBack) {
            new Authentification(disp);
        }
        if (c == cmdNext) {
            //------------------------------
           
          String  url="http://localhost/parsingdarkom/getXmlPersons_Characters.php";
            url = url + "?username=" + tfLogin.getString()+ "&password=" + tfMdp.getString();
            System.out.println(url);
            try {
            // this will handle our XML
            UserHandler1 userHandler = new UserHandler1();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, userHandler);
            // display the result
            personnes = userHandler.getUtilisateurs();

            if (personnes.length > 0) {
                if(personnes[0].getRoles().equals("a:1:{i:0;s:10:\"ROLE_ADMIN\";}"))
                {
                    System.out.println("admin");
                new MenuAdmin();
                
                }
                else if(personnes[0].getRoles().equals("a:1:{i:0;s:14:\"ROLE_ANNONCEUR\";}"))
                {
                     System.out.println("annonceur");
                     user=personnes[0];
                     System.out.println("maher++"+user.getId());
                     new AccueilAnnonceur(disp,user);
                    
                    
               
                }
                else 
                {
                     System.out.println("client");
                    new AccueilClient(disp );
                }
                }
            }

         catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception:" + e.toString());
        }
            
            
            
            //---------------
        }
    }
}

            
