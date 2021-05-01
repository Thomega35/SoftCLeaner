package interaction;
import java.awt.Container;
import java.awt.event.*;

import UI.Display;

public class RefreshAction implements ActionListener{

	Container panel;
	@Override
	public void actionPerformed(ActionEvent action) {
		Display.update();
	}
	
	public RefreshAction() {
	}

}
