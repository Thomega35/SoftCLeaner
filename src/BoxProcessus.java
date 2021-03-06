import java.awt.Color;
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
		JButton redButton = new JButton("CLOSE");
		KillImplementation action = new KillImplementation(p.ID);
		redButton.addActionListener(action);
		redButton.setBackground(new Color(171, 7, 42));
		this.add(redButton);
		this.setBackground(Color.LIGHT_GRAY);
	}
}
