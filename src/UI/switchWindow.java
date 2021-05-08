package UI;
import main.Main;
import java.awt.Container;
import java.awt.event.*;

public class switchWindow implements ActionListener{

	Container panel;
	@Override
	public void actionPerformed(ActionEvent action) {
		Main.window.setContentPane(panel);
		Main.window.revalidate();
		Main.window.repaint();
	}
	
	public switchWindow(Container panel) {
		this.panel = panel;
	}

}
