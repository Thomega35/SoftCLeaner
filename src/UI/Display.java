package UI;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import interaction.*;
import main.Main;

@SuppressWarnings("unused")
public class Display {

	private static JPanel BoxMainProcessus = new JPanel();
	private static JPanel BoxOtherProcessus = new JPanel();

	public static void init() {

		// FRAME
		Main.window = new JFrame("SoftCleaner V1.4");
		Main.window.setSize(600, 600);
		Main.window.setLocationRelativeTo(null);
		Main.window.setVisible(true);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Creation composants principaux
		JPanel panneau_principal = new JPanel();
		panneau_principal.setLayout(new BorderLayout());
		Main.window.setContentPane(panneau_principal);

		JPanel BoxAllProcessus = new JPanel();
		BoxAllProcessus.setLayout(new BoxLayout(BoxAllProcessus, BoxLayout.Y_AXIS));
		panneau_principal.add(BoxAllProcessus, BorderLayout.CENTER);

		// Box stockage Processus
		getBoxMainProcessus().setLayout(new BoxLayout(getBoxMainProcessus(), BoxLayout.Y_AXIS));
		JScrollPane mainScroll = new JScrollPane(getBoxMainProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScroll.setBounds(0, 0, 930, 610);
		mainScroll.setPreferredSize(new Dimension(Main.window.getSize().width/2,Main.window.getSize().width/2));

		getBoxOtherProcessus().setLayout(new BoxLayout(getBoxOtherProcessus(), BoxLayout.Y_AXIS));
		JScrollPane otherScroll = new JScrollPane(getBoxOtherProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		otherScroll.setBounds(0, 0, 930, 610);
		otherScroll.setPreferredSize(new Dimension(Main.window.getSize().width/2,Main.window.getSize().width/2));

		
		//Remplissage composant principaux
		BoxAllProcessus.add(mainScroll);
		BoxAllProcessus.add(otherScroll);
		panneau_principal.add(new Label("TODO"), BorderLayout.EAST);
		panneau_principal.add(new Label("TODO"), BorderLayout.WEST);
		Main.window.revalidate();
	}

	public static void setListeProcessus(ArrayList<Processus> listep, JPanel mainp, JPanel otherp) {
		mainp.removeAll();
		otherp.removeAll();
		for (Processus p : listep) {
			BoxProcessus boxp = new BoxProcessus(p);
			if (p.getPath().length() > 0) {
				mainp.add(boxp);
			}else {
				otherp.add(boxp);
			}
		}
		
		mainp.revalidate();
		otherp.revalidate();
		
	}
		
	public static void update() {
		while (true) {
			setListeProcessus(Interaction.getProcessus(),
					// (JPanel) Main.window.getContentPane().getComponent(0)
					Display.getBoxMainProcessus(), Display.getBoxOtherProcessus());
			Main.window.revalidate();
			// TIMER
			try {
				// TODO changer l'update
				Thread.sleep(25000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static JPanel getBoxMainProcessus() {
		return BoxMainProcessus;
	}

	public static void setBoxMainProcessus(JPanel boxMainProcessus) {
		BoxMainProcessus = boxMainProcessus;
	}

	public static JPanel getBoxOtherProcessus() {
		return BoxOtherProcessus;
	}

	public static void setBoxOtherProcessus(JPanel boxOtherProcessus) {
		BoxOtherProcessus = boxOtherProcessus;
	}

}
