package estructuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelCaparazon extends JLabel {
	private static final long serialVersionUID = 1L; // Para serialización
	
	public static final int TAMANYO_BLOQUE = 24; // píxels (igual ancho que largo)
	
	public int velX;

	/**
	 * Construye y devuelve el JLabel del Bloque con su gráfico y tamaño
	 */
	
	public JLabelCaparazon() {
		velX=2;
		try {

			setIcon(new ImageIcon(JLabelCaparazon.class.getResource("/imagenes/CaparazonVerde.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: CaparazonVerde.png no encontrado");
			e.printStackTrace();
		}
		setVisible(true);
		setBounds(0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE);

	}
	
	/**
	 * Método para pintar el componente de Bloque
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado
		// normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotación (siguientes operaciones se rotarán)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_BLOQUE, TAMANYO_BLOQUE, null);
	
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}
	
}
