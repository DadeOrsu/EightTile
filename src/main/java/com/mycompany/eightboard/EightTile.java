package com.mycompany.eightboard;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.io.Serializable;
import javax.swing.SwingUtilities;

public class EightTile extends JButton implements ActionListener, Serializable {
    private int label;  
    private int position;    
    private VetoableChangeSupport vetos;
    private PropertyChangeSupport changes;

    
    public EightTile() {
        // Initialize support for vetoable property changes
        this.vetos = new VetoableChangeSupport(this);
        // initialize support for property change notificarions
        this.changes = new PropertyChangeSupport(this);
    }
    /*
    * method to set the position of the tile
    *
    * @position the position of the tile
    */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * method to get the position of the tile
     * 
     * @return the position of the tile
     */
    public int getPosition() {
        return position;
    }

    /**
     * method to get the label of the tile
     * 
     * @return the label of the tile 
     */
    public int getTileLabel(){
        return label;
    }
    
    /**
     * Method to be invoked when the player performs a move. 
     * It notifies the EightBoard about the changes so that it can put a veto if 
     * the move is illegal.
     * 
     * @param label
     * @throws InterruptedException 
     */
    public void moveTile(int label) throws InterruptedException {
        int oldLabel = this.label;
        try{
            vetos.fireVetoableChange("label",oldLabel,label);
            this.setTileLabel(label);
            changes.firePropertyChange("label", oldLabel, label);
        }
        catch(PropertyVetoException e){
            Color oldBackground = getBackground();
            setBackground(Color.RED);

            // Use swingutilities to make it blink if the veto is negative.
            SwingUtilities.invokeLater(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {  }
                setBackground(oldBackground);
            });
            throw new InterruptedException();
        }
    }
    
    
    /**
     * method to add a vetoable change listener to the tile
     * 
     * @param l listener
     */
    public void addVetoableChangeListener(VetoableChangeListener l){
        vetos.addVetoableChangeListener(l);
    }
    
    /**
     * method to remove a vetoable change listener to the tile
     * 
     * @param l listener
     */
    public void removeVetoableChangeListener(VetoableChangeListener l){
        vetos.removeVetoableChangeListener(l);
    }
    

    /**
     * method to update the backgorund color of the tile according 
     * to its label and position
     */
    public void updateBackgroundColor() {
        if (label == 9) {
            setBackground(Color.GRAY);  
        } else if (label == position) {
            setBackground(Color.GREEN); 
        } else {
            setBackground(Color.YELLOW); 
        }
    }
    
    
    /**
     * method used set the Tile label
     * 
     * @param label the new label
     */
    public void setTileLabel(int label){
        this.label = label;
        if(label == 9)
            setText(String.valueOf(" "));
        else
            setText(String.valueOf(label));
        this.updateBackgroundColor();
    }

    /**
     * action perfordmed to manage the pression of the restart button 
     * 
     * @param ae event 
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        // retrieve the Array from the the restartButton's properties
        JButton button = (JButton) ae.getSource();
        if(button.getActionCommand().equals("restart")){
            int[] retrievedArray = (int[]) button.getClientProperty("labels");
            this.setTileLabel(retrievedArray[this.position - 1]);
        }
    }
}