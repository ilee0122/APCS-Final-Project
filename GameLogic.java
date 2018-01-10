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
	
	startGame();
    }

    public void startGame(){
	gameRunning = true;
	
	MainMenu startMenu = new MainMenu(frame);
	startMenu.loadTitleScreen();
	while(startMenu.isImageVisible()){}
	
	Ship[] p1Ships = initializeShipCreation(true);
	Ship[] p2Ships = initializeShipCreation(false);

	Grid grid = new Grid(chooseShipPositions(p1Ships));
	SmallGrid small = new SmallGrid(chooseShipPositions(p2Ships));
	small.setLocation(grid.getWidth()+10, grid.getY());
	
	//panel.setLayout(null);
	
	int windowWidth = small.getX() + small.getWidth() + 10;
	frame.setPreferredSize(new Dimension(windowWidth, frame.getHeight())); 
	frame.setSize(frame.getPreferredSize());
	frame.pack();
	
	frame.getContentPane().add(grid);  // adds the grids to the window
	frame.getContentPane().add(small);

	//grid needs mouse listener to manually place the ships on the grid
	frame.addMouseListener(grid);
	
	frame.setVisible(true);

	gameLoop(p1Ships, p2Ships, grid, small);
    }

    private Ship[] initializeShipCreation(boolean isPlayerOne) {
	Ship[] battleships = createShips(battleshipSize, battleshipCount, isPlayerOne);
	Ship[] cruisers = createShips(cruiserSize, cruiserCount, isPlayerOne);
	Ship[] destroyers = createShips(destroyerSize, destroyerCount, isPlayerOne);
	Ship[] submarines = createShips(submarineSize, submarineCount, isPlayerOne);

	Ship[] ships = concatShipArray(battleships, cruisers);
	ships = concatShipArray(ships, destroyers);
	ships = concatShipArray(ships, submarines);

	return ships;
    }

    private Ship[] createShips(int shipSize, int numOfShips, boolean isPlayerOne) {}

    private Ship[] concatShipArray(Ship[] a, Ship[] b) {}

    private Object[][] chooseShipPositions(Ship[] ships){}

    private void betweenTurns(Grid grid, SmallGrid small){}

    private void gameLoop(Ship[] p1Ships, Ship[] p2Ships, Grid grid, SmallGrid small){}








}