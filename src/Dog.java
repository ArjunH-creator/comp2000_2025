import java.awt.Color;
import java.awt.Polygon;


public class Dog extends Actor {
  public Dog(Cell inLoc) {
    loc = inLoc;
    color = Color.YELLOW;
    
    Polygon ear1 = new Polygon();
    ear1.addPoint(5, 5);
    ear1.addPoint(15, 5);
    ear1.addPoint(5, 15);
    
    Polygon ear2 = new Polygon();
    ear2.addPoint(20, 5);
    ear2.addPoint(30,  5);
    ear2.addPoint(30, 15);
    
    Polygon face = new Polygon();
    face.addPoint( 8,  7);
    face.addPoint(27, 7);
    face.addPoint(27, 25);
    face.addPoint(8, 25);
    
    displayOffSets.add(face);
    displayOffSets.add(ear1);
    displayOffSets.add(ear2);

    addItems(new Bone());
    addItems(new Bone());
  }
  
  @Override
  public boolean canEnter(Cell cell) {
    //dog cannot walk on water
    return !(cell.terrain instanceof Water);
  }
}
