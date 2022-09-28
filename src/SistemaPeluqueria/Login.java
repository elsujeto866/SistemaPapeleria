package SistemaPeluqueria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtPassword;
	private JTextField txtUsuario;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
					//System.out.println(Arrays.toString(fontNames));
					Login frame = new Login();
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
public Login() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(500, 150, 360, 360);
		setBounds(200, 100, 1000, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));
		
		JLabel l1 = new JLabel();
		l1.setBounds(10, 0, 150, 120);
		//l1.setSize(150,120);
		ImageIcon imagen = new ImageIcon("Imagenes/pelu.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(l1.getWidth(), l1.getHeight(), Image.SCALE_DEFAULT));
		l1.setIcon(icono);
		l1.setHorizontalAlignment(SwingConstants.CENTER);
		add(l1);
		
		JLabel l2 = new JLabel();
		l2.setBounds(800, 0, 150, 120);
		//l2.setSize(150,120);
		ImageIcon imagen2 = new ImageIcon("Imagenes/pelu.png");
		Icon icono2 = new ImageIcon(imagen2.getImage().getScaledInstance(l2.getWidth(), l2.getHeight(), Image.SCALE_DEFAULT));
		l2.setIcon(icono2);
		l2.setHorizontalAlignment(SwingConstants.CENTER);
		add(l2);
		
		
		JLabel l3 = new JLabel();
		l3.setBounds(50, 200, 300, 300);
		ImageIcon imagen3 = new ImageIcon("Imagenes/fondo2.png");
		Icon icono3 = new ImageIcon(imagen3.getImage().getScaledInstance(l3.getWidth(), l3.getHeight(), Image.SCALE_DEFAULT));
		l3.setIcon(icono3);
		l3.setHorizontalAlignment(SwingConstants.CENTER);
		add(l3);
		
		
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Roboto Medium", Font.ROMAN_BASELINE, 30));
		lblUsuario.setBounds(400,150, 400, 40);
		lblUsuario.setForeground(Color.black);
		contentPane.add(lblUsuario);
		
		JLabel lblContra = new JLabel("Contraseña:");
		lblContra.setFont(new Font("Roboto Medium", Font.ROMAN_BASELINE, 30));
		lblContra.setBounds(400,250, 400, 40);
		lblContra.setForeground(Color.black);
		contentPane.add(lblContra);
		
		JLabel lblModo = new JLabel("Tipo:");
		lblModo.setFont(new Font("Roboto Medium", Font.ROMAN_BASELINE, 30));
		lblModo.setBounds(50, 150, 400, 40);
		lblModo.setForeground(Color.black);
		contentPane.add(lblModo);
		
		JComboBox boxModo = new JComboBox();
		boxModo.setFont(new Font("Roboto", Font.PLAIN, 20));
		boxModo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Subadministrador", "Vendedor"}));
		boxModo.setBounds(150, 150, 190, 40);
		contentPane.add(boxModo);
	
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(600,150, 300, 40);
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 20));
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(600,250, 300, 40);
		txtPassword.setFont(new Font("Roboto", Font.PLAIN, 20));
		contentPane.add(txtPassword);
		
		JButton btnIngresar = new JButton("Ingresar");
		
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DatosIngresados userLogin = new DatosIngresados(); 
				
				try {
					
					String apodoUsuario = txtUsuario.getText();//obtengo el string del textfile del recuadro usuario
					String passUsuario = String.valueOf(txtPassword.getPassword()); //"casting" obtengo y transformo la contrase�a para que sea visible en c�digo
					String tipoUsuario = boxModo.getSelectedItem().toString();//"casting" obtengo y transformo el tipo de usuario a String 					
					
					if(userLogin.ingresoCorr(apodoUsuario, passUsuario, tipoUsuario)) {
						switch(InicioSesion.idtipoUsuario)
						{
						case 1:
							Sistema v1 = new Sistema();
							v1.setVisible(true); //hacemos visible
							setVisible(false); //cerramos ventana actual
							Sistema2 vv1 = new Sistema2();
							vv1.setVisible(true); //hacemos visible
							setVisible(false); //cerramos ventana actual
						break;
						case 2:
							Sistema2 v2= new Sistema2();
							v2.setVisible(true);
							setVisible(false);
						break;
						case 3:
							SistemaVender v3= new SistemaVender();
							v3.setVisible(true);
							setVisible(false);
						break;
						}
					}else {
						if(tipoUsuario.equals("")||passUsuario.equals("")||apodoUsuario.equals("")) {
							JOptionPane.showMessageDialog(null, "Llene todos los campos");
						}
						else{
							JOptionPane.showMessageDialog(null, "Datos incorrectos");
						}
						//acciones que tomo cuando llena mal los datos
					}
					
				}catch(Exception e) { 
					JOptionPane.showMessageDialog(null, "Digite una contraseña válida");
				}
			}
				
		});
		btnIngresar.setFont(new Font("Roboto Black", Font.BOLD, 27));
		btnIngresar.setBounds(700,350, 150, 60);
		btnIngresar.setEnabled(true);
		btnIngresar.setForeground(Color.green);
		btnIngresar.setMnemonic('a');
		
		
		contentPane.add(btnIngresar);
		
		JLabel lblInicioDeSesion = new JLabel("Iniciar Sesión");
		lblInicioDeSesion.setForeground(Color.black);
		lblInicioDeSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioDeSesion.setFont(new Font("Roboto Black", Font.BOLD, 50));
		lblInicioDeSesion.setBounds(300, 20, 400, 40);
		contentPane.add(lblInicioDeSesion);
	}
}