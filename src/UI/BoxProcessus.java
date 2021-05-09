package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interaction.*;
import main.Main;

@SuppressWarnings("serial")
public class BoxProcessus extends JPanel {
	
	public BoxProcessus(Processus p) {
		super();
		int hauteurBox = 30;
		int longueurBox = 500;
		String couleurFondBoxP = "#52057b";
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(longueurBox,hauteurBox));
		setBackground(Color.decode("#000000"));
		setOpaque(false);
		
		JPanel boxP = new JPanel();
		boxP.setPreferredSize(new Dimension(longueurBox,hauteurBox));
		boxP.setMinimumSize(new Dimension(longueurBox,hauteurBox));
		boxP.setOpaque(true);
		boxP.setBackground(Color.decode(couleurFondBoxP));//3c415c
		boxP.setLayout(new BorderLayout());
		
		JLabel blocPic = new JLabel();
		Label blocName = new Label(p.getName());
		blocName.setFont(new Font("IntroFont", 1, (int) (hauteurBox/1.5)));
		JButton redButton = new ShutButton();
		
		blocPic.setPreferredSize(new Dimension(p.getPic().getIconHeight(),p.getPic().getIconWidth()));
		blocPic.setIcon(p.getPic());
		blocPic.setOpaque(true);
		blocPic.setBackground(Color.decode(couleurFondBoxP));
		blocName.setForeground(Color.decode("#bc8be8"));//892CDC
		KillImplementation action = new KillImplementation(p.getID());
		redButton.addActionListener(action);
		redButton.setBorderPainted(false);
		redButton.setBackground(Color.decode(couleurFondBoxP));
		redButton.setOpaque(true);
		
		this.add(boxP);
		boxP.add(blocPic, BorderLayout.WEST);
		boxP.add(blocName, BorderLayout.CENTER);
		redButton.setPreferredSize(new Dimension((int) boxP.getPreferredSize().getHeight(), (int) boxP.getPreferredSize().getHeight()));
		boxP.add(redButton, BorderLayout.EAST);
	}
}