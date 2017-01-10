/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;


import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author maher
 */
public class AccueilClient { 
    
    Display disp;
    ListeOffres lo = new ListeOffres("offre",List.IMPLICIT ,disp );
    public AccueilClient(Display disp) {
        this.disp = disp;
        MyDraw md = new MyDraw();
        disp.setCurrent(md);
    }

    public AccueilClient() {
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
                 disp.setCurrent(lo);
            } else if (((x >= carreauX) && (y >= carreauY2) && (x <= carreauX + w - 11) && (y <= carreauY2 + 50))) {
                
                disp.setCurrent(new AjoutReclamation(null,disp));
            }
            
        }

        protected void paint(Graphics g) {
            g.setColor(204, 255, 255);
            g.fillRect(0, 0, w, h);

            g.setColor(255, 50, 153);
            g.drawRoundRect(carreauX, carreauY1, w - 11, 65, 30, 20);
            
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("recherche annonce", 130, carreauY1 + 40, Graphics.BASELINE | Graphics.HCENTER);

            g.setColor(255, 0, 153);
            g.drawRoundRect(carreauX, carreauY2 + 7, w - 11, 65, 30, 20);
            
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_UNDERLINED | Font.STYLE_PLAIN | Font.STYLE_ITALIC, Font.SIZE_LARGE));
            g.drawString("Reclamation", 130, carreauY2 + 45, Graphics.BASELINE | Graphics.HCENTER);

            //Image retour
            
        }

    }

}
