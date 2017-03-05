public class GasTank {
    
    private int maximum;
    private double current;
    
    //constructor for gas tank objects
    //only takes in one parameter, the maximum gas tank size
    GasTank( int max) {
        
        //if an invalid value is passed in,
        //the maximum is set to 0
        //else, the maximum is set to the max value passed in the constructor
        if (max < 0)
            maximum = 0;
        else
            maximum = max;
        
        //variable for the current gas level is set to 0 by default
        current = 0;
    }
    
    //method that returns the capacity of the gas tank object
    public int getCapacity() {
        
        return maximum;
    }
    
    //method that returns the current gas level of the gas tank object
    public double getLevel() {
        
        return current;
    }
    
    //method that "manually" sets the current level of the gas tank
    //takes in the desired gas level as the only parameter
    public void setLevel(double levelIn) {
        
        //if a negative value is passed, the current
        //level is set to 0
        if (levelIn < 0)
            current = 0;
        //if the desired gas level is greater than the gas tank's
        //capacity, then the current level is set to the capacity
        else if (levelIn > maximum)
                current = maximum;
        //otherwise, the current level is set to the gas level
        //passed in the parameter
        else
            current = levelIn;
                        
    }
    
}
