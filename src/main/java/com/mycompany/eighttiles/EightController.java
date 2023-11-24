package com.mycompany.eighttiles;
import javax.swing.JLabel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class EightController extends JLabel implements VetoableChangeListener {
    private int holePosition; // Store the position of the hole

    public EightController() {
        super("START");
        holePosition = 0; 
    }

    public void restart(int holePosition) {
        setText("START");
        this.holePosition = holePosition; // Reset hole position
    }

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
                System.out.print(this.holePosition);
            }
        }
    }

    private boolean isAdjacent(int position1, int position2) {
        int riga1 = (position1 - 1) / 3;
        int colonna1 = (position1 - 1) % 3;
        int riga2 = (position2 - 1) / 3;
        int colonna2 = (position2 - 1) % 3;
        return Math.abs(riga1 - riga2) + Math.abs(colonna1 - colonna2) == 1;
    }
}