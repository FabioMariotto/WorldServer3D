/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws3d_hub;

//import com.sun.glass.events.KeyEvent;

import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;

/**
 *
 * @author Note Fabio M
 */
public class CreatureController {

    public String CreatureName;
    public Creature ThisCreature;
    
    public CreatureController(int x, int y, String name, WS3DProxy proxy) {
            try {   
                //WS3DProxy MyProxy = new WS3DProxy();
                ThisCreature = proxy.createCreature(x,y,0);
                ThisCreature.start();
                CreatureName = name;
                
//                WorldPoint position = c.getPosition();
//                double pitch = c.getPitch();
//                double fuel = c.getFuel();                      
//                c.moveto(4, 0, 0);
            } catch (CommandExecException e) {
                 System.out.println("Erro capturado"); 
            }            
    }
    
}
