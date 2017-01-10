///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Menu;
//
//
//
//import entities.Offre;
//import javax.microedition.lcdui.Command;
//import javax.microedition.lcdui.CommandListener;
//import javax.microedition.lcdui.Display;
//import javax.microedition.lcdui.Displayable;
//import javax.microedition.lcdui.Form;
//import javax.microedition.lcdui.Gauge;
//import javax.microedition.lcdui.List;
//
///**
// *
// * @author
// */
//public class DetailOffres extends Form implements CommandListener{
//    Offre art ;
//    Display disp ;
//    Command cmback = new Command("Retour", Command.SCREEN, 0);
//
//   
//    public DetailOffres(String title,Offre art, Display disp) {
//        super(title);
//        this.art = art;
//        this.disp=disp;
//        append("titre: \n");
//        append(art.getTitre());
//        append("prix: \n");
//        append(art.getPrix()+" ");
//        append("localite: \n");
//        append(art.getLocalite()+"\n");
//        
//        addCommand(cmback);
//        setCommandListener(this);
//    }
//    
//
//    public void commandAction(Command c, Displayable d) {
//        if(c==cmback){
//            ListeOffres la = new ListeOffres("offre", List.IMPLICIT, disp);
//            disp.setCurrent(la);
//        }
//    }
//    
//}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import entities.Offre;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.List;

/**
 *
 * @author Amine Kriaa
 */
public class DetailOffres extends Form implements CommandListener{
    
    Offre art ;
    Display disp ;
    Command cmdon = new Command("Faire un don", Command.SCREEN, 0);
    Command cmback = new Command("Retour", Command.SCREEN, 1);
    public DetailOffres(String title,Offre art, Display disp) {
        super(title);
        this.art = art;
        this.disp=disp;
        append("Titre: \n");
        append(art.getTitre()+"\n");
        
        append("Prix: \n");
        append(art.getPrix()+"\n");
        
        append("Localite: \n");
        append(art.getLocalite()+"\n");
        addCommand(cmback);
        addCommand(cmdon);
        setCommandListener(this);
    }
    

    public void commandAction(Command c, Displayable d) {
        if(c==cmback){
            ListeOffres la = new ListeOffres("Offre", List.IMPLICIT, disp);
            disp.setCurrent(la);
        }

    }
    
}
