package ventanas;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BD.SqliteBD;

import javax.swing.JScrollPane;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class JtableTabla extends JFrame{
	
	private static final long serialVersionUID = 1L;
	public static SqliteBD bd;
	VInicio vmp;
	
	public JtableTabla(){
		//array bidimencional de objetos con los datos de la tabla
		 Object[][] data = {};

		//array de String's con los títulos de las columnas
		 String[] columnNames = {"Nombre", "Score"};
		 
		//creamos el Modelo de la tabla con los datos anteriores
		 DefaultTableModel dtm= new DefaultTableModel(data, columnNames);
		
		 //se crea la Tabla con el modelo DefaultTableModel
		 final JTable table = new JTable(dtm);
		
		 //filas
		 for(int i = 0; i<bd.aNombre.size() && bd.aNombre.get(i) !=null;i++){
			 Object[] newRow={bd.aNombre.get(i),bd.aScores.get(i)};
			 dtm.addRow(newRow);
		 }
		 
		//se define el tamaño
		 table.setPreferredScrollableViewportSize(new Dimension(200, 200));
		 
		//Creamos un JscrollPane y le agregamos la JTable
		 JScrollPane scrollPane = new JScrollPane(table);
		 
		 //Agregamos el JScrollPane al contenedor
		 getContentPane().add(scrollPane, BorderLayout.CENTER);
		 
		//manejamos la salida
		 addWindowListener(new WindowAdapter() {
		 public void windowClosing(WindowEvent e) {
			dispose();
			VInicio.main(null);
		 }
		 });	 
	}
	
	public static void abrirJTable() {
		JtableTabla frame = new JtableTabla();
		frame.pack();
		frame.setVisible(true);
	}

}