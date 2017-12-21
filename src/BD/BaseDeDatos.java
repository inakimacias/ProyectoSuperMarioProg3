package BD;

import java.sql.*;
import java.util.*; 
import java.util.logging.*;


public class BaseDeDatos {
	
	public static ArrayList<String> aNombre = new ArrayList<>();
	public static ArrayList<Integer> aMonedas = new ArrayList<>();
	public static ArrayList<Integer> aVidas = new ArrayList<>();
	
	// Inicializa la conexion
	public static Connection initBD( String nombreBD ) {
		try {
		    Class.forName("org.sqlite.JDBC");
		    Connection con = DriverManager.getConnection("jdbc:sqlite:" + nombreBD );
		    return con;
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// Devuelve el statemen para utilizarlo
	public static Statement usarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			return statement;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/** Crea las tablas de la base de datos. Si ya existen, las deja tal cual
	 * @param con	Conexión ya creada y abierta a la base de datos
	 * @return	sentencia de trabajo si se crea correctamente, null si hay cualquier error
	 */
	public static Statement usarCrearTablasBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			try {
				statement.executeUpdate("create table usuario " +
						"(nombre text not null primary key, monedas integer, vida integer)");
				System.out.println("Tabla creada con exito!");
			
			} catch (SQLException e) {} // Tabla ya existe. Nada que hacer
			return statement;	
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean usuarioInsert(Statement st, String nombre, int monedas, int vidas) {
		String sentSQL = "";
		sentSQL = "Insert into usuario values(" + "'" + nombre +"',"+monedas+","+vidas+")";
		System.out.println("Se han insertado los datos con exito! ");
		
		try {
			st.executeUpdate(sentSQL);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ResultSet  ObtenerUsuarios(Statement st) {
		ResultSet rs = null;
		String sentSql = "Select * from usuario order by monedas desc";
		System.out.println("Se ha seleccionado todo con exito!");
		
		try {
			rs = st.executeQuery(sentSql);
			while (rs.next()) {
				aNombre.add(rs.getString(1));
				aMonedas.add(rs.getInt(2));
				aVidas.add(rs.getInt(3));
//				System.out.println("Nombre: " + rs.getString(1));
//				System.out.println("Monedas: " + rs.getInt(2));
//				System.out.println("Vidas: "+rs.getInt(3));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;

	}
	
	public static void cerrarBaseDeDatos( Connection con, Statement st ) {
		try {
			if (st!=null) st.close();
			if (con!=null) con.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Reinicia y pone en blanco la tabla de la base de datos
	public static Statement reiniciarBD( Connection con ) {
		try {
			Statement statement = con.createStatement();
			statement.setQueryTimeout(30);  // poner timeout 30 msg
			statement.executeUpdate("drop table if exists usuario");
			return usarCrearTablasBD( con );
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
}
