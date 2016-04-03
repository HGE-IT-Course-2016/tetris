import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends Actor
{
    private int nächsterStein, score; // values to be displayed by the following Text objects
    private Text moveText, scoreText; // objects to display the previous field values
    private Text moveTexta, highscoreText;
    private Text level, levelText;
    int lv = 0;
    int p;
    public Counter()
    {    
        
        moveText = new Text("Nächster Stein: 0");
        scoreText = new Text("Score: 0");
        highscoreText = new Text("Highscore: ");
        levelText = new Text ("Level: " + lv);
        p=0;
    }

    // this method adds the Text objects into any world that this actor is added or moved into
    public void addedToWorld(World w)
    {
        w.addObject(moveText, 16, 2);
        w.addObject(scoreText, 16, 8);
        w.addObject(highscoreText, 16, 10);
        w.addObject(levelText, 16, 12);
    }

    
    /**
     * Berechnet die Punkte
     * 
     * @param z Die Anzahl gelöschter Zeilen
     * @param n Das aktuelle Level
     */
    protected int pbr ( int z, int n) 
    {
        int zp=0; 
        
        switch(z)
        {
            case 1 :
             zp = 40*(n+1)+(z*10);
            break;
            case 2 :
             zp = 200*(n+1)+(z*10); 
            break;
            case 3 :
             zp = 300*(n+1)+(z*10);  
            break;
            case 4 :
             zp = 1200*(n+1)+(z*10); 
            break;
            
        }
        p=p+zp;
        zp=0;
        return p ;
    }
    public void act() 
    {
        int i =0;
        if(i==0)
        {
            moveText.setText("Nächster Stein: "+nächsterStein);
            score=p;
            scoreText.setText("Score: "+score);
        }
        
        scoreText.setText("Score: "+score);
    }
}
