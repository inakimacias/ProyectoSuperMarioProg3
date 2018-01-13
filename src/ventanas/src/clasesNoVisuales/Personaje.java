package clasesNoVisuales;


/**
 * Clase para definir instancias lógicas de un Personaje
 */

public class Personaje {
	protected double posX; // Atributo que guarda la posición en X (horizontal)
	protected double posY; // Atributo que guarda la posición en Y (vertical)
	protected String nombre; // Atributo que guarda el nombre del personaje
	protected boolean caida; // Atributo que devuelve si hay o no una caida
	protected int vida=3; //Atributo para saber la vida que tiene el personaje
	protected int monedas=0; //Atributo que sirve como contador de las monedas que ha recogido el personaje

	/**
	 * Constructor del Personaje
	 */
	

	public Personaje() {
		this.posX = posX;
		this.posY = posY;
		this.nombre = nombre;
		this.caida=false;
		this.vida=vida;
		this.monedas=monedas;

	}
	
	/**
	 * Getters y setters de los atributos del personaje
	 * @return el atributo en cuestion
	 */
	
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

	public boolean isCaida() {
		return caida;
	}

	public void setCaida(boolean caida) {
		this.caida = caida;
	}

	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosicion(double posX, double posY) {
		setPosX(posX);
		setPosY(posY);
	}

	public String getNombre() {
		return nombre;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método toString que nos devuelve por escrito la vida que tiene el personaje
	 * @return vida
	 */
	
	@Override
	public String toString() {
		return "Personaje [ Nombre: "+nombre+" Vida:" + vida + " Monedas:" + monedas + "]";
	}
	
	
	
	
	
	

}