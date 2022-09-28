package SistemaPeluqueria;

import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class IngresoProductos {

	public void ingreso(int ID, String nombreIn,String precio,String cantidad) {
		// TODO Auto-generated method stub
		MySQLConnection conex = new MySQLConnection();
		
		PreparedStatement pss = null;
		
		try {
			pss = conex.getConexion().prepareStatement("INSERT INTO productos VALUES(?,?,?,?)");
			pss.setInt(1,ID);
			pss.setString(2,nombreIn);
			pss.setString(3, precio);
			pss.setString(4, cantidad);
			pss.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ingreso el producto!!");
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo ingresar el producto en la base de datos");
			e.printStackTrace();
		}
		

	}

}