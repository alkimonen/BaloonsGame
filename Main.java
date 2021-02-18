import javax.swing.*;

/**
 * Balloon game
 * @author Alkým Önen
 * @version 28/03/2018
 */
public class Main
{
   public static void main( String[] args)
   {
      final int WIDTH = 1000;
      final int HEIGHT = 700;
      
      JFrame frame;
      JPanel panel;
      
      frame = new JFrame();
      panel = new BalloonsGamePanel();
      
      frame.setSize( WIDTH, HEIGHT);
      frame.add( panel);
      frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
      frame.setVisible( true);
   }
}