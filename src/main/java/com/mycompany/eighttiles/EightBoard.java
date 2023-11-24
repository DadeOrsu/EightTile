package com.mycompany.eighttiles;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davide
 */
public class EightBoard extends javax.swing.JFrame {

    /**
     * Creates new form EightBoard
     */

    public EightBoard() {
        initComponents();
        // add the Vetoable Change Listener to each tile
        eightTile1.addVetoableChangeListener(eightController1);
        eightTile2.addVetoableChangeListener(eightController1);
        eightTile3.addVetoableChangeListener(eightController1);
        eightTile4.addVetoableChangeListener(eightController1);
        eightTile5.addVetoableChangeListener(eightController1);
        eightTile6.addVetoableChangeListener(eightController1);
        eightTile7.addVetoableChangeListener(eightController1);
        eightTile8.addVetoableChangeListener(eightController1);
        eightTile9.addVetoableChangeListener(eightController1);
        
        
        // assign the labels to the tiles
        
        int[] labels = {1,2,3,4,5,6,7,8,9};
        permuteArray(labels);
        eightTile1.restart(labels);
        eightTile2.restart(labels);
        eightTile3.restart(labels);
        eightTile4.restart(labels);
        eightTile5.restart(labels);
        eightTile6.restart(labels);
        eightTile7.restart(labels);
        eightTile8.restart(labels);
        eightTile9.restart(labels);
        
        // find the hole position and tell it to the controller
        int holePosition = findHole(labels) + 1;
        eightController1.restart(holePosition);
        
        // compute the first permutation
        permuteArray(labels);
        restartButton.setActionCommand("restart");
        restartButton.putClientProperty("labels", labels);
        
        // Add an action listener that permutes the labels
        restartButton.addActionListener((ActionEvent ae) -> {
            permuteArray(labels);
            restartButton.setActionCommand("restart");
            restartButton.putClientProperty("labels", labels);
        });
        
        // Add the tiles to the list of the action listeners
        restartButton.addActionListener(eightTile1);
        restartButton.addActionListener(eightTile2);
        restartButton.addActionListener(eightTile3);
        restartButton.addActionListener(eightTile4);
        restartButton.addActionListener(eightTile5);
        restartButton.addActionListener(eightTile6);
        restartButton.addActionListener(eightTile7);
        restartButton.addActionListener(eightTile8);
        restartButton.addActionListener(eightTile9);

                
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
     
    public static int findHole(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 9) {
                return i; // restituisce l'indice se il numero è trovato
            }
        }
        return -1; // restituisce -1 se il numero non è presente nell'array
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
        eightTile1 = new com.mycompany.eighttiles.EightTile(1);
        eightTile2 = new com.mycompany.eighttiles.EightTile(2);
        eightTile3 = new com.mycompany.eighttiles.EightTile(3);
        eightTile4 = new com.mycompany.eighttiles.EightTile(4);
        eightTile5 = new com.mycompany.eighttiles.EightTile(5);
        eightTile6 = new com.mycompany.eighttiles.EightTile(6);
        eightTile7 = new com.mycompany.eighttiles.EightTile(7);
        eightTile8 = new com.mycompany.eighttiles.EightTile(8);
        eightTile9 = new com.mycompany.eighttiles.EightTile(9);
        jPanel2 = new javax.swing.JPanel();
        eightController1 = new com.mycompany.eighttiles.EightController();
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
            eightTile.setLabel(9);
        } catch (InterruptedException ex) {
            Logger.getLogger(EightBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    private com.mycompany.eighttiles.EightController eightController1;
    private com.mycompany.eighttiles.EightTile eightTile1;
    private com.mycompany.eighttiles.EightTile eightTile2;
    private com.mycompany.eighttiles.EightTile eightTile3;
    private com.mycompany.eighttiles.EightTile eightTile4;
    private com.mycompany.eighttiles.EightTile eightTile5;
    private com.mycompany.eighttiles.EightTile eightTile6;
    private com.mycompany.eighttiles.EightTile eightTile7;
    private com.mycompany.eighttiles.EightTile eightTile8;
    private com.mycompany.eighttiles.EightTile eightTile9;
    private javax.swing.JButton flip;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables
}
