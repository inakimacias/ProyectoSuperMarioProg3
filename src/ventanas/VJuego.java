package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
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

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VJuego extends JFrame {

	private JPanelFondo pPrincipal;
	boolean[] teclaPulsada = new boolean[4];
	boolean impedimento=false;
	MiRunnable miHilo = null;
	
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
		setSize(1000,390);
		setLocationRelativeTo(null);
	//	this.setUndecorated(true);                         ESTO SIRVE PARA QUITAR BORDES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pPrincipal = new JPanelFondo();
		pPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pPrincipal);
		pPrincipal.setLayout(null);
		
		JLabelMario LabelMario = new JLabelMario();
		//double posX, double posY, boolean salto, boolean caida, int vida, int monedas,
		//double gravedadFija, double gravedad, boolean modoEspejo
		LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAndando.png")));
		LabelMario.setBounds(145, 302, 23, 31);
		pPrincipal.add(LabelMario);
	
		pPrincipal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case KeyEvent.VK_W: {
					teclaPulsada[0] = true;
					System.out.println("up-pressed");
					break;
				}
				case KeyEvent.VK_D: {
					teclaPulsada[1] = true;
					System.out.println("right-pressed");
					if(LabelMario.getIcon().toString().endsWith("MarioEspejo.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAndando.png")));
					}else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoI.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAgachadoD.png")));
					}
					pPrincipal.setVar(pPrincipal.getVar()-5);
					pPrincipal.repaint();
					break;
				}
				case KeyEvent.VK_A: {
					teclaPulsada[2] = true;
					System.out.println("left-pressed");
					if(LabelMario.getIcon().toString().endsWith("MarioAndando.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioEspejo.png")));
					} else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoD.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAgachadoI.png")));
					}
					pPrincipal.setVar(pPrincipal.getVar()+5);
					pPrincipal.repaint();
					break;
				}
				case KeyEvent.VK_S: {
					teclaPulsada[3] = true;
					System.out.println("down-pressed");
					if(LabelMario.getIcon().toString().endsWith("MarioAndando.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAgachadoD.png")));
					}else if(LabelMario.getIcon().toString().endsWith("MarioEspejo.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAgachadoI.png")));
					}
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
					System.out.println("up-released");
					break;
				}
				case KeyEvent.VK_D: {
					teclaPulsada[1] = false;
					System.out.println("right-released");
					break;
				}
				case KeyEvent.VK_A: {
					teclaPulsada[2] = false;
					System.out.println("left-released");
					break;
				}
				case KeyEvent.VK_S: {
					teclaPulsada[3] = false;
					System.out.println("down-released");
					if(LabelMario.getIcon().toString().endsWith("MarioAgachadoD.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioAndando.png")));
					}else if(LabelMario.getIcon().toString().endsWith("MarioAgachadoI.png")){
						LabelMario.setIcon(new ImageIcon(VJuego.class.getResource("/Imagenes/MarioEspejo.png")));
					}
					break;
				}
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
	
	
	
	
	class MiRunnable implements Runnable {
		boolean sigo = true;
		@Override
		public void run() {
			// Bucle principal forever hasta que se pare el juego...
			while (sigo) {
				if (!impedimento) {
					if (teclaPulsada[1]) {
						pPrincipal.setVar(pPrincipal.getVar()-20);
						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() - 20);
						if (((JPanelFondo) pPrincipal).getVar() <= -7337) {
							((JPanelFondo) pPrincipal).setVar(-7337);
						}
					}
				}
				

				if (!impedimento) {
					if (teclaPulsada[2]) {
						pPrincipal.setVar(pPrincipal.getVar()+20);
						((JPanelFondo) pPrincipal).setVar(((JPanelFondo) pPrincipal).getVar() + 20);
						if (((JPanelFondo) pPrincipal).getVar() >= -60) {
							((JPanelFondo) pPrincipal).setVar(-60);
						}
					}
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
