import shapes.ShapeContainer;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import java.util.Iterator;

/**
 * Panel class for balloon game
 * @author Alkým Önen
 * @version 28/03/2018
 */
public class BalloonsGamePanel extends JPanel
{
   private final int DELAY = 250;
   private final int NO_OF_BALLOONS = 25;
   private final int MIN_NO_OF_BALLOONS = 15;
   private final int MAX_RUNNING_TIME = 60000;
   
   private int points;
   private int elapsedTime;
   private ShapeContainer balloons;
   private Timer timer;
   private JLabel scores;
   
   class PinMouseListener implements MouseListener
   {
      /**
       * Erases the balloons on clicked point
       * @param event Mouse click
       */
      public void mousePressed( MouseEvent event)
      {
         int clicked;
         clicked = balloons.selectAllAt( event.getX(), event.getY());
         
         if ( clicked >= 2 )
            points = points + clicked;
         scores.setText( "Points: " + points);
      }
      
      // Do-nothing methods
      public void mouseReleased( MouseEvent event) {}
      public void mouseClicked( MouseEvent event) {}
      public void mouseEntered( MouseEvent event) {}
      public void mouseExited( MouseEvent event) {}
   }
   
   class TimerListener implements ActionListener
   {
      /**
       * @param event Time passes
       */
      public void actionPerformed( ActionEvent event)
      {
         Balloon newBalloon;
         Iterator iterator;
         int input;
         
         iterator = balloons.iterator();
         
         // Makes balloons grow
         while ( iterator.hasNext())
         {
            (( Balloon) iterator.next()).grow();
            repaint();
         }
         // Removes oversized ballons
         balloons.removeSelecteds();
         
         // Adds balloons if the number is low
         while ( balloons.size() < MIN_NO_OF_BALLOONS )
         {
            newBalloon = new Balloon();
            newBalloon.locateRandomly();
            balloons.add( newBalloon);
         }
         
         // Takes record of the time, and stops the game if it reaches max time
         elapsedTime = elapsedTime + DELAY;
         if ( elapsedTime >= MAX_RUNNING_TIME )
         {
            timer.stop();
            input = JOptionPane.showConfirmDialog( null, "Play again?",
                                                  "Game over", JOptionPane.YES_NO_OPTION);
            
            if ( input == JOptionPane.YES_OPTION )
            {
               startNewGame();
            }
            else if (  input == JOptionPane.NO_OPTION )
            {
               System.exit( 0);
            }
         }
      }
   }
   
   public BalloonsGamePanel()
   {
      addMouseListener( new PinMouseListener());
      
      // Label for points
      scores = new JLabel();
      add( scores);
      
      startNewGame();
   }
   
   /**
    * Creates a new game so the code will not be repeated in program
    */
   public void startNewGame()
   {
      elapsedTime = 0;
      points = 0;
      balloons = new ShapeContainer();
      scores.setText( "Points: " + points);
      
      // Adds balloons
      for ( int i = 0; i < NO_OF_BALLOONS; i++ )
      {
         balloons.add( new Balloon());
      }
      
      Iterator iterator;
      iterator = balloons.iterator();
      
      // Locates added balloons randomly
      while ( iterator.hasNext())
      {
         ((Balloon) iterator.next()).locateRandomly();
      }
      
      // Creates timer
      timer = new Timer( DELAY, new TimerListener());
      timer.start();
   }
   
   /**
    * Paints balloons
    * @param g Graphics
    */
   @Override
   public void paintComponent( Graphics g)
   {
      super.paintComponent( g);
      
      Iterator iterator;
      iterator = balloons.iterator();
      
      while( iterator.hasNext() )
      {
         ((Drawable) iterator.next()).draw( g);
      }
   }
}