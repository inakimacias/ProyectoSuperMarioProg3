package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import estructuras.JLabelMario;
import estructuras.JPanelFondo;
import clasesNoVisuales.Mario;
import clasesNoVisuales.Mundo;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VJuego extends JFrame {

	/**
	 * 
	 */
	public VJuego VentJuego=this;
	private static final long serialVersionUID = 1L;
	private JPanelFondo pPrincipal;
	boolean[] teclaPulsada = new boolean[4];
	boolean impedimento=false;
	boolean finalVisto=false;
	Mundo Mundo; // Mundo que crearemos
	Mario Mario; // Mario del juego
	MiRunnable miHilo = null; // Hilo del bucle principal de juego
	
	public void InicializadorArray() {
		for (int i = 0; i < teclaPulsada.length; i++) {
			teclaPulsada[i] = false;
		}
	}


	/**
	 * Create the frame.
	 */
	public VJuego(VentanaMenuPrincipal vmp) {
		
		setResizable(false);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),345);
		setLocationRelativeTo(null);
		this.setUndecorated(true);                         //ESTO SIRVE PARA QUITAR BORDES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pPrincipal = new JPanelFondo();
		pPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pPrincipal);
		pPrincipal.setLayout(null);
		
//		JLabelMario LabelMario = new JLabelMario();
//		LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAndando.png")));
//		LabelMario.setBounds(145, 302, 23, 31);
//		pPrincipal.add(LabelMario);
	
		pPrincipal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W: {
					teclaPulsada[0] = true;
					break;
				}
				case KeyEvent.VK_D: {
					teclaPulsada[1] = true;
//					if(LabelMario.getIcon().toString().endsWith("MarioEspejo.png")){
//						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAndando.png")));
//					}else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoI.png")){
//						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAgachadoD.png")));
//					}
//					pPrincipal.setVar(pPrincipal.getVar()-5);
//					pPrincipal.repaint();
					break;
				}
				case KeyEvent.VK_A: {
					teclaPulsada[2] = true;
//					if(LabelMario.getIcon().toString().endsWith("MarioAndando.png")){
//						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioEspejo.png")));
//					} else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoD.png")){
//						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAgachadoI.png")));
//					}
//					pPrincipal.setVar(pPrincipal.getVar()+5);
//					pPrincipal.repaint();
					break;
				}
