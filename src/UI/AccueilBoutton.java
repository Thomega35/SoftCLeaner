package UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ButtonModel;
import javax.swing.JButton;
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
        //Main.window.setMinimumSize(new Dimension((int) Main.window.getMinimumSize().getWidth(),Main.window.getWidth()/2));
        try {
			BufferedImage recyr = ImageIO.read(AccueilBoutton.class.getResource("/Images/Recycling_symbol.png"));
			BufferedImage recy = ImageIO.read(AccueilBoutton.class.getResource("/Images/Recycling_symbol_pressed.png"));
			BufferedImage recyp = ImageIO.read(AccueilBoutton.class.getResource("/Images/Recycling_symbol_rollover.png"));
			BufferedImage sd = ImageIO.read(AccueilBoutton.class.getResource("/Images/Shut_down.png"));
			BufferedImage pm = ImageIO.read(AccueilBoutton.class.getResource("/Images/Engrenage.png"));
			BufferedImage us = ImageIO.read(AccueilBoutton.class.getResource("/Images/User.png"));
			recy = ShutButton.resizeImage(recy, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			recyp = ShutButton.resizeImage(recyp, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			recyr = ShutButton.resizeImage(recyr, (int) getPreferredSize().getHeight()/4, (int)getPreferredSize().getHeight()/4);
			ButtonModel model = getModel();
			if (!model.isPressed()) {
				if (!model.isRollover()) {
					g.drawImage(recy, Main.window.getWidth()/2-recy.getHeight()/2, 10, null);
				}else {
					g.drawImage(recyr, Main.window.getWidth()/2-recy.getHeight()/2, 10, null);
				}
			}else {
				g.drawImage(recyp, Main.window.getWidth()/2-recy.getHeight()/2, 10, null);
			}
			Font init = g.getFont();
			
			g.setColor(Color.decode("#892CDC"));
			Font intro = new Font("IntroFont", 1,  Main.window.getWidth()/47);
			Font pb = new Font("pb", 2, Main.window.getWidth()/35);
			g.setFont(intro);
			FontMetrics metricsIntro = g.getFontMetrics(intro);
			FontMetrics metricsInit = g.getFontMetrics(init);
			FontMetrics metricsPb = g.getFontMetrics(pb);
			
			String text1 = "Bienvenue,";
			String text2 = "Vous pouvez voir ici les différents logiciels fonctionnant sur votre machine.";
			String text3 = "SoftCleaner© vous permet de réduire leur nombre sans risque.";
			String text4 = "Pour cela, appuyez sur l'icône       à côté du processus recommandé.";
			String text5 = "Vous pouvez aussi voir vos informations dans       .";
			String text6 = "Où aller sur       pour voir la liste de logiciels complémentaires. (UTILISATEURS EXPERIMENTÉS)";
			
			sd = ShutButton.resizeImage(sd, metricsIntro.getHeight(), metricsIntro.getHeight());
			pm = ShutButton.resizeImage(pm, metricsIntro.getHeight(), metricsIntro.getHeight());
			us = ShutButton.resizeImage(us, metricsIntro.getHeight(), metricsIntro.getHeight());
			
			g.drawString(text1,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text1)/2), recy.getHeight()+15);
			g.drawString(text2,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text2)/2), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-4*metricsIntro.getHeight()));
			g.drawString(text3,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text3)/2), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-3*metricsIntro.getHeight()));
			g.drawString(text4,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text4)/2), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-2*metricsIntro.getHeight()));
			int adv = metricsIntro.stringWidth("Pour cela, appuyez sur l'icône ");
			g.drawImage(sd, (int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text4)/2 + adv), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-2.75*metricsIntro.getHeight()), null);
			g.drawString(text5,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text5)/2), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-metricsIntro.getHeight()));
			adv = metricsIntro.stringWidth("Vous pouvez aussi voir vos informations dans ");
			g.drawImage(us,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text5)/2 + adv), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-1.75*metricsIntro.getHeight()), null);
			g.drawString(text6,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text6)/2), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())));
			adv = metricsIntro.stringWidth("Où aller sur ");
			g.drawImage(pm, (int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text6)/2 + adv), (int) (Main.window.getHeight()-40-3*(metricsInit.getHeight())-0.75*metricsIntro.getHeight()), null);
			
			g.setColor(Color.gray);
			g.setFont(init);
			
			//System.out.println(metricsInit);
			g.drawString("SoftCleaner©", (int) (Main.window.getWidth()/2-metricsInit.stringWidth("SoftCleaner©")/2), (int) (Main.window.getHeight()-40-2*(metricsInit.getHeight())));
			g.drawString("Groupe DELAPART Thomas & BESNARD Valentin & DAVID Corentin", (int) (Main.window.getWidth()/2-metricsInit.stringWidth("Groupe DELAPART Thomas & BESNARD Valentin & DAVID Corentin")/2), (int) (Main.window.getHeight()-42.5-(metricsInit.getHeight())));
			g.drawString("Developpeur : DELAPART Thomas", (int) (Main.window.getWidth()/2-metricsInit.stringWidth("Developpeur : DELAPART Thomas")/2), (int) (Main.window.getHeight()-45));
			
			
			g.setColor(Color.decode("#B547E5"));
			g.setFont(pb);
			String text7 = "Comment réduire la consommation énergétique de votre ordinateur ?";
			String text8 = "La consommation d'énergie de votre ordinateur dépend";
			String text9 = "majoritairement du nombre de logiciels dont il doit s'occuper.";
			String text10 = "Vous pouvez donc réduire votre facture d'éléctricité, tout en augmentant";
			String text11 = "drastiquement la longévité de vos batteries, en réduisant leur nombre.";
			String text12 = "Un objectif de 5 arrêts de logiciel est souhaitable à chaque utilisation";
			
			double freeSpace = (Main.window.getHeight()-40-3*(metricsInit.getHeight())-4*metricsIntro.getHeight())-(recy.getHeight()+15+6*metricsIntro.getHeight()+1*metricsPb.getHeight());			
			g.drawString(text7,(int) (Main.window.getWidth()/2-metricsPb.stringWidth(text7)/2), recy.getHeight()+15+1*metricsPb.getHeight());
			g.setColor(Color.decode("#bc8be8"));
			g.setFont(intro);
			g.drawString(text8,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text8)/2), (int) (recy.getHeight()+15+1*metricsIntro.getHeight()+1*metricsPb.getHeight()+freeSpace/5));
			g.drawString(text9,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text9)/2), (int) (recy.getHeight()+15+2*metricsIntro.getHeight()+1*metricsPb.getHeight()+freeSpace/5*2));
			g.drawString(text10,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text10)/2), (int) (recy.getHeight()+15+3*metricsIntro.getHeight()+1*metricsPb.getHeight()+freeSpace/5*3));
			g.drawString(text11,(int) (Main.window.getWidth()/2-metricsIntro.stringWidth(text11)/2), (int) (recy.getHeight()+15+4*metricsIntro.getHeight()+1*metricsPb.getHeight()+freeSpace/5*4));
			g.setColor(Color.decode("#B547E5"));
			g.setFont(new Font("IntroFont", 1,  Main.window.getWidth()/40));
			FontMetrics metricsobj= g.getFontMetrics(new Font("IntroFont", 1,  Main.window.getWidth()/40));
			g.drawString(text12,(int) (Main.window.getWidth()/2-metricsobj.stringWidth(text12)/2), (int) (recy.getHeight()+15+4*metricsIntro.getHeight()+1*metricsobj.getHeight()+1*metricsPb.getHeight()+freeSpace));
			
			//System.out.println();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
