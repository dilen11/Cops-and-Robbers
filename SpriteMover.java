//begins class SpriteMover that implements the Runnable interface
public class SpriteMover implements Runnable {
    
    //declares a Model and a View object
    Model model;
    View view;
    
    //constructor that takes in two parameters,
    //a model object, and a view object
    SpriteMover( Model spriteMoverModel, View spriteMoverView){
        
        //sets the model and view objects accordingly
        model = spriteMoverModel;
        view = spriteMoverView;
        
    }
    
    @Override
    //overriding the run() method that is present in the Runnable interface
    public void run() {
        
        //while(true), means this is an infinite loop
        while (true) {

            //update the scene for the model object, and 
            //repaint with the view object
            this.model.updateScene(this.view.getWidth(), this.view.getHeight());
            this.view.repaint();

            //try...
            try {
                
                //make the thread sleep for 2 milliseconds
                Thread.sleep(2);
            } 
            
            //catches any exception, in case the thread 
            //was interrupted at any point
            catch (InterruptedException e) {}
        }
    }
}
