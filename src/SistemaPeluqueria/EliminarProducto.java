package SistemaPeluqueria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class EliminarProducto {
	public  void mod(int id) {
		// TODO Auto-generated method stub
		MySQLConnection sql = new MySQLConnection();
		PreparedStatement pss = null;
		ResultSet rs = null;
	//	int codMod = 8;
		
		try {
			pss = sql.getConexion().prepareStatement("SELECT idProducto FROM productos WHERE idProducto ="+id);
			rs = pss.executeQuery();
			if(rs.next()) {
			pss = sql.getConexion().prepareStatement("DELETE FROM productos WHERE idProducto ="+id);
			pss.executeUpdate();
			JOptionPane.showMessageDialog(null, "Se elimino el producto!!");
			}
			else {
				pss = sql.getConexion().prepareStatement("DELETE FROM productos WHERE idProducto ="+id);
				pss.executeUpdate();
				JOptionPane.showMessageDialog(null, "No existen registros del producto");
				}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto");
			e.printStackTrace();	
			
		}
	}
}
