package com.mycompany.eightboard;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import javax.swing.SwingUtilities;

public class EightTile extends JButton implements ActionListener {
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

    @Override
    public String getLabel(){
        return Integer.toString(label);
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
            throw new InterruptedException();
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
            setBackground(Color.GRAY);  
        } else if (label == position) {
            setBackground(Color.GREEN); 
        } else {
            setBackground(Color.YELLOW); 
        }
    }
    
    public void restart(int[] labels){
        this.label = labels[this.position - 1];
        if(label == 9)
            setText(String.valueOf(" "));
        else
            setText(String.valueOf(label));
        this.updateBackgroundColor();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // retrieve the Array from the the restartButton's properties
        JButton button = (JButton) ae.getSource();
        if(button.getActionCommand().equals("restart")){
            int[] retrievedArray = (int[]) button.getClientProperty("labels");
            this.restart(retrievedArray);
        }
    }
}