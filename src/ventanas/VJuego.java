package ventanas;

import java.applet.Applet;
import java.applet.AudioClip;
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
	private VInicio Vinicio;
	public VJuego VentJuego=this;
	
	private static final long serialVersionUID = 1L;
	private JPanelFondo pPrincipal;
	boolean[] teclaPulsada = new boolean[4];
	boolean hiloSigue=true;
	boolean finalVisto=false;
	boolean MarioAndando=false;
	AudioClip ClipNivel= Applet.newAudioClip(this.getClass().getResource("/sonidos/Level1Song.wav"));
	AudioClip ClipSalto= Applet.newAudioClip(this.getClass().getResource("/sonidos/Salto.wav"));
	AudioClip ClipMuerte= Applet.newAudioClip(this.getClass().getResource("/sonidos/Muerte.wav"));
	AudioClip ClipMoneda1= Applet.newAudioClip(this.getClass().getResource("/sonidos/Moneda.wav"));
	AudioClip ClipMoneda2= Applet.newAudioClip(this.getClass().getResource("/sonidos/Moneda.wav"));
	AudioClip ClipStomp= Applet.newAudioClip(this.getClass().getResource("/sonidos/Stomp.wav"));
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
	
	public VJuego(VInicio vinicio) {
		Vinicio=vinicio;
		setResizable(false);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),345);
		setLocationRelativeTo(null);
		this.setUndecorated(true);                         //ESTO SIRVE PARA QUITAR BORDES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pPrincipal = new JPanelFondo();
		pPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pPrincipal);
		pPrincipal.setLayout(null);
	
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
					break;
				}
				case KeyEvent.VK_A: {
					teclaPulsada[2] = true;
					break;
				}
				case KeyEvent.VK_ESCAPE: {
					teclaPulsada[3] = true;
					break;
				}
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
				case KeyEvent.VK_ESCAPE: {
					teclaPulsada[3] = false;
					break;
				}
				}
			}
	
		});
		
		pPrincipal.setFocusable(true);
		
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
		this.Mundo.creaMario(145,290);
		this.Mario = this.Mundo.getMario();
		this.Mundo.creaBloque();
		this.Mundo.creaRectangles();
		this.Mundo.creaMonedas();
		this.Mundo.creaCaparazones();
		this.Mundo.creaGoombas();
		ClipNivel.loop();
		
		this.miHilo = this.new MiRunnable(); 	// Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread(this.miHilo);
		nuevoHilo.start();
	}
	
	
	public boolean isHiloSigue() {
		return hiloSigue;
	}


	public void setHiloSigue(boolean hiloSigue) {
		this.hiloSigue = hiloSigue;
	}


	class MiRunnable implements Runnable {
		@Override
		public void run() { // Bucle principal forever hasta que se pare el juego...
			InicializadorArray();
			while (isHiloSigue()) {
				try {
					pPrincipal.repaint();
					Thread.sleep(3);
					pPrincipal.repaint();
				} catch (Exception e) {
				};
				
				if(teclaPulsada[3]==true){
					setHiloSigue(false);
					VPausa vpausa = new VPausa(Vinicio,VentJuego);
					vpausa.setVisible(true);
				};
				
				//GOOMBAS/CAPARAZONES
				//GOOMBAS/CAPARAZONES
				Mundo.movimientoEnemigosX();
				Mundo.interseccionGoombasDerecha();
				Mundo.interseccionGoombasIzquierda();
				Mundo.interseccionCaparazonesIzquierda();
				Mundo.interseccionCaparazonesDerecha();
				
				//Interacciones con goombas y caparazones FALTA
				//Interacciones con goombas y caparazones FALTA
				if(Mundo.interseccionCaparazonArriba()){
					Mario.saltoMario();
					ClipStomp.play();
				}
				if(Mundo.interseccionGoombaArriba()){
					Mario.saltoMario();
					ClipStomp.play();
				}
				if(Mundo.interseccionCaparazonAbajo()){
					ClipMuerte.play();
					acaba();
				}
				if(Mundo.interseccionGoombaAbajo()){
					ClipMuerte.play();
					acaba();
				}
				//MONEDAS
				//MONEDAS
			if(Mundo.interseccionMonedasPares()){
				ClipMoneda1.play();
			}
			if(Mundo.interseccionMonedasImpares()){
				ClipMoneda2.play();
			}
			Mundo.mueveMonedas();
			Mundo.EstadoMonedas++;
			if(Mundo.EstadoMonedas==100){
				Mundo.EstadoMonedas=0;
			}
				// CORRECCION DE COLISIONES
				// CORRECCION DE COLISIONES
			Mundo.interseccionEsquinasArriba();
			Mundo.interseccionEsquinasAbajo();
				// FINAL
				// FINAL
			if(Mario.getPosX()>1250){
				acaba();
				VentJuego.dispose();
				
			}
//			if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
//				finalVisto=true;
//			}
			
				// QUIETO
				// QUIETO
			if(!teclaPulsada[0] && !teclaPulsada[1] && !teclaPulsada[2] && !Mario.salto){
				if(!Mario.getGrafico().EsEspejo()){
					Mario.getGrafico().setComponentOrientationMarioQuieto();
				}
				if(Mario.getGrafico().EsEspejo()){
					Mario.getGrafico().setComponentOrientationMarioQuietoEspejo();
				}
			}
				// GRAVEDAD	VERTICAL SALTOS
				// GRAVEDAD VERTICAL SALTOS

			Mario.setPosY(Mario.getPosY()+Mario.velY);
			
			if (Mario.getPosY()>400){
				ClipMuerte.play();
				acaba();
			}
			if (Mundo.interseccionArriba()){
				Mario.velY=0;
				if (teclaPulsada[0]){
					Mario.saltoMario();
					ClipSalto.play();
				}
			}
			
			if(!Mundo.interseccionArriba() && Mario.salto){
				Mundo.gravedadAcumulada=Mundo.gravedadAcumulada+Mundo.gravedad;
				Mario.velY=Mario.velY+((int)Mundo.gravedadAcumulada);
			}
			
			if((int)Mundo.gravedadAcumulada>=1 || Mundo.interseccionArriba()){
				Mundo.gravedadAcumulada=0;
			}
			
			if(Mario.velY==0){
				Mario.salto=false;
				
			}
			
			if(!Mundo.interseccionArriba() && !Mario.salto){
				Mario.velY=1;
			}
			
			if(Mundo.interseccionAbajo() && Mario.salto){
				Mario.velY=0;
			}
			
			// DERECHA
			// DERECHA
		if (!Mundo.interseccionIzquierda()) {
			if (teclaPulsada[1]) {
//				System.out.println(pPrincipal.getVar());
				Mario.getGrafico().setComponentOrientationNormal();
				if(pPrincipal.getVar() > (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
					pPrincipal.setVar(pPrincipal.getVar()-Mario.velX);
					Mundo.moverObjetoI(Mario.velX);
				}
				
				if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
					Mario.setPosX(Mario.getPosX()+Mario.velX);
				}
			}
		}
//			 IZQUIERDA
//			 IZQUIERDA
			if (!Mundo.interseccionDerecha()) {
				if (teclaPulsada[2]) {
					Mario.getGrafico().setComponentOrientationEspejo();
					if(pPrincipal.getVar() < 0){
						pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
						Mundo.moverObjetoD(Mario.velX);
					}
					else if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
						Mario.setPosX(Mario.getPosX()-Mario.velX);
					}
				}
			}
			pPrincipal.repaint();
			
//				// DERECHA
//				// DERECHA
//			if (!Mundo.interseccionIzquierda()) {
//				if (teclaPulsada[1]) {
//					Mario.getGrafico().setComponentOrientationNormal();
//					if(pPrincipal.getVar() > (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320
//							&& Mario.getPosX()>=150){
//						pPrincipal.setVar(pPrincipal.getVar()-Mario.velX);
//						Mundo.moverObjetoI(Mario.velX);
//						Mario.setPosX(Mario.getPosX()-Mario.velX);
//						pPrincipal.setVar(pPrincipal.getVar()-Mario.velX);
//						Mundo.moverObjetoI(Mario.velX);
//					}else if(pPrincipal.getVar() > (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320
//							&& Mario.getPosX()<150){
//						pPrincipal.setVar(pPrincipal.getVar()-Mario.velX);
//						Mundo.moverObjetoI(Mario.velX);
//					}else if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
//						Mario.setPosX(Mario.getPosX()+Mario.velX);
//					}
//				}
//			}
////				 IZQUIERDA
////				 IZQUIERDA
//				if (!Mundo.interseccionDerecha()) {
//					if (teclaPulsada[2]) {
//						Mario.getGrafico().setComponentOrientationEspejo();
//						if(pPrincipal.getVar()<0 && Mario.getPosX()<=1150){
//							pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
//							Mundo.moverObjetoD(Mario.velX);
//							Mario.setPosX(Mario.getPosX()+Mario.velX);
//							pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
//							Mundo.moverObjetoD(Mario.velX);
//						}else if (pPrincipal.getVar()<0 && Mario.getPosX()>1150){
//							pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
//							Mundo.moverObjetoD(Mario.velX);
//						}else if (pPrincipal.getVar()>=0){
//							Mario.setPosX(Mario.getPosX()-Mario.velX);
//						}
//					}
//				}		
			}
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			ClipNivel.stop();
			setHiloSigue(false);
			VentJuego.dispose();
		}
	};
}
