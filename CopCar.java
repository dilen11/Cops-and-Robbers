import java.awt.Graphics;
import java.util.Random;

//this class extends the Car class
public class CopCar extends Car {
    
    private static int xxrat, yyrat;    
    Random randomratio = new Random();
    private int max = 5, min = -5;          
    int xDirection = 1, yDirection = 1;    
    
    //constructor for the Cop Car object that has no parameters
    CopCar () {
        
        //super constructor must be called first
        //a cop car, is created by creating an initial Car object
        //with the given default parameters 
        super ("Cop Car", 5000, new Engine("V8", 30, 100), "cop-car.jpg");
        
        //the cop car is given a random direction to drive, 
        //dictated by the randomizing of the x & y direction ratios
        xxrat = (int) randomratio.nextInt((max - min) + 1) + min;
        yyrat = (int) randomratio.nextInt((max - min) + 1) + min;
        
        //the cop car's gas tank is filled to capacity
        fillUp();    
    }
    
    //method that updates the state of the cop car, and
    //takes two parameters, width & height
    public void updateState(int width, int height) {
        
        //if the image of the cop car is greater than the 
        //width of the window, then reverse the direction 
        //of the cop car's x direction
        if (getX()+60 > width) {
            xDirection = -1 * xDirection;
        }
        //or if the image of the cop car is less than the
        //width of the window, then reverse the direction
        //of the cop car's x direction
        else if (getX() < 0) {
            xDirection = -1 * xDirection;
        }
        //otherwise, if the cop car image is just somewhere
        //in the window, it can continue on its current path
        else {
            xDirection = 1 * xDirection;
        }
        
        //if the image of the cop car is greater than the 
        //height of the window, then reverse the direction 
        //of the cop car's y direction
        if (getY()+60 > height) {
            yDirection = -1 * yDirection;
        }
        //if the image of the cop car is less than the 
        //height of the window, then reverse the direction 
        //of the cop car's y direction
        else if (getY() < 0) {
            yDirection = -1 * yDirection;
        }
        //otherwise, if the cop car image is just somewhere
        //in the window, it can continue on its current path
        else {
            yDirection = 1 * yDirection;
        }
        
        //to complete updating the state of the cop car,
        //we drive the cop car again, with the updated
        //x or y direction
        drive(2,xDirection * xxrat,yDirection * yyrat);
        
        //the x & y directions are multiplied by -1 inside each
        //check, in order to ensure that the static values of 
        //xxrat and yyrat are not changed.  This ensures that
        //each cop car bounces individually and one bounce doesn't
        //cause every cop car to change direction
    }
    
    //method that updates the image of the cop car object
    public void updateImage (Graphics g) {
        
        //it calls the super updateImage, which actually calls
        //the updateImage method found in the Sprite class.
        //This method redraws the image with the new x and y
        //locations that could have been changed from the
        //updateState(int width, int height) method
        super.updateImage(g);
    }
    
}
