/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.*;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author maher
 */
public class Inscription {

    Display disp;

    public Inscription() {
    }

    public Inscription(Display disp) {
        this.disp = disp;
        disp.setCurrent(new MyDraw());

    }

    protected class MyDraw extends Canvas {

        int w = getWidth();
        int h = getHeight();
        int carreauX = 5;
        int carreauY1 = 50;

        int carreauY2 = 120;

        int carreauY3 = 190;
        Image imgRetour;

        protected void pointerPressed(int x, int y) {
            if (((x >= carreauX) && (y >= carreauY1)) && (x <= carreauX + w - 11) && (y <= carreauY1 + 50)) {
                new AjoutAnnonceur(disp);
            } else if (((x >= carreauX) && (y >= carreauY2) && (x <= carreauX + w - 11) && (y <= carreauY2 + 50))) {
                new AjoutClient(disp);
            
            } else if (((x >= 1) && (y >= 2)) && (x <= imgRetour.getWidth()) && (y <= imgRetour.getHeight())) {
                System.out.println("pressed");
                new Authentification(disp);

            }
        }

        protected void paint(Graphics g) {

            g.setColor(255, 255, 204);
            g.fillRect(0, 0, w, h);

            g.setColor(255, 0, 153);
            g.drawRoundRect(carreauX, carreauY1, w - 11, 60, 30, 20);
            try {
                Image img = Image.createImage("/Images/Annonceur.png");
                g.drawImage(img, carreauX, carreauY1 + 4, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("Annonceur", 130, carreauY1 + 33, Graphics.BASELINE | Graphics.HCENTER);

            g.setColor(255, 0, 153);
            g.drawRoundRect(carreauX, carreauY2, w - 11, 60, 30, 20);
            try {
                Image img = Image.createImage("/Images/Client.png");
                g.drawImage(img, carreauX+4, carreauY2 + 4, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("Client", 125, carreauY2 + 32, Graphics.BASELINE | Graphics.HCENTER);

           
           
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
