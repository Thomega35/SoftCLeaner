import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
		String ligne = null; 
		String[] process = new String[1000];
		int i = 0;
		try {
			@SuppressWarnings("unused")
			BufferedReader pros = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("powershell.exe get-process" ).getInputStream()));
			while (( process[i] = pros.readLine()) != null) { 
		         // ligne contient une ligne de sortie normale ou d'erreur
				System.out.println(process[i]);
				i++;
		    }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[][] processSplit = new String[i][11];
		for (int j = 0;j<i;j++) {
			processSplit[j] = process[j].split(" ");
		}
		for (int j = 0; j<i;j++) {
			for (int J = 0; J< processSplit[j].length;J++) {
				//System.out.print(processSplit[j][J] + " , ");
			}
			//System.out.println();
		}
		return l;
	}
	
}
