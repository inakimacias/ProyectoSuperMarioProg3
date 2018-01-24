package clasesNoVisuales;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import estructuras.JLabelBloque;
import estructuras.JLabelCaparazon;
import estructuras.JLabelGoomba;
import estructuras.JLabelMario;
import estructuras.JLabelMoneda;
import estructuras.JLabelRectangulo;
import estructuras.JPanelFondo;

public class Mundo {
	public JPanelFondo panel; // Atributo del panel visual del juego
	static Mario Mario; // Atributo que contiene al Mario del juego
	ImageIcon MiImageIcon=null;
	ImageIcon MiImagenMarioD=null;
	ImageIcon MiImagenMarioI=null;
	
	public boolean apoyo;
	JLabelBloque Bloque; // Atributo Jlabel para bloque
	JLabelRectangulo Rectangulo;
	JLabelCaparazon Caparazon;
	JLabelGoomba Goomba;
	JLabelMoneda Moneda;
	public int EstadoMonedas;
	public int EstadoMario;
	
	public double gravedad;
	public double gravedadAcumulada;
	public int velocidadGoombasX;
	public int velocidadCaparazonesX;
	public int velocidadGoombasY;
	public int velocidadCaparazonesY;
	
	public static ArrayList<JLabelBloque> aBloques = new ArrayList<JLabelBloque>(); //Aray que guarda los bloques
	public static ArrayList<JLabelRectangulo> aRectangulos = new ArrayList<JLabelRectangulo>();
	public static ArrayList<JLabelCaparazon> aCaparazones = new ArrayList<JLabelCaparazon>();
	public static ArrayList<JLabelGoomba> aGoombas = new ArrayList<JLabelGoomba>();
	public static ArrayList<JLabelMoneda> aMonedas = new ArrayList<JLabelMoneda>();
	
