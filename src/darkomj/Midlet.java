/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package darkomj;

import Menu.Partage;
import Menu.SplashScreennn;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.*;

/**
 * @author maher
 */
public class Midlet extends MIDlet {
  Display disp = Display.getDisplay(this);
   MyDraw md;
    public void startApp() {
        Partage.mainMid = this;
        Partage.disp = disp;
        disp.setCurrent(new SplashScreennn(this));
        try {
            Thread.sleep(3000);//set for 3 seconds
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
          md = new MyDraw();
          disp.setCurrent(md);
   
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
     public class MyDraw extends Canvas {

        int w = getWidth();
        int h = getHeight();

        int carreauX = 5;
        int carreauY1 = 70;

        int carreauY2 = 130;

        int carreauY3;

        protected void pointerPressed(int x, int y) {
            if (((x >= carreauX) && (y >= carreauY2) && (x <= carreauX + w - 11) && (y <= carreauY2 + 50))) {
                new Menu.Acceuil(disp);
            } else if (((x >= carreauX) && (y >= carreauY1) && (x <= carreauX + w - 11) && (y <= carreauY1 + 50))) {
                //new GoogleMapsMarkerCanvas(this,md.,50,120);
            }
        }

        protected void paint(Graphics g) {

            g.setColor(204, 255, 255);
            g.fillRect(0, 0, w, h);

            g.setColor(51, 0, 102);
            g.drawRoundRect(carreauX, carreauY2 + 7, w - 11, 65, 30, 20);
            try {
                Image img = Image.createImage("/Images/start.png");
                g.drawImage(img, carreauX, carreauY2 + 10, Graphics.TOP | Graphics.LEFT);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            g.setFont(Font.getFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
            g.drawString("Bienvenue", 130, carreauY2 + 45, Graphics.BASELINE | Graphics.HCENTER);
        }
    }
}
