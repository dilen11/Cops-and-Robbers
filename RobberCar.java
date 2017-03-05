import java.awt.Graphics;
import java.util.Random;

//class that extends the Car class
public class RobberCar extends Car {
    
    private int xxrat, yyrat, max = 5, min = -5;   
    Random randomratio = new Random();    
    private boolean isCaptured, isEscaped;    
    static int escapedCount = 0, capturedCount= 0;
    
    //Robber Car constructor that has no parameters
    RobberCar () {
        
        //the super constructor that calls the constructor of Car
        super ("Robber Car", 5000, new Engine("V6", 20, 200), "red-car.jpg");
        
        //the robber car is given a random direction to drive, 
        //dictated by the randomizing of the x & y direction ratios
        xxrat = (int) randomratio.nextInt((max - min) + 1) + min;
        yyrat = (int) randomratio.nextInt((max - min) + 1) + min;
        
        //setting the initial location of all robber cars to (300,300)
        setX(300);
        setY(300);
        
        //Filling up the robber car's gas tank
        fillUp();
        
        //setting the variables to their correct initial values 
        //of not being captured and not having escaped
        isCaptured = false;
        isEscaped = false;
    }
    
    //method that updates the state of the robber car object
    public void updateState(int width, int height) {
        
        //if the robber car is not captured, then drive
        //the robber car
        if ( !isCaptured)
            drive(4,xxrat,yyrat);
        
        //if the robber car's x location exceeds the width
        //of the window in either direction, then...
        if ((getX()+60 > width) || (getX() < 0)) { 
            
            //if the robber car has not already escaped, then
            //increase the escaped count by 1 & set
            //the ifEscaped variable to true
            if(!hasEscaped()){       
                escapedCount++;
                isEscaped = true;
            }    
        }
        
        //if the robber car's y location exceeds the height
        //of the window in either direction, then...
        if ((getY()+60 > width) || (getY() < 0)) {
            
            //if the robber car has not already escaped, then
            //increase the escaped count by 1 & set
            //the ifEscaped variable to true
            if(!hasEscaped()){       
                escapedCount++;
                isEscaped = true;
            }
        }            
    }
    
    //method that updates the image of the robber car object
    public void updateImage (Graphics g) {
        super.updateImage(g);
    }
    
    //method that determines if the robber car is captured or not
    public void captured () {
        
        //sets the image to a jail cell, if 
        //the robber car is captured
        setImage("jail.jpg");
        
        //if the robber car has not already been captured
        if(isCaptured == false){
            
            //the count of captured robber cars is increased by 1
            capturedCount++;            
        }
        
        //the isCaptured variable is set to true
        isCaptured = true;
        
        //calls the method that returns a value of true
        //to say the robber car was captured
        isCaptured();
        
    }
    
    //method that returns true to say the robber
    //car was indeed captured
    public static boolean isCaptured() {
        
        return true;
    }
    
    //method that checks if the robber car has escaped or not
    public boolean hasEscaped() {
        
        //if the isEscaped variable is set to
        //true, then return true
        if(isEscaped == true) {
            
            return true;           
        }
        
        //otherwise return false
        else 
            return false;
    }
    
    //method that prints out the escaped count
    public static void printEscape() {
        System.out.printf("The Escaped Count is: %d\n", escapedCount);
    }
    
    //method that prints out the captured count
    public static void printCapture() {
        System.out.printf("The Captured Count is: %d\n", capturedCount);
    }    
}