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
import javax.swing.border.EmptyBorder;

import interaction.*;
import main.Main;
import type.Conseille;
import type.Secondaire;
import type.Systeme;

@SuppressWarnings("unused")
public class Display {

	private static JPanel BoxMainProcessus = new JPanel();
	private static JPanel BoxOtherProcessus = new JPanel();
	private static JPanel BoxAdviseProcessus = new JPanel();

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
		panneau_principal.setBackground(Color.decode("#52057b"));

		JPanel BoxAllProcessus = new JPanel();
		BoxAllProcessus.setLayout(new BoxLayout(BoxAllProcessus, BoxLayout.Y_AXIS));
		BoxAllProcessus.setBackground(Color.decode("#000000")); //USELESS 
		panneau_principal.add(BoxAllProcessus, BorderLayout.CENTER);

// Box stockage Processus
		int n = 1;
		//BOXAINPROCESSUS
		getBoxMainProcessus().setLayout(new BoxLayout(getBoxMainProcessus(), BoxLayout.Y_AXIS));
		JScrollPane mainScroll = new JScrollPane(getBoxMainProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScroll.setBounds(0, 0, 930, 610);
		mainScroll.setPreferredSize(new Dimension(Main.window.getSize().width/n,Main.window.getSize().width/n));
		getBoxMainProcessus().setBackground(Color.decode("#000000")); 
		mainScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//BOXOTHERPROCESSUS
		getBoxOtherProcessus().setLayout(new BoxLayout(getBoxOtherProcessus(), BoxLayout.Y_AXIS));
		JScrollPane otherScroll = new JScrollPane(getBoxOtherProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		otherScroll.setBounds(0, 0, 930, 610);
		otherScroll.setPreferredSize(new Dimension(Main.window.getSize().width/n,Main.window.getSize().width/n));
		getBoxOtherProcessus().setBackground(Color.decode("#000000"));
		otherScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//BOWADVISEPROCESSUS
		getBoxAdviseProcessus().setLayout(new BoxLayout(getBoxAdviseProcessus(), BoxLayout.Y_AXIS));
		JScrollPane AdviseScroll = new JScrollPane(getBoxAdviseProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		AdviseScroll.setBounds(0, 0, 930, 610);
		AdviseScroll.setPreferredSize(new Dimension(Main.window.getSize().width,Main.window.getSize().width));
		getBoxAdviseProcessus().setBackground(Color.decode("#000000"));
		AdviseScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//TODO
		Label todo1 = new Label("TODO");
		todo1.setForeground(Color.decode("#000000"));
		
		//TODO
		Label todo2 = new Label("TODO");
		todo2.setForeground(Color.decode("#000000"));
		
		//Remplissage du composant principal
		BoxAllProcessus.add(AdviseScroll);
		//BoxAllProcessus.add(mainScroll);
		//BoxAllProcessus.add(otherScroll);
//		panneau_principal.add(todo1, BorderLayout.EAST);
//		panneau_principal.add(todo2, BorderLayout.WEST);
		Main.window.revalidate();
	}

	public static void setListeProcessus(ArrayList<Processus> listep, JPanel mainp, JPanel otherp, JPanel advisep) {
		
		mainp.removeAll();
		otherp.removeAll();
		advisep.removeAll();
		
		for (Processus p : listep) {
			BoxProcessus boxp = new BoxProcessus(p);
			if (p.getType().getClass() == new Systeme().getClass()) {
				otherp.add(boxp);
			}else if (p.getType().getClass() == new Secondaire().getClass()){
				mainp.add(boxp);
			}else if (p.getType().getClass() == new Conseille().getClass()){
				advisep.add(boxp);
			}
		}
		
		mainp.revalidate();
		otherp.revalidate();
		advisep.revalidate();
	}
	
	public static void update() {
		while (true) {
			for(Processus p :Interaction.getProcessus()) {
				System.out.println(p);
			}
			
			setListeProcessus(Interaction.getProcessus(),
					// (JPanel) Main.window.getContentPane().getComponent(0)
					getBoxMainProcessus(), getBoxOtherProcessus(), getBoxAdviseProcessus());
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
	public static JPanel getBoxAdviseProcessus() {
		return BoxAdviseProcessus;
	}
	public static void setBoxAdviseProcessus(JPanel boxAdviseProcessus) {
		BoxAdviseProcessus = boxAdviseProcessus;
	}
}
