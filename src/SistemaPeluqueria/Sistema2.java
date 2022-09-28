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

public class Sistema2 extends JFrame {

	private JPanel contentPane;
	private JTextField CuadIngCon;
	private JTextField CuadNomElim;
	private JTextField CuadIngNom;
	private JTextField CuadIngusu;
	private JTextField CuadIngID;
	private JTextField CuadIngAp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema2 frame = new Sistema2();
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
	public Sistema2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 100, 518, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(0,172,238));
		
		JButton BtnIngresarV = new JButton("Ingresar Vendedor");
		BtnIngresarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				IngresarVendedor nuevoProducto = new IngresarVendedor();
				int id = Integer.parseInt(CuadIngID.getText());
				String nombre = CuadIngNom.getText();
				String apellido = CuadIngAp.getText();
				String usuario = CuadIngusu.getText();
				String contra = CuadIngCon.getText();
				
				nuevoProducto.ingreso(id, nombre, apellido, usuario, contra);
			}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos");
				}
				//nuevoProducto.ingreso(id,nombre, precio, cant); 	
			}
		});
		BtnIngresarV.setBounds(170, 92, 160, 28);
		BtnIngresarV.setForeground(Color.red);
		BtnIngresarV.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		contentPane.add(BtnIngresarV);
		
		CuadIngusu = new JTextField();
		CuadIngusu.setBounds(266, 36, 86, 20);
		contentPane.add(CuadIngusu);
		CuadIngusu.setColumns(10);
		
		CuadIngCon = new JTextField();
		CuadIngCon.setBounds(389, 36, 86, 20);
		contentPane.add(CuadIngCon);
		CuadIngCon.setColumns(10);
		
		JButton btnEliminarV = new JButton("Eliminar Vendedor");
		btnEliminarV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarVendedor chaoVendedor = new EliminarVendedor();
				String nomb = CuadNomElim.getText();
				chaoVendedor.mod(nomb);
			}
		});
		btnEliminarV.setBounds(170, 193, 160, 23);
		btnEliminarV.setForeground(Color.red);
		btnEliminarV.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		contentPane.add(btnEliminarV);
		
		CuadNomElim = new JTextField();
		CuadNomElim.setBounds(200, 145, 86, 20);
		contentPane.add(CuadNomElim);
		CuadNomElim.setColumns(10);
		
		JButton BtnInventario = new JButton("Lista");
		BtnInventario.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					Lista v2 = new Lista();
					v2.setVisible(true);
					setVisible(false);
				}
		});
		BtnInventario.setBounds(391, 242, 101, 35);
		BtnInventario.setForeground(Color.BLACK);
		BtnInventario.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 10));
		contentPane.add(BtnInventario);
		
		CuadIngNom = new JTextField();
		CuadIngNom.setColumns(10);
		CuadIngNom.setBounds(67, 36, 86, 20);
		contentPane.add(CuadIngNom);
		
		JLabel lblNewLabel = new JLabel("MANEJO DE VENDEDORES");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(140, 11, 250, 14);
		lblNewLabel.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(286, 63, 46, 14);
		lblNombre.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Usuario/Apodo");
		lblPrecio.setBounds(70, 63, 100, 14);
		lblPrecio.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Contrase\u00F1a");
		lblCantidad.setBounds(174, 63, 65, 14);
		lblCantidad.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblCantidad);
		
		JLabel label = new JLabel("Usuario/Apodo");
		label.setBounds(200, 168, 100, 14);
		label.setFont(new Font("cooper black", 30, 10));
		contentPane.add(label);
		
		CuadIngID = new JTextField();
		CuadIngID.setBounds(10, 36, 35, 20);
		contentPane.add(CuadIngID);
		CuadIngID.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(20, 63, 19, 14);
		lblId.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblId);
		
		CuadIngAp = new JTextField();
		CuadIngAp.setColumns(10);
		CuadIngAp.setBounds(163, 36, 86, 20);
		contentPane.add(CuadIngAp);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(411, 63, 50, 14);
		lblApellido.setFont(new Font("cooper black", 30, 10));
		contentPane.add(lblApellido);
	}
}
