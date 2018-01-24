package estructuras;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelFondo extends JPanel {

	private static final long serialVersionUID = 1L;
	public int var=0;
	
	public JPanelFondo(){
		//this.setSize( , );
	}
	
	
	@Override
	public void paintComponent (Graphics g){
		
		//Como no estamos usando un Jlabel no podemos utilizar el set Icon, asi que lo crearemos con el método ImageIcon
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Imagenes/Nivel-1.png"));
		g.drawImage(imagenFondo.getImage(),var,0,7337, 350, null);
		setOpaque(false);
		super.paintComponent(g);
		}


	public int getVar() {
		return var;
	}


	public void setVar(int var) {
		this.var = var;
	}


	public void setIcon(ImageIcon imageIcon) {
		this.setIcon(imageIcon);
		
	}	
	
	
}
