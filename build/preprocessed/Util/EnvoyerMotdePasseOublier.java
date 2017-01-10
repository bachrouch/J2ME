/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Util.Sms;
import javax.microedition.io.Connector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.wireless.messaging.MessageConnection;
/**
 *
 * @author wissal
 */
public class EnvoyerMotdePasseOublier  implements Runnable {

    MessageConnection clientConn;
    private Alert alert;
    Thread th ;
    String mno = "123456789";
    public String msg;
    
    public EnvoyerMotdePasseOublier(String msg) {
        this.msg = msg;
        th = new Thread();
    }

    public void run() {
        System.out.println(msg);
        try {
            clientConn = (MessageConnection) Connector.open("sms://" + mno);
        } catch (Exception e) {
            System.out.println("Unable to connect to Station because of network problem");
        }
        try {
            Sms.Envoyer(mno, msg);
        } catch (Exception e) {
          
           
        }
    }
}