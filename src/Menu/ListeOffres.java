/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Menu.DetailOffres;
import entities.Offre;
import handler.OffreeHandler;
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
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author
 */
public class ListeOffres extends List implements Runnable, CommandListener {

     Offre[] articles ;
    Display disp;
    StringBuffer sb = new StringBuffer();
    Command cmretour ;
    public ListeOffres(String title, int listType, Display d) {
        super(title, listType);
        disp=d;
        cmretour = new Command("Retour", Command.SCREEN , 0);
        this.addCommand(cmretour);
        Thread th = new Thread(this);
        th.start();
    }

    public void run() {
      
        setCommandListener(this);
        try {
            OffreeHandler arth = new OffreeHandler();
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            HttpConnection ht = (HttpConnection) Connector.open("http://localhost/parsingdarkom/offre/getXmlOffre.php");
            DataInputStream dis = new DataInputStream(ht.openDataInputStream());
            parser.parse(dis, arth);
            articles = arth.getOffre();
          
            for(int i =0;i<articles.length;i++){
                append(articles[i].getTitre(),null);
                
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    
}

    public void commandAction(Command c, Displayable d) {
        if(c==List.SELECT_COMMAND){
            Offre a = articles[getSelectedIndex()];
           DetailOffres da = new DetailOffres(a.getTitre(),a,disp);
            disp.setCurrent(da);
        }
    }
}