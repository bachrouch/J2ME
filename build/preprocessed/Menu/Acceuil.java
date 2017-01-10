/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author maher
 */
public class Acceuil {

    private int collision = 0;
    private Display disp;

    public Acceuil(Display disp) {
        this.disp = disp;
        MyDraw md = new MyDraw();

        disp.setCurrent(md);
    }

    public class MyDraw extends Canvas implements Runnable {

        private int wWel = getWidth() / 2 - 10;
        private int hWel = getHeight() - 50;

        private int wWelsun = 15;
        private int hWelsun = 20;
        private int wWelcl = 85;
        private int wWelcl1 = 105;
        private int hWelcl = 20;
        private int wWeloj = 30;
        private int hWeloj = 65;
        private int wWelmf = 95;
        private int hWelmf = 120;
        private int widthLog = 22;
        private int heightLog = getHeight() - 25;

        private int wWelpa = 125;
        private int hWelpa = 135;
        private int w = getWidth();
        private int h = getHeight();

        Thread runner;

        public MyDraw() {
            runner = new Thread(this);
            runner.start();
        }

        Image imgLog;

        protected void pointerPressed(int x, int y) {
            if (((x >= 0) && (y >= h - imgLog.getHeight())) && (x <= w - 200) && (y <= h)) {
                new Authentification(disp);
            }

        }

        protected void paint(Graphics g) {
            g.setColor(128, 204, 204);
            g.fillRect(0, 0, w, h);
            //System.out.println(h);
            //System.out.println(h);

            try {
                //image du background
                Image img = Image.createImage("/Images/a.png");

                g.drawImage(img, w / 2, h / 2, Graphics.VCENTER | Graphics.HCENTER);

                imgLog = Image.createImage("/Images/Locked_Cell_Door.png");

                Image imgA = Image.createImage("/Images/images (1) - Copie.png");

                Image imgSun = Image.createImage("/Images/logo.png");

                g.drawImage(imgLog, widthLog, heightLog, Graphics.VCENTER | Graphics.HCENTER);
                g.drawImage(imgA, wWel, hWel, Graphics.VCENTER | Graphics.HCENTER);
                g.drawImage(imgSun, wWelsun, hWelsun, Graphics.VCENTER | Graphics.HCENTER);

            } catch (Exception e) {
            }

        }

        public void run() {
            while (true) {
                if (wWel < w - 87) {
                    wWel = wWel + 5;
                    wWeloj++;
                    wWelmf--;
                    wWelsun = wWelsun + 10;
                    wWelcl--;
                    wWelcl1++;
                    wWelpa--;
                    hWelpa--;
                    collision = 1;

                    repaint();

                } else if (collision != 1) {
                    wWel--;

                    repaint();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
