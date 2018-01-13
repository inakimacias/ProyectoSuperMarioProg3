package clasesNoVisuales;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JPanel;

import estructuras.JLabelBloque;
import estructuras.JLabelCaida;
import estructuras.JLabelRectangulo;
import estructuras.JPanelFondo;
import javazoom.jl.player.Player;

public class Mundo {
	public JPanelFondo panel; // Atributo del panel visual del juego
	static Mario Mario; // Atributo que contiene al Mario del juego
	
	public boolean apoyo;
	JLabelBloque Bloque = new JLabelBloque(); // Atributo Jlabel para bloque
	JLabelRectangulo Rectangulo = new JLabelRectangulo();
	public double gravedad;
	public double gravedadAcumulada;
	
	public static ArrayList<JLabelBloque> aBloques = new ArrayList(); //Aray que guarda los bloques
	public static ArrayList<JLabelCaida> aCaida = new ArrayList(); // Array que guarda las caidas de Mario
	public static ArrayList<JLabelRectangulo> aRectangulos = new ArrayList();
	
	public Mundo(JPanelFondo panel) {
		aBloques = new ArrayList(); 
		aCaida = new ArrayList();
		aRectangulos = new ArrayList();
		this.panel = panel;
		apoyo=false;
		gravedad=0.01;
		gravedadAcumulada=0;
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
	
	public void creaRectangles(){
		for(int i=0; i<aBloques.size(); i++){
			Rectangulo = new JLabelRectangulo();
			Rectangulo.setLocation(aBloques.get(i).getX()-2,aBloques.get(i).getY()-2);
			panel.add(Rectangulo);
			aRectangulos.add(Rectangulo);
		}
	}
	
	public void creaBloque() {
		//BLOQUE PRUEBA
		Bloque = new JLabelBloque();
		Bloque.setLocation(145,250);
		panel.add(Bloque);
		aBloques.add(Bloque);
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
		for(int i=5100; i<5400; i=i+28){
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
		Bloque.setLocation(6404,306);
		panel.add(Bloque);
		aBloques.add(Bloque);
		
		Bloque = new JLabelBloque();
		Bloque.setLocation(6404,278);
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
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() - pixels, (aCaida.get(o).getY()));
		}
		for (int v = 0; v < aRectangulos.size(); v++) {
			aRectangulos.get(v).move(aRectangulos.get(v).getX() - pixels, (aRectangulos.get(v).getY()));
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
		for (int o = 0; o < aCaida.size(); o++) {
			aCaida.get(o).move(aCaida.get(o).getX() + pixels, (aCaida.get(o).getY()));
		}
		for (int v = 0; v < aRectangulos.size(); v++) {
			aRectangulos.get(v).move(aRectangulos.get(v).getX() + pixels, (aRectangulos.get(v).getY()));
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
