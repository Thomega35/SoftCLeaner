package UI;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import main.Main;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = -1263929978294565756L;

	public MainFrame(String nom) {
		super(nom);
		this.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
            	//Main.window.setMinimumSize(new Dimension((int) Main.window.getMinimumSize().getWidth(),(int) (Main.window.getSize().getWidth()/1.95)));
            	Main.window.validate();
            	Main.window.revalidate();
            	Main.window.repaint();
            }
        });
		
	}

}
