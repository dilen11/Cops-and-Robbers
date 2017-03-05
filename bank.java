//class bank that extends the Sprite class
public class bank extends Sprite {
    
    //constructor for the bank class that
    //takes no parameters
    bank ( ) {
        
        //calls the super constructor, which is the
        //Sprite constructor, and passes the bank image 
        //as the only parameter
        super("bank.png");
        
        //sets the location of the bank image 
        //to (300,300)
        setX(300);
        setY(300);        
    }    
}
