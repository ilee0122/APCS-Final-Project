//import 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameLogic{

    //default grid size
    public static int boardSize = 10;

    //default size 
    public static int battleshipSize = 4;
    public static int cruiserSize = 3;
    public static int destroyerSize = 2;
    public static int submarineSize = 1;

    //default count
    public static int battleshipCount = 1;
    public static int cruiserCount = 2;
    public static int destroyerCount = 3;
    public static int submarineCount = 4;

    private JFrame frame;

    private boolean gameRunning;

    public void setUpWindow() {
	frame = new JFrame();
	
	frame.getContentPane().setLayout(null);
	frame.getContentPane().setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	//set them equal
	frame.setPreferredSize(new Dimension(900, 615));
	frame.setMinimumSize(new Dimension(900, 615));

	//no need to resize the GUI window
	frame.setResizable(false);
	frame.pack();
	
	//
    }

    public void startGame(){

    }
}