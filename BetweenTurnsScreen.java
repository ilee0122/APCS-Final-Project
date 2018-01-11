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


}