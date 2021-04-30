package UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import interaction.*;

@SuppressWarnings("serial")
public class BoxProcessus extends JPanel {
		
	public BoxProcessus(Processus p) {
		super();
		int hauteurbox = 30;
		setLayout(new FlowLayout());
		setPreferredSize(new Dimension(300,hauteurbox));
		setBackground(Color.decode("#000000"));
		setOpaque(true);
		
		JPanel boxP = new JPanel();
		boxP.setLayout(new BorderLayout());
		
		JLabel blocPic = new JLabel(p.getPic());
		Label blocName = new Label(p.getName());
		JButton redButton = new ShutButton();
		
		blocPic.setPreferredSize(new Dimension(40,hauteurbox+12));
		blocName.setForeground(Color.decode("#bc8be8"));//892CDC
		KillImplementation action = new KillImplementation(p.getID());
		redButton.addActionListener(action);
		redButton.setBorderPainted(false);
		
		this.add(boxP);
		boxP.setPreferredSize(new Dimension(300,30));
		boxP.setBackground(Color.decode("#52057b"));//3c415c
		boxP.add(blocPic, BorderLayout.WEST);
		boxP.add(blocName, BorderLayout.CENTER);
		boxP.add(redButton, BorderLayout.EAST);
	}
}










