import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BetweenTurnsScreen implements MouseListener{
   
    private JPanel window;
    private ImageIcon backgroundImageIcon;
    private JLabel bkgImageContainer;
    private volatile boolean isImageVisible;
    private Grid grid;
    private SmallGrid small;

    public BetweenTurnsScreen(JPanel theWindow, Grid grid, SmallGrid small){
	window = theWindow;
	backgroundImageIcon = new ImageIcon("NextTurn.png");
	Image bkgImage = backgroundImageIcon.getImage();
	Image scaledBkgImage = bkgImage.getScaledInstance(window.getWidth(),
							  window.getHeight(), BufferedImage.SCALE_FAST);
	ImageIcon scaledBkgImageIcon = new ImageIcon(scaledBkgImage);
	bkgImageContainer = new JLabel(scaledBkgImageIcon);
	bkgImageContainer.setSize(window.getWidth(), 
				  window.getHeight());
	bkgImageContainer.setLocation(0, 0); 
	isImageVisible = true;
	this.grid = grid;
	this.small = small;
    }
}