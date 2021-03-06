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

@SuppressWarnings("unused")
public class Display {
	static JPanel BoxMainProcessus = new JPanel();
	static JPanel BoxOtherProcessus = new JPanel();
	public static void init() {
		
		//FRAME 
		Main.window = new JFrame("SoftCleaner V1.3");
		Main.window.setSize(400,210);
		Main.window.setLocationRelativeTo(null);
		Main.window.setVisible(true);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Creation Panels
		JPanel panneau_principal = new JPanel();
		panneau_principal.setLayout(new BorderLayout()); 
		Main.window.setContentPane(panneau_principal);
		
		//PROCESSUS
		BoxMainProcessus.setLayout(new BoxLayout(BoxMainProcessus, BoxLayout.Y_AXIS));		
		JScrollPane scroll = new JScrollPane(BoxMainProcessus, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, 0, 930, 610);
        
		BoxOtherProcessus.setLayout(new BoxLayout(BoxOtherProcessus, BoxLayout.Y_AXIS));
        

		//panneau_principal.add(scroll, BorderLayout.SOUTH);
		panneau_principal.add(scroll, BorderLayout.CENTER);
		//panneau_principal
		panneau_principal.add(new Label("TODO"), BorderLayout.EAST);
		panneau_principal.add(new Label("TODO"), BorderLayout.WEST);

	}
	
	public static void setListeProcessus(ArrayList<Processus> listep, JPanel pane) {
		pane.removeAll();		
		for(Processus p : listep) {
			if (p.name.equals("chrome")) {
				pane.add(new BoxProcessus(p));		
			}
		}
		for(Processus p : listep) {
			if (!p.name.equals("chrome")) {
				pane.add(new BoxProcessus(p));		
			}
		}
		pane.revalidate();
		//TIMER
		try {
			//TODO changer l'update
			Thread.sleep(25000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		while(true) {
			setListeProcessus(Interaction.getApi(),
					//(JPanel) Main.window.getContentPane().getComponent(0)
					Display.BoxMainProcessus);
		}
	}

}
