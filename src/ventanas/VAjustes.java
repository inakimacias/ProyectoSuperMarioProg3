package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VAjustes extends JFrame {

	private JPanel contentPane;
	
	public VAjustes(VInicio Vinicio) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 100, 100);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnBorrarBd = new JButton("Borrar BD");
		btnBorrarBd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vinicio.miBD.BorrarTablaBD(Vinicio.miConexion);
			}
		});
		contentPane.add(btnBorrarBd, BorderLayout.CENTER);
		addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				requestFocus();
			}
		});
	}

}
