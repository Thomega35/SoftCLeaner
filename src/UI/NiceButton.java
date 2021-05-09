package UI;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NiceButton extends JButton{
	
	private static final long serialVersionUID = -4920404834458477119L;
	Image im;
	Image rolOver;
	Image pressed;
	
	public NiceButton(Image im, Image rolOver, Image pressed) {
		super();
		this.im = im;
		this.rolOver = rolOver;
		this.pressed = pressed;
		setIcon(new ImageIcon(im));
	}
	
	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponent(g);
		ButtonModel model = getModel();
		Image im = this.im.getScaledInstance((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), Image.SCALE_DEFAULT);
		Image rolOver = this.rolOver.getScaledInstance((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), Image.SCALE_DEFAULT);
		Image pressed = this.pressed.getScaledInstance((int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight(), Image.SCALE_DEFAULT);
		if (!model.isPressed()) {
			if (!model.isRollover()) {
				g.drawImage(im, 0, 0, null);
			}else {
				g.drawImage(rolOver, 0, 0, null);
			}
		}else {
			g.drawImage(pressed, 0, 0, null);
		}
	}

}
