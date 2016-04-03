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
