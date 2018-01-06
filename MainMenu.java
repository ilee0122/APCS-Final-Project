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
