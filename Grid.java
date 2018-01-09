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

    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// draws the grid
		g2.drawImage(gridImage, 0, 0, this);

		// loops through all spots in the grid
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				// checks if there is a 1 or a ShipPiece that has not been
				// destroyed
				if (array[i][j].equals((Object) 1) || ((array[i][j]).getClass().getName().equals("ShipPiece")
						&& !((ShipPiece) array[i][j]).isDestroy())) {
					// covers the spot on the grid with a gray box
					g2.setColor(Color.gray);
					g2.fillRect(X_ORIGIN + i + 1 + ((TILE_SIZE + BORDER_SIZE) * i), Y_ORIGIN + j + 1 + ((TILE_SIZE + BORDER_SIZE) * j),
							TILE_SIZE+(BORDER_SIZE/2)-1, TILE_SIZE+(BORDER_SIZE/2)-1);
					// if there is a ship piece at the position that is
					// destroyed
				} else if ((array[i][j]).getClass().getName().equals("ShipPiece")) {
					// draw the image associated with the ship piece
					g2.drawImage(((ShipPiece) array[i][j]).getShipImage(),
							X_ORIGIN + i + ((TILE_SIZE + BORDER_SIZE) * i) + BORDER_SIZE/2,
							Y_ORIGIN + j + ((TILE_SIZE + BORDER_SIZE) * j) + BORDER_SIZE/2, this);
				}
			}
		}

	}

