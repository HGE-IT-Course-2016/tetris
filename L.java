import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Der L Stein (länglich)
 * 
 * @author Achim Retzbach & Angelika Knittel
 * @version 03/01/2016 7:53
 */
public class L extends Stein
{
    @Override public void renewLocation() {
        int x = posX;
        int y = posY;
        rot = checkRotation(rot);
        if(rot == 0) {
            b1.setLocation(x,y-2);
            b2.setLocation(x,y-1);
            b3.setLocation(x,y);
            b4.setLocation(x+1,y);
        } else if(rot == 1) {
            b1.setLocation(x+2,y);
            b2.setLocation(x+1,y);
            b3.setLocation(x,y);
            b4.setLocation(x,y+1);
        } else if (rot == 2) {
            b1.setLocation(x,y+2);
            b2.setLocation(x,y+1);
            b3.setLocation(x,y);
            b4.setLocation(x-1,y);
        } else if(rot == 3) {
            b1.setLocation(x-2,y);
            b2.setLocation(x-1,y);
            b3.setLocation(x,y);
            b4.setLocation(x,y-1);
        }
    }

    protected boolean checkRot(int r) {
        int x = posX;
        int y = posY;
        r = checkRotation(r);
        if(rot == 0) {
            if ( checkPos(x,y-2) == true && checkPos(x,y-1) == true && checkPos(x,y) == true && checkPos(x+1,y) == true )
            {
                return true;
            }
            else
            {
                return false;
            }
        } else if(rot == 1) {
            if ( checkPos(x+2,y) == true && checkPos(x+1,y) == true && checkPos(x,y) == true && checkPos(x,y+1) == true )
            {
                return true;
            }
            else
            {
                return false;
            }
        } else if (rot == 2) {
            if ( checkPos(x,y+2) == true && checkPos(x,y+1) == true && checkPos(x,y) == true && checkPos(x-1,y) == true )
            {
                return true;
            }
            else
            {
                return false;
            }
        } else if(rot == 3) {
            if ( checkPos(x-2,y) == true && checkPos(x-1,y) == true && checkPos(x,y) == true && checkPos(x,y-1) == true )
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        return false;
    }

    public L() {
        super();
    }
}