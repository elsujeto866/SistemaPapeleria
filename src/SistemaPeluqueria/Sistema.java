package SistemaPeluqueria;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;

public class Sistema extends JFrame {

	private JPanel contentPane;
	private JTextField CuadCantidad;
	private JTextField CuadIDElim;
	private JTextField CuadNombre;
	private JTextField CuadPrecio;
	private JTextField CuadIngID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema frame = new Sistema();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sistema() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,172,238));
		
		JButton BtnIngresarP = new JButton("Ingresar Producto");
		
		BtnIngresarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				IngresoProductos nuevoProducto = new IngresoProductos();
				int id = Integer.parseInt(CuadIngID.getText());
				String nombre = CuadNombre.getText();
				String precio = CuadPrecio.getText();
				String cant = CuadCantidad.getText();
				nuevoProducto.ingreso(id,nombre, precio, cant);
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos");
				}
			}
		});
		BtnIngresarP.setBounds(170, 92, 160, 23);
		BtnIngresarP.setForeground(Color.BLUE);
		BtnIngresarP.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		
		contentPane.add(BtnIngresarP);
		
		CuadPrecio = new JTextField();
		CuadPrecio.setBounds(255, 36, 86, 20);
		contentPane.add(CuadPrecio);
		CuadPrecio.setColumns(10);
		
		CuadCantidad = new JTextField();
		CuadCantidad.setBounds(370, 36, 86, 20);
		contentPane.add(CuadCantidad);
		CuadCantidad.setColumns(10);
		
		JButton btnEliminarP = new JButton("Eliminar Producto");
		btnEliminarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarProducto chaoProducto = new EliminarProducto();
				int id = Integer.parseInt(CuadIDElim.getText());
				chaoProducto.mod(id);
			}
		});
		btnEliminarP.setBounds(170, 202, 160, 23);
		btnEliminarP.setForeground(Color.BLUE);
		btnEliminarP.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		contentPane.add(btnEliminarP);
		
		CuadIDElim = new JTextField();
		CuadIDElim.setBounds(207, 146, 86, 20);
		contentPane.add(CuadIDElim);
		CuadIDElim.setColumns(10);
		
		JButton BtnInventario = new JButton("Inventario");
		BtnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inventario v2 = new Inventario();
				v2.setVisible(true);
				setVisible(false);
			}
		});
		BtnInventario.setBounds(391, 242, 101, 35);
		BtnInventario.setForeground(Color.BLACK);
		BtnInventario.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		contentPane.add(BtnInventario);
		
		CuadNombre = new JTextField();
		CuadNombre.setColumns(10);
		CuadNombre.setBounds(121, 36, 86, 20);
		contentPane.add(CuadNombre);
		
		JLabel lblNewLabel = new JLabel("MANEJO DE PRODUCTOS");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setBounds(150, 11, 240, 14);
		lblNewLabel.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(146, 63, 46, 14);
		lblNombre.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(280, 63, 46, 14);
		lblPrecio.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setBounds(391, 63, 50, 14);
		lblCantidad.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblCantidad);
		
		JLabel lblId_1 = new JLabel("ID Producto");
		lblId_1.setBounds(217, 177, 76, 14);
		lblId_1.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblId_1);
		
		CuadIngID = new JTextField();
		CuadIngID.setBounds(50, 36, 35, 20);
		contentPane.add(CuadIngID);
		CuadIngID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(60, 63, 46, 14);
		lblId.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblId);
	}
}
