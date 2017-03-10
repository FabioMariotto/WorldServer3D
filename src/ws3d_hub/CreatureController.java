/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws3d_hub;

//import com.sun.glass.events.KeyEvent;
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.event.KeyListener;
import javafx.scene.input.KeyCode;
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

    
    
    public CreatureController() {
        WS3DProxy proxy = new WS3DProxy();
            try {   
                World w = World.getInstance();
                w.reset();
                World.createFood(0, 350, 75);
                World.createFood(0, 100, 220);
                World.createFood(0, 250, 210);
                Creature c = proxy.createCreature(100,450,0);
                w.setEnvironmentHeight(100);
                c.start();
                WorldPoint position = c.getPosition();
                double pitch = c.getPitch();
                double fuel = c.getFuel();                      
                c.moveto(4, 0, 0);
            } catch (CommandExecException e) {
                 System.out.println("Erro capturado"); 
            }            
    }
    
}
