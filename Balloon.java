import shapes.Circle;
import java.awt.Graphics;

/**
 * A shape of balloon
 * @author Alkým Önen
 * @version 28/03/2018
 */
public class Balloon extends Circle implements Drawable
{   
   private final int GROWING_UNIT = 5;
   private final int MAXIMUM_SIZE = 100;
   
   public Balloon()
   {
      super( 25);
   }
   
   /**
    * Draws the balloon
    * @param g Graphics
    */
   public void draw( Graphics g)
   {
      g.drawOval( getX() - getRadius(), getY() - getRadius(), 2 * getRadius(), 2 * getRadius() );
   }
   
   /**
    * Increases radius of the balloon
    * If radius reaches its limit, baloon disappears
    */
   public void grow()
   {
      super.setRadius( super.getRadius() + GROWING_UNIT );
      if ( super.getRadius() >= MAXIMUM_SIZE )
      {
         super.setRadius( 0);
         super.setSelected( true);
      }
   }
   
   /**
    * Changes balloons location to a random one
    */
   public void locateRandomly()
   {
      int x;
      int y;
      
      x = (int) Math.ceil( Math.random() * 1000);
      y = (int) Math.ceil( Math.random() * 700);
      setLocation( x, y);
   }
}