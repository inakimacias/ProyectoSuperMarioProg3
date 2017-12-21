package clasesNoVisuales;

import java.util.ArrayList;

import javax.swing.JPanel;

import estructuras.JLabelBloque;
import estructuras.JLabelCaida;

public class Mundo {
	private JPanel panel; // Atributo del panel visual del juego
	static Mario Mario; // Atributo que contiene al Mario del juego
	
	JLabelBloque Bloque = new JLabelBloque(); // Atributo Jlabel para bloque
	JLabelCaida Caida = new JLabelCaida(); // Atributo Jlabel para caida
	
	static ArrayList<JLabelBloque> aBloques = new ArrayList(); //Aray que guarda los bloques
	static ArrayList<JLabelCaida> aCaida = new ArrayList(); // Array que guarda las caidas de Mario
	
	public Mundo(JPanel panel) {
		aBloques = new ArrayList(); 
		aCaida = new ArrayList(); 
		this.panel = panel;
	}
	
	public void creaMario(int posX, int posY) {
		// Crear y añadir el Mario a la ventana
		Mario = new Mario();
		Mario.setPosicion(posX, posY);
		panel.add(Mario.getGrafico()); // Añade al panel visual
		Mario.getGrafico().repaint(); // Refresca el dibujado de Mario

	}
	
	public Mario getMario() {
		return Mario;
	}
	
	public void creaBloque() {
		for(int i=5; i<2000; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		for(int i=2080; i<4500; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		for(int i=4600; i<4990; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		for(int i=5100; i<5400; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		for(int i=5480; i<6100; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		for(int i=6180; i<7330; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		Bloque = new JLabelBloque();
		Bloque.setLocation(845,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(873,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(901,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(929,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(957,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(985,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(873,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(901,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(929,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(957,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(901,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(929,250);
		panel.add(Bloque);
		aBloques.add(Bloque);

		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1041,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1069,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		for(int i=1293; i<1574; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,306);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1293,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1321,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1489,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1517,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1685,138);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1713,138);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4824,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4796,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4852,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4824,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4880,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4852,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4908,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4880,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4936,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4908,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4964,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4936,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
	}
	
	public void crearCaida() {
		
		
		Caida = new JLabelCaida();
		Caida.setLocation(2042, 340);
		panel.add(Caida);
		aCaida.add(Caida);
		
		Caida = new JLabelCaida();
		Caida.setLocation(2875, 340);
		panel.add(Caida);
		aCaida.add(Caida);
		
		Caida = new JLabelCaida();
		Caida.setLocation(4545, 340);
		panel.add(Caida);
		aCaida.add(Caida);
		
		Caida = new JLabelCaida();
		Caida.setLocation(5435, 340);
		panel.add(Caida);
		aCaida.add(Caida);
		
		Caida = new JLabelCaida();
		Caida.setLocation(6135, 340);
		panel.add(Caida);
		aCaida.add(Caida);
	}
	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la izquierda
	 * 
	 */
	public void moverObjetoI() {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() - 40, (aBloques.get(i).getY()));
		}
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() - 40, (aCaida.get(o).getY()));
		}
	}
	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la derecha
	 * 
	 */
	public void moverObjetoD() {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() + 40, (aBloques.get(i).getY()));
		}
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() + 40, (aCaida.get(o).getY()));
		}
	}
	
	/**
	 * Método que fija la caida
	 * @return si hay o no caida
	 * 
	 */
	public static boolean caida() {
		for (int i = 0; i < aCaida.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aCaida.get(i).getBounds())) {
				Mario.setCaida(true);
				return true;
			}
		}
		return false;

	}
	/**
	 * Método para la interseccion del choque horizontal
	 * @return si hay o no interseccion
	 * 
	 */
	public boolean interseccion() {
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& Mario.getPosX()<aBloques.get(j).getX()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Método para la interseccion del choque horizontal
	 * @return si hay o no interseccion
	 * 
	 */
	public boolean interseccion2() {
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& Mario.getPosX()>aBloques.get(j).getX()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Método de apoyo para que mario se quede sobre los objetos
	 * @return si hay o no apoyo
	 * 
	 */
	public static boolean apoyo() {
		for (int i = 0; i < aBloques.size(); i++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
					&& Mario.getPosY() <= aBloques.get(i).getY() - 100) {
				Mario.gravedad = Mario.gravedad - 20;
				Mario.setPosY(Mario.gravedad);
				return true;
			}
		}
		return false;
	}
	/**
	 * Método para saber si hay un choque vertical con algunos de los objetos del mundo
	 * @return si hay o no choque vertical cn dicho objeto
	 * 
	 */
	public boolean choqueV() {
		for (int i = 0; i < aBloques.size(); i++) {
			if(aBloques.get(i).getY()<=660){
				if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
						&& Mario.getPosY() > aBloques.get(i).getY() && Mario.getPosY() < 860) {
					Mario.gravedad = Mario.getGravedad() + 20;
					Mario.setSalto(false);
					Mario.setCaida(true);
					return true;
				}
			}
		}
		return false;
	}
}
