import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.*;

public class KillImplementation implements ActionListener{
	
	ArrayList<String> PID;
	
	public void actionPerformed(ActionEvent action) {
		try {
			for (String s : PID) {
				Runtime.getRuntime().exec("powershell.exe taskkill /F /PID " + s);
				System.out.println("powershell.exe taskkill /F /PID " + s);
			}
		} catch (IOException exeption) {
			exeption.printStackTrace();
		}
		Display.setListeProcessus(Interaction.getApi(),
				//(JPanel) Main.window.getContentPane().getComponent(0)
				Display.BoxMainProcessus, Display.BoxOtherProcessus);
	}
	
	public KillImplementation (ArrayList<String> PID) {
		this.PID = PID;
	}

}
