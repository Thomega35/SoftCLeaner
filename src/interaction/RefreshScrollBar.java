package interaction;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JScrollPane;

public class RefreshScrollBar implements MouseWheelListener {
	JScrollPane scrollPane;
	
	@Override
    public void mouseWheelMoved(MouseWheelEvent e) {
		scrollPane.getListeners(MouseWheelListener.class)[0].mouseWheelMoved(e);
		scrollPane.revalidate();
		scrollPane.repaint();
    }
  
	public RefreshScrollBar(JScrollPane scrollPane) {
		super();
		this.scrollPane = scrollPane ; 
	}

}
