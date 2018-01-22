package ventanas;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import estructuras.JButtonPlay;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VInicio vinicio = this;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInicio frame = new VInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VInicio() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 640, 480);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ImagenFondo = new JLabel("");
		ImagenFondo.setIcon(new ImageIcon(VInicio.class.getResource("/imagenes/SuperMarioInicio.jpg")));
		ImagenFondo.setBounds(0, 0, 640, 480);
		contentPane.add(ImagenFondo);
		
		JButtonPlay BotonPlay = new JButtonPlay();
		BotonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VJuego ventana2 = new VJuego(vinicio);
				ventana2.dispose();
				ventana2.setVisible(true);
				ventana2.Arranque();
				dispose();
			}
		});
		BotonPlay.setBounds(470, 400, 153, 66);
		BotonPlay.setBorderPainted(false);
		BotonPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(BotonPlay);
		
		setUndecorated(true);
	}
}
