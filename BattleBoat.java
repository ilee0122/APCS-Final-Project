import javax.swing.*;
import java.awt.*;

public class BattleBoat extends JFrame implements KeyListener, ActionListener{

    private Container pane;

    private JButton rotate;
    private JButton restart;
    private JButton place;
    private JButton start;
    private JButton fire;

    //Research JLabel
    private JLabel instruction;
    private JLabel player;
    private JLabel title;
    private JLabel computer;

    private JTextField x;
    private JTextField y;

    private JTable pTable;
    private JTable cTable;

    public BattleBoat(){
	this.setTitle("BattleBoat");
	//this.setSize( , );         Try different dimensions
	//this.setLocation( , );     Try different locations   
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	//pane.setLayout();  Which layout to use?

	rotate = new JButton("Rotate");
	restart = new JButton("Restart");
	place = new JButton("Place");
	start = new JButton("START!");
	fire = new JButton("Fire!");

	instruction = new JLabel("Instruction:...");
	player = new JLabel("Player");
	computer = new JLabel("Computer");
	title = new JLabel("BattleBoat");

	x = new JTextField(10); // Try different sizes
	y = new JTextField(10); // Try different sizes

	pTable = new JTable( );
	cTable = new JTable( );


	pane.add(title);
	pane.add(player);
       	pane.add(computer);
        pane.add(pTable);
	pane.add(cTable);
       	pane.add(x);
	pane.add(y);
        pane.add(rotate);
        pane.add(place);
	pane.add(start);
 	pane.add(fire);
	pane.add(restart);
	     
	
    }
}
