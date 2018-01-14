import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverScreen implements MouseListener{

    private JPanel window;
    private ImageIcon backgroundImageIcon;
    private JLabel bkgImageContainer;

    public GameOverScreen(JFrame app, boolean playerOneWin){
	window = (JPanel)app.getContentPane();
	if (playerOneWin){
	    backgroundImageIcon = new ImageIcon("P1Win.png");
	}else{
	    backgroundImageIcon = new ImageIcon("P2Win.png");
	}
	Image bkgImage = backgroundImageIcon.getImage();
	Image scaledBkgImage = bkgImage.getScaledInstance(window.getWidth(),
							  window.getHeight(), BufferedImage.SCALE_FAST);
	ImageIcon scaledBkgImageIcon = new ImageIcon(scaledBkgImage);


    }

    public void loadEndScreen() {
    
    }


}