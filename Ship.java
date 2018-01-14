import java.awt.Point;
import java.util.ArrayList;

public class Ship {

	private ShipPiece[] pieces;
	private Point startingPosition;

	/*
	 * Constructor. Sets pieces equal to the list parameter
	 */
	Ship(ShipPiece[] list) {
		pieces = list;
		startingPosition = new Point(0,0);
	}
	
	Ship(ArrayList<ShipPiece> list){
		pieces = list.toArray(new ShipPiece[0]);
		startingPosition = new Point(0,0);
	}
