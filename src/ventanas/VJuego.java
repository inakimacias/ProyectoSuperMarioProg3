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
import java.sql.Connection;

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
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VJuego extends JFrame {

	/**
	 * 
	 */
	private VInicio Vinicio;
	public VJuego VentJuego=this;
	
	private int Score;
	public int minLeft;
	public int secLeft;
	private JLabel LabelTemp;
	private JLabel LabelScore;
	private static final long serialVersionUID = 1L;
	private JPanelFondo pPrincipal;
	boolean[] teclaPulsada = new boolean[4];
	boolean sigo=true;
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
	MiRunnable1 miHilo1 = null; // Hilo del cronometro
	
	public VJuego(VInicio vinicio) {
		Vinicio=vinicio;
		setResizable(false);
		setSize((int)Toolkit.getDefaultToolkit().getScreenSize().getWidth(),345);
		setLocationRelativeTo(null);
		this.setUndecorated(true);                         //ESTO SIRVE PARA QUITAR BORDES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pPrincipal = new JPanelFondo();
		pPrincipal.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
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
		
		LabelTemp = new JLabel(":");
		LabelTemp.setHorizontalAlignment(SwingConstants.CENTER);
		LabelTemp.setBackground(Color.GREEN);
		LabelTemp.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		LabelTemp.setBounds(289, 11, 70, 25);
		LabelTemp.setOpaque(true);
		pPrincipal.add(LabelTemp);
		
		LabelScore = new JLabel("Score: 0");
		LabelScore.setBackground(Color.GREEN);
		LabelScore.setHorizontalAlignment(SwingConstants.CENTER);
		LabelScore.setFont(new Font("Segoe UI Black", Font.PLAIN, 14));
		LabelScore.setBounds(390, 11, 70, 25);
		LabelScore.setOpaque(true);
		pPrincipal.add(LabelScore);
		
		// Cierre del hilo al cierre de la ventana
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (miHilo != null)
					miHilo.acabaMuerto();
			}
		});
		
	}

	public void Arranque() { 					// Crea y visibiliza la ventana con los objetos
		
		
		this.Mundo = new Mundo(this.pPrincipal);
		
		this.Score = 0;
		
		this.Mario = new Mario();
		this.Mundo.creaMario(145,290);
		this.Mario = this.Mundo.getMario();
		this.Mundo.creaBloque();
		this.Mundo.creaRectangles();
		this.Mundo.creaMonedas();
		this.Mundo.creaCaparazones();
		this.Mundo.creaGoombas();
		this.secLeft=0;
		this.minLeft=2;
		
		ClipNivel.loop();
		
		this.miHilo = this.new MiRunnable(); 	// Sintaxis de new para clase interna
		Thread nuevoHilo = new Thread(miHilo);
		nuevoHilo.start();
		
		this.miHilo1 = this.new MiRunnable1(); 	// Sintaxis de new para clase interna
		Thread nuevoHilo1 = new Thread(miHilo1);
		nuevoHilo1.start();
	}
	
	
	public boolean isHiloSigue() {
		return hiloSigue;
	}


	public void setHiloSigue(boolean hiloSigue) {
		this.hiloSigue = hiloSigue;
	}
	
	public void cronometro(){
		while(minLeft>=0 && isHiloSigue()){
			while(secLeft>=0 && isHiloSigue()){
				delaySegundo();
				LabelTemp.setText(minLeft+":"+secLeft);
				secLeft--;
			}
			secLeft=59;
			minLeft--;
		}
	}
	
	private static void delaySegundo(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}
	
	class MiRunnable1 implements Runnable {
		public void run() {
			cronometro();
		}
	}
	class MiRunnable implements Runnable {
		
		public void run() { // Bucle principal forever hasta que se pare el juego...
			while (sigo){
				
				if(isHiloSigue()) {
					
				try {
					pPrincipal.repaint();
					Thread.sleep(3);
					pPrincipal.repaint();
				} catch (Exception e) {
				}
				
				if(teclaPulsada[3]==true){
					setHiloSigue(false);
					VPausa vpausa = new VPausa(Vinicio,VentJuego);
					vpausa.setVisible(true);
				}
				
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
					Score=Score+12;
					LabelScore.setText("Score: "+Score);
				}
				if(Mundo.interseccionGoombaArriba()){
					Mario.saltoMario();
					ClipStomp.play();
					Score=Score+8;
					LabelScore.setText("Score: "+Score);
				}
				if(Mundo.interseccionCaparazonAbajo()){
					acabaMuerto();
				}
				if(Mundo.interseccionGoombaAbajo()){
					acabaMuerto();
				}
				//MONEDAS
				//MONEDAS
			if(Mundo.interseccionMonedasPares()){
				ClipMoneda1.play();
				Score=Score+1;
				LabelScore.setText("Score: "+Score);
			}
			if(Mundo.interseccionMonedasImpares()){
				ClipMoneda2.play();
				Score=Score+1;
				LabelScore.setText("Score: "+Score);
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
				acabaVivo();
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
				acabaMuerto();
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
		}
		/** Ordena al hilo detenerse en cuanto sea posible
		 */
		public void acabaVivo() {
			ClipNivel.stop();
			sigo=false;
			setHiloSigue(false);
			VFinalBuena VFB = new VFinalBuena(Vinicio,VentJuego,Score);
			VentJuego.dispose();
			VFB.setVisible(true);
		}
		
		public void acabaMuerto() {
			ClipNivel.stop();
			ClipMuerte.play();
			sigo=false;
			setHiloSigue(false);
			VFinalMala VFM = new VFinalMala(Vinicio,VentJuego);
			VentJuego.dispose();
			VFM.setVisible(true);
		}
		public void stop() {
			ClipNivel.stop();
			sigo=false;
			VentJuego.dispose();
			setHiloSigue(false);
		}
	};
}
