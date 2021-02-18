import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.*;

public class Display {
	
	public static void init() {
		Main.window = new JFrame("Boite de Dialogue");
		Main.window.setSize(1000,500);
		ImageIcon fingerIco = new ImageIcon("src/Images/u_put_the_finger_on_it.jpg");
		Image finger = fingerIco.getImage().getScaledInstance( 100, 100,  java.awt.Image.SCALE_SMOOTH ) ;
		fingerIco = new ImageIcon(finger);
		JButton bouton = new JButton("Cliquez-moi",fingerIco);
		bouton.setPreferredSize(new Dimension(100, 100));
	    JButton b2 =new JButton("Mon bouton");
	    JButton b3 =new JButton("TEst");
		JPanel panneau = new JPanel();
		JPanel panneau_interieur = new JPanel();
		panneau.add(bouton);
		Main.window.setContentPane(panneau);
	    Main.window.getContentPane().add(b2);
	    panneau.add(b3);
	    panneau.add(panneau_interieur);
		Main.window.setVisible(true);
	}
	
	public static void update() {
		Main.window.getContentPane();
		ArrayList<String[]> res = Interaction.getApi();
		
	}
//https://www.jmdoudoux.fr/java/dej/chap-swing.htm
}
