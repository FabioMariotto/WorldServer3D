/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws3d_hub;

import ws3d_hub.CreatureController;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import ws3dproxy.CommandExecException;
import ws3dproxy.WS3DProxy;
import ws3dproxy.model.Creature;
import ws3dproxy.model.World;
import ws3dproxy.model.WorldPoint;

/**
 *
 * @author Note Fabio M
 */
public class frame_HubHome extends JFrame implements KeyListener {

    WS3DProxy MyProxy;
    List CreatureControllers = new Stack();
    DefaultListModel CreatureIDs = new DefaultListModel();
    String SelectedCreature = "";
    CreatureController CC;
    
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Key Listening...");
        if (!CreatureControllers.isEmpty()){
            
            for (int i = 0; i < CreatureControllers.size(); i++) {
                CC = (CreatureController) CreatureControllers.get(i);
                if(CC.CreatureName.equals(SelectedCreature))
                    break;
            }
            try {
                 if (e.getKeyCode() == KeyEvent.VK_UP) {
                    CC.ThisCreature.updateState();
                    //CC.ThisCreature.ge
                    //creature.updateState();
                    
                    CC.ThisCreature = MyProxy.getCreature("0");
                    CC.ThisCreature.move(2.0, 2.0, 5.0);
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    CC.ThisCreature.start();
                    //creature.updateState();
                    
                    CC.ThisCreature = MyProxy.getCreature("1");
                    CC.ThisCreature.move(-2.0, -2.0, 5.0);
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    CC.ThisCreature.start();
                    //creature.updateState();
                    CC.ThisCreature.rotate(1.0);
                } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    CC.ThisCreature.start();
                    //creature.updateState();
                    CC.ThisCreature.rotate(-1.0);
                }
            }
            catch (Exception ex) {
                System.out.println("Socket Error. " + ex.getMessage());
            }
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        //try {
            //creature.stop();
        //} catch (CommandExecException ex) {
        //    System.out.println("Socket Error. " + ex.getMessage());
        //}

    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped = " + e.getKeyChar());
    }
  
    
    /**
     * Creates new form frame_HubHome
     */
    

    public static void execute() {
        
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
      
                frame_HubHome frame = new frame_HubHome();
                frame.setTitle(".: HUB - ws3d :.");
                frame.setResizable(false);
                frame.setSize(800, 600);
                frame.setMinimumSize(new Dimension(800, 600));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
    }
    
    frame_HubHome() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        initComponents();
        
    }
    
   
  
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_CreateNewCreature = new javax.swing.JButton();
        jL_Creature_Selected = new javax.swing.JLabel();
        JTextBox_PosXtoGo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTextBox_PosYtoGo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        JTextBox_PosXtoGo1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jL_Speed_OfMove = new javax.swing.JLabel();
        jB_MoveGo = new javax.swing.JButton();
        jB_Reset_World = new javax.swing.JButton();
        jB_Start_New_World = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_CreatureList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jB_CreateNewCreature.setText("Create new Creature");
        jB_CreateNewCreature.setActionCommand("jB_new_creature");
        jB_CreateNewCreature.setFocusable(false);
        jB_CreateNewCreature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_CreateNewCreatureActionPerformed(evt);
            }
        });

        jL_Creature_Selected.setText("Selected creature:");

        JTextBox_PosXtoGo.setText("0");
        JTextBox_PosXtoGo.setFocusable(false);

        jLabel2.setText("Move creature to:");

        JTextBox_PosYtoGo.setText("0");
        JTextBox_PosYtoGo.setFocusable(false);

        jLabel3.setText("PosX:");

        jLabel1.setText("PosY:");

        jLabel4.setText("Movement time =");

        JTextBox_PosXtoGo1.setText("0");
        JTextBox_PosXtoGo1.setFocusable(false);

        jLabel5.setText("seconds.");

        jL_Speed_OfMove.setText("Speed = ?");

        jB_MoveGo.setText("Go!");
        jB_MoveGo.setFocusable(false);

        jB_Reset_World.setText("Reset World");
        jB_Reset_World.setFocusable(false);
        jB_Reset_World.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Reset_WorldActionPerformed(evt);
            }
        });

        jB_Start_New_World.setText("Start New World");
        jB_Start_New_World.setFocusable(false);
        jB_Start_New_World.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_Start_New_WorldActionPerformed(evt);
            }
        });

        jL_CreatureList.setFocusable(false);
        jL_CreatureList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jL_CreatureListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jL_CreatureList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(JTextBox_PosYtoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextBox_PosXtoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JTextBox_PosXtoGo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5))
                                    .addComponent(jL_Speed_OfMove))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jB_MoveGo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jL_Creature_Selected, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jB_Reset_World, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_CreateNewCreature, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addComponent(jB_Start_New_World, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_CreateNewCreature)
                    .addComponent(jL_Creature_Selected, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextBox_PosXtoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JTextBox_PosXtoGo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(JTextBox_PosYtoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(jL_Speed_OfMove, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jB_MoveGo))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jB_Start_New_World)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jB_Reset_World)
                .addGap(302, 302, 302))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_CreateNewCreatureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_CreateNewCreatureActionPerformed
       //TO DO: test if world was launched
        try {
                
            String CreatureName = (String)JOptionPane.showInputDialog(
                    this,
                    "Choose a creature name:",
                    "Creature Creation",
                    JOptionPane.PLAIN_MESSAGE);
            
            System.out.println("Choosen name=" + CreatureName);
            if(CreatureIDs.contains(CreatureName)){
                JOptionPane.showMessageDialog(this, "Name already exists");
            }
            else if (null==CreatureName){
                System.out.println("Creation canceled");
            }
            else {
                System.out.println("Creating Creature...");
                //
                CreatureController CC = new CreatureController(400, 400, CreatureName, MyProxy);
                //});
                CreatureControllers.add(CC); 
                CreatureIDs.addElement(CC.CreatureName);// attributes.getName());// getIndex());
                SelectedCreature = CC.CreatureName;
                jL_Creature_Selected.setText("Selected Creature: " + SelectedCreature);
                jL_CreatureList.setModel(CreatureIDs);
                CC.ThisCreature.updateState();
                System.out.println("Creature Created! Index=" + CC.ThisCreature.getIndex().toString() + " Name=" +CC.ThisCreature.getName().toString());
            }
        } catch (Exception e) {
            System.out.println("Error trying to create new creature");
            //Logger.getLogger(frame_HubHome.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jB_CreateNewCreatureActionPerformed

    private void jB_Start_New_WorldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Start_New_WorldActionPerformed

        //check if wordserver is running, if not, run it and do the bellow code
        
            try {  
                MyProxy = new WS3DProxy();
                World w = World.getInstance();
                w.reset();
                w.setEnvironmentHeight(100);
                
                
            } catch (CommandExecException e) {
                 System.out.println("Erro capturado"); 
            }
            
    }//GEN-LAST:event_jB_Start_New_WorldActionPerformed

    private void jB_Reset_WorldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_Reset_WorldActionPerformed
        try {   
                World w = World.getInstance();
                w.reset();
                CreatureControllers.removeAll(CreatureControllers);
                CreatureIDs.removeAllElements();
                jL_Creature_Selected.setText("Selected Creature: " + SelectedCreature);
                jL_CreatureList.removeAll();
                jL_CreatureList.updateUI();
            } catch (CommandExecException e) {
                 System.out.println("Erro capturado"); 
            }
    }//GEN-LAST:event_jB_Reset_WorldActionPerformed

    private void jL_CreatureListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jL_CreatureListValueChanged
        SelectedCreature = jL_CreatureList.getSelectedValue().toString();
        jL_Creature_Selected.setText("Selected Creature: " + SelectedCreature);
    }//GEN-LAST:event_jL_CreatureListValueChanged



    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTextBox_PosXtoGo;
    private javax.swing.JTextField JTextBox_PosXtoGo1;
    private javax.swing.JTextField JTextBox_PosYtoGo;
    private javax.swing.JButton jB_CreateNewCreature;
    private javax.swing.JButton jB_MoveGo;
    private javax.swing.JButton jB_Reset_World;
    private javax.swing.JButton jB_Start_New_World;
    private javax.swing.JList<String> jL_CreatureList;
    private javax.swing.JLabel jL_Creature_Selected;
    private javax.swing.JLabel jL_Speed_OfMove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
