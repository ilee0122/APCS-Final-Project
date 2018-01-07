import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class GridCreator extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage gridImage = null;
    private Object[][] gridArray;
    private Ship[] shipArray;
    private JPanel[] panelArray;
    private JButton endSetup, randomizeShipsBtn;
    private JFrame window;

    private volatile boolean setupOver = false;
    public static final int X_ORIGIN = 54;
    public static final int Y_ORIGIN = 56;
    public static final int TILE_SIZE = 47;
    public static final int BORDER_SIZE = 5;
    public static boolean currentlyPlacingShip = false;

    public GridCreator(Ship[] shipArray, JFrame app) {
	this(shipArray, 10, app);
    }

    public GridCreator(Ship[] shipArray, int gridSize, JFrame app) {
	this(shipArray, gridSize, "gridLabels.png", app);
    }

    public GridCreator(Ship[] shipArray, int gridSize, String path, JFrame app) {
	setLayout(null);
	setBackground(Color.white);
	setLocation(0,0);
	window = app;

	Object[][] grid = new Object[gridSize][gridSize];
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[i].length; j++) {
		grid[i][j] = 1;
	    }
	}

	gridArray = grid;
	this.shipArray = shipArray;
	panelArray = new JPanel[shipArray.length];

	try {
	    gridImage = ImageIO.read(new File(path));
	} catch (IOException e) {
	    System.out.println("Failed to load image");
	}

    }


    /*
     * Does all the work to setup the grid.
     */
    public void setup() {
	int largestShipSize = 0;
	for (int i = 0; i < shipArray.length; i++){
	    int temp = shipArray[i].getShipPieces().length;
	    if (temp > largestShipSize){
		largestShipSize = temp;
	    }
	}
	
	int windowWidth = X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 50
	    + ((largestShipSize + 1) * TILE_SIZE);
	int windowHeight = Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * (gridArray.length + 1));
	if (windowHeight < 2 * TILE_SIZE + (shipArray.length * (TILE_SIZE + BORDER_SIZE + 2))) {
	    windowHeight = 2 * TILE_SIZE + (shipArray.length * (TILE_SIZE + BORDER_SIZE + 2));
	}
	window.setPreferredSize(new Dimension(windowWidth, windowHeight));
	window.setMinimumSize(new Dimension(windowWidth, windowHeight));
	window.pack();
	setSize(window.getContentPane().getSize());

	// creates a label with the grid image and adds it to the screen
	JLabel gridLabel = new JLabel(new ImageIcon(gridImage));
	gridLabel.setSize(X_ORIGIN + gridArray.length + 1 + ((TILE_SIZE + BORDER_SIZE) * gridArray.length),
			  Y_ORIGIN + gridArray.length + 1 + ((TILE_SIZE + BORDER_SIZE) * (gridArray.length)));
	gridLabel.setLocation(0, 0);
	gridLabel.setHorizontalAlignment(SwingConstants.LEFT);
	gridLabel.setVerticalAlignment(SwingConstants.TOP);
	add(gridLabel);

	int buttonXPos = gridLabel.getWidth();

	randomizeShipsBtn = new JButton("Randomize Grid");
	randomizeShipsBtn.setBounds(buttonXPos, 0, window.getWidth() - buttonXPos, TILE_SIZE - 5);
	randomizeShipsBtn.addActionListener(new ActionListener() {
		@Override
		    public void actionPerformed(ActionEvent e) {
		    Random rand = new Random();
		    for (int i = 0; i < panelArray.length; i++) {
			panelArray[i].setLocation(shipArray[i].getStartingOffGridPosition());
		    }
		    for (int i = 0; i < panelArray.length; i++) {
			int timeout = 0;
			while (timeout < 500
			       && shipArray[i].getStartingOffGridPosition().equals(panelArray[i].getLocation())) {
			    int x = rand.nextInt(gridArray.length);
			    int y = rand.nextInt(gridArray.length);
			    timeout++;
			    leftClick(i, x, y);
			    if (rand.nextInt(2) == 0
				&& !shipArray[i].getStartingOffGridPosition().equals(panelArray[i].getLocation())) {
				rightClick(i, x, y);
			    }
			}
		    }
		}
	    });
	add(randomizeShipsBtn);
	randomizeShipsBtn.setVisible(true);
	repaint();

	// creates a button that ends setup when pressed
	endSetup = new JButton("Finish");
	endSetup.setBounds(buttonXPos, TILE_SIZE - 5, window.getWidth() - buttonXPos, window.getHeight());
	endSetup.addActionListener(new ActionListener() {
		@Override
		    public void actionPerformed(ActionEvent e) {
		    setupOver = true;
		}
	    });
	add(endSetup);
	// sets the visibility of the button to false
	endSetup.setVisible(false);

	// loops through all the ships
	for (int j = 0; j < shipArray.length; j++) {
	    final int shipNum = j;

	    // creates a panel with an X Axis box layout for the ship
	    JPanel panel = new JPanel();
	    panel.setBackground(Color.WHITE);
	    panel.setOpaque(false);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
	    panel.add(Box.createRigidArea(new Dimension(0, 0)));

	    // loops through the ship pieces in the ship
	    for (int i = 0; i < shipArray[j].getShipPieces().length; i++) {
		// adds labels containing each image to the panel
		ImageIcon icon = new ImageIcon(shipArray[j].getShipPieces()[i].getShipImage());
		JLabel label = new JLabel(icon);
		panel.add(label);
		panel.add(Box.createRigidArea(new Dimension(BORDER_SIZE + 2, 0)));
		// places the panel off to the side of the grid
		// panel.setLocation(650, 50 + (j * 50));

	    }
	    panel.setLocation(X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * gridArray.length) + (2 * BORDER_SIZE) + 50,
			      TILE_SIZE + BORDER_SIZE + 2 + (j * (TILE_SIZE + BORDER_SIZE + 2)));
	    panel.setSize(shipArray[j].getShipPieces().length * (TILE_SIZE + BORDER_SIZE), TILE_SIZE);
	    shipArray[shipNum].setStartingOffGridPosition(panel.getLocation());
	    add(panel);
	    panelArray[j] = panel;
	    setComponentZOrder(panel, 0);

	    panel.addMouseMotionListener(new MouseMotionAdapter() {

		    @Override
			public void mouseDragged(MouseEvent e) {
			// when the left mouse button is down the panel is moved to
			// the mouse location
			if (SwingUtilities.isLeftMouseButton(e)) {
			    JPanel component = (JPanel) e.getComponent().getParent().getParent();
			    Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
			    panel.setLocation((int) pt.getX() - (TILE_SIZE / 2), (int) pt.getY() - (TILE_SIZE / 2));
			    currentlyPlacingShip = true;
			}
		    }

		});
	    // adds a mouse listener to the panel
	    panel.addMouseListener(new MouseAdapter() {
		    @Override
			public void mouseReleased(MouseEvent e) {
			// gets the coordinates of the mouse in terms of the window
			JPanel component = (JPanel) e.getComponent().getParent().getParent();
			Point pt = new Point(SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), component));
			int counter1 = 0;
			int counter2 = 0;

			// calculates the position in the grid array based on the
			// mouse coordinates
			int value = (int) pt.getX();

			while (X_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter1) < value) {
			    counter1++;
			}
			counter1--;

			int value2 = (int) (pt.getY());
			while (Y_ORIGIN + ((TILE_SIZE + BORDER_SIZE) * counter2) < value2) {
			    counter2++;
			}
			counter2--;

			// if left button released
			if (e.getButton() == MouseEvent.BUTTON1) {
			    // calls the left click method
			    currentlyPlacingShip = false;
			    leftClick(shipNum, counter1, counter2);
			    // if right button released
			} else if (e.getButton() == MouseEvent.BUTTON3) {
			    rightClick(shipNum, counter1, counter2);
			}

			endSetup.repaint();

		    }

		});
	}
    }


}