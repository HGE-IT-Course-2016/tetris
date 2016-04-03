import greenfoot.*;

/**
 * A simple class to display changable text
 */
public class Text extends Actor
{
    public Text(String txt)
    {
        setText(txt);
    }
    
    public void setText(String txt)
    {
        setImage(new GreenfootImage(txt, 20, java.awt.Color.black, null));
    }
}
