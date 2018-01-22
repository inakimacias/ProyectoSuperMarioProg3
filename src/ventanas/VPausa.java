package ventanas;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class VPausa extends JFrame {

	private JPanel contentPane;
	
	public VPausa(VInicio vinicio, VJuego vjuego) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 272, 292);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				requestFocus();
			}
		});
		
		JLabel FondoPausa = new JLabel("");
		FondoPausa.setIcon(new ImageIcon(VPausa.class.getResource("/imagenes/ImagenPausa.png")));
		FondoPausa.setBounds(0, 0, 272, 292);
		contentPane.add(FondoPausa);
		
		JButton BotonResume = new JButton("");
		BotonResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Resume");
				vjuego.setHiloSigue(true);
				dispose();
			}
		});
		BotonResume.setIcon(new ImageIcon(VPausa.class.getResource("/imagenes/Resume.png")));
		BotonResume.setBounds(18, 84, 232, 46);
		contentPane.add(BotonResume);
		BotonResume.setBorderPainted(false);
		BotonResume.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonResume.setVisible(true);
		
		JButton BotonRestart = new JButton("");
		BotonRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Restart");
				vjuego.miHilo.acaba();
				VJuego ventana2 = new VJuego(vinicio);
				ventana2.dispose();
				ventana2.setVisible(true);
				ventana2.Arranque();
				dispose();
			}
		});
		BotonRestart.setIcon(new ImageIcon(VPausa.class.getResource("/imagenes/Restart.png")));
		BotonRestart.setBounds(20, 149, 232, 46);
		contentPane.add(BotonRestart);
		BotonRestart.setBorderPainted(false);
		BotonRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		BotonRestart.setVisible(true);
		
		JButton BotonMenu = new JButton("");
		BotonMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Menu");
				vjuego.miHilo.acaba();
				vinicio.setVisible(true);
				dispose();
			}
		});
		BotonMenu.setIcon(new ImageIcon(VPausa.class.getResource("/imagenes/Menu.png")));
		BotonMenu.setBounds(22, 216, 233, 47);
		contentPane.add(BotonMenu);
		BotonMenu.setBorderPainted(false);
		BotonMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		setUndecorated(true);
	}

}
