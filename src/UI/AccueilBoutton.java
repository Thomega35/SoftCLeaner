package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JLabel;

import main.Main;

public class AccueilBoutton extends JButton{
	
	private static final long serialVersionUID = -7235304740089713344L;

	public AccueilBoutton() {
		super();
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFont(new Font("Thoma", Font.BOLD, 12));
		setBackground(Color.decode("#892CDC"));
		setFocusable(false);
		setPreferredSize(new Dimension(Main.window.getWidth(), Main.window.getHeight()));
		setFocusPainted(true); // On n'affiche pas l'effet de focus.
	}
	
	public void paintComponent(Graphics g) {
		setPreferredSize(new Dimension(Main.window.getWidth(), Main.window.getHeight()));
        super.paintComponent(g);
        try {
			BufferedImage recyr = ImageIO.read(new File("src/Images/Recycling_symbol.png"));
			BufferedImage recy = ImageIO.read(new File("src/Images/Recycling_symbol_pressed.png"));
			BufferedImage recyp = ImageIO.read(new File("src/Images/Recycling_symbol_rollover.png"));
			BufferedImage sd = ImageIO.read(new File("src/Images/Shut_down.png"));
			BufferedImage pm = ImageIO.read(new File("src/Images/Engrenage.png"));
			BufferedImage us = ImageIO.read(new File("src/Images/User.png"));
			recy = ShutButton.resizeImage(recy, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			recyp = ShutButton.resizeImage(recyp, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			recyr = ShutButton.resizeImage(recyr, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			sd = ShutButton.resizeImage(sd, 30, 30);
			pm = ShutButton.resizeImage(pm, 30, 30);
			us = ShutButton.resizeImage(us, 30, 30);
			ButtonModel model = getModel();
			if (!model.isPressed()) {
				if (!model.isRollover()) {
					g.drawImage(recy, Main.window.getWidth()/2-recy.getHeight()/2, Main.window.getHeight()/4-recy.getHeight()/2, null);
				}else {
					g.drawImage(recyr, Main.window.getWidth()/2-recy.getHeight()/2, Main.window.getHeight()/4-recy.getHeight()/2, null);
				}
			}else {
				g.drawImage(recyp, Main.window.getWidth()/2-recy.getHeight()/2, Main.window.getHeight()/4-recy.getHeight()/2, null);
			}
			String text1 = "Bienvenue,";
			String text2 = "Vous pouvez voir ici les différents logiciels fonctionnant sur votre machine.";
			String text3 = "SoftCleaner vous permet de réduire leur nombre sans risque.";
			String text4 = "Pour cela, appuyez sur l'icône         à côté du processus recommandé.";
			String text5 = "Vous pouvez aussi voir vos informations dans         .";
			String text6 = "Où aller sur         pour voir la liste de logiciels complémentaires. (UTILISATEURS EXPERIMENTÉS)";
			JLabel consigne1 = new JLabel(text1);
			JLabel consigne2 = new JLabel(text2);
			JLabel consigne3 = new JLabel(text3);
			JLabel consigne4 = new JLabel(text4);
			JLabel consigne5 = new JLabel(text5);
			JLabel consigne6 = new JLabel(text6);
			Font init = g.getFont();
			g.setColor(Color.decode("#892CDC"));
			int n = 16;
			int m = 12;
			g.setFont(new Font("IntroFont", 1,n));
			g.drawString(text1,(int) (Main.window.getWidth()/2-consigne1.getPreferredSize().getWidth()/22*n), Main.window.getHeight()/4+recy.getHeight()/2+10);
			g.drawString(text2,(int) (Main.window.getWidth()/2-consigne2.getPreferredSize().getWidth()/22*n), (int) (Main.window.getHeight()/4+recy.getHeight()/2+10 + 2*2*(consigne1.getPreferredSize().getHeight())));
			g.drawString(text3,(int) (Main.window.getWidth()/2-consigne3.getPreferredSize().getWidth()/22*n), (int) (Main.window.getHeight()/4+recy.getHeight()/2+10 + 3*2*(consigne1.getPreferredSize().getHeight())));
			g.drawString(text4,(int) (Main.window.getWidth()/2-consigne4.getPreferredSize().getWidth()/22*n), (int) (Main.window.getHeight()/4+recy.getHeight()/2+10 + 4*2*(consigne1.getPreferredSize().getHeight())));
			g.drawImage(sd, Main.window.getWidth()/2-47, (int) (Main.window.getHeight()/4+recy.getHeight()/2 + 4*2*(consigne1.getPreferredSize().getHeight()))-11, null);
			g.drawString(text5,(int) (Main.window.getWidth()/2-consigne5.getPreferredSize().getWidth()/22*n), (int) (Main.window.getHeight()/4+recy.getHeight()/2+10 + 5*2*(consigne1.getPreferredSize().getHeight())));
			g.drawImage(us, Main.window.getWidth()/2+160, (int) (Main.window.getHeight()/4+recy.getHeight()/2 + 5*2*(consigne1.getPreferredSize().getHeight()))-10, null);
			g.drawString(text6,(int) (Main.window.getWidth()/2-consigne6.getPreferredSize().getWidth()/22*n), (int) (Main.window.getHeight()/4+recy.getHeight()/2+10 + 6*2*(consigne1.getPreferredSize().getHeight())));
			g.drawImage(pm, Main.window.getWidth()/2-297, (int) (Main.window.getHeight()/4+recy.getHeight()/2 + 6*2*(consigne1.getPreferredSize().getHeight()))-10, null);
			
			g.setColor(Color.gray);
			g.setFont(init);
			JLabel name = new JLabel("SoftCleaner©");
			JLabel groupe = new JLabel("Groupe DELAPART Thomas & BESNARD Valentin & DAVID Corentin");
			JLabel dev = new JLabel("Devellopeur : DELAPART Thomas");
			//System.out.println(name.getPreferredSize());
			g.drawString("SoftCleaner©", (int) (Main.window.getWidth()/2-name.getPreferredSize().getWidth()/22*m), (int) (Main.window.getHeight()-40-2*(name.getPreferredSize().getHeight())));
			g.drawString("Groupe DELAPART Thomas & BESNARD Valentin & DAVID Corentin", (int) (Main.window.getWidth()/2-groupe.getPreferredSize().getWidth()/22*m), (int) (Main.window.getHeight()-40-(groupe.getPreferredSize().getHeight())));
			g.drawString("Developpeur : DELAPART Thomas", (int) (Main.window.getWidth()/2-dev.getPreferredSize().getWidth()/22*m), (int) (Main.window.getHeight()-40));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
