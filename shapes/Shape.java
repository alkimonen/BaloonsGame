package shapes;
/**
 * 
 * @author Alkým Önen
 * @version 14/03/18
 */
public abstract class Shape implements Locatable, Selectable
{
   private int x;
   private int y;
   
   /**
    * Sets the shape to location (x,y)
    * @param x X coordinate
    * @param y Y coordinate
    */
   public void setLocation( int x, int y)
   {
      this.x = x;
      this.y = y;
   }
   
   /**
    * Getter method for x
    * @return int x
    */
   public int getX()
   {
      return x;
   }
   
   /**
    * Getter method for y
    * @return int y
    */
   public int getY()
   {
      return y;
   }
   
   public abstract double getArea();
}