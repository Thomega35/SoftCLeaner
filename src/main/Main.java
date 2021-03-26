package main;
import java.util.ArrayList;
import javax.swing.*;
//
import UI.Display;
import interaction.*;
//import com.sun.jna.Native;
//import com.sun.jna.win32.W32APIOptions;
//import com.sun.jna.platform.win32.User32;
//import com.sun.jna.platform.win32.WinDef;
//import com.sun.jna.platform.win32.WinDef.HICON;
//import com.sun.jna.win32.*;
//import sun.awt.shell.*;
//import com.sun.jna.Native;
//import com.sun.jna.Pointer;
//import com.sun.jna.platform.win32.WinDef.HWND;
//import com.sun.jna.platform.win32.WinGDI;
//import com.sun.jna.ptr.PointerByReference;
//import java.awt.GridLayout;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.util.Vector;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.WindowConstants;
//import java.io.*;
//import javax.swing.*;

public class Main {
	
	public static JFrame window;
	public static ArrayList<String> mainProcess;
	
	public static void main(String[] args) {
		mainProcess = (ArrayList<String>) Interaction.extractMainProcess("./src/ProcessToKill.txt");
		Display.init();
		Display.update();	
	}

//	private static void ExtractAssociatedIconEx(){
//		final WinGDI.ICONINFO iconinfo = new WinGDI.ICONINFO();
//		HICON hIcon1 = null ; 
//		
//		User32.INSTANCE.GetIconInfo(new WinDef.HICON(hIcon1.getPointer()), iconinfo);
//		// Get metadata and create an icon
//		sun.awt.shell.ShellFolder sf =
//		        sun.awt.shell.ShellFolder.getShellFolder(file);
//		Icon icon = new ImageIcon(sf.getIcon(true));
//		
//	}
}









