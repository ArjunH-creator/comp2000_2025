// Abstract class showing inheritance
// Each actor has a color, a location, a display, and an inventory

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;
import java.util.ArrayList;

public abstract class Actor {
  Color color;
  Cell loc;
  List<Polygon> displayOffSets; //polygons stores as offsets from cell
  Inventory<Item> inventory = new Inventory<>(); //each actor has inventory that can hold items
  int points = 0;  // points for collected items
  
  public Actor() {
    displayOffSets = new ArrayList<>();
    inventory = new Inventory<>();
  }
  
  public void paint(Graphics g) {
    for(Polygon offset : displayOffSets) {
      Polygon actual = new Polygon();
      for(int i = 0; i < offset.npoints; i++) {
        actual.addPoint(loc.x + offset.xpoints[i], loc.y + offset.ypoints[i]);
      }
      g.setColor(color);
      g.fillPolygon(actual);
      g.setColor(Color.GRAY);
      g.drawPolygon(actual);
    }
  }

  public void addItems(Item item) {
    inventory.addItem(item);
    
    // Only collect allowed items
    if ((this instanceof Cat && item instanceof Fish) ||
        (this instanceof Dog && item instanceof Bone) ||
        (this instanceof Bird && item instanceof Seed)) {
        
        inventory.addItem(item);
        points++;
        System.out.println(this.getClass().getSimpleName() + " collected " + points + " point(s)");
    }
  }

  public Inventory<Item> getInventory() {
    return inventory; 
  }

  // move method: move by dx and dy affected by terrain
  public void move(int dx, int dy) {
    int movementCost = loc.terrain.getMovementCost(); //calculate movement cost based on terrain

    int adjustedDx = dx / movementCost; 
    int adjustedDy = dy / movementCost; 

    loc = new Cell(loc.col, loc.row, loc.x + adjustedDx, loc.y + adjustedDy, loc.terrain);
  }

  //can be overridden for special rules
  public boolean canEnter(Cell c) {
    return true;
  }

}
