import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.List;

public abstract class Actor {
  Color color;
  Cell loc;
  List<Polygon> display;
  Inventory<Item> inventory = new Inventory<>(); //each actor has inventory that can hold items

  public void paint(Graphics g) {
    for(Polygon p: display) {
      g.setColor(color);
      g.fillPolygon(p);
      g.setColor(Color.GRAY);
      g.drawPolygon(p);
    }
  }

  public void addItems(Item item) {
    inventory.addItem(item);
  }

  public Inventory<Item> getInventory() {
    return inventory; 
  }

  public void move(int dx, int dy) {
    int movementCost = loc.terrain.getMovementCost(); //calculate movement cost based on terrain

    int adjustedDx = dx / movementCost; 
    int adjustedDy = dy / movementCost; 

    loc = new Cell(loc.col, loc.row, loc.x + adjustedDx, loc.y + adjustedDy, loc.terrain);
  }

}
