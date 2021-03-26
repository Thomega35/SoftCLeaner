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
		this.add(new JLabel(p.getPic()));
		this.add(new Label(p.getName()));
		JButton redButton = new JButton("CLOSE");
		KillImplementation action = new KillImplementation(p.getID());
		redButton.addActionListener(action);
		redButton.setBackground(new Color(171, 7, 42));
		this.add(redButton);
		this.setBackground(Color.LIGHT_GRAY);
	}
}
