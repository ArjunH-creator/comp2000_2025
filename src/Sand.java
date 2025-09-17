// Terrain with slightly higher movement cost
import java.awt.Color; 

public class Sand implements Terrain {
    public int getMovementCost() {
        return 3; 
    }

    public Color getColor() {
        return new Color(194, 178, 128); 
    }
}