
//example: terrain with movement cost 1
import java.awt.Color;

public class Grass implements Terrain {
    public int getMovementCost() {
        return 1; 
    }

    public Color getColor() {
        return Color.GREEN;   
    }
}