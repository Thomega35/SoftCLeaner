package interaction;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import type.Systeme;
import type.Type;

public class Processus {

	private String name;
	private java.util.List<String> ID;
	private ImageIcon pic;
	private String path;
	static ImageIcon errorPic;
	private Type type;
	
	public Processus(String name, java.util.List<String> PID, String path) {
		this.setName(name);
		this.setID(PID);
		this.setPath(path);
		this.setIconAndTypeByPath();
	}
	
	public String toString() {
		String result = "";
		result = name  + "[";
		for (String s : ID) {
			result = result + s + "/";
		}
		result = result + "]";
		if (path.length() > 0) {
			result = result + " PATH = " + path;
		}
		return result;
	}

	public ImageIcon getPic() {
		return pic;
	}

	public void setPic(ImageIcon pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.List<String> getID() {
		return ID;
	}

	public void setID(java.util.List<String> list) {
		ID = list;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public static void loadAdminPic() {
		Image errorPic = null;
		try {
			errorPic = ImageIO.read(new File("src/Images/Admin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Processus.errorPic = new ImageIcon((errorPic.getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
	}
	
	public void setIconAndTypeByPath () {
		if (path.length() <= 0) {
			this.setPic(Processus.errorPic);
			this.setType(new Systeme());
		}else {
		File file = new File(path);
		this.setPic((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file));
		}
	}
}
