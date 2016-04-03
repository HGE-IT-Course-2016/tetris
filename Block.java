import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    public  Block()
    {
        
        int i = (int)(Math.random()*5+1);
       
        

        switch(i)
        {

            case 1: 
                this.setImage ("Tetris_Block_Cyan.png");
                break;

            case 2:
                this.setImage ("Tetris_Block_Green.png");
                break;

            case 3:
                this.setImage ("Tetris_Block_Grey.png");
                break;

            case 4:
                this.setImage ("Tetris_Block_Red.png");
                break;

            case 5:
                this.setImage ("Tetris_Block_BetterYellow.png");
                break;

        }
     
    }
}
