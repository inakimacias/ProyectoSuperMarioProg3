package clasesNoVisuales;
import javax.swing.JPanel;

import estructuras.JLabelMario;


/**
 * Clase heredera de personaje que define las instancias lógicas de Mario
 */

public class Mario extends Personaje{
	
	private JLabelMario Grafico; // Atributo de etiqueta gráfica para mario
	public boolean salto = false; // Atributo que guarda si Mario ha realizado un salto
	public boolean caida = false; // Atributo que guarda si ha habido o no una caida
	public boolean cont = true; // Atributo contador
	public double gravedadFija = 0; // Atributo de gravedad fija
	public double gravedad = 859; // Atributo de gravedad
	private Mundo mundo; // Atributo que guarda el mundo del juego
	
	/**  Crea un nuevo personaje de juego (Mario)
	 */
	
	public Mario() {
		salto = false;
		caida = false;
		cont = true;
		gravedadFija = 0;
		gravedad = 859;
		Grafico = new JLabelMario();
	}
	
	/** Devuelve el JLabel gráfico asociado al Mario de juego
	 * @return	Etiqueta gráfica del Mario
	 */
	
	public JLabelMario getGrafico() {
		return Grafico;
	}

	/**
	 * Getters y setters de los atributos de Mario
	 * @return el atributo en cuestion
	 */
	
	public void setPosX(double posX) {
		super.setPosX(posX);
		Grafico.setLocation((int) posX, Grafico.getY());

	}

	public void setPosY(double posY) {
		super.setPosY(posY);
		Grafico.setLocation((Grafico.getX()), (int) posY);
	}
	
	
	public boolean isCaida() {
		return caida;
	}



	public boolean isCont() {
		return cont;
	}



	public void setCaida(boolean caida) {
		this.caida = caida;
	}



	public void setCont(boolean cont) {
		this.cont = cont;
	}
	


	public boolean isSalto() {
		return salto;
	}



	public void setSalto(boolean salto) {
		this.salto = salto;
	}



	public double getGravedad() {
		return gravedad;
	}



	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}



	public void setGrafico(JLabelMario grafico) {
		Grafico = grafico;
	}	

	/**
	 * Método que implementa el salto de este personaje 
	 */

//	public void saltoMario() {
//		if (salto && cont) {
//			gravedad = gravedad - 20;
//			this.setPosY(gravedad);
//			if (this.getPosY() == this.gravedadFija - 440 || this.getPosY() <= 0) {
//				cont = false;
//				caida = true;
//			}
//		}
//		
//		if (!mundo.apoyo() && this.getPosY() != 860 && !salto) {
//			caida = true;
//		}
//		if (caida && !mundo.apoyo()) {
//			if (this.getPosY() == 860 && !mundo.caida()) {
//				caida = false;
//			} else if (caida) {
//				gravedad = gravedad + 20;
//				this.setPosY(gravedad);
//				if (this.getPosY() == 860 || mundo.apoyo()) {
//					salto = false;
//					caida = false;
//				}
//			}
//		}
//	}
}

