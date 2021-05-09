package main;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import UI.Display;
import interaction.*;

public class Main {

	public static JFrame window;
	public static ArrayList<String> mainProcess = new ArrayList<String>();
	public static ArrayList<String> data = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		interaction.Processus.loadAdminPic();
		mainProcess = (ArrayList<String>) Interaction.extractMainProcesStream(Processus.class.getResourceAsStream("/ProcessToKill.txt"));
	    Display.init();
	   	Display.update();
	}
}