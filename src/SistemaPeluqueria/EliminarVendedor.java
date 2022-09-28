package SistemaPeluqueria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class EliminarVendedor {
	public  void mod(String nom) {
		// TODO Auto-generated method stub
		MySQLConnection sql = new MySQLConnection();
		PreparedStatement pss = null;
		ResultSet rs = null;

	//	int codMod = 8;
		//orden a realizarze en el MySQL
		
		
		try {
				pss = sql.getConexion().prepareStatement("SELECT apodoUsuario FROM usuarios WHERE apodoUsuario ='"+nom+"'");
				rs = pss.executeQuery();

				if (rs.next()) {
					pss = sql.getConexion().prepareStatement("DELETE FROM usuarios WHERE apodoUsuario ='"+nom+"'");
					pss.executeUpdate();
					JOptionPane.showMessageDialog(null, "Se elimino al vendedor!!");
				} else {
					pss = sql.getConexion().prepareStatement("DELETE FROM usuarios WHERE apodoUsuario ='"+nom+"'");
					pss.executeUpdate();
					JOptionPane.showMessageDialog(null, "No existen registros del usuario");
				} 
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el vendedor");
			e.printStackTrace();	
			
		}
	}
}
