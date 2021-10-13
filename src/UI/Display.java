package UI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.sound.midi.VoiceStatus;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interaction.*;
import main.Main;
import type.Conseille;
import type.Secondaire;
import type.Systeme;
import java.lang.*;

@SuppressWarnings("unused")
public class Display {

	private static JPanel boxMainProcessus = new JPanel();
	private static JPanel boxOtherProcessus = new JPanel();
	private static JPanel boxAdviseProcessus = new JPanel();

	private static JPanel PageAccueil = new JPanel();
	private static JPanel PagePrincipal = new JPanel();
	private static JPanel PageUtilisateur = new JPanel();
	private static JPanel PageParametre = new JPanel();
	private static JPanel bar = new JPanel();

	private static JProgressBar objectif;
	private static Font pb;
	private static JLabel nbProcNow;

	private static JLabel info1;
	private static JLabel info2;
	private static JLabel info3;

	private static void buildWindow() {
		Main.window = new MainFrame("SoftCleaner V1.5");
		Main.window.setSize(950, 700);
		Main.window.setMinimumSize(new Dimension(870, 600));
		Main.window.setLocationRelativeTo(null);
		Main.window.setVisible(true);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			Main.window.setIconImage(ImageIO.read(Processus.class.getResource("/Images/Recycling_symbol.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void buildPagePrincipal(int buttonSize) throws IOException {
		PagePrincipal.setLayout(new BorderLayout());
		PagePrincipal.setBackground(Color.decode("#52057b"));
//Image 
		// .getScaledInstance((int) help.getPreferredSize().getWidth(), (int)
		// help.getPreferredSize().getHeight(), Image.SCALE_DEFAULT))
		Image helpim = ImageIO.read(Processus.class.getResource("/Images/Help.png"));
		Image helpimRol = ImageIO.read(Processus.class.getResource("/Images/HelpRolover.png"));
		Image helpimPre = ImageIO.read(Processus.class.getResource("/Images/HelpPressed.png"));

		Image refreshim = ImageIO.read(Processus.class.getResource("/Images/Refresh.png"));
		Image refreshimRol = ImageIO.read(Processus.class.getResource("/Images/RefreshRolover.png"));
		Image refreshimPre = ImageIO.read(Processus.class.getResource("/Images/RefreshPressed.png"));

		Image parametreim = ImageIO.read(Processus.class.getResource("/Images/Engrenage.png"));
		Image parametreimRol = ImageIO.read(Processus.class.getResource("/Images/EngrenageRolover.png"));
		Image parametreimPre = ImageIO.read(Processus.class.getResource("/Images/EngrenagePressed.png"));

		Image utilisateurim = ImageIO.read(Processus.class.getResource("/Images/User.png"));
		Image utilisateurimRol = ImageIO.read(Processus.class.getResource("/Images/UserRolover.png"));
		Image utilisateurimPre = ImageIO.read(Processus.class.getResource("/Images/UserPressed.png"));

		JPanel headingPrincipal = new JPanel();
		headingPrincipal.setLayout(new BorderLayout());
		headingPrincipal.setBackground(Color.black);
		headingPrincipal.setBorder(new EmptyBorder(0, 0, 0, 0));

		JPanel barandadvise = new JPanel();
		barandadvise.setLayout(new BorderLayout());
		barandadvise.setBackground(Color.ORANGE);
		barandadvise.setBorder(new EmptyBorder(0, 0, 0, 0));

		bar.setLayout(new FlowLayout());
		bar.setBackground(Color.black);

		JLabel infoBar = new JLabel("Objectif session 5 Processus : ");
		infoBar.setFont(pb);
		infoBar.setForeground(Color.decode("#bc8be8"));

		UIManager.put("ProgressBar.background", Color.decode("#52057b"));
		UIManager.put("ProgressBar.foreground", Color.decode("#bc8be8"));
		UIManager.put("ProgressBar.selectionBackground", Color.decode("#bc8be8"));// 5C236D
		UIManager.put("ProgressBar.selectionForeground", Color.decode("#52057b"));

		objectif = new JProgressBar(SwingConstants.HORIZONTAL, 0, 5);
		objectif.setIndeterminate(false);
		objectif.setStringPainted(true);
		objectif.setBorder(new EmptyBorder(0, 0, 0, 0));

		JPanel raccourcis = new JPanel();
		raccourcis.setLayout(new BoxLayout(raccourcis, BoxLayout.X_AXIS));
		raccourcis.setBorder(new EmptyBorder(0, 0, 0, 0));
		raccourcis.setOpaque(false);

		JButton parametre = new NiceButton(parametreim, parametreimRol, parametreimPre);
		parametre.setBorder(new EmptyBorder(0, 0, 0, 0));
		parametre.setOpaque(false);
		parametre.setPreferredSize(new Dimension(buttonSize, buttonSize));
		parametre.setSize(new Dimension(buttonSize, buttonSize));
		parametre.setBackground(Color.black);
		parametre.setFocusable(false);
		parametre.addActionListener(new switchWindow(PageParametre));

		JButton utilisateur = new NiceButton(utilisateurim, utilisateurimRol, utilisateurimPre);
		utilisateur.setOpaque(false);
		utilisateur.setBorder(new EmptyBorder(0, 0, 0, 0));
		utilisateur.setPreferredSize(new Dimension(buttonSize, buttonSize));
		utilisateur.setSize(utilisateur.getPreferredSize());
		utilisateur.setBackground(Color.black);
		utilisateur.setFocusable(false);
		utilisateur.addActionListener(new switchWindow(PageUtilisateur));

		JButton refresh = new NiceButton(refreshim, refreshimRol, refreshimPre);
		refresh.setOpaque(false);
		refresh.setBorder(new EmptyBorder(0, 0, 0, 0));
		refresh.setPreferredSize(new Dimension(buttonSize, buttonSize));
		refresh.setBackground(Color.black);
		refresh.setFocusable(false);
		refresh.addActionListener(new RefreshAction());

		JButton help = new NiceButton(helpim, helpimRol, helpimPre);
		help.setOpaque(false);
		help.setBorder(new EmptyBorder(0, 0, 0, 0));
		help.setPreferredSize(new Dimension(buttonSize, buttonSize));
		help.setBackground(Color.black);
		help.setFocusable(false);
		help.addActionListener(new switchWindow(PageAccueil));

		nbProcNow = new JLabel("Vous avez " + Interaction.getProcessus().size() + " processus en route :");
		nbProcNow.setFont(pb);
		nbProcNow.setForeground(Color.decode("#bc8be8"));

//BOXADVISEPROCESSUS
		getBoxAdviseProcessus().setLayout(new BoxLayout(getBoxAdviseProcessus(), BoxLayout.Y_AXIS));
		JScrollPane AdviseScroll = new JScrollPane(getBoxAdviseProcessus(),
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		AdviseScroll.setPreferredSize(new Dimension(Main.window.getSize().width,
				Main.window.getSize().height - headingPrincipal.getHeight()));
		getBoxAdviseProcessus().setBackground(Color.decode("#000000"));
		bar.setBorder(new EmptyBorder(0, 0, 0, 0));
		bar.setBackground(Color.black);
		AdviseScroll.setBorder(new EmptyBorder(0, 0, 0, 0));

		headingPrincipal.add(raccourcis, BorderLayout.EAST);
		headingPrincipal.add(nbProcNow, BorderLayout.WEST);
		raccourcis.add(help);
		raccourcis.add(voidSpacer(5, buttonSize));
		raccourcis.add(refresh);
		raccourcis.add(voidSpacer(5, buttonSize));
		raccourcis.add(parametre);
		raccourcis.add(voidSpacer(5, buttonSize));
		raccourcis.add(utilisateur);
		PagePrincipal.add(headingPrincipal, BorderLayout.NORTH);
		barandadvise.add(AdviseScroll, BorderLayout.CENTER);
		barandadvise.add(bar, BorderLayout.NORTH);
		bar.add(infoBar);
		bar.add(objectif);
		PagePrincipal.add(barandadvise, BorderLayout.CENTER);
	}

	private static void buildPageParametre(int buttonSize) throws IOException {

		Image arrowim = ImageIO.read(Processus.class.getResource("/Images/Arrow.png"));
		Image arrowimRol = ImageIO.read(Processus.class.getResource("/Images/ArrowRolover.png"));
		Image arrowimPre = ImageIO.read(Processus.class.getResource("/Images/ArrowPressed.png"));

		PageParametre.setLayout(new BorderLayout());
		PageParametre.setBackground(Color.decode("#000000"));

		JPanel mainBorder = new JPanel();
		mainBorder.setLayout(new BorderLayout());
		mainBorder.setBackground(Color.black);

//		JPanel midPara = new JPanel();
//		midPara.setLayout(new BorderLayout());
//		midPara.setBackground(Color.black);
//		midPara.setPreferredSize(new Dimension(buttonSize, buttonSize));

		JButton retour2 = new NiceButton(arrowim, arrowimRol, arrowimPre);
		retour2.setPreferredSize(new Dimension(buttonSize, buttonSize));
		retour2.setBorder(new EmptyBorder(0, 0, 0, 0));
		retour2.setOpaque(false);
		retour2.setBackground(Color.black);
		retour2.setFocusable(false);
		retour2.addActionListener(new switchWindow(PagePrincipal));
		retour2.setMaximumSize(new Dimension(buttonSize, buttonSize));

		JLabel head = new JLabel("Autres processus principaux (Non Sécurisé) :");
		head.setFont(pb);
		head.setForeground(Color.decode("#bc8be8"));

		JLabel mid = new JLabel("Processus systems : ");
		mid.setFont(pb);
		mid.setForeground(Color.decode("#bc8be8"));

		// mainBorder.add(retour2, BorderLayout.WEST);
		mainBorder.add(retour2, BorderLayout.WEST);

		// midPara.add(voidSpacer(buttonSize, buttonSize), BorderLayout.WEST);
		JPanel BoxAllProcessus = new JPanel();
		BoxAllProcessus.setLayout(new BoxLayout(BoxAllProcessus, BoxLayout.Y_AXIS));
		BoxAllProcessus.setBackground(Color.black);

// Box stockage Processus
		int n = 2;
		// BOXAINPROCESSUS
		getBoxMainProcessus().setLayout(new BoxLayout(getBoxMainProcessus(), BoxLayout.Y_AXIS));
		JScrollPane mainScroll = new JScrollPane(getBoxMainProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScroll.setPreferredSize(new Dimension(Main.window.getSize().width / n, Main.window.getSize().width / n));
		getBoxMainProcessus().setBackground(Color.decode("#000000"));
		mainScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		mainScroll.setWheelScrollingEnabled(true);
		mainScroll.getVerticalScrollBar().setUnitIncrement(10);
		mainScroll.addMouseWheelListener(null);

		// BOXOTHERPROCESSUS
		getBoxOtherProcessus().setLayout(new BoxLayout(getBoxOtherProcessus(), BoxLayout.Y_AXIS));
		JScrollPane otherScroll = new JScrollPane(getBoxOtherProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		otherScroll.setPreferredSize(new Dimension(Main.window.getSize().width / n, Main.window.getSize().width / n));
		getBoxOtherProcessus().setBackground(Color.decode("#000000"));
		otherScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		otherScroll.setWheelScrollingEnabled(true);
		otherScroll.getVerticalScrollBar().setUnitIncrement(5);

		// Parametre
		// BoxAllProcessus.add(mainBorder);

		BoxAllProcessus.add(head);
		BoxAllProcessus.add(mainScroll);
		BoxAllProcessus.add(mid);
		BoxAllProcessus.add(otherScroll);
		mainBorder.add(BoxAllProcessus, BorderLayout.CENTER);
		PageParametre.add(mainBorder);
	}

	private static void buildPageUtilisateur(int buttonSize) throws IOException {
		PageUtilisateur.setLayout(new BorderLayout());
		PageUtilisateur.setBackground(Color.decode("#000000"));

		Image arrowim = ImageIO.read(Processus.class.getResource("/Images/Arrow.png"));
		Image arrowimRol = ImageIO.read(Processus.class.getResource("/Images/ArrowRolover.png"));
		Image arrowimPre = ImageIO.read(Processus.class.getResource("/Images/ArrowPressed.png"));

		JPanel headingUtili = new JPanel();
		headingUtili.setLayout(new BorderLayout());
		headingUtili.setBackground(Color.black);
		headingUtili.setPreferredSize(new Dimension(buttonSize, buttonSize));

		JButton retour2 = new NiceButton(arrowim, arrowimRol, arrowimPre);
		retour2.setBorder(new EmptyBorder(0, 0, 0, 0));
		retour2.setOpaque(false);
		retour2.setPreferredSize(new Dimension(buttonSize, buttonSize));
		retour2.setBackground(Color.black);
		retour2.setFocusable(false);
		retour2.addActionListener(new switchWindow(PagePrincipal));

		Font para = new java.awt.Font("Calibri", 0, 25);

		JLabel paraTitle = new JLabel("Information Utilisateur :");
		paraTitle.setFont(pb);
		paraTitle.setForeground(Color.decode("#bc8be8"));

		JPanel infoUtili = new JPanel();
		infoUtili.setLayout(new BoxLayout(infoUtili, BoxLayout.Y_AXIS));
		infoUtili.setOpaque(false);

		info1 = new JLabel("Nombre de lancement de l'application : " + Main.data.get(0));
		info1.setForeground(Color.decode("#bc8be8"));
		info1.setPreferredSize(new Dimension(50, 50));
		info1.setFont(para);
		info1.setAlignmentX(Component.CENTER_ALIGNMENT);

		info2 = new JLabel("Nombre de processus arrêtés grâce à l'application : " + Main.data.get(1));
		info2.setForeground(Color.decode("#bc8be8"));
		info2.setPreferredSize(new Dimension(50, 50));
		info2.setFont(para);
		info2.setAlignmentX(Component.CENTER_ALIGNMENT);

		double rap = Double.parseDouble(Main.data.get(1)) / Double.parseDouble(Main.data.get(0));
		info3 = new JLabel("Nombre de logiciels arrétés par utilisation : " + rap);
		info3.setForeground(Color.decode("#bc8be8"));
		info3.setPreferredSize(new Dimension(50, 50));
		info3.setFont(para);
		info3.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel info4 = new JLabel("Mode plein écran : OFF");
		info4.setForeground(Color.decode("#bc8be8"));
		info4.setPreferredSize(new Dimension(20, 50));
		info4.setFont(para);
		info4.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel info5 = new JLabel("Taille des différents composants : 12");
		info5.setForeground(Color.decode("#bc8be8"));
		info5.setPreferredSize(new Dimension(20, 50));
		info5.setFont(para);
		info5.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel info6 = new JLabel("Langue Utilisé : Français");
		info6.setForeground(Color.decode("#bc8be8"));
		info6.setPreferredSize(new Dimension(20, 50));
		info6.setFont(para);
		info6.setAlignmentX(Component.CENTER_ALIGNMENT);

		JLabel info7 = new JLabel("Version Beta : NON");
		info7.setForeground(Color.decode("#bc8be8"));
		info7.setPreferredSize(new Dimension(20, 50));
		info7.setFont(para);
		info7.setAlignmentX(Component.CENTER_ALIGNMENT);

		infoUtili.add(info1);
		// infoUtili.add(voidSpacer(20, 10));
		infoUtili.add(info2);
		infoUtili.add(info3);
		infoUtili.add(Box.createVerticalGlue());
//		infoUtili.add(voidSpacer(20, 10));
//		infoUtili.add(info3);
//		infoUtili.add(voidSpacer(20, 10));
//		infoUtili.add(info4);
//		infoUtili.add(voidSpacer(20, 10));
//		infoUtili.add(info5);
//		infoUtili.add(voidSpacer(20, 10));
//		infoUtili.add(info6);
//		infoUtili.add(voidSpacer(20, 10));
//		infoUtili.add(info7);

		headingUtili.add(retour2, BorderLayout.WEST);
		headingUtili.add(paraTitle, BorderLayout.CENTER);
		PageUtilisateur.add(headingUtili, BorderLayout.NORTH);
		PageUtilisateur.add(infoUtili, BorderLayout.CENTER);
	}

	public static void setInfo() {
		info1.setText("Nombre de processus arrêtés grâce à l'application : " + Main.data.get(0));
		info2.setText("Nombre de lancement de l'application : " + Main.data.get(1));
		double rap = Integer.parseInt(Main.data.get(1)) / Integer.parseInt(Main.data.get(0));
		info3.setText("Nombre de logiciels arrétés par utilisation : " + rap);
	}

	public static void init() throws IOException {

// FRAME
		buildWindow();
		Main.window.setContentPane(PageAccueil);

//Donnes User //nb lancement application //nb fermeture procvessus (//nb fermeture moyenne)
		// REMPLISSAGE DE DATA
		//System.out.println(Processus.class.getResourceAsStream("/DonnesUser.txt"));
		InputStream path = Processus.class.getResourceAsStream("/DonnesUser.txt");
		File logFileObj = new File(System.getProperty("user.dir"), "DonnesUser.txt");
		if (logFileObj.canRead()) {
			Main.data = (ArrayList<String>) Interaction
					.extractMainProcessFile(logFileObj);
			// SI PAS DE FILE ON EN FABRIQUE UN
		} else {
			Interaction.putInFile("");
		}
		// INITALISATION DATA SELON CONTENU
		if (Main.data.size() == 0) {
			Interaction.putInFile("0\n0");
			Main.data = (ArrayList<String>) Interaction
					.extractMainProcessFile(logFileObj); // nb lancement
																									// application //nb
																									// fermeture
																									// procvessus (//nb
																									// fermeture
																									// moyenne)
		} else {
			Interaction.putInFile(Main.data.get(0) + "\n" + Main.data.get(1));
		}
		// nb lancement application ++
		Main.data = new ArrayList<>(Arrays.asList((Integer.parseInt(Main.data.get(0), 10) + 1) + "", Main.data.get(1)));
		Interaction.putInFile(Main.data.get(0) + "\n" + Main.data.get(1));
//	    System.out.println(Main.data.get(0));
//	    System.out.println(Main.data.get(1));
//	    System.out.println(Main.data);

		// myWriter.write(Main.data.get(0));

		// Creation PagePrincipal
		int buttonSize = Main.window.getWidth() / 15;
		pb = new Font("pb", 1, Main.window.getWidth() / 35);

		try {
			buildPagePrincipal(buttonSize);
			buildPageParametre(buttonSize);
			buildPageUtilisateur(buttonSize);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PageAccueil.setLayout(new BorderLayout());
		PageAccueil.setBackground(Color.decode("#000000"));

		AccueilBoutton accueilBoutton = new AccueilBoutton();
		accueilBoutton.addActionListener(new switchWindow(PagePrincipal));

		PageAccueil.add(accueilBoutton);

		Main.window.revalidate();
	}

	public static void setListeProcessus(ArrayList<Processus> listep, JPanel mainp, JPanel otherp, JPanel advisep) {

		mainp.removeAll();
		otherp.removeAll();
		advisep.removeAll();

		for (Processus p : listep) {
			BoxProcessus boxp = new BoxProcessus(p);
			if (p.getType().getClass() == new Systeme().getClass()) {
				otherp.add(boxp);
			} else if (p.getType().getClass() == new Secondaire().getClass()) {
				mainp.add(boxp);
			} else if (p.getType().getClass() == new Conseille().getClass()) {
				advisep.add(boxp);
			}
		}

		mainp.revalidate();
		otherp.revalidate();
		advisep.revalidate();
	}

	public static void update() {
		ArrayList<Processus> listp = Interaction.getProcessus();
		setListeProcessus(listp, getBoxMainProcessus(), getBoxOtherProcessus(), getBoxAdviseProcessus());
		Main.window.revalidate();
		Main.window.repaint();
		nbProcNow.setText("Vous avez " + listp.size() + " processus en route :");

		// TIMER
//		try {
//			// TO-DO changer l'update
//			Thread.sleep(25000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	public static JPanel getBoxMainProcessus() {
		return boxMainProcessus;
	}

	public static void setBoxMainProcessus(JPanel boxMainProcessu) {
		boxMainProcessus = boxMainProcessu;
	}

	public static JPanel getBoxOtherProcessus() {
		return boxOtherProcessus;
	}

	public static void setBoxOtherProcessus(JPanel boxOtherProcessu) {
		boxOtherProcessus = boxOtherProcessu;
	}

	public static JPanel getBoxAdviseProcessus() {
		return boxAdviseProcessus;
	}

	public static void setBoxAdviseProcessus(JPanel boxAdviseProcessu) {
		boxAdviseProcessus = boxAdviseProcessu;
	}

	public static JProgressBar getObjectif() {
		return objectif;
	}

	public static void addObjectif() {
		objectif.setValue(getObjectif().getValue() + 1);
		if (getObjectif().getValue() >= 5 && bar.getComponentCount() < 3) {
			JLabel gg = new JLabel("Beau travail");
			gg.setFont(pb);
			gg.setForeground(Color.decode("#bc8be8"));
			bar.add(gg);
		}
	}

	public static JPanel voidSpacer(int width, int height) {
		JPanel result = new JPanel();
		result.setPreferredSize(new Dimension(width, height));
		result.setOpaque(false);
		return result;
	}
}
