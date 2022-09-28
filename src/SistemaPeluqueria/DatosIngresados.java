package SistemaPeluqueria;

import java.sql.*;

import javax.swing.JOptionPane;

public class DatosIngresados {
public static boolean ingresoCorr (String apodo, String contrasena, String tipo) {
		
		MySQLConnection miConexion = new MySQLConnection();
		PreparedStatement pps = null;
		ResultSet rs = null;
		//orden a realizarze en el MySQL
		String sql = "SELECT u.idUsuario, u.nombreUsuario, u.apellidoUsuario, u.idTipo, t.tipoUsuario, u.apodoUsuario"//Seleccionamos las columnas que necesitamos  
				+ " FROM usuarios AS u INNER JOIN tipousuario AS t ON u.idTipo = t.idtipoUsuario " //interconectamos ambas tablas comparando las columnas que tiene el tipo de usuario
				+ "WHERE apodoUsuario= '"+apodo+"'AND passUsuario= '"+contrasena+"'";	//busca donde coincida el usuario y la contrase�a
		
		try {			
				pps = miConexion.getConexion().prepareStatement(sql);//enviamos la intrucci�n mencionada
				rs = pps.executeQuery(); //se pasa a un arreglo para poder comparar con las datos seleccionados
				
			while(rs.next()) {
				
				InicioSesion.idUsuario = rs.getInt(1);
				InicioSesion.nombreUsuario = rs.getString(2);
				InicioSesion.apellidoUsuario = rs.getString(3);
				InicioSesion.idtipoUsuario = rs.getInt(4);
				InicioSesion.tipoUsuario = rs.getString(5);
				InicioSesion.apodoUsuario = rs.getString(6);
				
				if (tipo.equals(InicioSesion.tipoUsuario)) {
					return true;
				}else {
					return false;
				}		
			}
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el ingreso "+e.getMessage());						
		}
		
		return false;
	}
}
