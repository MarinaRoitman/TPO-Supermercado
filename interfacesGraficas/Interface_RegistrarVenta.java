package interfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import clases.Catalogo;
import clases.Credito;
import clases.Debito;
import clases.Detalle;
import clases.Efectivo;
import clases.Producto;
import clases.Venta;

import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.Box;
import javax.swing.SpinnerNumberModel;	

public class Interface_RegistrarVenta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	static DefaultTableModel tablaFuncional;
	private JTextField txtCodigoAgregar;
	private JTextField txtCodigoEliminar;
	private JLabel lblPrecioFinal;
	private JLabel lblCuotas;
	private JButton btnAgregarProducto;
	private JButton btnEliminarProducto;
	private JButton btnTotalizarCarrito;
	private JButton btnRealizarCompra;
	private JSpinner spinnerVenta;
	private JSpinner spinnerCantEliminar;
	private JComboBox<Integer> comboBox;
	private ButtonGroup buttonGroupMedio = new ButtonGroup();
	private JRadioButton rdbtnDebito;
	private JRadioButton rdbtnCredito;
	private JRadioButton rdbtnEfectivo;
	private JLabel lblCodigoNoExiste;	
	private JLabel lblStock;  				
	public static Venta v = new Venta();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_RegistrarVenta frame = new Interface_RegistrarVenta();
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
	public Interface_RegistrarVenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.RED);
		menuBar.setBackground(Color.RED);
		menuBar.setBounds(0, 0, 796, 22);
		contentPane.add(menuBar);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Interface_Inicio newframe = new Interface_Inicio();                               
				newframe.setVisible(true);                                                             
				dispose();																				
			}
		});
		btnInicio.setBackground(Color.RED);
		menuBar.add(btnInicio);
		
		JButton btnCatálogo = new JButton("Catálogo");
		btnCatálogo.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {											
				Interface_Catalogo newframe = new Interface_Catalogo();								
				newframe.setVisible(true);
				dispose();																			
			}
		});
		btnCatálogo.setBackground(Color.RED);
		menuBar.add(btnCatálogo);
		
		JButton btnRegistrarVenta = new JButton("Registrar venta");
		btnRegistrarVenta.setBackground(Color.RED);
		menuBar.add(btnRegistrarVenta);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interface_RegistrarVenta.class.getResource("/img/Bienvenidoa.png")));
		lblNewLabel.setBounds(0, 21, 796, 118);
		contentPane.add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 133, 796, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 198, 774, 414);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 21, 466, 235);
		panel_1.add(scrollPane);
		
		table = new JTable();
		tablaFuncional = new DefaultTableModel();
		tablaFuncional.addColumn("Producto");
		tablaFuncional.addColumn("Cantidad");
		tablaFuncional.addColumn("Precio");
		table.setModel(tablaFuncional);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 436, 774, 34);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 607, 774, 42);
		contentPane.add(panel_3);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setLayout(null);

		JLabel lblPrecioFinal = new JLabel("");
		lblPrecioFinal.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrecioFinal.setBounds(541, 352, 233, 40);
		panel_1.add(lblPrecioFinal);
		
		JLabel lblCodigoNoExiste = new JLabel("*El código ingresado no pertenece a ningún producto.");
		lblCodigoNoExiste.setVisible(false);
		lblCodigoNoExiste.setForeground(Color.RED);
		lblCodigoNoExiste.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigoNoExiste.setBounds(95, 267, 312, 14);
		panel_1.add(lblCodigoNoExiste);
		
		JLabel lblStock = new JLabel("*No hay suficiente stock para el código de producto ingresado.");
		lblStock.setVisible(false);
		lblStock.setForeground(Color.RED);
		lblStock.setFont(new Font("Arial", Font.BOLD, 12));
		lblStock.setBounds(71, 291, 364, 14);
		panel_1.add(lblStock);
		
		JButton btnRealizarCompra_1 = new JButton("Comprar");
		btnRealizarCompra_1.setEnabled(false);
		btnRealizarCompra_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 for(int i = 0; i<v.getCarrito().size(); i++) {
					 Producto prod = Interface_Catalogo.catalogo.getProductoById(v.getCarrito().get(i).getCodProd());
					 prod.setStock(prod.getStock()-v.getCarrito().get(i).getCantidad());
					 if(prod.getStock()<prod.getStockMinimo()) {
						 prod.setActivo(false);
					 }
					 v.vaciarCarrito();
					 actualizarTablaCarrito();
					 lblPrecioFinal.setText("");
					 lblCodigoNoExiste.setVisible(false);
					 lblStock.setVisible(false);
				 }
				 JOptionPane.showMessageDialog(null, "Compra realizada, vuelva pronto :)");
			}
		});
		btnRealizarCompra_1.setBounds(675, 9, 89, 23);
		panel_3.add(btnRealizarCompra_1);
		actualizarTablaCarrito();
		
		JLabel lblCuotas = new JLabel("3 - Selecionar cuotas:");
		lblCuotas.setFont(new Font("Arial", Font.BOLD, 13));
		lblCuotas.setBounds(525, 179, 137, 14);
		panel_1.add(lblCuotas);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel<>(new Integer[] {2, 3, 6}));
		comboBox.setBounds(577, 214, 109, 23);
		panel_1.add(comboBox);
		
		ActionListener radioButtonListener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroupMedio.add(rdbtnCredito);
				buttonGroupMedio.add(rdbtnDebito);
				buttonGroupMedio.add(rdbtnEfectivo);
				ButtonModel selectedModel = buttonGroupMedio.getSelection();
	        	String selectedRadioButtonName = buttonGroupMedio.getSelection().getActionCommand();
	    		if (selectedModel != null) {
				    for (Enumeration<AbstractButton> botones = buttonGroupMedio.getElements(); botones.hasMoreElements();) {
				        JRadioButton radioButton = (JRadioButton) botones.nextElement();
				        
				        if (radioButton.getModel() == selectedModel) {
					        if(!selectedRadioButtonName.equals("rdbtnCredito")) {
					        	comboBox.setEnabled(false);	
					        	
					        }else {
					        	comboBox.setEnabled(true);	
					        }
				            break;
				        }
				    }
				}
		    }
		};
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBounds(670, 6, 89, 23);
		panel_2.add(btnComprar);
		
		JRadioButton rdbtnCredito = new JRadioButton("Crédito");
		rdbtnCredito.setSelected(true);
		buttonGroupMedio.add(rdbtnCredito);
		rdbtnCredito.setActionCommand("rdbtnCredito");
		rdbtnCredito.addActionListener(radioButtonListener);
		
		rdbtnCredito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnCredito.setBounds(525, 51, 109, 23);
		panel_1.add(rdbtnCredito);
		
		JRadioButton rdbtnDebito = new JRadioButton("Débito");
		buttonGroupMedio.add(rdbtnDebito);
		rdbtnDebito.setActionCommand("rdbtnDebito");
		rdbtnDebito.addActionListener(radioButtonListener);

		rdbtnDebito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnDebito.setBounds(525, 86, 109, 23);
		panel_1.add(rdbtnDebito);
		
		JRadioButton rdbtnEfectivo = new JRadioButton("Efectivo");
		buttonGroupMedio.add(rdbtnEfectivo);
		rdbtnEfectivo.setActionCommand("rdbtnEfectivo");
		rdbtnEfectivo.addActionListener(radioButtonListener);

		rdbtnEfectivo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnEfectivo.setBounds(525, 121, 109, 23);
		panel_1.add(rdbtnEfectivo);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL A PAGAR: $");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_3.setBounds(541, 328, 145, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("2 - Seleccione método de pago");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_2_1_1.setBounds(525, 22, 203, 14);
		panel_1.add(lblNewLabel_2_1_1);
		
		
		JSpinner spinnerCantAgregar = new JSpinner();
		spinnerCantAgregar.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerCantAgregar.setBounds(362, 320, 36, 23);
		panel_1.add(spinnerCantAgregar);

		JSpinner spinnerCantEliminar = new JSpinner();
		spinnerCantEliminar.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerCantEliminar.setBounds(362, 364, 36, 23);
		panel_1.add(spinnerCantEliminar);
		
		JButton btnTotalizarCarrito = new JButton("Totalizar");
		btnTotalizarCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double total = 0;
				double sumador = 0;
	        	String selectedRadioButtonName = buttonGroupMedio.getSelection().getActionCommand();

				for(int i = 0; i<v.getCarrito().size(); i++) {
					String codigoActual = v.getCarrito().get(i).getCodProd();
					Producto prodActual = Interface_Catalogo.catalogo.getProductoById(codigoActual);
					sumador += prodActual.getPrecio()*v.getCarrito().get(i).getCantidad();
				}
				
		        if(selectedRadioButtonName.equals("rdbtnCredito")) {
		        	Credito medio = new Credito();
		        	int cantCuotas = (Integer) comboBox.getSelectedItem();
		        	
		        	medio.setCantCuotas(cantCuotas);
		        	total = medio.calcularMonto(sumador);
		        	
		        }
		        if(selectedRadioButtonName.equals("rdbtnDebito")) {
		        	Debito medio = new Debito();
		        	total = medio.calcularMonto(sumador);
		        }
		        if(selectedRadioButtonName.equals("rdbtnEfectivo")) {
		        	Efectivo medio = new Efectivo();
		        	total = medio.calcularMonto(sumador);
		        }

				
				lblPrecioFinal.setText(String.valueOf(total));
				btnRealizarCompra_1.setEnabled(true);
			}
		});
		btnTotalizarCarrito.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnTotalizarCarrito.setBounds(588, 262, 89, 23);
		panel_1.add(btnTotalizarCarrito);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese código de producto a eliminar");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBounds(36, 368, 251, 14);
		panel_1.add(lblNewLabel_1);
		
		txtCodigoAgregar = new JTextField();
		txtCodigoAgregar.setBounds(285, 320, 67, 23);
		panel_1.add(txtCodigoAgregar);
		txtCodigoAgregar.setColumns(10);
		
		JButton btnEliminarProducto = new JButton("Eliminar");
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant = (Integer) spinnerCantEliminar.getValue();
				String cod = txtCodigoEliminar.getText();
				Producto prod = Interface_Catalogo.catalogo.getProductoById(cod);
				if(prod != null) {
					for(int i = 0; i<v.getCarrito().size(); i++) {
						if(cod.equals(v.getCarrito().get(i).getCodProd())) {
							lblCodigoNoExiste.setVisible(false);
							v.eliminarDetalle(v.getCarrito().get(i), cant);
							actualizarTablaCarrito();
						}
					}
					if(cant <= prod.getStock()) {
						lblStock.setVisible(false);
					}
				}else {
					lblCodigoNoExiste.setVisible(true);
				}
			}
		});
		btnEliminarProducto.setBounds(408, 364, 81, 23);
		panel_1.add(btnEliminarProducto);
		
		JButton btnAgregarProducto = new JButton("Agregar");
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cant = (Integer) spinnerCantAgregar.getValue();
				String cod = txtCodigoAgregar.getText();
				Producto prod = Interface_Catalogo.catalogo.getProductoById(cod);
				if(prod != null) {
					if(prod.getActivo()) {
						if(v.existe(cod)) {
							if(cant+v.getDetalleById(cod).getCantidad()>prod.getStock()) {
								lblStock.setVisible(true);
							}else {
								lblCodigoNoExiste.setVisible(false);
								Detalle d = new Detalle(cant, cod);
								v.agregarDetalle(d);
								actualizarTablaCarrito();
							}
						}else {
							if(cant>prod.getStock()) {
								lblStock.setVisible(true);
							}else {
								lblCodigoNoExiste.setVisible(false);
								Detalle d = new Detalle(cant, cod);
								v.agregarDetalle(d);
								actualizarTablaCarrito();
							}
						}
					}else {
						lblCodigoNoExiste.setVisible(true);
					}
				}else {
					lblCodigoNoExiste.setVisible(true);
				}
			}
		});
		btnAgregarProducto.setBounds(408, 320, 81, 23);
		panel_1.add(btnAgregarProducto);
		
		JLabel lblNewLabel_1_1 = new JLabel("1 - Ingrese código de producto a agregar");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(18, 324, 274, 14);
		panel_1.add(lblNewLabel_1_1);
		
		txtCodigoEliminar = new JTextField();
		txtCodigoEliminar.setColumns(10);
		txtCodigoEliminar.setBounds(285, 364, 67, 23);
		panel_1.add(txtCodigoEliminar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4.setBounds(10, 150, 774, 41);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Detalle de la compra");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(204, 10, 391, 22);
		lblNewLabel_2.setBackground(new Color(240, 240, 240));
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		
	}
	public static void actualizarTablaCarrito() {
		tablaFuncional.setRowCount(0);
		
		for(int i=0;i<v.getCarrito().size();i++) {
			tablaFuncional.addRow(
					new Object[] {
						v.getCarrito().get(i).getCodProd(),
						v.getCarrito().get(i).getCantidad(),
						Interface_Catalogo.catalogo.getProductoById(v.getCarrito().get(i).getCodProd()).getPrecio()
					});
		}
	}
}