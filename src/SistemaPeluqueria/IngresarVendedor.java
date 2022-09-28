package SistemaPeluqueria;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class IngresarVendedor {
	public void ingreso(int id, String nombreIn,String apellidoIn, String usuIN,String conIN) {
		// TODO Auto-generated method stub
		MySQLConnection conex = new MySQLConnection();
		
		PreparedStatement pss = null;
		
		try {
			pss = conex.getConexion().prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?,?)");
			pss.setInt(1,id);
			pss.setString(2,nombreIn);
			pss.setString(3,apellidoIn);
			pss.setString(4, usuIN);
			pss.setString(5, conIN);
			pss.setString(6, "3");
			pss.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ingreso un nuevo vendedor!!");
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "No se pudo ingresar el vendendor en la base de datos");
			e.printStackTrace();
		}
		

	}

}
