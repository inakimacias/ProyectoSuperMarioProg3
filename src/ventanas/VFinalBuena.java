package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import Atxy2k.CustomTextField.RestrictedTextField;

public class VFinalBuena extends JFrame {

	private JPanel contentPane;
	private JTextField TextoNombre;
	private VInicio Vinicio;
	
	public VFinalBuena(VInicio vinicio, VJuego vjuego, int Score) {
		Vinicio=vinicio;
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 600, 450);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelFondo = new JLabel();
		LabelFondo.setIcon(new ImageIcon(VFinalBuena.class.getResource("/imagenes/FondoWin.png")));
		LabelFondo.setBounds(0, 0, 600, 450);
		contentPane.add(LabelFondo);
		
		JButton BotonExit = new JButton();
		BotonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vinicio.setVisible(true);
				dispose();
			}
		});
		BotonExit.setIcon(new ImageIcon(VFinalMala.class.getResource("/imagenes/ExitButton.png")));
		BotonExit.setBounds(490, 10, 100, 35);
		BotonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonExit.setBorderPainted(false);
		LabelFondo.add(BotonExit);
		
		JButton BotonMenu = new JButton();
		BotonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Menu");
				vjuego.miHilo.stop();
				vinicio.setVisible(true);
				dispose();
			}
		});
		BotonMenu.setIcon(new ImageIcon(VFinalBuena.class.getResource("/imagenes/MenuWin.png")));
		BotonMenu.setBounds(10, 10, 150, 75);
		BotonMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonMenu.setBorderPainted(false);
		LabelFondo.add(BotonMenu);
		
		JButton BotonSave = new JButton();
		BotonSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vinicio.miBD.InsertarUsuario(Vinicio.miConexion, TextoNombre.getText(), Score);
				TextoNombre.setEditable(false);
			}
		});
		BotonSave.setIcon(new ImageIcon(VFinalBuena.class.getResource("/imagenes/SaveGame.png")));
		BotonSave.setBounds(474, 350, 90, 90);
		BotonSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonMenu.setBorderPainted(false);
		LabelFondo.add(BotonSave);
		
		TextoNombre = new JTextField();
		TextoNombre.setBounds(400, 190, 100, 30);
		LabelFondo.add(TextoNombre);
		TextoNombre.setColumns(10);
		
		JLabel LabelHasGanado = new JLabel("¡Has Ganado! Puntuacion:");
		LabelHasGanado.setBounds(400, 120, 150, 20);
		LabelFondo.add(LabelHasGanado);
		
		JLabel LabelScore = new JLabel(""+Score);
		LabelScore.setBounds(400, 140, 150, 20);
		LabelFondo.add(LabelScore);
		
		JLabel LabelGuardar = new JLabel("<html><body>Escribe tu nombre<br>para guardar</body></html>");
		LabelGuardar.setBounds(400, 150, 150, 40);
		LabelFondo.add(LabelGuardar);
		
		JLabel LabelMax = new JLabel("<html><body>Max (15) caracteres</body></html>");
		LabelMax.setBounds(400, 200, 150, 50);
		LabelFondo.add(LabelMax);
		
		RestrictedTextField restricted = new RestrictedTextField(TextoNombre);
		restricted.setOnlyText(true);
		restricted.setLimit(15);
	}
}
