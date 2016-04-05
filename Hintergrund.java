import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hintergrund here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hintergrund extends World
{
    private Block[][] keller;
    /**
     * Constructor for objects of class Hintergrund.
     * 
     */
    public Hintergrund()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(22, 18, 30);
        keller = new Block[15][9];

        prepare();
    }
    
    public void warnYellow()
    {
        Text warningText;
        warningText = new Text ("Warning! Yellow =|= Yellow");
        this.addObject(warningText, 16, 1);
    }

    public void gefallen(Stein s)
    {
        Block[] b = s.gibBlöcke();
        for(int i = 0;i<4;i++)
        {

            int x = b[i].getX() - 2;
            int y = b[i].getY() - 2;
            keller[y][x] = b[i];
            System.out.println( b[i]);
        }
        removeObject(s);
        int r = (new java.util.Random()).nextInt();
        Stein t = new L();
        if(r == 0) {
            t = new L();
        } else if(r == 1) {
            t = new O();
        } else if(r == 2) {
            t = new I();
        } else if(r == 3) {
            t = new J();
        } else if(r == 4) {
            t = new T();
        } else if(r == 5) {
            t = new S();
        } else if(r == 6) {
            t = new Z();
        }
        addObject(t,6,1);
    }

    public boolean istBelegt(int x,int y)
    {
        int i = x - 2;
        int j = y - 2;
        if(i < 0 || i >= 9 || j < 0 || j >= 15) {
            return true;
        }
        if ( keller [j][i] == null)
        {
            return false;
        }
        else 
        {
            return true;
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Spielfeld spielfeld = new Spielfeld();
        addObject(spielfeld, 5, 9);
        spielfeld.setLocation(5, 9);
        spielfeld.setLocation(6, 9);
        Vorschau vorschau = new Vorschau();
        addObject(vorschau, 16, 4);
        Anzeigefeld anzeigefeld = new Anzeigefeld();
        addObject(anzeigefeld, 16, 8);
        Anzeigefeld anzeigefeld2 = new Anzeigefeld();
        addObject(anzeigefeld2, 16, 10);
        Anzeigefeld anzeigefeld3 = new Anzeigefeld();
        addObject(anzeigefeld3, 16, 12);
        anzeigefeld3.setLocation(16, 16);
        anzeigefeld2.setLocation(16, 14);
        anzeigefeld.setLocation(16, 12);
        vorschau.setLocation(16, 7);
        vorschau.setLocation(16, 4);
        anzeigefeld.setLocation(16, 8);
        anzeigefeld2.setLocation(16, 10);
        anzeigefeld3.setLocation(16, 12);
        Counter c = new Counter();
        addObject(c, 0, 1);
    }

}
