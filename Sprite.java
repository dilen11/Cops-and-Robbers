import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class Sprite
{
	private String jpgName;
	private int locationX, locationY;
	private Image image;

	//constructor that only takes in a picture name as a parameter
        public Sprite(String jpgName)
	{
            //the setImage method is called, to set the parameter
            //file name as the image
            setImage(jpgName);
		
            //the x & y locations for the Sprite object are set to 0
            locationX = 0;
            locationY = 0;
	}
	
	//method that returns the x location of the sprite object
        public int getX() {	return locationX; }
	
        //method that returns the y location of the sprite object
        public int getY() {	return locationY; }
	
        //method that sets the x location of the sprite object
        //to the desired x location passed into the method call
        public void setX(int x) { locationX = x; }
	
        //method that sets the y location of the sprite object
        //to the desired y location passed into the method call
        public void setY(int y) { locationY = y; }
	
	//method that sets the file passed in, as the image
        //object for the sprite object
        //(basically associates a picture with a sprite object)
        public void setImage(String imagePath) {
            
            //the actual code that turns the filename into
            //an actual visual picture that can be used
            try {
                image = ImageIO.read(new File(imagePath));
            } 
            
            //catches an exception, and provides an error checking
            //statement to clarify what's going on when there is an error
            catch (IOException ioe) {
            System.out.println("Unable to load image file.");
            }
	}
	
        //method that returns the image associated with a sprite object
        public Image getImage() { return image; }	
	
	//method that updates the image of the sprite object
        //takes in a Graphics object as the parameter
        public void updateImage(Graphics g) {
            
            //moves the sprite object, redrawing the image again with 
            //a new location
            g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
        
        //method that updates the state of the sprite object
        //this method is defined by lower level classes, so
        //it doesn't need to be implemented here
        public void updateState(int width, int height) {}
        
        //method that determines if sprite objects overlap or not
        public boolean overlaps(Sprite s) {
            
           //if the object A overlaps object B is any of the
           //ways specified below, the method returns true
            if((this.getX()+60 >= s.getX())&&
               (this.getX() < s.getX() + 60)&&
               (this.getY()+60 >= s.getY()) &&
               (this.getY() < s.getY() + 60)){
                return true;
            }
            
            //else, the method returns false - they don't overlap
            else {
                return false;
            } 
            
        }
        
}