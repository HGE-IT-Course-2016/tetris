import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Die Oberklasse zu den Formen der Steine.
 * Die Formen importieren diese Klasse direkt und überschreiben die angegeben leeren Funktionen
 * 
 * @author Achim Retzback & Felix Stupp & Aaron Holzapfel
 * @version 03/08/2016 8:41
 */
public abstract class Stein extends Actor
{
    /** Stellt die X-Koordinate des Mittelpunkts des Steins dar. Absolute Position */
    protected int posX = 0;
    /** Stellt die Y-Koordinate des Mittelpunkts des Steins dar. Absolute Position */
    protected int posY = 0;
    /** Stellt die Rotation um den Mittelpunkt des Steins dar. */
    protected int rot;
    
    /** Block 1 */
    protected Block b1;
    /** Block 2 */
    protected Block b2;
    /** Block 3 */
    protected Block b3;
    /** Block 4 */
    protected Block b4;
    
    private final int maxC = 750000;
    private int counter = maxC;
    private String lastKeyDown = "";
    
    // Order for key input: {rotate-1; rotate+1; left; right}
    private String[] keyList = {"w","s","a","d"};
    private boolean[] keyDown = new boolean[keyList.length];
    
    // Konstruktor ist aufgrund der Unnötigkeit nicht vorhanden.
    
    /**
     * Passt den Wert der Rotation an die Grenzen von 0 bis 3 an. Muss von renewLocation aufgerufen werden.
     */
    public void checkRotation() {
        if(rot < 0) {
            rot = 3;
        } else if(rot > 3) {
            rot = 0;
        }
    }
    
    @Override public Hintergrund getWorld() {
        return (Hintergrund) super.getWorld();
    }
    
    /**
     * Erneuert die Position aller Blöcke des Steins.
     * Die Funktion muss von den Unterklassen überschrieben werden.
     */
    protected abstract void renewLocation();
    
    
    protected abstract boolean checkRot(int r);
    
    /**
     * Prüft ab, ob der gesamte Stein sich noch nach unten bewegen kann.
     */
    protected boolean canFall() {
        return checkAll(0,1);
    }
    
    /**
     * Setzt die mittlere Position des Steins.
     * Muss nicht überschrieben werden.
     */
    protected void setLoc(int x, int y) {
        posX = x;
        posY = y;
        renewLocation();
    }
    
    private boolean checkPos(int x, int y) {
        if(y > 18 || x < 2 || x > 11) {
            return false;
        }
        /*
        if(getWorld().istBelegt(x,y)) {
            return false;
        }
        */
        return true;
    }
    
    private boolean checkAll(int x, int y) {
        boolean bool1 = checkPos(b1.getX() + x, b1.getY() + y);
        boolean bool2 = checkPos(b2.getX() + x, b2.getY() + y);
        boolean bool3 = checkPos(b3.getX() + x, b3.getY() + y);
        boolean bool4 = checkPos(b4.getX() + x, b4.getY() + y);
        return bool1 && bool2 && bool3 && bool4;
    }
    
    /**
     * Fügt die Blöcke des Steins zur selben Welt dazu, die er auch selbst angehört.
     * Muss nicht überschrieben werden.
     */
    @Override public void addedToWorld(World w) {
        posX = getX();
        posY = getY();
        b1 = new Block();
        b2 = new Block();
        b3 = new Block();
        b4 = new Block();
        GreenfootImage i = b1.getImage();
        b2.setImage(i);
        b3.setImage(i);
        b4.setImage(i);
        /*
        b1.setRotation(90);
        b2.setRotation(90);
        b3.setRotation(90);
        b4.setRotation(90);
        */
        w.addObject(b1,0,0);
        w.addObject(b2,0,0);
        w.addObject(b3,0,0);
        w.addObject(b4,0,0);
        renewLocation();
        setLocation(0,0);
    }
    
    /**
     * Nimmt periodisch die Tastatureingaben entgegen und bewegt (falls möglich) den Stein nach unten.
     * Muss nicht überschrieben werden.
     */
    @Override public void act() {
        for(int i = 0; i < keyList.length; i++) {
            String k = keyList[i];
            boolean b = Greenfoot.isKeyDown(k);
            if((keyDown[i] != b) && b) {
                if(i == 0) {
                    if(checkRot(rot - 1)) {
                        rot = rot - 1;
                    }
                } else if(i == 1) {
                    if(checkRot(rot + 1)) {
                        rot = rot + 1;
                    }
                } else if(i == 2) {
                    if(checkAll(-1,0)) {
                        posX = posX - 1;
                    }
                } else if(i == 3) {
                    if(checkAll(1,0)) {
                        posX = posX + 1;
                    }
                }
            }
            keyDown[i] = b;
        }
        if(canFall()) {
            counter = counter - 1;
            if(counter == 0) {
                posY = posY + 1;
                counter = maxC;
            }
        } else {
            //getWorld().gefallen(this);
        }
        renewLocation();
    }
}
