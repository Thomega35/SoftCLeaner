import java.awt.BorderLayout;
import java.awt.Button;
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
	
	public static void init() {
		
		//FRAME 
		Main.window = new JFrame("Boite de Dialogue");
		Main.window.setSize(400,210);
		Main.window.setLocationRelativeTo(null);
		Main.window.setVisible(true);
		
		//Creation Panels
		JPanel panneau_principal = new JPanel();
		panneau_principal.setLayout(new BorderLayout()); 
		Main.window.setContentPane(panneau_principal);

		//ICON BOUTON
//		Image disc = null;
//		try {
//			disc = ImageIO.read(new File("src/Images/Disc.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//PROCESSUS
		JPanel BoxAllProcessus = new JPanel();
		BoxAllProcessus.setLayout(new BoxLayout(BoxAllProcessus, BoxLayout.Y_AXIS));
		
//		BoxAllProcessus.add(new BoxProcessus("Test","", new ImageIcon(disc)));
//		BoxAllProcessus.add(new BoxProcessus("Test","", new ImageIcon(disc)));
//		BoxAllProcessus.add(new BoxProcessus("Test","", new ImageIcon(disc)));
//		BoxAllProcessus.add(new BoxProcessus("Test","", new ImageIcon(disc)));
		
		panneau_principal.add(BoxAllProcessus, BorderLayout.CENTER);
		//((JPanel)Main.window.getContentPane().getComponent(0)).add(new JLabel("Hello"));;
		panneau_principal.add(new Label("TODO"), BorderLayout.EAST);
		panneau_principal.add(new Label("TODO"), BorderLayout.WEST);

	}
	
	public static void setListeProcessus(ArrayList<Processus> listep, JPanel pane) {
		pane.removeAll();		
		for(Processus p : listep) {
			pane.add(new BoxProcessus(p));		
		}
		pane.revalidate();
		//TIMER
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void update() {
		while(true) {
			setListeProcessus(Interaction.getApi(),(JPanel) Main.window.getContentPane().getComponent(0));
		}
	}

}
