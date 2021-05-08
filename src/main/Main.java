package main;
import java.util.ArrayList;
import javax.swing.*;
import UI.Display;
import interaction.*;

public class Main {

	public static JFrame window;
	public static ArrayList<String> mainProcess;
	public static ArrayList<String> data;

	public static void main(String[] args) {
		interaction.Processus.loadAdminPic();
		mainProcess = (ArrayList<String>) Interaction.extractMainProcess("./src/ProcessToKill.txt");
		data = (ArrayList<String>) Interaction.extractMainProcess("./src/DonnesUser.txt"); //nb lancement application //nb fermeture procvessus (//nb fermeture moyenne)
		Display.init();
		Display.update();
	}
}