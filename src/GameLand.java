//Game Example
//Lockwood Version 2023-24
// Learning goals:
// make an object class to go with this main class
// the object class should have a printInfo()
//input picture for background
//input picture for object and paint the object on the screen at a given point
//create move method for the object, and use it
// create a wrapping move method and a bouncing move method
//create a second object class
//give objects rectangles
//start interactions/collisions

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;


//*******************************************************************************
// Class Definition Section

public class GameLand implements Runnable {

    //Variable Declaration Section
    //Declare the variables used in the program
    //You can set their initial values here if you want

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;

    public BufferStrategy bufferStrategy;

    //Declare the objects used in the program below
    /** STEP 1 declare your object and give it a name **/
    public Hero astro;
    public Hero brave;
    public Hero raceCar;
    public Hero whiteRaceCar;
    public Hero greenRaceCar;
    public Hero raceCar4;
    /** STEP 2 declare an image for your object**/
    public Image astroPic;
    public Image bravePic;
    public Image raceCarPic;
    public Image raceTrack;
    public Image whiteRaceCarPic;
    public Image greenRaceCarPic;
    public Image raceCar4Pic;
    public boolean raceCarIsIntersectingRaceCar2;
    public boolean raceCarIsIntersectingRaceCar3;
    public boolean raceCarIsIntersectingRaceCar;
    public boolean raceCar4IsIntersectingRaceCar2;



    // Main method definition: PSVM
    // This is the code that runs first and automatically
    public static void main(String[] args) {
       GameLand ex = new GameLand();   //creates a new instance of the game and tells GameLand() method to run
        new Thread(ex).start();       //creates a thread & starts up the code in the run( ) method
    }

    // Constructor Method
    // This has no return type and has the same name as the class
    // This section is the setup portion of the program
    // Initialize your variables and construct your program objects here.
    public GameLand() {
        setUpGraphics(); //this calls the setUpGraphics() method

        //create (construct) the objects needed for the game below
        //for each object that has a picture, load in images as well
        /** STEP 3 construct a specific Hero **/
    //    astro = new Hero(800,100,5,3,100,134);
    //    brave = new Hero(500,100,5,3,100,110);
        raceCar = new Hero(700,100,5,3,100,29);
        whiteRaceCar = new Hero(520,300,2,3,100,56);
        greenRaceCar = new Hero(100,430,5,3,100,62);
        raceCar4 = new Hero(200,5,4,3,100,57);
        /** STEP 4 load in the image for your object **/
     //   astroPic = Toolkit.getDefaultToolkit().getImage("astronaut.png");
    //    bravePic = Toolkit.getDefaultToolkit().getImage("brave.png");
        raceCarPic = Toolkit.getDefaultToolkit().getImage("raceCar.png");
        raceTrack = Toolkit.getDefaultToolkit().getImage("raceTrack.png");
        whiteRaceCarPic = Toolkit.getDefaultToolkit().getImage("whiteRaceCar.png");
        greenRaceCarPic = Toolkit.getDefaultToolkit().getImage("greenRaceCar.png");
        raceCar4Pic = Toolkit.getDefaultToolkit().getImage("raceCar4.png");

     //   astro.printInfo();
     //   brave.printInfo();
        raceCar.printInfo();
        whiteRaceCar.printInfo();
        greenRaceCar.printInfo();
        raceCar4.printInfo();

    }// GameLand()

//*******************************************************************************
//User Method Section
//
// put your code to do things here.

