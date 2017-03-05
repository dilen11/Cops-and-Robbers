import java.awt.Graphics;

//extending the class Sprite, with a new class Car
public class Car extends Sprite {
    
    private String car_type;    
    private GasTank gvar;
    private Engine evar;
    
    //constructor for the Car class
    Car (String a, int fuel, Engine obj, String jpgName) {
        
        //every class that extends from a parent must first call its super constructor
        super(jpgName);
        
        //if no car name is passed in, it will be called "Generic Car";
        //otherweise, the string will be the name of the car_type
        if (a.length() == 0) {
            car_type = "Generic Car";
        }
        else {
            car_type = a;
        }
        
        //if no engine object is passed in, a default one will be made
        //else, the engine object becomes the car's engine object
        if (obj == null){
            evar = new Engine("", 0, 0);
        }
        else {
            evar = obj;
        }
        
        //creating a new GasTank object with the amount of fuel
        //passed in through the constructor
        gvar = new GasTank(fuel);
        
        
    }
    
    //this method "gets" a description of the car
    //and prints out all of the relevant info to the console
    public String getDescription() {
        
        //made one string, and then added further text and variables as needed
        String out = car_type;
            out += " (engine: " + evar.getDescription() + "), ";
            out += "fuel: " + String.format("%.2f", gvar.getLevel()) + "/" + gvar.getCapacity() + ", ";
            out += "location: (" + getX() + "," + getY() + ")";
            return out;
        
    }    
    
    //method that returns the current fuel level of the car object
    public double getFuelLevel() {
        
        return gvar.getLevel();
    }
    
    //method that returns the MPG of the car object
    public int getMPG() {
        
        return evar.getmpg();
    }
    
    //method that fills up the car's gas tank all of the way
    public void fillUp() {
        
        //make an integer that holds the same value as
        //the car's gas tank capacity
        //the gas tank variable's gas level is then set to that integer 
        int fill = gvar.getCapacity();
        gvar.setLevel(fill);
        
    }
    
    //method that returns the maximum speed of the car object
    public int getMaxSpeed() {
        return evar.getmax_speed();
    }
    
    //method that mimicks "driving" the car object
    //takes a distance, and ratios for x & y that determine the direction
    //it drives on the JPanel
    public double drive(int distance, double xRatio, double yRatio) {
        
        //declaring a gas variable and getting the number of gallons needed
        //to drive the "distance" declared
        double gas;
        gas = ((double) distance / evar.getmpg());
        
        //if the required amount of gas is greater than the amount of gas
        //that the car currently has
        if(gas > gvar.getLevel())
        {
            //determining how far the car can drive with its current gas amount,
            //and setting the gas level to 0, b/c it "ran out of gas"
            distance = (int) gvar.getLevel() * evar.getmpg();
            gvar.setLevel(0);
            System.out.println("Ran out of gas after driving " + (double) distance + " miles");

            //determining the location of the car object after driving
            double ratio_constant = (xRatio * xRatio) + (yRatio * yRatio);
            setX(getX() + (int) ((distance/Math.sqrt(ratio_constant)) * xRatio));  
            setY(getY() + (int) ((distance/Math.sqrt(ratio_constant)) * yRatio));
        }
        
        //otherwise, the car has enough gas and drives
        else
        {
            //setting the gas level to whatever the amount currently is
            //after driving the required distance
            gvar.setLevel(gvar.getLevel() - gas);

            //determining the location of the car object after driving
            double ratio_constant = (xRatio * xRatio) + (yRatio * yRatio);
            setX(getX() + (int) ((distance/Math.sqrt(ratio_constant)) * xRatio));  
            setY(getY() + (int) ((distance/Math.sqrt(ratio_constant)) * yRatio));
        }
        return (double) distance;
    }
    
    //method that updates the image of the car objects	
    public void updateImage(Graphics g) {
            
            //calling the sprite update method (aka the super update)
            super.updateImage(g);
        }
}
