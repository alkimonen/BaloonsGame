package shapes;
/**
 * Selectable interface with three methods
 * @author Alk�m �nen
 * @version 14/03/18
 */
public interface Selectable
{
   public boolean getSelected();
   
   public void setSelected( boolean b);
   
   public Shape contains( int x, int y);
}