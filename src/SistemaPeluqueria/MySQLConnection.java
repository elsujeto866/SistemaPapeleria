package SistemaPeluqueria;

import java.sql.*;
import javax.swing.JOptionPane;

public class MySQLConnection {
	public static Connection getConexion() {
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/datospeluqueria"+"?useTimezone=true&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String usuarioDB = "root"; //Cuando se crea eL MySQl
			String passwordDB = "Contraseña105827"; //Cuando se crea eL MySQl
			
			con = DriverManager.getConnection(url,usuarioDB,passwordDB); //Enviamos para verficicaci�n de identidad
			
			
		} catch(SQLException e) {
		
			JOptionPane.showMessageDialog(null,"Error en la conexion con la base de datos");
			e.printStackTrace();
			
		} catch(ClassNotFoundException e) {
		
			JOptionPane.showMessageDialog(null,"Conexion fallida (ClassNotFoundException)");
			e.printStackTrace();
		}
		
		return con;
	}
}
