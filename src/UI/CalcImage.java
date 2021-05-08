package UI;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class CalcImage {
	
	public static BufferedImage iconToBuff(ImageIcon icon) {
		Image image = icon.getImage();
	
	    BufferedImage bimage = new BufferedImage(image.getWidth(null), image
	        .getHeight(null), BufferedImage.TYPE_INT_RGB);
	
	    Graphics2D g = bimage.createGraphics();
	    g.drawImage(image, 0, 0, null);
	    g.dispose();
	    return bimage;
	}
}
