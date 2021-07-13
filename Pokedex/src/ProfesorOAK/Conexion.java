package ProfesorOAK;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {

	private static String url= "jdbc:mysql://localhost:3306/pokedex?autoReconnect=true&useSSL=false";
	 private static String usuario= "root";
	 private static String password="36344817";
	 
	 
	 public static Connection conectar() {
		 Connection conexion=null;
		 try {
			 conexion= DriverManager.getConnection(url, usuario, password);
			
		} catch (SQLException e) {
		System.out.println("Ocurrio un error al conectar con la base de datos" + e.getMessage());
		}
		 return conexion;
	 }
	public ResultSet visualizar() {
		 Connection conexion=conectar();
		 ResultSet rs=null;
		 
		 try {
			PreparedStatement ps= conexion.prepareStatement("Select * from pokemon");
			rs=ps.executeQuery();
		} catch (Exception e) {
			System.out.println("Ocurrio un error en la consulta" + e.getMessage());
		}
	return rs;
	}
	
	public void guardarImagen(String IdPK, String Nombre,String Tipo, String Peso, String Altura, String Habitat, String Categoría,String Habilidad, String HabilidadOculta,  String EvolucionaDe,String EvolucionaA, String  ruta) {
		Connection conexion=conectar();
		String insert= "insert into pokemon (IdPK,Nombre, Tipo, Peso, Altura,  Habitat, Categoría, Habilidad, HabilidadOculta, EvolucionaDe, EvolucionaA, foto) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		FileInputStream fi= null;
		PreparedStatement ps= null;
		
		try {
		File file=new File(ruta);
		fi=new FileInputStream(file);
		
		ps=conexion.prepareStatement(insert);
		ps.setString(1, IdPK);
		ps.setString(2, Nombre);
		ps.setString(3, Tipo);
		ps.setString(4, Peso);
		ps.setString(5, Altura);
		ps.setString(6, Habitat);
		ps.setString(7, Categoría);
		ps.setString(8, Habilidad);
		ps.setString(9, HabilidadOculta);
		ps.setString(10, EvolucionaDe);
		ps.setString(11, EvolucionaA);
		ps.setBinaryStream(12, fi);
		ps.executeUpdate();
		
		}catch(Exception e) {
			System.out.println("Error al guardar" + e.getMessage());
		}
	
	}
}
