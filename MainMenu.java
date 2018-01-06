import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainMenu {
	
    private JFrame window;
    private ImageIcon backgroundImageIcon;
    private JLabel bkgImageContainer;
    private JButton gridSizeBtn;
    private JButton startGame;
    private JButton battleshipSize, cruiserSize, destroyerSize, submarineSize;
    private JButton battleshipCount, cruiserCount, destroyerCount, submarineCount;
    private JLabel errorMessage;
    private JLabel errorMessage;
    private volatile boolean isImageVisible;
    private static final int MAX_SHIP_SIZE = 8;
    private static final int MAX_SHIP_COUNT = 5;

    public MainMenu(JFrame theWindow){
		window = theWindow;
		backgroundImageIcon = new ImageIcon("Title.png");
		bkgImageContainer = new JLabel(backgroundImageIcon);
		isImageVisible = true;
    }

    public boolean canShipsFitOnBoard(){
		int totalShipSize = (GameLogic.battleshipCount * GameLogic.battleshipSize) + 
				(GameLogic.cruiserCount * GameLogic.cruiserSize) +
				(GameLogic.destroyerCount * GameLogic.destroyerSize) + 
				(GameLogic.submarineCount * GameLogic.submarineSize);
		if (totalShipSize > GameLogic.boardSize*GameLogic.boardSize){
			return false;
		}
		if (GameLogic.battleshipSize > GameLogic.boardSize){
			return false;
		}
		if (GameLogic.cruiserSize > GameLogic.boardSize){
			return false;
		}
		if (GameLogic.destroyerSize > GameLogic.boardSize){
			return false;
		}
		if (GameLogic.submarineSize > GameLogic.boardSize){
			return false;
		}
		return true;
    }

    public void loadTitleScreen() {
		bkgImageContainer.setSize(window.getContentPane().getWidth(),
				window.getContentPane().getHeight()/2);
		bkgImageContainer.setLocation(0, 0); 
		bkgImageContainer.setVisible(true);
		
	
