package SistemaPeluqueria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarLista {
public DefaultTableModel model() {
		
		MySQLConnection icom = new MySQLConnection();
		PreparedStatement pss= null;
		
		String id[]= new String[6];
		DefaultTableModel model = new DefaultTableModel();
		try {
			pss = icom.getConexion().prepareStatement("SELECT * FROM usuarios WHERE idTipo=3");
			
			ResultSet rs = pss.executeQuery();
		
			
			model.addColumn("idUsuario");
			model.addColumn("apodoUsuario");
			model.addColumn("passUsuario");
			model.addColumn("nombreUsuario");
			model.addColumn("apellidoUsuario");
			model.addColumn("idTipo");
			while(rs.next()) {
				
			id[0] = String.valueOf(rs.getInt(1));
			id[1] = rs.getString(2);
			id[2] = rs.getString(3);
			id[3] = rs.getString(4);
			id[4] = rs.getString(5);
			id[5] = rs.getString(6);
			model.addRow(id);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error en la lectura Base de Datos");
			e.printStackTrace();
		}								
		
		
		return model;
		

}
}

