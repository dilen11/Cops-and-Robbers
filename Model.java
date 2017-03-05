import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

//beginning the model class
class Model
{
    //creating an array list of sprite
    private ArrayList<Sprite> sprite;    

    //the Model constructor that throws IOExceptions,
    //and takes no parameters
    Model() throws IOException {
        
        //creates new ArrayList sprite object,
        //creates a new bank object,
        //and adds the bank object to the ArrayList
        sprite = new ArrayList<Sprite>();
        bank initialBank;
        initialBank = new bank();
        sprite.add(initialBank);
    }

    //method that updates the graphics
    public void update(Graphics g) {
		
        //synchronizing code that iterates over the ArrayList
        synchronized(sprite){
            
            //iterates over every element in the ArrayList,
            //and updates the image for each object
            for(int i = 0; i < sprite.size(); i++) {
                sprite.get(i).updateImage(g);
                }
            }
    }
    
    //variable that is used to enable the
    //alternating nature of creating Cop Cars
    //first, and then robber cars
    private int alternate = 0;
    
    //method that creates a new sprite object,
    //with parameters of x and y coordinates
    public void n_sprite(int x, int y) {
        
        //declares a Car object called nsprite (new sprite)
        Car nsprite;
        
        //if alternate equals 0, then...
        if ( alternate == 0 ) {
            
            //create a new cop car object called nsprite, 
            //set it's coordinates, and set alternate to
            //1, so that a robber car will be made next
            nsprite = new CopCar();
            nsprite.setX(x);
            nsprite.setY(y);
            alternate = 1;
        }
        
        //if alternate is not equal to 0, then...
        else {
            
            //create a new robber car object called nsprite, 
            //and set alternate to 0 so that a cop car
            //will be made next
            nsprite = new RobberCar();
            alternate = 0;
        }
        
        //add the newly created sprite to the ArrayList
        sprite.add(nsprite);
    }
    
    //method that updates the scene, with parameters
    //of width and height
    public void updateScene (int width, int height ) {

        //code that synchronizes any code that iterates over
        //the ArrayList
        synchronized(sprite) {
            
            //iterates over the ArrayList
            for(int i = 0; i < sprite.size(); i++) {
                
                //calls updateState for each element in the
                //ArrayList, with passed in values for width and height
                sprite.get(i).updateState(width, height);

                //if element i in the ArrayList is an instance of a cop car...
                if(sprite.get(i) instanceof CopCar) {
                    
                    //iterate over the ArrayList
                    for ( int j = 0; j < sprite.size(); j++ ) {
                        
                        //if element j in the ArrayList is 
                        //an instance of a robber car
                        if ( sprite.get(j) instanceof RobberCar ) {
                            
                            //if the cop car i, overlaps robber car j, then...
                            if (sprite.get(i).overlaps(sprite.get(j))) {

                                //casting the sprite to a robber car and
                                //calling the captured method on element j
                                ((RobberCar)sprite.get(j)).captured();
                            }
                        }
                    }
                }
            }

            //declaring an iter object for the ArrayList
            Iterator iter = sprite.iterator();
            
            //while the iterator detects that a next element
            //exists in the ArrayList, then...
            while (iter.hasNext()) {
                
                //a new sprite object s is equal to the next iterator element
                Sprite s = (Sprite) iter.next();

                //if s is an instance of a robber car object, then...
                if (s instanceof RobberCar) {
                    
                    //casting the s sprite object to a robber car
                    //object, and then if it has escaped, then...
                    if(((RobberCar)s).hasEscaped() == true) {
                        
                        //remove the element from the ArrayList
                        iter.remove();
                    }
                }
            }
        }
    }
        
    //method that initializes with default, initial conditions
    public void initialize() {
        
        sprite.clear();
        bank initialBank;
        initialBank = new bank();
        sprite.add(initialBank);
        RobberCar.capturedCount = 0;
        RobberCar.escapedCount = 0;
    }    
}
