import java.awt.Color;
import java.awt.Polygon;


public class Cat extends Actor {
  public Cat(Cell inLoc) {
    loc = inLoc;
    color = Color.BLUE;
    
    Polygon ear1 = new Polygon();
    ear1.addPoint(11,5);
    ear1.addPoint(15, 15);
    ear1.addPoint(7, 15);
    
    Polygon ear2 = new Polygon();
    ear2.addPoint(22, 5);
    ear2.addPoint(26,15);
    ear2.addPoint(18,15);
    
    Polygon face = new Polygon();
    face.addPoint(5, 15);
    face.addPoint(29,15);
    face.addPoint(17, 30);
    
    displayOffSets.add(face);
    displayOffSets.add(ear1);
    displayOffSets.add(ear2);
  }
  
  @Override
  public boolean canEnter(Cell cell) {
    //cat cannot walk on water
    return !(cell.terrain instanceof Water);
  }
}
