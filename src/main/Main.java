package main;
import java.util.ArrayList;
import javax.swing.*;
import UI.Display;
import interaction.*;

public class Main {

	public static JFrame window;
	public static ArrayList<String> mainProcess;

	public static void main(String[] args) {
		interaction.Processus.loadAdminPic();
		mainProcess = (ArrayList<String>) Interaction.extractMainProcess("./src/ProcessToKill.txt");
		Display.init();
		Display.update();
	}
}