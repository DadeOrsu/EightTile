package com.mycompany.eightboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import javax.swing.JButton;

public class EightController extends JLabel implements VetoableChangeListener, ActionListener {
    private int holePosition; // Store the position of the hole
    
    /**
     * constructor used to initialize the EightController variables
     */
    public EightController() {
        super("START");
        holePosition = 0; 
    }
    
    /**
     * method used when you restart the game to set up the EightController
     * 
     * @param labels array containing the new labels when you restart the game.
     */
    public void restart(int[] labels) {
        setText("START");
        for (int i = 0; i < labels.length; i++) {
            if (labels[i] == 9) {
                holePosition = i+1; 
            }
        }
    }
    
    /**
    * vetoable change listener that checks if the the action is legal
    * 
    * @param evt event
    */
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        String propertyName = evt.getPropertyName();
        
        if ("label".equals(propertyName)) {
            EightTile tile = (EightTile) evt.getSource();
            int tilePosition = tile.getPosition();

            // Check if the tile is the hole or not adjacent to the hole
            if (tilePosition == holePosition || !isAdjacent(tilePosition, holePosition)) {
                setText("KO");
                throw new PropertyVetoException("Illegal move", evt);
            } else {
                setText("OK");
                this.holePosition = tilePosition;
            }
        }
    }

     /**
     * method to see if two tiles are adjacent
     * 
     * @param position1 position of the first tile.
     * @param position2 position of the second tile.
     * @return true if the tiles are adjacent, false otherwhise.
     */
    private boolean isAdjacent(int position1, int position2) {
        int riga1 = (position1 - 1) / 3;
        int colonna1 = (position1 - 1) % 3;
        int riga2 = (position2 - 1) / 3;
        int colonna2 = (position2 - 1) % 3;
        return Math.abs(riga1 - riga2) + Math.abs(colonna1 - colonna2) == 1;
    }

    
    /**
     * method to perform an action when restart or flip button are clicked
     * 
     * @param ae avent 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // retrieve the Array from the the restartButton's properties
        JButton button = (JButton) ae.getSource();
        if(button.getActionCommand().equals("restart")){
            int[] retrievedArray = (int[]) button.getClientProperty("labels");
            this.restart(retrievedArray);
        }
        if(button.getActionCommand().equals("flip")){
            if(holePosition == 9){
                EightTile t1 = (EightTile) button.getClientProperty("eightTile1");
                EightTile t2 = (EightTile) button.getClientProperty("eightTile2");
                String tempText = t1.getText();
                t1.setText(t2.getText());
                t2.setText(tempText);
        
            }
        }
    }
}