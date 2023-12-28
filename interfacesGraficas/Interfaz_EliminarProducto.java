package interfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import clases.Producto;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_EliminarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JLabel lblNoExisteCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_EliminarProducto frame = new Interfaz_EliminarProducto();
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
	public Interfaz_EliminarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 341);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(SystemColor.menu);
		panel.setBounds(0, 252, 622, 50);
		contentPane.add(panel);
		
		JLabel lblNoExisteCodigo = new JLabel("No existe el codigo del producto ingresado, intente otra vez.");
		lblNoExisteCodigo.setVisible(false);
		lblNoExisteCodigo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		lblNoExisteCodigo.setBounds(103, 86, 449, 14);
		contentPane.add(lblNoExisteCodigo);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();                                           
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(512, 11, 97, 30);
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoElim = textCodigo.getText();
				Producto prod = Interface_Catalogo.catalogo.getProductoById(codigoElim);
				if(prod != null) {
					Interface_Catalogo.catalogo.hacerInactivo(codigoElim);
					Interface_Catalogo.actualizarTabla();
					dispose();
				}else {
					lblNoExisteCodigo.setVisible(true);
				}
				
			}
		});
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(405, 11, 97, 30);
		panel.add(btnAceptar);
		
		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(150, 140, 72, 26);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(232, 142, 207, 26);
		contentPane.add(textCodigo);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Eliminar Producto");
		lblNewJgoodiesTitle.setBackground(Color.WHITE);
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setForeground(Color.RED);
		lblNewJgoodiesTitle.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewJgoodiesTitle.setBounds(0, 23, 622, 50);
		contentPane.add(lblNewJgoodiesTitle);
		
	}
}
