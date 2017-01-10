/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.CustomItem;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.TextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author maher
 */
public class Authentification {

    Display disp;

    public Authentification(Display disp) {
        this.disp = disp;
        MyDraw md = new MyDraw();
        disp.setCurrent(md);
    }

    public Authentification() {
        MyDraw md = new MyDraw();
        disp.setCurrent(md);
    }

    protected class MyDraw extends Canvas {

        int w = this.getWidth();
        int h = this.getHeight();

        int carreauX = 5;
        int carreauY1 = 70;

        int carreauY2 = 130;

        int carreauY3;
        Image imgRetour;

        protected void pointerPressed(int x, int y) {
            if (((x >= carreauX) && (y >= carreauY1)) && (x <= carreauX + w - 11) && (y <= carreauY1 + 50)) {
                new Login(disp);
            } else if (((x >= carreauX) && (y >= carreauY2) && (x <= carreauX + w - 11) && (y <= carreauY2 + 50))) {
                new Inscription(disp);
            }
            if (((x >= 1) && (y >= 2)) && (x <= imgRetour.getWidth()) && (y <= imgRetour.getHeight())) {
                System.out.println("pressed");
                new Acceuil(disp);

            }
        }

        protected void paint(Graphics g) {
            g.setColor(204, 255, 255);
            g.fillRect(0, 0, w, h);

            g.setColor(255, 50, 153);
            g.drawRoundRect(carreauX, carreauY1, w - 11, 65, 30, 20);
            try {
                Image img = Image.createImage("/Images/login.png");
                g.drawImage(img, carreauX, carreauY1 + 1, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("Login", 130, carreauY1 + 40, Graphics.BASELINE | Graphics.HCENTER);

            g.setColor(255, 0, 153);
            g.drawRoundRect(carreauX, carreauY2 + 7, w - 11, 65, 30, 20);
            try {
                Image img = Image.createImage("/Images/inscription.png");
                g.drawImage(img, carreauX, carreauY2 + 5, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("Inscription", 130, carreauY2 + 45, Graphics.BASELINE | Graphics.HCENTER);

            //Image retour
            try {
                imgRetour = Image.createImage("/Images/flecheRetour.png");
                g.drawImage(imgRetour, 1, 2, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
