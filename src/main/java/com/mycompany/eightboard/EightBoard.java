package com.mycompany.eightboard;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 *
 * @author davide
 */
public class EightBoard extends javax.swing.JFrame {

    /**
     * Creates new form EightBoard
     */

    private EightTile hole;
    private EightTile nextHole;
    public EightBoard() {
        initComponents();
        EightTile[] tiles = new EightTile[]{
            eightTile1,
            eightTile2,
            eightTile3,
            eightTile4,
            eightTile5,
            eightTile6,
            eightTile7,
            eightTile8, 
            eightTile9
        };
        // add the Vetoable Change Listener to each tile
        
        for (EightTile tile : tiles) {
            tile.addVetoableChangeListener(eightController1);
        }
        
        
        // assign the labels to the tiles
        
        int[] labels = {1,2,3,4,5,6,7,8,9};
        permuteArray(labels);
        for (EightTile tile : tiles) {
            tile.restart(labels);
        }
        // find the hole position and tell it to the controller
        eightController1.restart(labels);
        
        //find the hole
        for(int i = 0;i<labels.length;i++){
            if(labels[i] == 9)
                hole = tiles[i];
        }
 
        // setup the flip button
        flip.setActionCommand("flip");
        flip.putClientProperty("eightTile1", eightTile1);
        flip.putClientProperty("eightTile2", eightTile2);
        flip.addActionListener(eightController1);
        // compute the first permutation and setup the restart button
        permuteArray(labels);
        restartButton.setActionCommand("restart");
        restartButton.putClientProperty("labels", labels);
        
        /* TODO: aggiungere next hole position */
        for(int i = 0;i<labels.length;i++){
            if(labels[i] == 9)
                nextHole = tiles[i];
        }
         
        
        // Add an action listener that permutes the labels
        restartButton.addActionListener((ActionEvent ae) -> {
            permuteArray(labels);
            hole = nextHole;
            for(int i = 0;i<labels.length;i++){
                if(labels[i] == 9)
                    nextHole = tiles[i];
            }
        });
        
        // Add the tiles to the list of the action listeners
        for (EightTile tile : tiles) {
            restartButton.addActionListener(tile);
        } 
        
        // Add the Eight Controller to the list of the action listeners
        restartButton.addActionListener(eightController1);
    }
        
     public static void permuteArray(int[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
     

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        eightTile1 = new com.mycompany.eightboard.EightTile(1);
        eightTile2 = new com.mycompany.eightboard.EightTile(2);
        eightTile3 = new com.mycompany.eightboard.EightTile(3);
        eightTile4 = new com.mycompany.eightboard.EightTile(4);
        eightTile5 = new com.mycompany.eightboard.EightTile(5);
        eightTile6 = new com.mycompany.eightboard.EightTile(6);
        eightTile7 = new com.mycompany.eightboard.EightTile(7);
        eightTile8 = new com.mycompany.eightboard.EightTile(8);
        eightTile9 = new com.mycompany.eightboard.EightTile(9);
        jPanel2 = new javax.swing.JPanel();
        eightController1 = new com.mycompany.eightboard.EightController();
        flip = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        eightTile1.setText(" ");
        eightTile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile1ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile1);

        eightTile2.setText(" ");
        eightTile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile2ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile2);

        eightTile3.setText(" ");
        eightTile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile3ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile3);

        eightTile4.setText(" ");
        eightTile4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile4ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile4);

        eightTile5.setText(" ");
        eightTile5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile5ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile5);

        eightTile6.setText(" ");
        eightTile6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile6ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile6);

        eightTile7.setText(" ");
        eightTile7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile7ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile7);

        eightTile8.setText(" ");
        eightTile8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile8ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile8);

        eightTile9.setText(" ");
        eightTile9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eightTile9ActionPerformed(evt);
            }
        });
        jPanel1.add(eightTile9);

        jPanel2.setLayout(new java.awt.GridLayout());
        jPanel2.add(eightController1);

        flip.setText("FLIP");
        flip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flipActionPerformed(evt);
            }
        });
        jPanel2.add(flip);

        restartButton.setText("RESTART");
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });
        jPanel2.add(restartButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void eightTilePressed(EightTile eightTile){
         try {
            String oldLabel = eightTile.getLabel();
            eightTile.setLabel(9);
            int[] newLabels = {0,0,0,0,0,0,0,0,0};
            newLabels[hole.getPosition()-1]=Integer.parseInt(oldLabel);
            hole.restart(newLabels);
            hole = eightTile;
        } catch (InterruptedException ex) {}
    }
    
    private void eightTile8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile8ActionPerformed
        eightTilePressed(eightTile8);
    }//GEN-LAST:event_eightTile8ActionPerformed

    private void eightTile4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile4ActionPerformed
        eightTilePressed(eightTile4);
    }//GEN-LAST:event_eightTile4ActionPerformed

    private void eightTile5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile5ActionPerformed
        eightTilePressed(eightTile5);
    }//GEN-LAST:event_eightTile5ActionPerformed

    private void eightTile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile3ActionPerformed
        eightTilePressed(eightTile3);
    }//GEN-LAST:event_eightTile3ActionPerformed

    private void eightTile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile1ActionPerformed
        eightTilePressed(eightTile1);
    }//GEN-LAST:event_eightTile1ActionPerformed

    private void eightTile7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile7ActionPerformed
        eightTilePressed(eightTile7);
    }//GEN-LAST:event_eightTile7ActionPerformed

    private void eightTile9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile9ActionPerformed
        eightTilePressed(eightTile9);
    }//GEN-LAST:event_eightTile9ActionPerformed

    private void eightTile6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile6ActionPerformed
        eightTilePressed(eightTile6);
    }//GEN-LAST:event_eightTile6ActionPerformed

    private void eightTile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eightTile2ActionPerformed
        eightTilePressed(eightTile2);
    }//GEN-LAST:event_eightTile2ActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed

    }//GEN-LAST:event_restartButtonActionPerformed

    private void flipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flipActionPerformed
        
    }//GEN-LAST:event_flipActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new EightBoard().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.eightboard.EightController eightController1;
    private com.mycompany.eightboard.EightTile eightTile1;
    private com.mycompany.eightboard.EightTile eightTile2;
    private com.mycompany.eightboard.EightTile eightTile3;
    private com.mycompany.eightboard.EightTile eightTile4;
    private com.mycompany.eightboard.EightTile eightTile5;
    private com.mycompany.eightboard.EightTile eightTile6;
    private com.mycompany.eightboard.EightTile eightTile7;
    private com.mycompany.eightboard.EightTile eightTile8;
    private com.mycompany.eightboard.EightTile eightTile9;
    private javax.swing.JButton flip;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables
}