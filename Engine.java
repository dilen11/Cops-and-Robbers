public class Engine {
    
    private String engine_type;
    private int mpg, max_speed;
    
    //Engine object constructor
    //takes an engine type, the mpg, and the max speed
    Engine (String eng_type, int milespg, int max_spd) {
        
        //if no engine type is given, it is named "Generic engine"
        //else, the engine is named by the string passed in
        if (eng_type.length() == 0){
            engine_type = "Generic engine";
        }
        else {
            engine_type = eng_type;
        }
        
        //if an invalid value is passed in, the mpg is set to 0
        //else, the mpg is set to the mpg value that is passed in the constructor
        if (milespg < 0) {
            mpg = 0; 
        }
        else  {
            mpg = milespg;
        }
        
        //if an invalid value is passed in, the max speed is set to 0
        //else the max speed is set to the value passed in in the constructor
        if (max_spd < 0) {
            max_speed = 0;
        }
        else {
            max_speed = max_spd;
        }
    }
    
    //method that returns the mpg value of the engine object
    public int getmpg() {
        
        return mpg;
    }
    
    //method that returns the max speed of the engine object
    public int getmax_speed() {
        
        return max_speed;
    }
    
    //method that returns the description of the engine object
    public String getDescription() {
        
        //one string is declared first, with the engine type
        //then strings are concatenated to the initial one, as needed
        String out = engine_type;
        out += " (MPG: " + mpg + ", Max speed: " + max_speed + ")";
        return out;        
    }
        
}
