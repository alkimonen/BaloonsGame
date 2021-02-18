package shapes;
import java.util.Iterator;
import java.util.*;

/**
 * Shape container class
 * @author Alkım Önen
 * @version 28/03/18
 */
public class ShapeContainer extends Shape implements Selectable, Iterable
{
   private boolean selected;
   private int x;
   private int y;
   private ArrayList<Shape> container;
   
   public ShapeContainer()
   {
      selected = false;
      container = new ArrayList<Shape>();
   }
   
   /**
    * Adds a shape to container
    */
   public void add( Shape s)
   {
      container.add( s);
   }
   
   /**
    * Computes and returns the total area
    * @return double the area
    */
   public double getArea()
   {
      int i;
      double area;
      
      area = 0;
      for ( i = 0; i < container.size(); i++ )
      {
         area = area + container.get( i).getArea();
      }
      return area;
   }
   
   /**
    * Returns properties of shapes in container
    * @return String
    */
   public String toString()
   {
      int i;
      String last;
      last = "";
      
      for ( i = 0; i < container.size(); i++ )
      {
         last = last + container.get( i).toString();
         if ( i < container.size() - 1 )
            last = last + "\n";
      }
      return last;
   }
   
   /**
    * Finds the first shape containing (x,y) and changes its selected
    * @param x X coordinate
    * @param y Y coordinate
    */
   public void toggle( int x, int y)
   {
      int i;
      
      for ( i = 0; i < container.size(); i++ )
      {
         if ( ((Selectable) container.get( i)).contains( x, y) != null )
         {
            ((Selectable) container.get( i)).setSelected( !((Selectable) container.get( i)).getSelected());
            i = container.size();
         }
      }
   }
   
   /**
    * Removes all selected shapes
    */
   public void removeSelecteds()
   {
      int i;
      
      for ( i = 0; i < container.size(); i++ )
      {
         if ( ((Selectable) container.get( i)).getSelected())
         {
            container.remove( i);
            i = i - 1;
         }
      }
   }
   
   /**
    * @return boolean true if selected, false otherwise
    */
   public boolean getSelected()
   {
      return selected;
   }
   
   /**
    * Changes selected
    * @param b Boolen of user
    */
   public void setSelected( boolean b)
   {
      selected = b;
   }
   
   /**
    * As ShapeContainer can't have size, returns itself so selected can be changed
    * @return Shape
    */
   public Shape contains( int x, int y)
   {
      return this;
   }
   
   /**
    * @return int Number of shapes in shape container
    */
   public int size()
   {
      return container.size();
   }
   
   /**
    * Selects all shapes is ShapeContainer which contains the point (x,y)
    * @param x X coordinate
    * @param y Y coordinate
    * @return int How many shapes contain that point
    */
   public int selectAllAt( int x, int y)
   {
      int i;
      int count;
      
      count = 0;
      for ( i = 0; i < container.size(); i++ )
      {
         if ( container.get( i).contains( x, y) != null )
         {
            count = count + 1;
            container.get( i).setSelected( true);
         }
      }
      return count;
   }
   
   /**
    * Returns the iterator of shapes
    * @return Iterator<Shape>
    */
   public Iterator<Shape> iterator()
   {
      return container.iterator();
   }
}