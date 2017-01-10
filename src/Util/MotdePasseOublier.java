/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import handler.UserHandler1;
import entities.fos_user;
import java.io.DataInputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MotdePasseOublier implements Runnable {

    String email;
    Thread th;
    public String msg;

    StringBuffer sb;
    SAXParser parser;


    public MotdePasseOublier(String email) {
        this.email = email;
        th = new Thread();
        msg = "";
    }

    public void run() {
        String url = "http://localhost/j2m/MotDePasseOubliee.php?email=";
        fos_user user;
        fos_user[] users;
        UserHandler1 Handler = new UserHandler1();
        SAXParser parser;
        try {
             parser = SAXParserFactory.newInstance().newSAXParser();
            url = url + email;
            HttpConnection hc = (HttpConnection) Connector.open(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, Handler);
            
            users = Handler.getUtilisateurs();
            System.out.println(users.length);
            if (users.length > 0)
            {
                user = users[0];
                msg = user.getPassword();
            }else{
                System.out.println("nuuuul");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println(msg);
        if (msg.equals("")) {
            msg = "Email incorrecte";
        }
    }
}
