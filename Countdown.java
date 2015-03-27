
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Countdown is part of implementation of the "Race Car" program.
 * It creates a frame separate from the main game frame.It is used to start each race leg.
 * Created by Henrique DeAguiar on 3/7/15.
 */

public class Countdown extends JFrame{
    
     private final static int NUMBER_OF_SLIDES = 4;
     private final static int SHOW_TIME_PER_SLIDE = 1100;
     private static final int TIME_VISIBLE = 7000;
     private int current = 5;
     private JLabel imageLabel = new JLabel();

     public Countdown() {
         
         imageLabel.setIcon(new ImageIcon("./images/number3.png"));
         Timer timer  = new Timer(SHOW_TIME_PER_SLIDE,new Listener());
         timer.start();
         add(imageLabel);
          
        setTitle("GET READY!");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //this makes the frame disappear automatically.
        new Timer(TIME_VISIBLE, new Listener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                    }
                }).start();
         setVisible(true);  
     }//end of constructor
     
     
         public class Listener implements ActionListener{
             public void actionPerformed(ActionEvent event)
             {
                 current  = (current-1);
                 imageLabel.setIcon(new ImageIcon("./images/number_"+current+".png"));
  
             }         
         }
}//end of class Countdown
 
     