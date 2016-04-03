import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Der T Stein
 * 
 * @author Achim Retzbach & Angelika Knittel
 * @version 03/01/2016 7:53
 */
public class T extends Stein
{
    @Override public void renewLocation() {
        int x = posX;
        int y = posY;
        checkRotation();
        if(rot == 0) {
            b1.setLocation(x-1,y);
            b2.setLocation(x+1,y);
            b3.setLocation(x,y);
            b4.setLocation(x,y+1);
        } else if(rot == 1) {
            b1.setLocation(x,y-1);
            b2.setLocation(x,y);
            b3.setLocation(x,y+1);
            b4.setLocation(x-1,y);
        } else if (rot == 2) {
            b1.setLocation(x+1,y);
            b2.setLocation(x,y);
            b3.setLocation(x-1,y);
            b4.setLocation(x,y-1);
        } else if(rot == 3) {
            b1.setLocation(x,y+1);
            b2.setLocation(x,y);
            b3.setLocation(x,y-1);
            b4.setLocation(x+1,y);
        }
    }

    protected boolean checkRot(int r) {
        return true;
    }

    public T() {
        super();
    }
}