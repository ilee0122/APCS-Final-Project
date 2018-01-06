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

		errorMessage = new JLabel("Error: grid is too small to fit the selected ships");
		errorMessage.setForeground(Color.RED);
		errorMessage.setFont(new Font("Impact", Font.PLAIN, 24));
		errorMessage.setSize(440, 40);
		errorMessage.setLocation(window.getWidth()/2 - errorMessage.getWidth()/2,
				window.getHeight()-errorMessage.getHeight() - 30);
		errorMessage.setVisible(false);

		startGame = new JButton("Start Game");
		startGame.setSize(200, 100);
		startGame.setLocation(150, bkgImageContainer.getHeight() + 50);
		startGame.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.getContentPane().remove(startGame);
				window.getContentPane().remove(bkgImageContainer);
				window.getContentPane().remove(gridSizeBtn);
				window.getContentPane().remove(battleshipSize);
				window.getContentPane().remove(cruiserSize);
				window.getContentPane().remove(destroyerSize);
				window.getContentPane().remove(submarineSize);
				window.getContentPane().remove(battleshipCount);
				window.getContentPane().remove(cruiserCount);
				window.getContentPane().remove(destroyerCount);
				window.getContentPane().remove(submarineCount);
				window.getContentPane().revalidate();
				window.getContentPane().repaint();
				window.getContentPane().setBackground(Color.WHITE);
				isImageVisible = false;
			}	
		});

		gridSizeBtn = new JButton("Grid Width: " + GameLogic.boardSize);
		gridSizeBtn.setSize(200, 100); 
		gridSizeBtn.setLocation(150, bkgImageContainer.getHeight() + startGame.getHeight() + 50);
		gridSizeBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (GameLogic.boardSize < 18){
					GameLogic.boardSize += 2;
				}else{
					GameLogic.boardSize = 6;
				}
				gridSizeBtn.setText("Grid Width: " + GameLogic.boardSize);
				boolean shipsFit = canShipsFitOnBoard();
				startGame.setEnabled(shipsFit);
				errorMessage.setVisible(!shipsFit);
			}	
		});
	
