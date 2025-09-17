// runs the main game window
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
    public static void main(String[] args) throws Exception {
      Main window = new Main();
      window.run();
    }

    class Canvas extends JPanel {
      Stage stage = new Stage();
      
      public Canvas() {
        setPreferredSize(new Dimension(1024, 720));
        addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            Point mousePos = e.getPoint();
            stage.moveActor(mousePos);
            repaint();
          }
        });
      }

      @Override
      public void paintComponent(Graphics g) {
        super.paintComponent(g);
        stage.paint(g, getMousePosition());
      }
    }

    private Main() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Canvas canvas = new Canvas();
      setContentPane(canvas);
      pack();
      setVisible(true);
    }

    public void run() {
      while(true) {
        repaint();
        try {
          Thread.sleep(16);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
}
