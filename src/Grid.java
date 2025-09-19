// Holds all cells and provides lookup methods
import java.awt.Graphics;
import java.awt.Point;
import java.util.Optional;

public class Grid {
  Cell[][] cells = new Cell[20][20];
  
  public Grid() {
    for(int i=0; i<cells.length; i++) {
      for(int j=0; j<cells[i].length; j++) {
        Terrain terrain = (i + j) % 5 == 0 ? new Sand() : new Grass();
        if (i == 7 && j == 6) terrain = new Water(); // water example
        cells[i][j] = new Cell(colToLabel(i), j, 10+Cell.size*i, 10+Cell.size*j, terrain);
      }
    }
  }

  private char colToLabel(int col) {
    return (char) (col + 'A');
  }

  private int labelToCol(char col) {
    return col - 'A';
  }

  public void paint(Graphics g, Point mousePos) {
    for (Cell[] row : cells) {
      for (Cell c : row) {
        c.paint(g, mousePos);
      }
    }
  }

  public Optional<Cell> cellAtColRow(int c, int r) {
    if(c >= 0 && c < cells.length && r >=0 && r < cells[c].length) {
      return Optional.of(cells[c][r]);
    } else {
      return Optional.empty();
    }
  }

  public Optional<Cell> cellAtColRow(char c, int r) {
    return cellAtColRow(labelToCol(c), r);
  }

  public Optional<Cell> cellAtPoint(Point p) {
    for (Cell[] row : cells) {
      for(Cell c : row) {
        if(c.contains(p)) return Optional.of(c);
      }
    }
    return Optional.empty();
  }


}
