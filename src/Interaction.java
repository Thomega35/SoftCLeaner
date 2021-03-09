import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Interaction {

	public static ArrayList<Processus> getApi() {
//INITIALISATION
		ArrayList<Processus> listRes = new ArrayList<Processus>();
		String[] liste_process = new String[1000];
		int nb_processus = 0;

//IMAGE DISCORD
		Image disc = null;
		try {
			disc = ImageIO.read(new File("src/Images/Disc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ImageIcon discIC = new ImageIcon(disc);

//COMMANDE GET-PROCESS STOCKE DANS process[]
		try {
			BufferedReader pros = new BufferedReader(
					new InputStreamReader(Runtime.getRuntime().exec("powershell.exe get-process").getInputStream()));
			while ((liste_process[nb_processus] = pros.readLine()) != null) {
				nb_processus++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		// process[] split dans processSplit[][]
		String[][] processSplit = new String[nb_processus][11];
		for (int i = 0; i < nb_processus; i++) {
			processSplit[i] = liste_process[i].split("\\s+");
		}

		// Creation des "Processus" rendu (pas de doubles)
		String[][] nameID = new String[nb_processus - 5][2];
		for (int i = 3; i < nameID.length + 3; i++) {
			if (processSplit[i].length - 3 >= 0) {
				nameID[i - 3][0] = processSplit[i][processSplit[i].length - 1];
				nameID[i - 3][1] = processSplit[i][processSplit[i].length - 3];
			}
		}
		Map<String, List<String>> map = tabToMap(nameID);
		for (Map.Entry<String, List<String>> process : map.entrySet()) {
			listRes.add(new Processus(process.getKey(), (ArrayList<String>) (process.getValue()), discIC));
		}
		return listRes;
	}

	public static boolean estNouveau(String[] tabExistant, String nouveauMot) {
		for (int index = 0; index < tabExistant.length; index++) {
			if (nouveauMot.equals(tabExistant[index]))
				return false;
		}
		return true;
	}

	public static Map<String, List<String>> tabToMap(String[][] input) {
		Map<String, List<String>> output = new HashMap<String, List<String>>();
		for (String[] strings : input) {
			String nom = strings[0];
			String id = strings[1];

			if (!output.containsKey(nom))
				output.put(nom, new ArrayList<String>() {/**
					 * 
					 */
					private static final long serialVersionUID = 473430190386781733L;

				{
						this.add(id);
					}});
			else
				output.get(nom).add(id);
		}
		return output;
	}

	public static List<String> extractMainProcess(String file) {
		Scanner scanner = null;
		List<String> res = new ArrayList<String>();
		try {
			scanner = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(scanner.hasNext()){
		     res.add(scanner.nextLine());
		}
		return res;
	}
	
	//https://docs.microsoft.com/en-us/windows/win32/procthread/process-and-thread-functions#process-enumeration-functions
	//Shell commande in java
	//get-process2130
	
}