    // main thread
    // this is the code that plays the game after you set things up
    public void run() {
        //for the moment we will loop things forever using a while loop
        while (true) {
            moveThings();  //move all the game objects
            collisions();  //checks for rec intersections
            render();  // paint the graphics
            pause(20); // sleep for 20 ms
        }
    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.drawImage(raceTrack,0,0,WIDTH,HEIGHT,null);

      //  g.drawImage(astroPic,200,400,59,40,null);
      //  g.drawImage(bravePic,200,400,214,235,null);
      //  g.drawImage(raceCarPic,200,400,400,116,null);
        //draw the image of your objects below:
        /** STEP 5 draw the image of your object to the screen **/
      //  g.drawImage(astroPic,astro.xpos,astro.ypos, astro.width,astro.height,null);
     //   g.drawImage(bravePic,brave.xpos, brave.ypos, brave.width, brave.height,null);
        g.drawImage(raceCarPic,raceCar.xpos, raceCar.ypos,raceCar.width, raceCar.height,null);
        if(whiteRaceCar.isAlive==true) {
            g.drawImage(whiteRaceCarPic, whiteRaceCar.xpos, whiteRaceCar.ypos, whiteRaceCar.width, whiteRaceCar.height, null);
        }
        g.drawImage(greenRaceCarPic,greenRaceCar.xpos, greenRaceCar.ypos,greenRaceCar.width,greenRaceCar.height,null);
        g.drawImage(raceCar4Pic,raceCar4.xpos,raceCar4.ypos,raceCar4.width,raceCar4.height,null);

        //dispose the images each time(this allows for the illusion of movement).
        g.dispose();

        bufferStrategy.show();
    }

    public void moveThings() {
        //call the move() method code from your object class
     //   astro.move();
     //   brave.move();
        raceCar.move();
        whiteRaceCar.move();
        greenRaceCar.move();
        raceCar4.move();

       // astro.wrappingMove();
     //   astro.bouncingMove();
     //   brave.wrappingMove();
        raceCar.bouncingMove();
        whiteRaceCar.bouncingMove();
        greenRaceCar.bouncingMove();
        raceCar4.bouncingMove();
    }
    public void collisions(){
        if(raceCar.rec.intersects(whiteRaceCar.rec)&&raceCarIsIntersectingRaceCar2==false) {
            raceCarIsIntersectingRaceCar2 = true;
            System.out.println("ouch");
            raceCar.width += 10;
            raceCar.height += 10;
        }
        if(raceCar.rec.intersects(whiteRaceCar.rec)==false){
            raceCarIsIntersectingRaceCar2=false;

        }
        if(raceCar.width>=200){
            raceCar.width = raceCar.width-20;
        }
        if(raceCar.height>=200){
            raceCar.height = raceCar.height-20;
        }
        if(whiteRaceCar.rec.intersects(greenRaceCar.rec)&&raceCarIsIntersectingRaceCar3==false){
            whiteRaceCar.dx = whiteRaceCar.dx*2;
            whiteRaceCar.dy = whiteRaceCar.dy*2;

          //  raceCar2.isAlive = false;
          //  raceCar2.dy=0;
          //  raceCar2.dx=0;
          //  raceCar2.xpos=200;
        }
        if(whiteRaceCar.rec.intersects(greenRaceCar.rec)==false) {
            raceCarIsIntersectingRaceCar3 = false;
       }
        if(whiteRaceCar.dx>=12){
            whiteRaceCar.dx = whiteRaceCar.dx/2;
        }
        if(whiteRaceCar.dy>=12){
            whiteRaceCar.dy=whiteRaceCar.dy/2;
        }

        if(greenRaceCar.rec.intersects(raceCar.rec)&&raceCarIsIntersectingRaceCar==false){
            greenRaceCar.dx=-greenRaceCar.dx;
         //   raceCar.dx=-raceCar.dy;
            greenRaceCar.dy=-greenRaceCar.dx;
           // raceCar.dy=-raceCar.dy;

        }

        if(greenRaceCar.rec.intersects(raceCar.rec)==false) {
            raceCarIsIntersectingRaceCar = false;
        }
        if(raceCar4.rec.intersects(raceCar.rec)&&raceCar4IsIntersectingRaceCar2==false){
            raceCar4IsIntersectingRaceCar2=true;
            System.out.println("NO");
            raceCar4.isAlive=false;
            raceCar4.dy=0;
            raceCar4.dx=0;
            raceCar4.xpos=800;
            raceCar4.ypos=800;
        }
        if(raceCar4.rec.intersects(raceCar.rec)==false){
            raceCar4IsIntersectingRaceCar2=false;
        }
    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    //Graphics setup method
    private void setUpGraphics() {
        frame = new JFrame("Game Land");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }

}