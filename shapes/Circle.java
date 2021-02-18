package shapes;
/**
 * Circle class which is a Shape
 * @author Alkým Önen
 * @version 28/03/18
 */
public class Circle extends Shape implements Selectable
{
   private int radius;
   private boolean selected;
   
   public Circle( int radius)
   {
      selected = false;
      this.radius = radius;
   }
   
   /**
    * Returns the area
    * @return double Area of shape
    */
   public double getArea()
   {
      return Math.PI * radius * radius;
   }
   
   /**
    * Returns properties of shape
    * @return String
    */
   public String toString()
   {
      return "A circle with radius: " + radius + ", area: " + getArea() + ", selected: " + getSelected();
   }
   
   /**
    * @return boolean true if selected, false otherwise
    */
   public boolean getSelected()
   {
      return selected;
   }
   
   /**
    * Chances selected
    * @param b Boolean that user wants
    */
   public void setSelected( boolean b)
   {
      selected = b;
   }
   
   /**
    * Checks that the point is in the shape
    * @param x X coordinate
    * @param y Y coordinate
    * @return Shape this shape if it contains point, null otherwise
    */
   public Shape contains( int x, int y)
   {
      if ( ((x - getX()) * (x - getX())) + ((y-getY()) * (y-getY())) < (radius * radius) )
         return this;
      return null;
   }
   
   /**
    * Returns radius
    * @return int Radius
    */
   public int getRadius()
   {
      return radius;
   }
   
   
   /**
    * Changes radius
    * @param int New radius
    */
   public void setRadius( int radius)
   {
      this.radius = radius;
   }
}