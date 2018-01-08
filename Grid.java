import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Grid extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	private BufferedImage gridImage;
	private Object[][] array;
	public static final int X_ORIGIN = 54; // X coordinate of the top left
	public static final int Y_ORIGIN = 56; // Y coordinate of the top left
	public static final int TILE_SIZE = 47; // Size of the tile spaces
	public static final int BORDER_SIZE = 5; // size of the border between spaces
	private volatile boolean isTurn;
	private boolean state;

    /*
	 * Default constructor. Uses an empty array
	 */
	public Grid() {
		this(new Object[10][10], "gridLabels.png");
	}

    /*
	 * Constructor that takes an array
	 */
	public Grid(Object[][] arr) {
		this(arr, "gridLabels.png");
	}

    /*
	 * constructor that takes an array and a file path.
	 */
	public Grid(Object[][] arr, String path) {
		array = arr;
		isTurn = true;
		state = false;
		// makes the background white and sets the size
		setBackground(Color.white);
		setPreferredSize(new Dimension((X_ORIGIN+ arr.length + 1 + ((TILE_SIZE+BORDER_SIZE)*array.length)), 
				Y_ORIGIN+ arr.length + 1 + ((TILE_SIZE+BORDER_SIZE)*array.length)));
		setSize(getPreferredSize());
		setLocation(0,0);

		try {
			gridImage = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("Failed to load image");
		}
	}
