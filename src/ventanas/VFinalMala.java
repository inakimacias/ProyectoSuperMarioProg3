package ventanas;

import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class VFinalMala extends JFrame {

	private JPanel contentPane;
	
	public VFinalMala(VInicio vinicio, VJuego vjuego) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 665, 374);
		setUndecorated(true);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelFondoDerrota = new JLabel("");
		LabelFondoDerrota.setIcon(new ImageIcon(VFinalMala.class.getResource("/imagenes/FondoDerrota.png")));
		LabelFondoDerrota.setBounds(0, 0, 665, 374);
		contentPane.add(LabelFondoDerrota);
		
		JButton BotonExit = new JButton();
		BotonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vinicio.setVisible(true);
				dispose();
			}
		});
		BotonExit.setIcon(new ImageIcon(VFinalMala.class.getResource("/imagenes/ExitButton.png")));
		BotonExit.setBounds(555, 10, 100, 35);
		BotonExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonExit.setBorderPainted(false);
		LabelFondoDerrota.add(BotonExit);
		
		
		JButton BotonRestart = new JButton();
		BotonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Restart");
				vjuego.miHilo.stop();
				VJuego ventana2 = new VJuego(vinicio);
				ventana2.dispose();
				ventana2.setVisible(true);
				ventana2.Arranque();
				dispose();
			}
		});
		BotonRestart.setIcon(new ImageIcon(VFinalMala.class.getResource("/imagenes/RestartFinal.png")));
		BotonRestart.setBounds(500, 205, 150, 154);
		BotonRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonRestart.setBorderPainted(false);
		LabelFondoDerrota.add(BotonRestart);
		
		setUndecorated(true);
	}
}
