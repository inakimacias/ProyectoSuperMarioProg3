package estructuras;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class JButtonPlay extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButtonPlay() {
		try {

			setIcon(new ImageIcon(JLabelCaparazon.class.getResource("/imagenes/Play.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: CaparazonVerde.png no encontrado");
			e.printStackTrace();
		}
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBounds(0, 0, 153, 66);
	}
	
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
		g2.drawImage(img, 0, 0, 153, 66, null);
	}
}
