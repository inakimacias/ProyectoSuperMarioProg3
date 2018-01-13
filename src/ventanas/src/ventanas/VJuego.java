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
	public VJuego VentJuego=this;
	private static final long serialVersionUID = 1L;
	private JPanelFondo pPrincipal;
	boolean[] teclaPulsada = new boolean[4];
	boolean finalVisto=false;
	boolean MarioAndando=false;
	AudioClip ClipNivel= Applet.newAudioClip(this.getClass().getResource("/sonidos/Level1Song.wav"));
	AudioClip ClipSalto= Applet.newAudioClip(this.getClass().getResource("/sonidos/Salto.wav"));
	AudioClip ClipMuerte= Applet.newAudioClip(this.getClass().getResource("/sonidos/Muerte.wav"));
	
	int velocidadMario=1;
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
		this.Mundo.creaMario(145,280);
		this.Mario = this.Mundo.getMario();
		this.Mundo.creaBloque();
		this.Mundo.creaRectangles();
		ClipNivel.loop();
		
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
				try {
					pPrincipal.repaint();
					Thread.sleep(3);
					pPrincipal.repaint();
				} catch (Exception e) {
				}
			//Interacciones con los ladrillos(setas,goombas etc) FALTA
			
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
			if(pPrincipal.getVar() <= (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-7320){
				finalVisto=true;
			}
			
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
					Mario.getGrafico().setComponentOrientationSalto();
					Mario.salto=true;
					Mario.velY=Mario.velY-1;
					ClipSalto.play();
				}
			}
			
			if(!Mundo.interseccionArriba() && Mario.salto){
				Mundo.gravedadAcumulada=Mundo.gravedadAcumulada+Mundo.gravedad;
				Mario.velY=Mario.velY+((int)Mundo.gravedadAcumulada);
			}
			
			if((int)Mundo.gravedadAcumulada>=1){
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
				if(finalVisto==false){
					pPrincipal.setVar(pPrincipal.getVar()-Mario.velX);
					Mundo.moverObjetoI(Mario.velX);
				}
				
				if(finalVisto==true){
					Mario.setPosX(Mario.getPosX()+Mario.velX);
				}
			}
		}
//			 IZQUIERDA
//			 IZQUIERDA
			if (!Mundo.interseccionDerecha()) {
				if (teclaPulsada[2]) {
					Mario.getGrafico().setComponentOrientationEspejo();
					if(pPrincipal.getVar() < 0 && finalVisto==false){
						pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
						Mundo.moverObjetoD(Mario.velX);
					}
					if(finalVisto==true){
						Mario.setPosX(Mario.getPosX()-Mario.velX);
					}
				}
			}
			
			System.out.println(pPrincipal.getVar()+";"+Mario.getPosX()+";"+(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth());
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
//						Mario.getGrafico().move((int)Mario.getPosX()-Mario.velX, (int)Mario.getPosY());
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
//							System.out.println("a");
//							Mario.getGrafico().move((int)Mario.getPosX()+Mario.velX, (int)Mario.getPosY());
//						}else if (pPrincipal.getVar()<0 && Mario.getPosX()>1150){
//							pPrincipal.setVar(pPrincipal.getVar()+Mario.velX);
//							Mundo.moverObjetoD(Mario.velX);
//						}else if (pPrincipal.getVar()>=0){
//							Mario.setPosX(Mario.getPosX()-Mario.velX);
//						}
//					}
//				}
				
//				
			}
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acaba() {
			ClipNivel.stop();
			sigo = false;
			VentJuego.dispose();
		}
	};
}
