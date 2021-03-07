import java.util.ArrayList;
import javax.swing.*;

public class Main {
	
	public static JFrame window;
	public static ArrayList<String> mainProcess;
	
	public static void main(String[] args) {
		mainProcess = (ArrayList<String>) Interaction.extractMainProcess("./src/ProcessToKill.txt");
		Display.init();
		Display.update();	
	}

}
