package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMenuPrincipal extends JFrame {

	private JPanel contentPane;
	public VentanaMenuPrincipal vmp=this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMenuPrincipal frame = new VentanaMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMenuPrincipal() {
		setResizable(false);
		setSize(1000,390);
		setLocationRelativeTo(null);
	//	this.setUndecorated(true);                         ESTO SIRVE PARA QUITAR BORDES
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("JUGAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VJuego ventana2 = new VJuego();
				ventana2.dispose();
				ventana2.setVisible(true);
				ventana2.Arranque();
				dispose();
			}
		});
		btnNewButton.setBounds(199, 96, 275, 132);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OPCIONES");
		btnNewButton_1.setBounds(581, 166, 146, 62);
		contentPane.add(btnNewButton_1);
	}
	
	public static void inicializarMenuPrincipal(){
		final VentanaMenuPrincipal Ventana = new VentanaMenuPrincipal();
		Ventana.setVisible(true);
	}
}
