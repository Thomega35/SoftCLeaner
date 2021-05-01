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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.sound.midi.VoiceStatus;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import interaction.*;
import main.Main;
import type.Conseille;
import type.Secondaire;
import type.Systeme;

@SuppressWarnings("unused")
public class Display {

	private static JPanel boxMainProcessus = new JPanel();
	private static JPanel boxOtherProcessus = new JPanel();
	private static JPanel boxAdviseProcessus = new JPanel();

	private static JPanel PageAccueil = new JPanel();
	private static JPanel PagePrincipal = new JPanel();
	private static JPanel PageUtilisateur = new JPanel();
	private static JPanel PageParametre = new JPanel();
	
	public static void init() {

// FRAME
		Main.window = new JFrame("SoftCleaner V1.5");
		Main.window.setSize(950, 700);
		Main.window.setMinimumSize(new Dimension(870,550));
		Main.window.setLocationRelativeTo(null);
		Main.window.setVisible(true);
		Main.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			Main.window.setIconImage(ImageIO.read(new File("src/Images/Recycling_symbol.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Main.window.setContentPane(PageAccueil);

// Creation PagePrincipal
		PagePrincipal.setLayout(new BorderLayout());
		PagePrincipal.setBackground(Color.decode("#52057b"));
		
		JPanel headingPrincipal = new JPanel();
		headingPrincipal.setLayout(new BorderLayout());
		headingPrincipal.setBackground(Color.black);
		
		JPanel raccourcis = new JPanel();
		raccourcis.setLayout(new BoxLayout(raccourcis, BoxLayout.X_AXIS));
		raccourcis.setBorder(new EmptyBorder(0, 0, 0, 0));
		raccourcis.setOpaque(false);
		
		JButton parametre = new JButton();
		parametre.setBorder(new EmptyBorder(0, 0, 0, 0));
		parametre.setOpaque(false);
		parametre.setPreferredSize(new Dimension(30,30));
		parametre.setBackground(Color.black);
		parametre.setFocusable(false);
		parametre.addActionListener(new switchWindow(PageParametre));
		
		JButton utilisateur = new JButton();
		utilisateur.setOpaque(false);
		utilisateur.setBorder(new EmptyBorder(0, 0, 0, 0));
		utilisateur.setPreferredSize(new Dimension(30,30));
		utilisateur.setBackground(Color.black);
		utilisateur.setFocusable(false);
		utilisateur.addActionListener(new switchWindow(PageUtilisateur));
		
		JButton refresh = new JButton();
		refresh.setOpaque(false);
		refresh.setBorder(new EmptyBorder(0, 0, 0, 0));
		refresh.setPreferredSize(new Dimension(30,30));
		refresh.setBackground(Color.black);
		refresh.setFocusable(false);
		refresh.addActionListener(new RefreshAction());
		
		JButton help = new JButton();
		help.setOpaque(false);
		help.setBorder(new EmptyBorder(0, 0, 0, 0));
		help.setPreferredSize(new Dimension(30,30));
		help.setBackground(Color.black);
		help.setFocusable(false);
		help.addActionListener(new switchWindow(PageAccueil));
		
		try {
			help.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/Help.png")).getScaledInstance((int) help.getPreferredSize().getWidth(), (int) help.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
			refresh.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/Refresh.png")).getScaledInstance((int) refresh.getPreferredSize().getWidth(), (int) refresh.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
			parametre.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/Engrenage.png")).getScaledInstance((int) parametre.getPreferredSize().getWidth(), (int) parametre.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
			utilisateur.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/User.png")).getScaledInstance((int) utilisateur.getPreferredSize().getWidth(), (int) utilisateur.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel nbProcNow = new JLabel("Vous avez actuellement " + Interaction.getProcessus().size() + " processus en route :");
		nbProcNow.setForeground(Color.decode("#bc8be8"));
		
//Creation PageParametre
		PageParametre.setLayout(new BorderLayout());
		PageParametre.setBackground(Color.decode("#000000"));
		
		JPanel headingPara = new JPanel();
		headingPara.setLayout(new BorderLayout());
		headingPara.setBackground(Color.black);
		headingPara.setPreferredSize(new Dimension(30,30));
		
		JPanel midPara = new JPanel();
		midPara.setLayout(new BorderLayout());
		midPara.setBackground(Color.black);
		midPara.setPreferredSize(new Dimension(30,30));
		
		JButton retour = new JButton();
		retour.setBorder(new EmptyBorder(0, 0, 0, 0));
		retour.setOpaque(false);
		retour.setPreferredSize(new Dimension(30,30));
		retour.setBackground(Color.black);
		retour.setFocusable(false);
		retour.addActionListener(new switchWindow(PagePrincipal));
		try {
			retour.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/Arrow.png")).getScaledInstance((int) retour.getPreferredSize().getWidth(), (int) retour.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JLabel head = new JLabel("Autres processus principaux : (UTILISATEURS EXPERIMENTÉS)");
		head.setForeground(Color.decode("#bc8be8"));
		
		JLabel mid = new JLabel("Processus systems : ");
		mid.setForeground(Color.decode("#bc8be8"));
		
		headingPara.add(retour, BorderLayout.WEST);
		headingPara.add(head, BorderLayout.CENTER);

		midPara.add(mid, BorderLayout.CENTER);
		midPara.add(voidSpacer(new Dimension(30,30)), BorderLayout.WEST);
		JPanel BoxAllProcessus = new JPanel();
		BoxAllProcessus.setLayout(new BoxLayout(BoxAllProcessus, BoxLayout.Y_AXIS));
		BoxAllProcessus.setBackground(Color.decode("#000000")); //USELESS 

//Creation PageUtilisateur
		PageUtilisateur.setLayout(new BorderLayout());
		PageUtilisateur.setBackground(Color.decode("#000000"));
		
		JPanel headingUtili = new JPanel();
		headingUtili.setLayout(new BorderLayout());
		headingUtili.setBackground(Color.black);
		headingUtili.setPreferredSize(new Dimension(30,30));
		
		JButton retour2 = new JButton();
		retour2.setBorder(new EmptyBorder(0, 0, 0, 0));
		retour2.setOpaque(false);
		retour2.setPreferredSize(new Dimension(30,30));
		retour2.setBackground(Color.black);
		retour2.setFocusable(false);
		retour2.addActionListener(new switchWindow(PagePrincipal));
		try {
			retour2.setIcon(new ImageIcon(ImageIO.read(new File("src/Images/Arrow.png")).getScaledInstance((int) retour2.getPreferredSize().getWidth(), (int) retour2.getPreferredSize().getHeight(), Image.SCALE_DEFAULT)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Font para = new java.awt.Font("Calibri", 0, 25);
		
		JLabel paraTitle = new JLabel("Information Utilisateur :                                                                                                                     ");
		paraTitle.setForeground(Color.decode("#bc8be8"));
		
		JPanel infoUtili = new JPanel();
		infoUtili.setLayout(new BoxLayout(infoUtili, BoxLayout.Y_AXIS));
		infoUtili.setOpaque(false);
		
		JLabel info1 = new JLabel("Nombre de processus arrêtés grâce à l'application : 35");
		info1.setForeground(Color.decode("#bc8be8"));
		info1.setPreferredSize(new Dimension(50,50));
		info1.setFont(para);
		info1.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info2 = new JLabel("Nombre de lancement de l'application : 4");
		info2.setForeground(Color.decode("#bc8be8"));
		info2.setPreferredSize(new Dimension(50,50));
		info2.setFont(para);
		info2.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info3 = new JLabel("Theme de couleur utilisé : Deep Purple");
		info3.setForeground(Color.decode("#bc8be8"));
		info3.setPreferredSize(new Dimension(50,50));
		info3.setFont(para);
		info3.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info4 = new JLabel("Mode plein écran : OFF");
		info4.setForeground(Color.decode("#bc8be8"));
		info4.setPreferredSize(new Dimension(20,50));
		info4.setFont(para);
		info4.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info5 = new JLabel("Taille des fifférents composants : 12");
		info5.setForeground(Color.decode("#bc8be8"));
		info5.setPreferredSize(new Dimension(20,50));
		info5.setFont(para);
		info5.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info6 = new JLabel("Langue Utilisé : Français");
		info6.setForeground(Color.decode("#bc8be8"));
		info6.setPreferredSize(new Dimension(20,50));
		info6.setFont(para);
		info6.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JLabel info7 = new JLabel("Version Beta : NON");
		info7.setForeground(Color.decode("#bc8be8"));
		info7.setPreferredSize(new Dimension(20,50));
		info7.setFont(para);
		info7.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		infoUtili.add(info1);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info2);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info3);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info4);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info5);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info6);
		infoUtili.add(voidSpacer(new Dimension(20,10)));
		infoUtili.add(info7);
		
		headingUtili.add(retour2, BorderLayout.WEST);
		headingUtili.add(paraTitle, BorderLayout.CENTER);
		PageUtilisateur.add(headingUtili, BorderLayout.NORTH);
		PageUtilisateur.add(infoUtili, BorderLayout.CENTER);

//Creation PageAccueil
		PageAccueil.setLayout(new BorderLayout());
		PageAccueil.setBackground(Color.decode("#000000"));
		
		AccueilBoutton accueilBoutton = new AccueilBoutton();
		accueilBoutton.addActionListener(new switchWindow(PagePrincipal));
		
		PageAccueil.add(accueilBoutton);
		
// Box stockage Processus
		int n = 2;
		//BOXAINPROCESSUS
		getBoxMainProcessus().setLayout(new BoxLayout(getBoxMainProcessus(), BoxLayout.Y_AXIS));
		JScrollPane mainScroll = new JScrollPane(getBoxMainProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainScroll.setBounds(0, 0, 930, 610);
		mainScroll.setPreferredSize(new Dimension(Main.window.getSize().width/n,Main.window.getSize().width/n));
		getBoxMainProcessus().setBackground(Color.decode("#000000")); 
		mainScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//BOXOTHERPROCESSUS
		getBoxOtherProcessus().setLayout(new BoxLayout(getBoxOtherProcessus(), BoxLayout.Y_AXIS));
		JScrollPane otherScroll = new JScrollPane(getBoxOtherProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		otherScroll.setBounds(0, 0, 930, 610);
		otherScroll.setPreferredSize(new Dimension(Main.window.getSize().width/n,Main.window.getSize().width/n));
		getBoxOtherProcessus().setBackground(Color.decode("#000000"));
		otherScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//BOWADVISEPROCESSUS
		getBoxAdviseProcessus().setLayout(new BoxLayout(getBoxAdviseProcessus(), BoxLayout.Y_AXIS));
		JScrollPane AdviseScroll = new JScrollPane(getBoxAdviseProcessus(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		AdviseScroll.setBounds(0, 0, 930, 610);
		AdviseScroll.setPreferredSize(new Dimension(Main.window.getSize().width,Main.window.getSize().width));
		getBoxAdviseProcessus().setBackground(Color.decode("#000000"));
		AdviseScroll.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		//Remplissage des 4composants principaux
		//BoxAllProcessus.add(AdviseScroll);
			//Parametre
		BoxAllProcessus.add(headingPara);
		BoxAllProcessus.add(mainScroll);
		BoxAllProcessus.add(midPara);
		BoxAllProcessus.add(otherScroll);
		PageParametre.add(BoxAllProcessus);
			//principal
		headingPrincipal.add(raccourcis, BorderLayout.EAST);
		headingPrincipal.add(nbProcNow, BorderLayout.WEST);
		raccourcis.add(help);
		raccourcis.add(voidSpacer(new Dimension(5,30)));
		raccourcis.add(refresh);
		raccourcis.add(voidSpacer(new Dimension(5,30)));
		raccourcis.add(parametre);
		raccourcis.add(voidSpacer(new Dimension(5,30)));
		raccourcis.add(utilisateur);
		PagePrincipal.add(headingPrincipal, BorderLayout.NORTH);
		PagePrincipal.add(AdviseScroll, BorderLayout.CENTER);
		
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
			}else if (p.getType().getClass() == new Secondaire().getClass()){
				mainp.add(boxp);
			}else if (p.getType().getClass() == new Conseille().getClass()){
				advisep.add(boxp);
			}
		}
		
		mainp.revalidate();
		otherp.revalidate();
		advisep.revalidate();
	}
	
	public static void update() {
		setListeProcessus(Interaction.getProcessus(),
				// (JPanel) Main.window.getContentPane().getComponent(0)
				getBoxMainProcessus(), getBoxOtherProcessus(), getBoxAdviseProcessus());
		Main.window.revalidate();
		
		// TIMER
//		try {
//			// TODO changer l'update
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
	
	public static JPanel voidSpacer(Dimension d) {
		JPanel result = new JPanel();
		result.setPreferredSize(d);
		result.setOpaque(false);
		return result;
	}
}
