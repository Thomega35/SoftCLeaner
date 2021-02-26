import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BoxProcessus extends JPanel {
		
	public BoxProcessus(Processus p) {
		super();
		this.setLayout(new FlowLayout());
		this.add(new JLabel(p.pic));
		this.add(new Label(p.name));
		this.add(new JButton(p.tache));
		
	}
	
}
