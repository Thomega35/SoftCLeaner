package interaction;
import javax.swing.ImageIcon;

public class Processus {

	private String name;
	private java.util.List<String> ID;
	private ImageIcon pic;
	private String path;
	
	public Processus(String name, java.util.List<String> PID, String path, ImageIcon pic) {
		this.setName(name);
		this.setID(PID);
		this.setPic(pic);
		this.setPath(path);
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

}
