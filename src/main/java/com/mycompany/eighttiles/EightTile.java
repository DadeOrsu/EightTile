package com.mycompany.eighttiles;


import javax.swing.JButton;
import java.awt.Color;
import java.beans.*;

public class EightTile extends JButton {
    private int label;  // Variabile di istanza per il numero sulla tessera
    private int position;    // Posizione della tessera
    private VetoableChangeSupport vetos = new VetoableChangeSupport(this);
    public EightTile() {}
    public EightTile(int label, int position) {
        super(String.valueOf(label));  // Imposta il testo del pulsante con il numero
        this.label = label;        // Imposta il numero sulla tessera
        this.position = position;        // Imposta la posizione della tessera
        this.updateBackgroundColor();
    }

    // Aggiungi altri metodi o variabili di istanza se necessario

    public int getTileNumber() {
        return label;
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
            Thread.sleep(1);
            setBackground(oldBackground);
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
}