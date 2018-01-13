package estructuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelRectangulo extends JLabel {
	private static final long serialVersionUID = 1L; // Para serialización
	
	public static final int TAMANYO_BLOQUE = 32; // píxels (igual ancho que largo)
	
	

	/**
	 * Construye y devuelve el JLabel del Bloque con su gráfico y tamaño
	 */
	
	public JLabelRectangulo() {
		setOpaque(false);
		setBackground(Color.YELLOW);
		setBounds(0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE);

	}


}