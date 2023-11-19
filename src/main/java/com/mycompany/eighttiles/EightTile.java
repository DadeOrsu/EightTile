package com.mycompany.eighttiles;


import javax.swing.JButton;
import java.awt.Color;
import java.beans.*;
import javax.swing.SwingUtilities;

public class EightTile extends JButton {
    private int label;  
    private int position;    
    private VetoableChangeSupport vetos = new VetoableChangeSupport(this);
    
    public EightTile() {}
    
    public EightTile(int position) {
        super(String.valueOf(0)); 
        this.label = 0;        
        this.position = position;       
        this.updateBackgroundColor();
    }


    public int getPosition() {
        return position;
    }

    public void setLabel(int label) throws InterruptedException {
        int oldLabel = this.label;
        try{
            vetos.fireVetoableChange("label",oldLabel,label);
            this.label = label;
            if(this.label==9)
                setText(" ");
            else
                setText(String.valueOf(this.label));
            this.updateBackgroundColor();
        }
        catch(PropertyVetoException e){
            Color oldBackground = getBackground();
            setBackground(Color.RED);

            // Utilizza SwingUtilities.invokeLater per eseguire il codice nell'EDT
            SwingUtilities.invokeLater(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {  }
                setBackground(oldBackground);
            });
        }
    }

    public void addVetoableChangeListener(VetoableChangeListener l){
        vetos.addVetoableChangeListener(l);
    }
    
    public void removeVetoableChangeListener(VetoableChangeListener l){
        vetos.removeVetoableChangeListener(l);
    }
    
    public void updateBackgroundColor() {
        if (label == 9) {
            setBackground(Color.GRAY);  // Sfondo grigio se il numero sulla tessera è 9
        } else if (label == position) {
            setBackground(Color.GREEN); // Sfondo verde se il numero sulla tessera è uguale alla posizione
        } else {
            setBackground(Color.YELLOW); // Sfondo giallo altrimenti
        }
    }
    
    public void restart(int label){
        this.label = label;
        if(label == 9)
            setText(String.valueOf(" "));
        else
            setText(String.valueOf(label));
        this.updateBackgroundColor();
    }
}