package interaction;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import UI.Display;
import main.Main;

import java.awt.event.*;

public class KillImplementation implements ActionListener{
	
	ArrayList<String> PID;
	
	@Override
	public void actionPerformed(ActionEvent action) {
		try {
			for (String s : PID) {
				Runtime.getRuntime().exec("powershell.exe taskkill /F /PID " + s);
				System.out.println("powershell.exe taskkill /F /PID " + s);
			}
		} catch (IOException exeption) {
			exeption.printStackTrace();
		}
		Display.setListeProcessus(Interaction.getProcessus(),
				//(JPanel) Main.window.getContentPane().getComponent(0)
				Display.getBoxMainProcessus(), Display.getBoxOtherProcessus(), Display.getBoxAdviseProcessus());
		Display.addObjectif();
		Main.data =  new ArrayList<String>(Arrays.asList(Main.data.get(0), ((Integer.parseInt(Main.data.get(1),10)+1))+""));
		Interaction.putInFile(Main.data.get(0) + "\n" + Main.data.get(1));
		Display.setInfo();
	}
	
	public KillImplementation (java.util.List<String> list) {
		
		this.PID = new ArrayList<String>(list);
	}

}
