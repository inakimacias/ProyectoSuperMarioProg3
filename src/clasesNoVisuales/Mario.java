package clasesNoVisuales;

import estructuras.JLabelMario;

public class Mario {
	protected int vida=3; //Atributo para saber la vida que tiene el personaje
	protected int monedas=0; //Atributo que sirve como contador de las monedas que ha recogido el personaje
	protected double posX; // Atributo que guarda la posición en X (horizontal)
	protected double posY; // Atributo que guarda la posición en Y (vertical)
	private JLabelMario Grafico; // Atributo de etiqueta gráfica para mario
	public boolean salto = false; // Atributo que guarda si Mario ha realizado un salto
	public boolean caida = false; // Atributo que guarda si ha habido o no una caida
	public boolean cont = true; // Atributo contador
	public double gravedadFija = 0; // Atributo de gravedad fija
	public double gravedad = 1; // Atributo de gravedad
	private Mundo mundo; // Atributo que guarda el mundo del juego
	
	
	//CREA UN NUEVO PERSONAJE DE MARIO LÓGICO
	public Mario() {
		salto = false;
		caida = false;
		cont = true;
		gravedadFija = 0;
		gravedad = 1;
		Grafico = new JLabelMario();
	}
	
//	public void saltoMario() {
//		if (salto && cont) {
//			gravedad = gravedad - 20;
//			this.setPosY(gravedad);
//			if (this.getPosY() == this.gravedadFija - 440 || this.getPosY() <= 0) {
//				cont = false;
//				caida = true;
//			}
//		}
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

	//GETTERS Y SETTERS--------------------------------------------------GETTERS Y SETTERS
	public JLabelMario getGrafico() {
		return Grafico;
	}


	public void setGrafico(JLabelMario grafico) {
		Grafico = grafico;
	}


	public boolean isSalto() {
		return salto;
	}


	public void setSalto(boolean salto) {
		this.salto = salto;
	}


	public boolean isCaida() {
		return caida;
	}


	public void setCaida(boolean caida) {
		this.caida = caida;
	}


	public boolean isCont() {
		return cont;
	}


	public void setCont(boolean cont) {
		this.cont = cont;
	}


	public double getGravedadFija() {
		return gravedadFija;
	}


	public void setGravedadFija(double gravedadFija) {
		this.gravedadFija = gravedadFija;
	}


	public double getGravedad() {
		return gravedad;
	}


	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}


	public Mundo getMundo() {
		return mundo;
	}


	public void setMundo(Mundo mundo) {
		this.mundo = mundo;
	}


	public int getVida() {
		return vida;
	}


	public void setVida(int vida) {
		this.vida = vida;
	}


	public int getMonedas() {
		return monedas;
	}


	public void setMonedas(int monedas) {
		this.monedas = monedas;
	}


	public double getPosX() {
		return posX;
	}
	
	public void setPosicion(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
	}

	public void setPosX(double posX) {
		this.posX = posX;
		Grafico.setLocation((int) posX, Grafico.getY());
	}

	public void setPosY(double posY) {
		this.posY = posY;
		Grafico.setLocation((Grafico.getX()), (int) posY);
	}
	
	public double getPosY() {
		return posY;
	}



	
	
}
