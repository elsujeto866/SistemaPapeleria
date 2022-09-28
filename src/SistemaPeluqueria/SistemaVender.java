package SistemaPeluqueria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;

public class SistemaVender extends JFrame {

	private JPanel CuadGen;
	private JTextField CuadIngPV;
	private JTextField CuadIngUV;
	private JTextPane CuadSetPag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaVender frame = new SistemaVender();
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
	public SistemaVender() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		CuadGen = new JPanel();
		CuadGen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(CuadGen);
		CuadGen.setLayout(null);
		CuadGen.setBackground(new Color(20,31,39));
		
		JLabel lblSistemaVentas = new JLabel("PRODUCTO A VENDER");
		lblSistemaVentas.setBackground(new Color(0, 0, 0));
		lblSistemaVentas.setFont(new Font("cooper black", Font.ROMAN_BASELINE, 17));
		lblSistemaVentas.setForeground(Color.GREEN);
		lblSistemaVentas.setBounds(110, 21, 250, 20);
		CuadGen.add(lblSistemaVentas);
		
		JButton BtnVender = new JButton("VENDER");
		BtnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				VenderProductos ventaProducto = new VenderProductos();
				int id = Integer.parseInt(CuadIngPV.getText());
				Lectura leer = new Lectura();
				String aux[] = leer.lecturaDB(id);
				int c = Integer.parseInt(aux[3]);
				String cant = CuadIngUV.getText();
				int d = Integer.parseInt(cant);
				int xx=c-d;
				ventaProducto.mod(id, String.valueOf(xx));
				double precio = Double.parseDouble(aux[2])*d;
				CuadSetPag.setText(String.valueOf(precio));
				}catch(Exception f) {
					JOptionPane.showMessageDialog(null, "Llene todos los campos");
				}
			}
		});
		BtnVender.setBounds(176, 132, 89, 23);
		BtnVender.setFont(new Font("cooper black", 30, 10));
		CuadGen.add(BtnVender);
		
		CuadIngPV = new JTextField();
		CuadIngPV.setBounds(83, 52, 94, 20);
		CuadGen.add(CuadIngPV);
		CuadIngPV.setColumns(10);
		
		CuadIngUV = new JTextField();
		CuadIngUV.setColumns(10);
		CuadIngUV.setBounds(254, 52, 94, 20);
		CuadGen.add(CuadIngUV);
		
		JLabel lblNewLabel = new JLabel("ID Producto");
		lblNewLabel.setBounds(104, 83, 73, 14);
		lblNewLabel.setFont(new Font("cooper black", 30, 10));
		lblNewLabel.setForeground(Color.white);
		CuadGen.add(lblNewLabel);
		
		JLabel lblUnidades = new JLabel("Unidades");
		lblUnidades.setFont(new Font("cooper black", 30, 10));
		lblUnidades.setBounds(275, 83, 63, 14);
		lblUnidades.setForeground(Color.white);
		CuadGen.add(lblUnidades);
		
		CuadSetPag = new JTextPane();
		
		//VenderProductos ventaProducto = new VenderProductos();
		//int id = Integer.parseInt(CuadIngPV.getText());
		/*Lectura leer = new Lectura();
		String aux[] = leer.lecturaDB(id);
		String cant = CuadIngUV.getText();
		double d = Double.parseDouble(cant);
		double precio = Double.parseDouble(aux[2])*d;*/
		
		CuadSetPag.setText("0.00");
		CuadSetPag.setBounds(241, 185, 63, 20);
		CuadGen.add(CuadSetPag);
		
		JLabel lblValorAPagar = new JLabel("Valor a Pagar =");
		lblValorAPagar.setForeground(Color.RED);
		lblValorAPagar.setFont(new Font("cooper black", 30, 15));
		lblValorAPagar.setBounds(124, 185, 120, 20);
		CuadGen.add(lblValorAPagar);
		
		JLabel lblSigno = new JLabel("$");
		lblSigno.setForeground(Color.RED);
		lblSigno.setFont(new Font("cooper black", 30, 15));
		lblSigno.setBounds(310, 185, 20, 20);
		CuadGen.add(lblSigno);
	}
}
