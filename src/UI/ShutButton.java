package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class ShutButton extends JButton {
	 
	private static final long serialVersionUID = -5168808778729080775L;
	/**
         * Constructor takes String argument
         */
	public ShutButton() {
		super();
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFont(new Font("Thoma", Font.BOLD, 12));
		setForeground(Color.WHITE);
		setBackground(Color.decode("#892CDC"));
		setFocusable(false);
		setPreferredSize(new Dimension(21, 21));
		setFocusPainted(true); // On n'affiche pas l'effet de focus.
//		try {
//			BufferedImage sdp = ImageIO.read(new File("src/Images/Shut_down_pressed.png"));
//			BufferedImage sd = ImageIO.read(new File("src/Images/Shut_down.png"));
//			//sd = resizeImage(sd, 20, 20);
//			setIcon(new ImageIcon(sdp));
//			//ImageIO.write((RenderedImage) sd, "png", new File("src/Images/Shut_down.png"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
 
	/**
         * 
         */
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			BufferedImage sd = ImageIO.read(new File("src/Images/Shut_down.png"));
			BufferedImage sdp = ImageIO.read(new File("src/Images/Shut_down_pressed.png"));
			BufferedImage sdr = ImageIO.read(new File("src/Images/Shut_down_rollover.png"));
			sd = resizeImage(sd, 20, 20);
			sdp = resizeImage(sdp, 20, 20);
			sdr = resizeImage(sdr, 20, 20);
			ButtonModel model = getModel();
			if (!model.isPressed()) {
				if (!model.isRollover()) {
					g.drawImage(sd, 1, 1, null);
				}else {
					g.drawImage(sdr, 1, 1, null);
				}
			}else {
				g.drawImage(sdp, 1, 1, null);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = resizedImage.createGraphics();
	    graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
	    graphics2D.dispose();
	    return resizedImage;
	}
}