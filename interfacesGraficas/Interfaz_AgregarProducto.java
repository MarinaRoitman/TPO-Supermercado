package interfacesGraficas;
import clases.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Interfaz_AgregarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JTextField textPrecioUnitario;
	private JTextField textCantidadStock;
	private JTextField textStockMinimo;
	private JTextField textNombreItem;
	private Producto prod;
	private JLabel labelYaExiste;
	private JLabel labelRellenar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_AgregarProducto frame = new Interfaz_AgregarProducto();
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
	public Interfaz_AgregarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.menu);
		panel.setBounds(0, 361, 630, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelYaExiste = new JLabel("Este producto ya existe, intente agregar otro.");
		labelYaExiste.setVisible(false);
		labelYaExiste.setForeground(SystemColor.desktop);
		labelYaExiste.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelYaExiste.setBounds(168, 60, 311, 14);
		contentPane.add(labelYaExiste);
		
		JLabel labelRellenar = new JLabel("Por favor, rellene todos los campos.");
		labelRellenar.setVisible(false);
		labelRellenar.setForeground(Color.BLACK);
		labelRellenar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		labelRellenar.setBounds(200, 82, 250, 14);
		contentPane.add(labelRellenar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 dispose();                                         
			}
		});
		btnCancelar.setBounds(523, 11, 97, 30);
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					prod = new Producto(textCodigo.getText(), textNombreItem.getText(),textDescripcion.getText(), Double.parseDouble(textPrecioUnitario.getText()), Integer.parseInt(textStockMinimo.getText()), Integer.parseInt(textCantidadStock.getText()), true );											
					if(!textCodigo.getText().isEmpty() && !textNombreItem.getText().isEmpty() && !textPrecioUnitario.getText().isEmpty() && !textStockMinimo.getText().isEmpty() && !textCantidadStock.getText().isEmpty()) {
						if(!Interface_Catalogo.catalogo.existe(prod)) {
							Interface_Catalogo.catalogo.agregarItems(prod);
							Interface_Catalogo.actualizarTabla();
							dispose();
						} else {
							labelYaExiste.setVisible(true);
						}
					}else {
						labelRellenar.setVisible(true);
					}
				}
				catch(java.lang.NumberFormatException exep) {
					labelRellenar.setVisible(true);
				}
				
			}
		});
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(416, 11, 97, 30);
		panel.add(btnAceptar);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Agregar Producto");
		lblNewJgoodiesTitle.setForeground(Color.RED);
		lblNewJgoodiesTitle.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setBounds(0, 11, 630, 50);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(107, 110, 130, 26);
		contentPane.add(lblCodigo);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcin.setBounds(107, 184, 130, 26);
		contentPane.add(lblDescripcin);
		
		JLabel lblPrecio = new JLabel("Precio Unitario");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(107, 221, 130, 26);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidadDeStock = new JLabel("Cantidad de Stock");
		lblCantidadDeStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDeStock.setBounds(107, 261, 130, 26);
		contentPane.add(lblCantidadDeStock);
		
		JLabel lblStockminimo = new JLabel("Stock minimo");
		lblStockminimo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStockminimo.setBounds(107, 303, 130, 26);
		contentPane.add(lblStockminimo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(254, 115, 235, 20);
		contentPane.add(textCodigo);
		textCodigo.setColumns(10);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(254, 188, 235, 20);
		contentPane.add(textDescripcion);
		
		textPrecioUnitario = new JTextField();
		textPrecioUnitario.setColumns(10);
		textPrecioUnitario.setBounds(254, 226, 235, 20);
		contentPane.add(textPrecioUnitario);
		
		textCantidadStock = new JTextField();
		textCantidadStock.setColumns(10);
		textCantidadStock.setBounds(254, 266, 235, 20);
		contentPane.add(textCantidadStock);
		
		textStockMinimo = new JTextField();
		textStockMinimo.setColumns(10);
		textStockMinimo.setBounds(254, 308, 235, 20);
		contentPane.add(textStockMinimo);
		
		JLabel lblNombreItem = new JLabel("Nombre Item");
		lblNombreItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreItem.setBounds(107, 147, 130, 26);
		contentPane.add(lblNombreItem);
		
		textNombreItem = new JTextField();
		textNombreItem.setColumns(10);
		textNombreItem.setBounds(254, 152, 235, 20);
		contentPane.add(textNombreItem);
		
	}
	
	public Producto getProducto() {
		return prod;
	}
}
