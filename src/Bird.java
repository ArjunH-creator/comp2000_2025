import java.awt.Color;
import java.awt.Polygon;


public class Bird extends Actor {
  public Bird(Cell inLoc) {
    loc = inLoc;
    color = Color.GREEN;
    
    Polygon wing1 = new Polygon();
    wing1.addPoint(5, 5);
    wing1.addPoint( 15, 17);
    wing1.addPoint( 5,  17);
    
    Polygon wing2 = new Polygon();
    wing2.addPoint( 30,  5);
    wing2.addPoint(20, 17);
    wing2.addPoint( 30, 17);
    
    Polygon body = new Polygon();
    body.addPoint(15,  10);
    body.addPoint( 20, 10);
    body.addPoint(20,  25);
    body.addPoint(15, 25);
    
    displayOffSets.add(body);
    displayOffSets.add(wing1);
    displayOffSets.add(wing2);

    addItems(new Seed());  // Adding Seed to the Bird's inventory
    addItems(new Seed());  // Adding another Seed to the Bird's inventory
  }

  @Override
  public boolean canEnter(Cell cell) {
    //bird can move on any terrain
    return true;
  }
 
}
