// Harder terrain. Birds can move over it, others cannot
import java.awt.Color; 

public class Water implements Terrain {
    public int getMovementCost() {
        return 5; 
    }

    public Color getColor() {
        return Color.BLUE; 
    }
}