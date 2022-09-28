package SistemaPeluqueria;

import java.sql.*;

import javax.swing.JOptionPane;

public class VenderProductos {


		public  void mod(int id, String cant) {
			// TODO Auto-generated method stub
			MySQLConnection sql = new MySQLConnection();
			PreparedStatement pss = null;
	
		//	int codMod = 8;
			
			try {
				pss = sql.getConexion().prepareStatement("UPDATE productos SET unidades='"+cant+"' WHERE idProducto ="+id);
				
				pss.executeUpdate();
				JOptionPane.showMessageDialog(null, "Se vendio el producto!!");
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "No se pudo vender el producto");
				e.printStackTrace();	
				
			}
		}
}