	public Mundo(JPanelFondo panel) {
		this.panel = panel;
		apoyo=false;
		gravedad=0.01;
		gravedadAcumulada=0;
		EstadoMonedas=0;
		EstadoMario=0;
		velocidadGoombasX=1;
		velocidadCaparazonesX=2;
		velocidadGoombasY=1;
		velocidadCaparazonesY=1;
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
	
	public void mueveMonedas(){
		try {
			MiImageIcon = new ImageIcon(JLabelMoneda.class.getResource("/imagenes/Moneda"+(int)(EstadoMonedas/10)+".png").toURI().toURL());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < aMonedas.size(); i++) {
			aMonedas.get(i).setIcon(MiImageIcon);
		}
	}
	
	public void mueveMarioDerecha(){
		try {
			MiImagenMarioD = new ImageIcon(JLabelMario.class.getResource("/imagenes/Mario"+(int)(EstadoMario/10)+".png").toURI().toURL());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Mario.getGrafico().setIcon(MiImagenMarioD);
	}
	
	public void creaMonedas(){
		//ESTRUCTURA1
		Moneda = new JLabelMoneda();
		Moneda.setLocation(903,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(931,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//ESTRUCTURA2
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1043,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1071,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1043,116);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1071,116);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1043,91);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1071,91);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//ESTRUCTURA3
		//PRIMEROS
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1295,197);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1323,197);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//SEGUNDOS
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1491,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1519,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//TERCEROS
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1687,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1715,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//ESTRUCTURA4
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,144);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,119);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,94);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,69);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(1911,44);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2222,44);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//ESTRUCTURA DOBLE FILA
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2334,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2362,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2390,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2418,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2446,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2474,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2502,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2530,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2558,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2586,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2614,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2642,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//SEGUNDA FILA MONEDAS
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2726,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2754,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2782,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2810,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2838,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2866,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2894,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2922,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2950,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(2978,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3006,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3034,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3034,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//MONEDAS EN BLOQUE
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3230,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3258,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//TRIPLE PIRAMIDE
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3538,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3538,200);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3538,175);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3678,197);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3678,172);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3678,147);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3874,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3874,144);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(3874,119);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//PUENTE DE MONEDAS
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4445,309);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4470,284);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4495,259);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4520,234);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4545,209);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4570,234);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4595,259);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4620,284);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4645,309);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		//ESTRUCTURA X
		//FORMA 1
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4882,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4910,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4938,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4966,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4910,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4938,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4966,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4938,238);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4966,238);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(4966,210);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		//FORMA 2
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5186,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5158,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5130,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5102,294);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5158,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5130,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5102,266);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5130,241);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5102,241);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5102,216);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//TOPCOIN
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5033,25);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//
		//
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5019,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5047,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//DIAGONAL
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5538,309);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5510,281);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5482,253);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5454,225);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5426,197);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5398,169);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5370,141);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5342,113);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5314,85);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5286,57);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		//FILA ARRIBA ESTRUCTURA LABERINTO
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5566,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5594,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5622,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5650,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5678,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5706,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5734,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5762,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5790,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5818,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5846,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5874,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5902,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5930,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5958,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(5986,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
		
		Moneda = new JLabelMoneda();
		Moneda.setLocation(6014,99);
		panel.add(Moneda,0);
		aMonedas.add(Moneda);
	}
	
	public void creaCaparazones(){
		//ESTRUCTURA3
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(1099,308);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
		
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(1750,308);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
		//DOBLE FILA
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(2360,308);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
		//LABERINTO
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(5620,98);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
		//FINAL
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(6350,308);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
		
		Caparazon = new JLabelCaparazon();
		Caparazon.setLocation(6440,308);
		panel.add(Caparazon);
		aCaparazones.add(Caparazon);
	}
	
	public void creaGoombas(){
		Goomba = new JLabelGoomba();
		Goomba.setLocation(800,305);
		panel.add(Goomba);
		aGoombas.add(Goomba);
		
		Goomba = new JLabelGoomba();
		Goomba.setLocation(4400,305);
		panel.add(Goomba);
		aGoombas.add(Goomba);
		
		Goomba = new JLabelGoomba();
		Goomba.setLocation(4640,305);
		panel.add(Goomba);
		aGoombas.add(Goomba);
	}
	
	public void creaRectangles(){
		for(int i=0; i<aBloques.size(); i++){
			Rectangulo = new JLabelRectangulo();
			Rectangulo.setLocation(aBloques.get(i).getX()-2,aBloques.get(i).getY()-2);
			panel.add(Rectangulo);
			aRectangulos.add(Rectangulo);
		}
	}
	
	public void creaBloque() {
		//BLOQUE1
		for(int i=5; i<2000; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//BLOQUE2
		for(int i=2080; i<4500; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//BLOQUE3
		for(int i=4600; i<4990; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//BLOQUE4
		for(int i=5100; i<5280; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//BLOQUE5
		for(int i=5480; i<6100; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//BLOQUE6
		for(int i=6180; i<7330; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,334);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//ESTRUCTURA1
		//FILA1
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
		
		//FILA2
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
		
		//FILA3
		Bloque = new JLabelBloque();
		Bloque.setLocation(901,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(929,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA2
		//COLUMNA1
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
		
		//COLUMNA2
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
		
		//ESTRUCTURA3
		//FILA1
		for(int i=1293; i<1730; i=i+28){
			Bloque = new JLabelBloque();
			Bloque.setLocation(i,306);
			panel.add(Bloque);
			aBloques.add(Bloque);
		}
		//PRIMEROS
		Bloque = new JLabelBloque();
		Bloque.setLocation(1293,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1321,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//SEGUNDOS
		Bloque = new JLabelBloque();
		Bloque.setLocation(1489,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1517,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//TERCEROS
		Bloque = new JLabelBloque();
		Bloque.setLocation(1685,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1713,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA4
		Bloque = new JLabelBloque();
		Bloque.setLocation(1909,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1909,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1909,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1909,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(1909,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//BLOQUE SOLITARIO SALVADOR
		Bloque = new JLabelBloque();
		Bloque.setLocation(1993,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA5
		//C1
		Bloque = new JLabelBloque();
		Bloque.setLocation(2108,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2108,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2108,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2108,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2108,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C2
		Bloque = new JLabelBloque();
		Bloque.setLocation(2136,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2136,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2136,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2136,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C3
		Bloque = new JLabelBloque();
		Bloque.setLocation(2164,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2164,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2164,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C4
		Bloque = new JLabelBloque();
		Bloque.setLocation(2192,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2192,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C5
		Bloque = new JLabelBloque();
		Bloque.setLocation(2220,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA5: DOBLE FILA
		//FILA1
		Bloque = new JLabelBloque();
		Bloque.setLocation(2332,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2360,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2388,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2416,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2444,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2472,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2500,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2528,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2556,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2584,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2612,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2640,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2
		Bloque = new JLabelBloque();
		Bloque.setLocation(2332,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2360,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2388,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2416,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2444,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2472,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2500,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2528,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2556,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2584,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2612,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2640,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//SEGUNDA ESTRUCTURA DOBLE FILA
		//PRIMERA FILA
		Bloque = new JLabelBloque();
		Bloque.setLocation(2724,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2752,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2780,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2808,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2836,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2864,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2892,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2920,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2948,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2976,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3004,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3032,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2
		Bloque = new JLabelBloque();
		Bloque.setLocation(2724,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2752,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2780,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2808,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2836,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2864,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2892,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2920,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2948,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(2976,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3004,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3032,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA FILA CON BLOQUE
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3172,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3200,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3228,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3256,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3284,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3312,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3228,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3256,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA TRIPLE PIRAMIDE
		
		//FILA BASE
		Bloque = new JLabelBloque();
		Bloque.setLocation(3480,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3508,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3536,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3564,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3592,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//
		Bloque = new JLabelBloque();
		Bloque.setLocation(3620,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3648,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3676,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3704,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3732,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3760,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//
		
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3788,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3816,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3844,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3872,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3900,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3928,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3956,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3984,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2
		Bloque = new JLabelBloque();
		Bloque.setLocation(3508,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3536,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3564,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//FILA3
		Bloque = new JLabelBloque();
		Bloque.setLocation(3536,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2-2
		Bloque = new JLabelBloque();
		Bloque.setLocation(3620,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3648,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3676,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3704,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3732,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA3-2
		Bloque = new JLabelBloque();
		Bloque.setLocation(3648,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3676,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3704,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//FILA4-2
		Bloque = new JLabelBloque();
		Bloque.setLocation(3676,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2-3
		Bloque = new JLabelBloque();
		Bloque.setLocation(3788,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3816,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3844,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3872,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3900,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3928,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3956,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//FILA3-3
		Bloque = new JLabelBloque();
		Bloque.setLocation(3816,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3844,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3872,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3900,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3928,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//FILA4-3
		Bloque = new JLabelBloque();
		Bloque.setLocation(3844,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3872,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(3900,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//FILA5-3
		Bloque = new JLabelBloque();
		Bloque.setLocation(3872,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//BLOQUES PARA CONTENER GOOMBAS
		Bloque = new JLabelBloque();
		Bloque.setLocation(4488,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4600,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//ESTRUCTURAX
		//COLUMNA1
		Bloque = new JLabelBloque();
		Bloque.setLocation(4796,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4824,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4824,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4852,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4852,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4880,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4880,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4908,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4908,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4936,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4936,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(4964,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//COLUMNA2
		Bloque = new JLabelBloque();
		Bloque.setLocation(5268,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5240,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5240,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5212,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5212,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5184,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5184,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5156,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5156,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5128,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5128,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5100,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//DOBLE BLOQUE
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5017,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5045,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA LABERINTO
		//PRIMERA FILA
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5564,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5592,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5620,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5648,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5676,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5704,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5732,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5760,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5788,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5816,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5844,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5872,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5900,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5928,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5956,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5984,264);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//COLUMNA DCHA
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//COLUMNA IZDA
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,236);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,208);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,180);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,152);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA2
		Bloque = new JLabelBloque();
		Bloque.setLocation(5620,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5648,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5676,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5704,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5732,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5760,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5788,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5816,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5844,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5872,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5900,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5928,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5956,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5984,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6012,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6040,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//FILA3
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5564,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5592,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5620,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5648,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5676,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5704,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5732,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5760,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5788,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5816,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5844,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5872,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5900,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5928,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5956,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(5984,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6012,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6040,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6068,124);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//BLOQUES PARA LIMITAR CAPARAZON
		Bloque = new JLabelBloque();
		Bloque.setLocation(5536,96);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6040,96);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		//ESTRUCTURA FINAL
		Bloque = new JLabelBloque();
		Bloque.setLocation(6264,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6264,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6264,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6404,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6404,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6404,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C1
		Bloque = new JLabelBloque();
		Bloque.setLocation(6544,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C2
		Bloque = new JLabelBloque();
		Bloque.setLocation(6572,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6572,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C3
		Bloque = new JLabelBloque();
		Bloque.setLocation(6600,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6600,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6600,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C4
		Bloque = new JLabelBloque();
		Bloque.setLocation(6628,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6628,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6628,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6628,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C5
		Bloque = new JLabelBloque();
		Bloque.setLocation(6656,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6656,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6656,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6656,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6656,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		//C6
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,278);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,222);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,194);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6684,166);
		panel.add(Bloque);
		aBloques.add(Bloque);
	}
	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la izquierda
	 * 
	 */
	public void moverObjetoI(int pixels) {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() - pixels, (aBloques.get(i).getY()));
		}
		for (int v = 0; v < aRectangulos.size(); v++) {
			aRectangulos.get(v).move(aRectangulos.get(v).getX() - pixels, (aRectangulos.get(v).getY()));
		}
		for (int a = 0; a < aCaparazones.size(); a++) {
			aCaparazones.get(a).move(aCaparazones.get(a).getX() - pixels, (aCaparazones.get(a).getY()));
		}
		for (int b = 0; b < aGoombas.size(); b++) {
			aGoombas.get(b).move(aGoombas.get(b).getX() - pixels, (aGoombas.get(b).getY()));
		}
		for (int b = 0; b < aMonedas.size(); b++) {
			aMonedas.get(b).move(aMonedas.get(b).getX() - pixels, (aMonedas.get(b).getY()));
		}
	}
	/**
	 * Método que mueve los bloques, los bloques amarillos, las tuberias pequeñas y grandes, los goombas y las monedas
	 * hacia la derecha
	 * 
	 */
	public void moverObjetoD(int pixels) {
		for (int i = 0; i < aBloques.size(); i++) {
			aBloques.get(i).move(aBloques.get(i).getX() + pixels, (aBloques.get(i).getY()));
		}
		for (int v = 0; v < aRectangulos.size(); v++) {
			aRectangulos.get(v).move(aRectangulos.get(v).getX() + pixels, (aRectangulos.get(v).getY()));
		}
		for (int i = 0; i < aCaparazones.size(); i++) {
			aCaparazones.get(i).move(aCaparazones.get(i).getX() + pixels, (aCaparazones.get(i).getY()));
		}
		for (int i = 0; i < aGoombas.size(); i++) {
			aGoombas.get(i).move(aGoombas.get(i).getX() + pixels, (aGoombas.get(i).getY()));
		}
		for (int i = 0; i < aMonedas.size(); i++) {
			aMonedas.get(i).move(aMonedas.get(i).getX() + pixels, (aMonedas.get(i).getY()));
		}
	}
	/**
	 * Método para la interseccion del choque horizontal
	 * @return si hay o no interseccion
	 * 
	 */
	public void movimientoEnemigosX(){
		for (int i = 0; i < aGoombas.size(); i++) {
			aGoombas.get(i).move(aGoombas.get(i).getX() + aGoombas.get(i).getVelX(), (aGoombas.get(i).getY()));
		}
		for (int i = 0; i < aCaparazones.size(); i++) {
			aCaparazones.get(i).move(aCaparazones.get(i).getX() + aCaparazones.get(i).getVelX(), (aCaparazones.get(i).getY()));
		}
	}
	public void interseccionGoombasIzquierda(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			for(int i = 0; i < aGoombas.size(); i++){
				if (aGoombas.get(i).getBounds().intersects(aRectangulos.get(j).getBounds())
						&& ((aGoombas.get(i).getX()+27)<(aRectangulos.get(j).getX()+5))){
					aGoombas.get(i).setVelX(-1);
				}
			}
		}
	}
	
	public void interseccionGoombasDerecha(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			for(int i = 0; i < aGoombas.size(); i++){
				if (aGoombas.get(i).getBounds().intersects(aRectangulos.get(j).getBounds())
					&& (aGoombas.get(i).getX()>(aRectangulos.get(j).getX()+27))) {
					aGoombas.get(i).setVelX(1);
				}
			}
		}
	}
	
	public void interseccionCaparazonesIzquierda(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			for(int i = 0; i < aCaparazones.size(); i++){
				if (aCaparazones.get(i).getBounds().intersects(aRectangulos.get(j).getBounds())
						&& ((aCaparazones.get(i).getX()+24)<(aRectangulos.get(j).getX()+6))){
					aCaparazones.get(i).setVelX(-2);
				}
			}
		}
	}
	
	public void interseccionCaparazonesDerecha(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			for(int i = 0; i < aCaparazones.size(); i++){
				if (aCaparazones.get(i).getBounds().intersects(aRectangulos.get(j).getBounds())
					&& (aCaparazones.get(i).getX()>(aRectangulos.get(j).getX()+24))) {
					aCaparazones.get(i).setVelX(2);
				}
			}
		}
	}
	
	public boolean interseccionCaparazonArriba(){
		for (int j = 0; j < aCaparazones.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aCaparazones.get(j).getBounds())
					&& (Mario.getPosY()+31)<=(aCaparazones.get(j).getY()+4)) {
				eliminaCaparazon(j);
				return true;
			}
		}
		return false;
	}
	public boolean interseccionCaparazonAbajo(){
		for (int j = 0; j < aCaparazones.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aCaparazones.get(j).getBounds())
					&& (Mario.getPosY()+31)>(aCaparazones.get(j).getY()+4)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionGoombaArriba(){
		for (int j = 0; j < aGoombas.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aGoombas.get(j).getBounds())
					&& (Mario.getPosY()+31)<=(aGoombas.get(j).getY()+4)) {
				eliminaGoomba(j);
				return true;
			}
		}
		return false;
	}
	public boolean interseccionGoombaAbajo(){
		for (int j = 0; j < aGoombas.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aGoombas.get(j).getBounds())
					&& (Mario.getPosY()+31)>(aGoombas.get(j).getY()+4)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean interseccionArriba(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aRectangulos.get(j).getBounds())
					&& (Mario.getPosY()+31)<(aRectangulos.get(j).getY()+2) && (Mario.getPosX()+23)>(aRectangulos.get(j).getX()+2)
					&& (Mario.getPosX()<(aRectangulos.get(j).getX()+30))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionAbajo(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aRectangulos.get(j).getBounds())
					&& (Mario.getPosY())>(aRectangulos.get(j).getY()+30) && (Mario.getPosX()+23)>(aRectangulos.get(j).getX()+2)
					&& (Mario.getPosX()<(aRectangulos.get(j).getX()+30))) {
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionIzquierda(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aRectangulos.get(j).getBounds())
					&& ((Mario.getPosX()+23)<(aRectangulos.get(j).getX()+2)) && (Mario.getPosY()+31)>(aRectangulos.get(j).getY()+2)
					&& (Mario.getPosY()<aRectangulos.get(j).getY()+30)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionDerecha(){
		for (int j = 0; j < aRectangulos.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aRectangulos.get(j).getBounds())
					&& ((Mario.getPosX())>(aRectangulos.get(j).getX()+30)) && (Mario.getPosY()+31)>(aRectangulos.get(j).getY()+2)
					&& (Mario.getPosY()<aRectangulos.get(j).getY()+30)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionEsquinasArriba(){
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& (Mario.getPosY()+31)<(aBloques.get(j).getY()+14)){
				Mario.setPosY(aBloques.get(j).getY()-33);
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionEsquinasAbajo(){
		for (int j = 0; j < aBloques.size(); j++) {
			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
					&& (Mario.getPosY())<(aBloques.get(j).getY()+14)){
				Mario.setPosY(aBloques.get(j).getY()+30);
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionMonedasPares(){
		for (int j = 0; j < aMonedas.size(); j=j+2) {
			if (Mario.getGrafico().getBounds().intersects(aMonedas.get(j).getBounds())){
				eliminaMoneda(j);
				return true;
			}
		}
		return false;
	}
	
	public boolean interseccionMonedasImpares(){
		try {
			for (int j = 1; j < aMonedas.size(); j=j+2) {
				if (Mario.getGrafico().getBounds().intersects(aMonedas.get(j).getBounds())){
					eliminaMoneda(j);
					return true;
				}
			}
		} catch (Exception e) {
		}
		return false;
	}
	
	public void eliminaCaparazon(int j) {
		try {
			JLabelCaparazon caparazon = aCaparazones.get(j);
			caparazon.setVisible(false);panel.remove(caparazon);
			aCaparazones.remove(j);
			
			panel.repaint();
		} catch (Exception e) {
		}
		
	}
	public void eliminaGoomba(int j) {
		try {
			JLabelGoomba goomba = aGoombas.get(j);
			goomba.setVisible(false);panel.remove(goomba);
			aGoombas.remove(j);
			
			panel.repaint();
		} catch (Exception e) {
		}
		
	}
	public void eliminaMoneda(int j) {
		try {
			JLabelMoneda moneda = aMonedas.get(j);
			moneda.setVisible(false);panel.remove(moneda);
			aMonedas.remove(j);
			
			panel.repaint();
		} catch (Exception e) {
		}
		
	}
//	public boolean interseccion() {
//		for (int j = 0; j < aBloques.size(); j++) {
//			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
//					&& Mario.getPosX()<aBloques.get(j).getX()) {
//				panel.var=panel.var-(int)(aBloques.get(j).getX()-(Mario.getPosX()+23));
//				moverObjetoI((int)(aBloques.get(j).getX()-(Mario.getPosX()+23)));
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	/**
//	 * Método para la interseccion del choque horizontal por la 
//	 * @return si hay o no interseccion
//	 * 
//	 */
//	public boolean interseccion2() {
//		for (int j = 0; j < aBloques.size(); j++) {
//			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
//					&& Mario.getPosX()>aBloques.get(j).getX()) {
////				panel.var=panel.var+(int)(Mario.getPosX()-aBloques.get(j).getX()+28);
////				moverObjetoD((int)(Mario.getPosX()-aBloques.get(j).getX()+28));
//				return true;
//				
//			}
//		}
//		return false;
//	}
//	
//	public boolean interseccion3() {
//		for (int j = 0; j < aBloques.size(); j++) {
//			if (Mario.getGrafico().getBounds().intersects(aBloques.get(j).getBounds())
//					&& Mario.getPosY()<aBloques.get(j).getY()) {
//				apoyo=true;
//				return true;
//			}
//		}
//		return false;
//	}
	/**
	 * Método de apoyo para que mario se quede sobre los objetos
	 * @return si hay o no apoyo
	 * 
	 */
//	public static boolean apoyo() {
//		for (int i = 0; i < aBloques.size(); i++) {
//			if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
//					&& Mario.getPosY() <= aBloques.get(i).getY() - 100) {
//				Mario.gravedad = Mario.gravedad - 20;
//				Mario.setPosY(Mario.gravedad);
//				return true;
//			}
//		}
//		return false;
//	}
//	/**
//	 * Método para saber si hay un choque vertical con algunos de los objetos del mundo
//	 * @return si hay o no choque vertical cn dicho objeto
//	 * 
//	 */
//	public boolean choqueV() {
//		for (int i = 0; i < aBloques.size(); i++) {
//			if(aBloques.get(i).getY()<=660){
//				if (Mario.getGrafico().getBounds().intersects(aBloques.get(i).getBounds())
//						&& Mario.getPosY() > aBloques.get(i).getY() && Mario.getPosY() < 860) {
//					Mario.gravedad = Mario.getGravedad() + 20;
//					Mario.setSalto(false);
//					Mario.setCaida(true);
//					return true;
//				}
//			}
//		}
//		return false;
//	}
}
