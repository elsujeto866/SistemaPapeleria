package SistemaPeluqueria;

import java.sql.*;

import javax.swing.JOptionPane;

public class Lectura {
public String[] lecturaDB(int IDIn){
		
		MySQLConnection icom = new MySQLConnection();
		PreparedStatement pss= null;
		
		String[] estudianteBD= {null,null,null,null};
		
		try {
			pss = icom.getConexion().prepareStatement("SELECT idProducto, nombre, precio, unidades From productos");
			ResultSet rs = pss.executeQuery();
			JOptionPane.showMessageDialog(null, "Sistema ejectudado con exito");
			
			while(rs.next()) {
			//rs.absolute(IDIn);
				String idd = rs.getString(1);
				String nombreLeido = rs.getString(2);
				String precioLeido = rs.getString(3);
				String unidadesLeido = rs.getString(4);
				
				if(IDIn==Integer.parseInt(idd))
				{
					estudianteBD[0]=idd;
					estudianteBD[1]=nombreLeido;
					estudianteBD[2]=precioLeido;
					estudianteBD[3]=unidadesLeido;
				}
				
				//System.out.println(nombreLeido+" "+apellidoLeido+" "+codLeido);
				
				
		}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error en la lectura Base de Datos");
			JOptionPane.showMessageDialog(null, "El producto no existe");
			e.printStackTrace();
		}			
		return estudianteBD;

	}

}
