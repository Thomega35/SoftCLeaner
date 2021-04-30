package UI;
import java.awt.Color;
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
		this.setLayout(new FlowLayout());
		JLabel blocPic = new JLabel(p.getPic());
		
		Label blocName = new Label(p.getName());
		blocName.setForeground(Color.decode("#892CDC"));
		
		JButton redButton = new OvalButton("CLOSE");
		KillImplementation action = new KillImplementation(p.getID());
		redButton.addActionListener(action);
		redButton.setBackground(Color.decode("#031163"));
		redButton.setBorderPainted(false);
		
		this.setBackground(Color.decode("#000000"));
		this.setOpaque(false);
		
		this.add(blocPic);
		this.add(blocName);
		this.add(redButton);
	}
}
