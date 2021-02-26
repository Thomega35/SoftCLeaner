import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Interaction {
	
	public static ArrayList<Processus> getApi(){
		ArrayList<Processus> l = new ArrayList<Processus>();
		
		Image disc = null;
		try {
			disc = ImageIO.read(new File("src/Images/Disc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Processus p1 = new Processus("Test","test.exe",new ImageIcon(disc));
		Processus p2 = new Processus("Teams","teams.exe",new ImageIcon(disc));
		Processus p3 = new Processus("Discord","discord.exe",new ImageIcon(disc));
		l.add(p1);
		l.add(p2);
		l.add(p3);
		
		return l;
	}
	
}
