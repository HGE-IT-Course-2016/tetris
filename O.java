import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class O here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class O extends Stein
{
    /**
     * O ist ein ganz bestimmter Stein. Das hättest du jetzt vielleicht nicht er-
     * wartet, aber manchmal muss man der Realtität eben ins Auge sehen.
     * 
     * Ja, O ist ein Stein.
     */

    public O() {
        super();
    }

    @Override public void renewLocation() {
        int x = posX;
        int y = posY;
        checkRotation();

        b1.setLocation(x,y);
        b2.setLocation(x+1,y);
        b3.setLocation(x,y+1);
        b4.setLocation(x+1,y+1);

        /*
        else if(rot == 1) {
        b1.setLocation(x,y);
        b2.setLocation(x,y+1);
        b3.setLocation(x-1,y);
        b4.setLocation(x-1,y+1);
        }

        else if (rot==2) {
        b1.setLocation(x,y);
        b2.setLocation(x-1,y);
        b3.setLocation(x-1,y-1);
        b4.setLocation(x,y-1);
        }

        else if (rot == 3) {
        b1.setLocation(x,y);
        b2.setLocation(x,y-1);
        b3.setLocation(x+1,y-1);
        b4.setLocation(x+1,y);
        }
         */
    }

    protected boolean checkRot(int r) {
        return true;
    }

    @Override public boolean canFall()
    {
        if (b3.getY() == 16 || b4.getY() == 16)
        {
            return false;
        }
        
        else 
        {
            return true;
        }
    }
}
