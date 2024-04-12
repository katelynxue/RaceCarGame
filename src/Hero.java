import java.awt.*;

public class Hero {
    //variable declaration section
    public String name;
    public int xpos;
    public int ypos;
    public int dx;
    public int dy;
    public int width;
    public int height;
    public boolean isAlive;
    public Rectangle rec;


    public Hero(int pXpos, int pYpos, int pdx, int pdy, int pwidth, int pheight){
        xpos=pXpos;
        ypos=pYpos;
        dx=pdx;
        dy=pdy;
        width=pwidth;
        height=pheight;
        isAlive=true;
        rec = new Rectangle(xpos, ypos, width, height);
    }

    public void move(){
        xpos=xpos+dx;
        ypos=ypos-dy;
        rec = new Rectangle(xpos, ypos, width, height);

    }
    public void printInfo(){
        System.out.println("x postition: " + xpos);
        System.out.println("y position: "+ypos);
        System.out.println("speed in x direction: "+dx);
        System.out.println("speed in y direction: "+dy);
        System.out.println("width: "+width);
        System.out.println("height: " +height);
        System.out.println("isAlive: "+isAlive);
    }

    public void bouncingMove(){
        if(xpos>1000-width){
            dx=-dx;
        }
        if(xpos<0){
            dx=-dx;
        }
        if(ypos>700-height){
            dy=-dy;
        }
        if(ypos<0){
            dy=-dy;
        }
       //xpos=xpos-dx;
      //  ypos=ypos-dy;
        rec = new Rectangle(xpos, ypos, width, height);

    }

    public void wrappingMove(){
        if(xpos>1000) {
            xpos = 0;
        }
        if(xpos<0){
            xpos=1000;
        }
        if(ypos>700){
            ypos=0;
        }
        if(ypos<0){
            ypos=700;
        }
       // xpos=xpos-dx;
        // ypos=ypos-dy;
        rec = new Rectangle(xpos, ypos, width, height);
    }
}


