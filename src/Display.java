import javax.swing.*;

public class Display {
	
	public static void init() {
		Main.window = new JFrame("Boite de Dialogue");
		Main.window.setSize(1000,500);
		ImageIcon img = new ImageIcon("src/Images/pp_cat.png");
		JButton bouton = new JButton("Cliquez-moi",img);
	    JButton b2 =new JButton("Mon bouton");
		JPanel panneau = new JPanel();
		panneau.add(bouton);
		Main.window.setContentPane(panneau);
	    Main.window.getContentPane().add(b2);

	}
	
	public static void update() {
		Main.window.setVisible(true);
	}
//https://www.jmdoudoux.fr/java/dej/chap-swing.htm
}
