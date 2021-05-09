package interaction;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Interaction {
	
	public static ArrayList<Processus> getProcessus() {
//INITIALISATION
		ArrayList<String> liste_vracProcessus = new ArrayList<String>();
		ArrayList<String[]> liste_vracProcessusSplit = new ArrayList<String[]>();
		ArrayList<String[]> liste_Organisee_Processus = new ArrayList<String[]>();
		ArrayList<Processus> liste_objetProcessus = new ArrayList<Processus>();//get-process

//REALISE LA COMMANED POWERSHELL ET RECUPERE LE RESULTAT DANS liste_vracProcessus
		try {
			BufferedReader pros = new BufferedReader(
					new InputStreamReader(Runtime.getRuntime().exec("powershell.exe wmic process get ProcessID,ExecutablePath,name").getInputStream()));
			String s = null;
			while ((s = pros.readLine()) != null){
				liste_vracProcessus.add(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

//DECOUPE LA LISTE liste_vracProcessus POUR AVOIR UNE LISTE DE LISTE liste_vracProcessusSplit
//CONTIENT ENCORE DES ELEMENTS VIDE ET LA LIGNE D'INTRODUCTION
		for (int i = 0; i < liste_vracProcessus.size(); i++) {
			liste_vracProcessusSplit.add(liste_vracProcessus.get(i).split(" \\ +"));// = liste_process[i].split("\\s+");
		}
		
//EPURE LA LISTE POUR N'AVOIR PLUS QUE DES TABLEAUX [CHEMIN/NOM/PID]
//CONTIENT DES DOUBLONS
		for (String[] tab : liste_vracProcessusSplit) {
			if (tab.length > 1 && !tab.equals(liste_vracProcessusSplit.get(0))) {
				liste_Organisee_Processus.add(tab);
			}
		}
		
// Creation des "Processus" rendu (pas de doubles)
		ArrayList<String> name = new ArrayList<>();
		for (String[] s : liste_Organisee_Processus) {
			if (estNouveau(name, s[1])) {
				liste_objetProcessus.add(new Processus(s[1], Arrays.asList(s[2]), s[0]));
				name.add(s[1]);
			}else {
				for (Processus p : liste_objetProcessus) {
					if (p.getName().equals(s[1])) {
						List<String> IDsp = new ArrayList<String>();
						for (String ID : p.getID()) {
							IDsp.add(ID);
						}
						IDsp.add(s[2]);
						p.setID(IDsp);
					}
				}
			}
		}
		return liste_objetProcessus;
	}

	public static boolean estNouveau(ArrayList<String> name, String nouveauMot) {
		for (String s : name) {
			if (nouveauMot.equals(s))
				return false;
		}
		return true;
	}

	public static List<String> extractMainProcess(InputStream inputStream) {
		Scanner scanner = null;
		List<String> res = new ArrayList<String>();
		scanner = new Scanner(inputStream);
		while(scanner.hasNext()){
		     res.add(scanner.nextLine());
		}
		scanner.close();
		return res;
	}
	
	public static void putInFile(String txt) {
	
		String logFile   = "DonnesUser.txt";
	    BufferedWriter logFileWriter;
	    File logFileObj = new File(System.getProperty("user.dir"), logFile);
	    
	    try {
//	    	System.out.println("hello");
//	    	System.out.println(logFileObj);
//	    	System.out.println(new File(System.getProperty("user.dir"), "DonnesUser.txt"));
//	    	System.out.println(new FileWriter(new File(System.getProperty("user.dir"), "DonnesUser.txt")));
	        FileWriter fileWriter = new FileWriter(logFileObj);
	        logFileWriter = new BufferedWriter(fileWriter);
	        logFileWriter.write(txt);
	        logFileWriter.flush();
	        logFileWriter.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

//		PrintWriter myWriter = new PrintWriter(Processus.class.getResourceAsStream("/DonnesUser.txt"));
//		myWriter.write(txt);
//		myWriter.flush();
//		myWriter.close();
	}
	
	public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
	    // Les deux images doivent avoir la même tailles
	    if (imgA.getWidth() == imgB.getWidth() && imgA.getHeight() == imgB.getHeight()) {
	        int width = imgA.getWidth();
	        int height = imgA.getHeight();
	 
	        // Boucle sur chaque pixel de l'image
	        for (int y = 0; y < height; y++) {
	            for (int x = 0; x < width; x++) {
	                // comparaison des deux pixels
	                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
	                    return false;
	                }
	            }
	        }
	    } else {
	        return false;
	    }
	 
	    return true;
	}
	
	//https://docs.microsoft.com/en-us/windows/win32/procthread/process-and-thread-functions#process-enumeration-functions
	//Shell commande in java
	//get-process2130
	//wmic process get ProcessID,ExecutablePath,name
}
