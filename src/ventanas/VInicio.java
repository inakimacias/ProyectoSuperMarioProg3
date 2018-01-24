package ventanas;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.SqliteBD;
import estructuras.JButtonPlay;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class VInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VInicio vinicio = this;
	
	static SqliteBD miBD;
	static Connection miConexion;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					miBD = new SqliteBD();
					miConexion = miBD.initBD("BDSM");
					miBD.CrearTablaBD(miConexion);
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
		
		JLabel ImagenFondo = new JLabel();
		ImagenFondo.setIcon(new ImageIcon(VInicio.class.getResource("/imagenes/SuperMarioInicio.png")));
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
		ImagenFondo.add(BotonPlay);
		
		JButton BotonExit = new JButton();
		BotonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		BotonExit.setIcon(new ImageIcon(VFinalMala.class.getResource("/imagenes/ExitButton.png")));
		BotonExit.setBounds(525, 10, 100, 35);
		BotonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonExit.setBorderPainted(false);
		ImagenFondo.add(BotonExit);
		
		JButton BotonRanking = new JButton();
		BotonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				miBD.ObtenerUsuarios(miConexion);
			}
		});
		BotonRanking.setIcon(new ImageIcon(VInicio.class.getResource("/imagenes/Ranking.png")));
		BotonRanking.setBounds(24, 413, 150, 44);
		BotonRanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonRanking.setBorderPainted(false);
		ImagenFondo.add(BotonRanking);
		
		JButton BotonAjustes = new JButton();
		BotonAjustes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VAjustes ajustes = new VAjustes(vinicio);
				ajustes.setVisible(true);
			}
		});
		BotonAjustes.setIcon(new ImageIcon(VInicio.class.getResource("/imagenes/Ajustes.png")));
		BotonAjustes.setBounds(15, 14, 50, 50);
		BotonAjustes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonAjustes.setBorderPainted(false);
		ImagenFondo.add(BotonAjustes);
		
		setUndecorated(true);
	}
}
