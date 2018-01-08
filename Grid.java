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
