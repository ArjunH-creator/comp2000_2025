import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Stage {
  Grid grid;
  List<Actor> actors;
  int currentActorIndex = 0; 

  public Stage() {
    grid = new Grid();
    actors = new ArrayList<Actor>();
    
    //place actors on grid
    actors.add(new Cat(grid.cellAtColRow(0, 0).get()));
    actors.add(new Dog(grid.cellAtColRow(0, 15).get()));
    actors.add(new Bird(grid.cellAtColRow(12, 9).get())); 
    
    //place some items on the grid for interaction
    grid.cellAtColRow(1, 1).get().item = new Fish();
    grid.cellAtColRow(2, 3).get().item = new Fish();
    grid.cellAtColRow(5, 5).get().item = new Fish();

    grid.cellAtColRow(3, 2).get().item = new Bone();
    grid.cellAtColRow(4, 4).get().item = new Seed();
    grid.cellAtColRow(6, 6).get().item = new Seed();

  }

  public void paint(Graphics g, Point mouseLoc) {
    grid.paint(g, mouseLoc);
    
    for(Actor a: actors) {
      a.paint(g);

      //draw points for actors
      g.setColor(Color.BLACK);
      g.drawString(
        a.getClass().getSimpleName() + " points: " + a.points, 
        780, 20 + actors.indexOf(a) * 20
      );
    }
    
    Optional<Cell> underMouse = grid.cellAtPoint(mouseLoc);
    if(underMouse.isPresent()) {
      Cell hoverCell = underMouse.get();
      g.setColor(Color.DARK_GRAY);
      g.drawString(String.valueOf(hoverCell.col) + hoverCell.row, 740, 30);
    }
  }

  public void moveActor(Point mousePos) {
    Optional<Cell> clickedCell = grid.cellAtPoint(mousePos);
    if (clickedCell.isPresent()) {
      Cell target = clickedCell.get();
      Actor actor = actors.get(currentActorIndex);

        if(actor.canEnter(target)) {
          actor.loc = target;
          
          if(target.item != null) {
            if((actor instanceof Cat && target.item instanceof Fish) ||
               (actor instanceof Dog && target.item instanceof Bone) ||
               (actor instanceof Bird && target.item instanceof Seed)) {

                actor.addItems(target.item);
                target.item = null; //remove item 
               }
          }
          currentActorIndex = (currentActorIndex + 1) % actors.size();
        }
    }
  }
}