//				case KeyEvent.VK_S: {
//					teclaPulsada[3] = true;
//					System.out.println("down-pressed");
////					if(LabelMario.getIcon().toString().endsWith("MarioAndando.png")){
////						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAgachadoD.png")));
////					}else if(LabelMario.getIcon().toString().endsWith("MarioEspejo.png")){
////						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAgachadoI.png")));
////					}
//					break;
//				}
				}
			}
		});
	
		pPrincipal.addKeyListener(new KeyAdapter() {
	
			@Override
			public void keyReleased(KeyEvent e) {
	
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W: {
					teclaPulsada[0] = false;
					break;
				}
				case KeyEvent.VK_D: {
					teclaPulsada[1] = false;
					break;
				}
				case KeyEvent.VK_A: {
					teclaPulsada[2] = false;
					break;
				}
//				case KeyEvent.VK_S: {
//					teclaPulsada[3] = false;
//					System.out.println("down-released");
////					if(LabelMario.getIcon().toString().endsWith("MarioAgachadoD.png")){
////						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioAndando.png")));
////					}else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoI.png")){
////						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("Imagenes/MarioEspejo.png")));
////					}
//					break;
//				}
				}
			}
	
		});
		
		pPrincipal.setFocusable(true);
		pPrincipal.requestFocus();
		pPrincipal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				pPrincipal.requestFocus();
			}
		});
		
		// Cierre del hilo al cierre de la ventana
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (miHilo != null)
					miHilo.acaba();
			}
		});
		
	}
	
	public void Arranque() { 					// Crea y visibiliza la ventana con los objetos
	
		this.Mundo = new Mundo(this.pPrincipal);
		this.Mario = new Mario();
		this.Mundo.creaMario(145, 302);
		this.Mario = this.Mundo.getMario();
		this.Mundo.creaBloque();
		this.Mundo.crearCaida();
		
		this.miHilo = this.new MiRunnable(); 	// Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread(this.miHilo);
		nuevoHilo.start();
	}
	
	
	class MiRunnable implements Runnable {
		boolean sigo = true;
		@Override
		public void run() { // Bucle principal forever hasta que se pare el juego...
			InicializadorArray();
			
			while (sigo) {
				
			pPrincipal.repaint();
			
			//Interacciones con los ladrillos(setas,goombas etc) FALTA
			
			if(Mario.getPosX()>1250){
				acaba();
				VentJuego.dispose();
				
			}
			
			if (!impedimento) {
				if(!teclaPulsada[0] && !teclaPulsada[1] && !teclaPulsada[2]){
					if(!Mario.getGrafico().EsEspejo()){
						Mario.getGrafico().setComponentOrientationMarioQuieto();
					}
					if(Mario.getGrafico().EsEspejo()){
						Mario.getGrafico().setComponentOrientationMarioQuietoEspejo();
					}
				}
			}
			
			if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
				finalVisto=true;
			}
			
			if (!impedimento) {
				if (teclaPulsada[1]) {
					System.out.println(pPrincipal.getVar());
					Mario.getGrafico().setComponentOrientationNormal();
					if(finalVisto==false){
						pPrincipal.setVar(pPrincipal.getVar()-40);
						Mundo.moverObjetoI();
					}
					
					if(finalVisto==true){
						Mario.setPosX(Mario.getPosX()+40);
					}
				}
			}

				if (!impedimento) {
					if (teclaPulsada[2]) {
						Mario.getGrafico().setComponentOrientationEspejo();
						System.out.println(pPrincipal.getVar());
						if(pPrincipal.getVar() < 0 && finalVisto==false){
							pPrincipal.setVar(pPrincipal.getVar()+40);
							Mundo.moverObjetoD();
						}
						if(finalVisto==true){
							Mario.setPosX(Mario.getPosX()-40);
						}
					}
				}
				pPrincipal.repaint();
			
				
//				
//				if (teclaPulsada[0]) {
//					System.out.println("Mario.salto = "+Mario.salto+" Mario.caida = "+Mario.caida+" Mundo.choqueV = "+Mundo.choqueV());
//					if (!Mario.salto && !Mundo.choqueV() && !Mario.caida && !Mundo.caida()) {
//						Mario.gravedad = Mario.getPosY();
//						Mario.gravedadFija = Mario.getPosY();
//						Mario.salto = true;
//						Mario.cont = true;
//						if (Mario.getGrafico().EsEspejo()) {
//							Mario.getGrafico().setComponentOrientationSalto();
//						} else {
//							Mario.getGrafico().setComponentOrientationSaltoEspejo();
//							repaint();
//						}
//					}
//				}
//				
//				if (!Mundo.interseccion()) {
//					if ((teclaPulsada[1] && !teclaPulsada[0]) || (teclaPulsada[1] && teclaPulsada[0])) {
//						Mario.getGrafico().setComponentOrientationNormal();
//						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 9);
//						if (((JPanelFondo) pPrincipal).getVar() <= -18840) {
//							((JPanelFondo) pPrincipal).setVar(-18840);
//						} else {
//							if (teclaPulsada[1] && !teclaPulsada[2]) {
//								Mundo.moverObjetoI();
//							}
//						}
//					}
//				}
//				
//				if (!Mundo.interseccion2()) {
//					if ((teclaPulsada[2] && !teclaPulsada[0]) || (teclaPulsada[2] && teclaPulsada[0])) {
//						Mario.getGrafico().setComponentOrientationEspejo();
//						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 9);
//						if (((JPanelFondo) pPrincipal).getVar() >= -60) {
//							((JPanelFondo) pPrincipal).setVar(-60);
//						} else {
//							if (teclaPulsada[2] && !teclaPulsada[1]) {
//								Mundo.moverObjetoD();
//							}
//						}
//					}
//				}
//				
//				Mundo.caida();
//				if (Mario.getPosY() >= 1100) {
//					Mario.setVida(0);
//				}
//				
//				if(Mario.getVida()==0){
//					Mario.caida = false;
//					Mario.salto = false;
//					sigo=false;
//				}
					
				// Dormir el hilo 30 milisegundos
				try {
					pPrincipal.repaint();
					Thread.sleep(27);
					pPrincipal.repaint();
				} catch (Exception e) {
					
				}
			}
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			sigo = false;
		}
	};
}
