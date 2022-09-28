package SistemaPeluqueria;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MostrarInventario {
public DefaultTableModel model() {
		
		MySQLConnection icom = new MySQLConnection();
		PreparedStatement pss= null;
		
		String id[]= new String[4];
		DefaultTableModel model = new DefaultTableModel();
		try {
			pss = icom.getConexion().prepareStatement("SELECT * FROM productos");
			
			ResultSet rs = pss.executeQuery();
		
			
			model.addColumn("id");
			model.addColumn("codigo");
			model.addColumn("nombre");
			model.addColumn("precio");
			while(rs.next()) {
				
			id[0] = String.valueOf(rs.getInt(1));
			id[1] = rs.getString(2);
			id[2] = rs.getString(3);
			id[3] = rs.getString(4);
			model.addRow(id);
			}
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error en la lectura Base de Datos");
			e.printStackTrace();
		}								
		
		
		return model;
		

}
}
