package interfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import clases.Producto;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class Interfaz_ModificarProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	private JTextField textStock;
	private JTextField textStockMin;
	private JTextField textNombreItem;
	private JLabel lblNoExiste;
	private JRadioButton rdbtnActivoOn;
	private JRadioButton rdbtnActivoOff;
	private ButtonGroup buttonGroupActivo = new ButtonGroup();
	private boolean activo = true;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_ModificarProducto frame = new Interfaz_ModificarProducto();
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
	public Interfaz_ModificarProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigo.setBounds(127, 103, 130, 26);
		contentPane.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setColumns(10);
		textCodigo.setBounds(274, 108, 235, 20);
		contentPane.add(textCodigo);
		
		JLabel lblDescripcin = new JLabel("Descripción");
		lblDescripcin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcin.setBounds(127, 175, 130, 26);
		contentPane.add(lblDescripcin);
		
		textDescripcion = new JTextField();
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(274, 181, 235, 20);
		contentPane.add(textDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio Unitario");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrecio.setBounds(127, 212, 130, 26);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(274, 217, 235, 20);
		contentPane.add(textPrecio);
		
		JLabel lblCantidadDeStock = new JLabel("Cantidad de Stock");
		lblCantidadDeStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidadDeStock.setBounds(127, 251, 130, 26);
		contentPane.add(lblCantidadDeStock);
		
		textStock = new JTextField();
		textStock.setColumns(10);
		textStock.setBounds(274, 256, 235, 20);
		contentPane.add(textStock);
		
		JLabel lblStockminimo = new JLabel("StockMinimo");
		lblStockminimo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStockminimo.setBounds(127, 287, 130, 26);
		contentPane.add(lblStockminimo);
		
		textStockMin = new JTextField();
		textStockMin.setColumns(10);
		textStockMin.setBounds(274, 293, 235, 20);
		contentPane.add(textStockMin);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(SystemColor.menu);
		panel.setBounds(0, 355, 631, 50);
		contentPane.add(panel);
		
		JLabel lblNoExiste = new JLabel("No existe el codigo ingresado, intente otra vez.");
		lblNoExiste.setVisible(false);
		lblNoExiste.setForeground(Color.BLACK);
		lblNoExiste.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		lblNoExiste.setBounds(154, 69, 321, 14);
		contentPane.add(lblNoExiste);
		
		ActionListener radioButtonListener = new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String codProd = textCodigo.getText();
				Producto prod = Interface_Catalogo.catalogo.getProductoById(codProd);
		    	buttonGroupActivo.add(rdbtnActivoOn);
				buttonGroupActivo.add(rdbtnActivoOff);
				ButtonModel selectedModel = buttonGroupActivo.getSelection();
	        	String selectedRadioButtonName = buttonGroupActivo.getSelection().getActionCommand();
		    	if (selectedModel != null) {
				    for (Enumeration<AbstractButton> botones = buttonGroupActivo.getElements(); botones.hasMoreElements();) {
				        JRadioButton radioButton = (JRadioButton) botones.nextElement();
				        
				        if (radioButton.getModel() == selectedModel) {

					        if(selectedRadioButtonName.equals("rdbtnActivoOn")) {
					        	activo = true;
					        }else {
					        	activo = false;
					        }
				            break;
				        }
				    }
				}
		    	System.out.println(prod.getNombre());
		    	System.out.println(prod.getActivo());
		    }
		};
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(523, 11, 97, 30);
		panel.add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String codProd = textCodigo.getText();
					Producto prod = Interface_Catalogo.catalogo.getProductoById(codProd);
					
					if(prod != null) {
						if(!textNombreItem.getText().isEmpty()) {
							prod.setNombreProd(textNombreItem.getText());
						}
						if (!textDescripcion.getText().isEmpty()) {
							prod.setDescripcion(textDescripcion.getText());
						}
						if (!textPrecio.getText().isEmpty()) {
							prod.setPrecio(Double.parseDouble(textPrecio.getText()));
						}
						if (!textStock.getText().isEmpty()) {
							prod.setStock(Integer.parseInt(textStock.getText()));
						}
						if (!textStockMin.getText().isEmpty()) {
							prod.setStockMinimo(Integer.parseInt(textStockMin.getText()));
						}
						prod.setActivo(activo);
						Interface_Catalogo.actualizarTabla();
						dispose();
					}else {
						lblNoExiste.setVisible(true);
					}
				}catch(java.lang.NullPointerException exep) {
					lblNoExiste.setVisible(true);
				}

			}
		});
		btnAceptar.setBackground(Color.WHITE);
		btnAceptar.setBounds(416, 11, 97, 30);
		panel.add(btnAceptar);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Modificar Producto");
		lblNewJgoodiesTitle.setForeground(Color.RED);
		lblNewJgoodiesTitle.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewJgoodiesTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewJgoodiesTitle.setBounds(0, 21, 631, 37);
		contentPane.add(lblNewJgoodiesTitle);
		
		textNombreItem = new JTextField();
		textNombreItem.setColumns(10);
		textNombreItem.setBounds(274, 143, 235, 20);
		contentPane.add(textNombreItem);
		
		JLabel lblNombreItem = new JLabel("Nombre Item");
		lblNombreItem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombreItem.setBounds(127, 138, 130, 26);
		contentPane.add(lblNombreItem);
		
		JRadioButton rdbtnActivoOn = new JRadioButton("Si");
		rdbtnActivoOn.setActionCommand("rdbtnActivoOn");
		rdbtnActivoOn.setSelected(true);
		buttonGroupActivo.add(rdbtnActivoOn);
		rdbtnActivoOn.setBackground(Color.WHITE);
		rdbtnActivoOn.setBounds(274, 328, 103, 21);
		contentPane.add(rdbtnActivoOn);
		rdbtnActivoOn.addActionListener(radioButtonListener);
		
		JRadioButton rdbtnActivoOff = new JRadioButton("No");
		rdbtnActivoOff.setActionCommand("rdbtnActivoOff");
		buttonGroupActivo.add(rdbtnActivoOff);
		rdbtnActivoOff.setBackground(Color.WHITE);
		rdbtnActivoOff.setBounds(408, 327, 103, 21);
		contentPane.add(rdbtnActivoOff);
		rdbtnActivoOff.addActionListener(radioButtonListener);
		
		JLabel lblActivo = new JLabel("Activo");
		lblActivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblActivo.setBounds(127, 330, 103, 15);
		contentPane.add(lblActivo);
	}
	
}
