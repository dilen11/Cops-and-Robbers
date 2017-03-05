import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

//class Controller that implements the interfaces
//of MouseListener and KeyListener
class Controller implements MouseListener, KeyListener {
    
    //declaring a Model object and a View object
    Model model;
    View view;

    //Controller constructor that throws exceptions
    Controller() throws IOException, Exception {
        
        //instantiating and creating new model and view objects
        //and also add a Key Listener
        model = new Model();
        view = new View(this);
        view.addKeyListener(this);        
    }

    //method that updates the model object
    public void update(Graphics g) {
        model.update(g);
    }

    //method that makes events associated with mouse presses
    public void mousePressed(MouseEvent e) {
		
        //if a left mouse button event is detected
        if (SwingUtilities.isLeftMouseButton(e)) {
            
            //gets the x & y location of the click
            //and calls the n_sprite constructor & repaints
            model.n_sprite(e.getX(),e.getY());
            view.repaint();
	} 
        
        //else if a right mouse button event is detected
        else if (SwingUtilities.isRightMouseButton(e))  {
            
            //calls updateScene with the width and height & repaints
            model.updateScene(view.getWidth(), view.getHeight());
            view.repaint();                        
	}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    
    public void keyPressed(KeyEvent e) {    }
    public void keyReleased(KeyEvent e) {    }
    
    //method that associates events with specific key presses
    public void keyTyped(KeyEvent e) {
        
        //getting the character that was pressed,
        //as was detected by the KeyListener
        char keyChar = e.getKeyChar();
        
        //if the character was an h, print "hello world"
        if (keyChar == 'h') {
          System.out.println("hello world");
        }
        
        //if the character was an n, print the
        //number of captured and escaped
        if(keyChar == 'n') {
            RobberCar.printCapture();
            RobberCar.printEscape();
        }
        
        //if the character was an r, reset
        //the window, reinitialize with default
        //values, and repaint the window
        if(keyChar == 'r') {
            model.initialize();
            view.repaint();
        }
        
        //if the character was an s, create 
        //and start a new Thread
        if(keyChar == 's') {
            Thread thread = new Thread (new SpriteMover(model, view));
            thread.start();
        }
    }  
    
    //main method that throws all exceptions and creates a new Controller object
    public static void main(String[] args) throws Exception {
        
        new Controller();
    }
}

