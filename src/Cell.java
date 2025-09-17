import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class Cell extends Rectangle {
  static int size = 35;
  char col;
  int row;
  Terrain terrain; 

  public Cell(char inCol, int inRow, int x, int y, Terrain terrain) {
    super(x, y, size, size);
    col = inCol;
    row = inRow;
    this.terrain = terrain; 
  }

  public void paint(Graphics g, Point mousePos) {
    g.setColor(terrain.getColor());
    g.fillRect(x, y, size, size);
    
    
  // If the mouse is over this cell, paint a semi-transparent overlay
    if(contains(mousePos)) {
      g.setColor(new Color(128, 128, 128, 100));
      g.fillRect(x, y, size, size);
    }
  // Draw cell border
    g.setColor(Color.BLACK);
    g.drawRect(x, y, size, size);
  }

  public boolean contains(Point p) {
    if(p != null) {
      return super.contains(p);
    } else {
      return false;
    }
  }
}
