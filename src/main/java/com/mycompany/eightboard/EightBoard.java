package com.mycompany.eightboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    private int[] labels;
    private EightTile[] tiles;
    public EightBoard() {
        initComponents();
        tiles = new EightTile[]{
            eightTile1, eightTile2, eightTile3,
            eightTile4, eightTile5, eightTile6,
            eightTile7, eightTile8, eightTile9
        };
        
        
        for (int i = 0; i < tiles.length ; i++) {
            tiles[i].setPosition(i+1);
            tiles[i].addVetoableChangeListener(eightController1);
            tiles[i].addActionListener(eightTileListener);
            restartButton.addActionListener(tiles[i]);
        }
        
        
        // assign the labels to the tiles and find the hole position
        labels = new int[]{1,2,3,4,5,6,7,8,9};
        permuteArray(labels);
        for (int i=0; i<labels.length;i++) {
            tiles[i].restart(labels[i]);
            if(labels[i] == 9)
                hole = tiles[i];
        }
        // find the hole position and tell it to the controller
        eightController1.setHolePosition(hole.getPosition());
        
 
        // setup the flip button
        flip.setActionCommand("flip");
        flip.putClientProperty("eightTile1", eightTile1);
        flip.putClientProperty("eightTile2", eightTile2);

        
        // compute the first permutation and setup the restart button
        permuteArray(labels);
        restartButton.setActionCommand("restart");
        restartButton.putClientProperty("labels", labels);
        

        for(int i = 0;i<labels.length;i++){
            if(labels[i] == 9)
                nextHole = tiles[i];
        }
         
        
        // Add the Eight Controller to the list of the action listeners
        restartButton.addActionListener(eightController1);
    }
     
    /**
     * function to compute a permutation of the array
     * 
     * @param array array of integers between 1 and 9 
     */
     public static void permuteArray(int[] array) {
        List<Integer> list = IntStream.of(array).boxed().collect(Collectors.toList());
        Collections.shuffle(list, new Random());
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        eightTile1 = new com.mycompany.eightboard.EightTile();
        eightTile2 = new com.mycompany.eightboard.EightTile();
        eightTile3 = new com.mycompany.eightboard.EightTile();
        eightTile4 = new com.mycompany.eightboard.EightTile();
        eightTile5 = new com.mycompany.eightboard.EightTile();
        eightTile6 = new com.mycompany.eightboard.EightTile();
        eightTile7 = new com.mycompany.eightboard.EightTile();
        eightTile8 = new com.mycompany.eightboard.EightTile();
        eightTile9 = new com.mycompany.eightboard.EightTile();
        jPanel2 = new javax.swing.JPanel();
        eightController1 = new com.mycompany.eightboard.EightController();
        flip = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(3, 3));
        jPanel1.add(eightTile1);
        jPanel1.add(eightTile2);
        jPanel1.add(eightTile3);
        jPanel1.add(eightTile4);
        jPanel1.add(eightTile5);
        jPanel1.add(eightTile6);
        jPanel1.add(eightTile7);
        jPanel1.add(eightTile8);
        jPanel1.add(eightTile9);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));
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
    
    
    /**
     * action performed when you try to move a tile
     * 
     * @param eightTile the tile that has been clicked
     */
    private final java.awt.event.ActionListener eightTileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent evt) {
            try {
                EightTile clickedTile = (EightTile) evt.getSource();
                int oldLabel = clickedTile.getTileLabel();
                clickedTile.setTileLabel(9);
                hole.restart(oldLabel);
                hole = clickedTile;
            } catch (InterruptedException ex) { }
        }
    };

   
                                      
    private void flipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flipActionPerformed
        if(eightController1.getHolePosition() == 9){
            EightTile t1 = (EightTile) flip.getClientProperty("eightTile1");
            EightTile t2 = (EightTile) flip.getClientProperty("eightTile2");
            int tempLabel = t1.getTileLabel();
            t1.restart(t2.getTileLabel());
            t2.restart(tempLabel);
        }
    }//GEN-LAST:event_flipActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        permuteArray(labels);
        hole = nextHole;
        for(int i = 0;i<labels.length;i++){
            if(labels[i] == 9)
                nextHole = tiles[i];
        }
    }//GEN-LAST:event_restartButtonActionPerformed

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EightBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            EightBoard board = new EightBoard();
            board.setVisible(true);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton restartButton;
    // End of variables declaration//GEN-END:variables
}
