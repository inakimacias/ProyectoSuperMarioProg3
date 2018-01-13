package estructuras;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import interfaces.IEstructuras;

public class JLabelMario extends JLabel {
	private static final long serialVersionUID = 8L; // Para serialización
	
	public static final int TAMANYO_MARIOx = 23; // píxels (igual ancho que largo)
	public static final int TAMANYO_MARIOy = 31; // píxels (igual ancho que largo)
	
	
	public static final int ARISTA_RECTANGULO_MARIO = 30; // Radio en píxels del rectangulo del Mario(para choques)
	
	private static final boolean DIBUJAR_RECTANGULO_MARIO = false; // Dibujado (paradepuración)del bounding rectangle de choque de Mario
	
	private boolean Espejo = false; //Atributo para saber si hay que aplicarle el método de espejo a la imagen de Mario
	

	/**
	 * Construye y devuelve el JLabel del Mario con su gráfico y tamaño
	 */
	
	public JLabelMario() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioQuieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioQuieto.png no encontrado");
			e.printStackTrace();
		}
		setBounds(0, 0, TAMANYO_MARIOx, TAMANYO_MARIOy);

	}
	
	/**
	 * Método para pintar el componente de Mario
	 */

	@Override
	protected void paintComponent(Graphics g) {
		// super.paintComponent(g); // En este caso no nos sirve el pintado normal de un JLabel
		Image img = ((ImageIcon) getIcon()).getImage();
		Graphics2D g2 = (Graphics2D) g; // El Graphics realmente es Graphics2D
		// Escalado más fino con estos 3 parámetros:
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// Prepara rotación (siguientes operaciones se rotarán)
		// Dibujado de la imagen
		g2.drawImage(img, 0, 0, TAMANYO_MARIOx, TAMANYO_MARIOy, null);
		if (DIBUJAR_RECTANGULO_MARIO)
			g2.drawRect(0,0,ARISTA_RECTANGULO_MARIO,ARISTA_RECTANGULO_MARIO);	
			}
	
	/**
	 * Método para Obtener la imagen de Mario corriendo en Modo espejo
	 */

	public void setComponentOrientationEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioEspejo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = true;

	}
	
	/**
	 * Método para Obtener la imagen de Mario corriendo en Modo normal
	 */

	public void setComponentOrientationNormal() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioAndando.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioAndando.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;

	}
	
	/**
	 * Método para Obtener la imagen de Mario Saltando en Modo normal
	 */

	public void setComponentOrientationSalto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioSalto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioSalto.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;

	}
	
	/**
	 * Método para Obtener la imagen de Mario Saltando en Modo espejo
	 */

	public void setComponentOrientationSaltoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioSaltoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: MarioSaltoEspejo.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = true;
	}
	
	public void setComponentOrientationMarioQuieto() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioQuieto.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = false;
	}
	
	public void setComponentOrientationMarioQuietoEspejo() {
		try {

			setIcon(new ImageIcon(JLabelMario.class.getResource("/Imagenes/MarioQuietoEspejo.png").toURI().toURL()));
		} catch (Exception e) {
			System.err.println("Error en carga de recurso: Mario.png no encontrado");
			e.printStackTrace();
		}
		setSize(TAMANYO_MARIOx, TAMANYO_MARIOy);
		Espejo = true;
	}
	
	/**
	 * Método get que sirve para saber si el componente está en espejo
	 * @return si es o no espejo
	 */
	
	public boolean EsEspejo() {
		return Espejo;
	}

}