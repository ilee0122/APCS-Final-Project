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
}