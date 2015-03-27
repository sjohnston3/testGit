import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton.*;
import java.awt.Graphics;
/**
 * Created by Tom on 12/7/2014.
 */
public class Game
{
    private int sizeOfScreen;
    private JFrame myFrame;
    private JPanel myPanel;
    private JButton[][] buttons = new JButton[3][3];
    private Cell[][] board = new Cell[3][3];
    private int turn;

    public Game()
    {
        turn = 0;
         //TttCell t = new TttCell();
        //JButton[][] buttons = new JButton[3][3];
        sizeOfScreen = 600;
        myFrame = new JFrame("Tic Tac Toe");

        JMenuBar menuBar = new JMenuBar();
        myFrame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem about = new JMenuItem("How To Play");
        fileMenu.add(about);

        myFrame.setVisible(true);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setSize(sizeOfScreen, sizeOfScreen);
        
        myPanel = new JPanel();
        myPanel.setLayout(new FlowLayout());
        
        JButton newButton1 = new JButton(new ImageIcon("C:\\Users\\Sean\\Documents\\Classes\\CS225\\circles\\test\\oval.png"
         ));
         
         JButton newButton2 = new JButton(new ImageIcon("C:\\Users\\Sean\\Documents\\Classes\\CS225\\circles\\test\\oval.png"
         ));
         
         JButton newButton3 = new JButton(new ImageIcon("C:\\Users\\Sean\\Documents\\Classes\\CS225\\circles\\test\\oval.png"
         ));
         
         
        
        myPanel.add(newButton1);
        myPanel.add(newButton2);
        myPanel.add(newButton3);
        
        

       
        myFrame.add(myPanel);
        

    }

    public static void main(String[] args)
    {
        new Game();
    }

    public int getSizeOfScreen()
    {
        return sizeOfScreen;
    }

    public void setSizeOfScreen(int sizeOfScreen)
    {
        this.sizeOfScreen = sizeOfScreen;
    }

    public JFrame getMyFrame()
    {
        return myFrame;
    }

    public void setMyFrame(JFrame myFrame)
    {
        this.myFrame = myFrame;
    }

    public JPanel getMyPanel()
    {
        return myPanel;
    }

    public void setMyPanel(JPanel myPanel)
    {
        this.myPanel = myPanel;
    }

    public Cell[][] getBoard()
    {
        return board;
    }

    public void setBoard(Cell[][] board)
    {
        this.board = board;
    }
    
    public void setButton(int i,int j)
    {
        buttons[i][j].setText("X");
    }
    
    public void checkWin()
    {
        checkRowWin();
        checkColWin();
        checkDiagonals();
    }
    
    public void checkRowWin()
    {
        for(int i=0; i<3;i++){
           if(buttons[i][0].getText().equals("X") && buttons[i][1].getText().equals("X") && buttons[i][2].getText().equals("X"))
           {
               System.out.println("WINNER!");
            }
        }
                for(int i=0; i<3;i++){
           if(buttons[i][0].getText().equals("O") && buttons[i][1].getText().equals("O") && buttons[i][2].getText().equals("O"))
           {
               System.out.println("WINNER!");
            }
        }
        
    }
    public void checkColWin()
    {
        for(int i=0; i<3;i++){
           if(buttons[0][i].getText().equals(buttons[1][i].getText())&&(buttons[1][i].getText().equals(buttons[2][i]))){
               System.out.println("WINNER!");
            }
        }
    }
    public void checkDiagonals()
    {
        if(buttons[0][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[2][2].getText().equals("X"))
        {
            System.out.println("WINNER!");
        }
        
        else if(buttons[2][0].getText().equals("X") && buttons[1][1].getText().equals("X") && buttons[0][2].getText().equals("X"))
        {
            System.out.println("WINNER!");
        }
        
        if(buttons[0][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[2][2].getText().equals("O"))
        {
            System.out.println("WINNER!");
        }
        
        else if(buttons[2][0].getText().equals("O") && buttons[1][1].getText().equals("O") && buttons[0][2].getText().equals("O"))
        {
            System.out.println("WINNER!");
        }
    }
    private class myActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           checkColWin();
           checkRowWin();
           checkDiagonals();
            turn++;
            for(int i = 0; i < 3; i++)         
            {
                for(int j = 0; j < 3; j++) 
            {
                board[i][j].increment();
            }
           }


        }
    }
}
