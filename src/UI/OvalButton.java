package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OvalButton extends JButton {
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5168808778729080775L;
	private Color startColor = Color.decode("#3c415c");//delet
	private Color endColor = Color.decode("#301B3F");
	private Color rollOverColor = Color.decode("#892CDC");//#301B3F
	private Color pressedColor = Color.decode("#BC6FF1");
	private GradientPaint GP;
 
	/**
         * Constructor takes String argument
         * @param text
         */
	public OvalButton(String text) {
		super();
		setText(text);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFont(new Font("Thoma", Font.BOLD, 12));
		setForeground(Color.WHITE);
		setFocusable(false);
 
	}
 
	/**
         * 
         * @param startColor
         * @param endColor
         * @param rollOverColor
         * @param pressedColor
         */
	public OvalButton(Color startColor, Color endColor,
			Color rollOverColor, Color pressedColor) {
		super();
		this.startColor = startColor;
		this.endColor = endColor;
		this.rollOverColor = rollOverColor;
		this.pressedColor = pressedColor;
		setForeground(Color.WHITE);
		setFocusable(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
 
	/**
         * 
         */
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		int h = getHeight();
		int w = getWidth();
		ButtonModel model = getModel();
 
		if (!model.isEnabled()) {
			setForeground(Color.GRAY);
			GP = new GradientPaint(0, 0, new Color(192,192,192), 0, h, new Color(192,192,192),
					true);
		}else{
			setForeground(Color.WHITE);
			if (model.isRollover()) {
				GP = new GradientPaint(0, 0, rollOverColor, 0, h, rollOverColor,
						true);
 
			} else {
				GP = new GradientPaint(0, 0, startColor, 0, h, endColor, true);
			}
		}
		g2d.setPaint(GP);
		GradientPaint p1;
		GradientPaint p2;
 
		if (model.isPressed()) {
			GP = new GradientPaint(0, 0, pressedColor, 0, h, pressedColor, true);
			g2d.setPaint(GP);
			p1 = new GradientPaint(0, 0, new Color(0, 0, 0), 0, h - 1,
					new Color(100, 100, 100));
			p2 = new GradientPaint(0, 1, new Color(0, 0, 0, 50), 0, h - 3,
					new Color(255, 255, 255, 100));
		} else {
			p1 = new GradientPaint(0, 0, new Color(100, 100, 100), 0, h - 1,
					new Color(0, 0, 0));
			p2 = new GradientPaint(0, 1, new Color(255, 255, 255, 100), 0,
					h - 3, new Color(0, 0, 0, 50));
			GP = new GradientPaint(0, 0, startColor, 0, h, endColor, true);
		}
 
		Ellipse2D.Float r2d = new Ellipse2D.Float(0, 0, w - 1,
				h - 1);
		Shape clip = g2d.getClip();
		g2d.clip(r2d);
		g2d.fillOval(0, 0, w, h);
		g2d.setClip(clip);
		g2d.setPaint(p1);
		g2d.drawOval(0, 0, w - 1, h - 1);
		g2d.setPaint(p2);
		g2d.drawOval(1, 1, w - 3, h - 3);
		g2d.dispose();
 
		super.paintComponent(g);
	}
	public JPanel getButtonsPanel(){
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		OvalButton standardButton = new OvalButton("Test");
		standardButton.setPreferredSize(new Dimension(130, 130));
 
		panel.add(standardButton);
		return panel;
 
	}
}