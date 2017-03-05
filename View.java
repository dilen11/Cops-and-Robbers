import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//begin class View that extends the JFrame class, but
//also implements the ActionListener interface
public class View extends JFrame implements ActionListener {

    //declaration of a class inside of a class
    //class MyPanel extends the JPane1 class
    private class MyPanel extends JPanel {
        
        //declares a new Controller object, named controller
        Controller controller;

        //MyPanel constructor that takes in a controller
        //object as a parameter
        MyPanel(Controller c) {
            
            //sets the declared controller object equal to
            //the Controller object passed into MyPanel() and
            //adds a Mouse Listener to that controller object
            controller = c;
            addMouseListener(c);
        }

        //method that paints the components onto the window
        public void paintComponent(Graphics g) {
            
            //updates the controller object and revalidates it
            controller.update(g);
            revalidate();
        }
    }

    //constructor for View, that takes in a controller
    //object as a parameter, and throws all exceptions
    public View(Controller c) throws Exception{
        
        //sets the title to "Assignment 5"
        setTitle("Assignment 5");
        
        //sets the size of the window to 1000 x 700 by default
        setSize(1000, 700);
        
        //adds a new MyPanel object with a parameter of a
        //controller object c
        getContentPane().add(new MyPanel(c));
        
        //makes the program or window close with the
        //default "x-out" button
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //makes the window visible to the user
        setVisible(true);
    }

    //method that repaints
    public void actionPerformed(ActionEvent evt) {
        repaint();
    }
}

