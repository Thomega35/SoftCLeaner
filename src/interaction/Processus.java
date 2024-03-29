package interaction;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import UI.CalcImage;
import main.Main;
import type.Secondaire;
import type.Systeme;
import type.Conseille;
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
		try {
			this.setIconAndTypeByPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		String result = "";
		result = name  + "[";
		for (String s : ID) {
			result = result + s;
			if (!s.equals(ID.get(ID.size()-1))) {
				result = result + "/";
			}
		}
		result = result + "]";
		if (path.length() > 0) {
			result = result + " PATH = " + path;
		}
		result = result + " TYPE = " + type.getClass();
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
			errorPic = ImageIO.read(Processus.class.getResource("/Images/Admin.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Processus.errorPic = new ImageIcon((errorPic.getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
	}
	
	public void setIconAndTypeByPath () throws IOException {
		//SI PAS DE PATH IMAGE ADMIN
		Boolean isValidate = false;
		for (String s : Main.mainProcess) {
			if (s.equals(name)) {
				isValidate = true;
			}
		}
		if (path.length() <= 0) {
			this.setPic(Processus.errorPic);
			this.setType(new Systeme());
		//SI PATH
		}else {
			File file = new File(path);
			
			this.setPic((ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file));
			
			//SI IMAGE NULLE => SECONDAIRE
			if(pic == null) {
				this.setType(new Secondaire());
				this.setPic(Processus.errorPic);
			}else if(isValidate){
				this.setType(new Conseille());
			}else if(Interaction.compareImages(CalcImage.iconToBuff(pic),ImageIO.read(Processus.class.getResource("/Images/CommonImage.png")))){
				this.setType(new Secondaire());
			}else {
				this.setType(new Secondaire());
				//System.out.println(this.name);
			}
		}
		if (isValidate) {
			this.setType(new Conseille());
		}
	}
}