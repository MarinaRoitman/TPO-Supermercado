package interfacesGraficas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;
import clases.*;

public class Interface_Catalogo extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public static Catalogo catalogo = new Catalogo();

	static DefaultTableModel tablaFuncional;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Catalogo frame = new Interface_Catalogo();
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
	public Interface_Catalogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 594);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 0, 0));
		menuBar.setBackground(new Color(255, 0, 0));
		setJMenuBar(menuBar);
		
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
		btnCatálogo.setBackground(Color.RED);
		menuBar.add(btnCatálogo);
		
		
		JButton btnRegistrarVenta = new JButton("Registrar venta");
		btnRegistrarVenta.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Interface_RegistrarVenta newframe = new Interface_RegistrarVenta();            
				newframe.setVisible(true);
				dispose();																		
			}
		});
		btnRegistrarVenta.setBackground(Color.RED);
		menuBar.add(btnRegistrarVenta);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Interface_Catalogo.class.getResource("/img/Bienvenidoa.png")));
		lblNewLabel.setBounds(0, -2, 794, 118);
		contentPane.add(lblNewLabel);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 110, 794, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(10, 186, 774, 333);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 32, 532, 264);
		panel_1.add(scrollPane);
				
		table = new JTable();
		
		tablaFuncional = new DefaultTableModel();
		
		tablaFuncional.addColumn("Código");
		tablaFuncional.addColumn("Nombre Producto");
		tablaFuncional.addColumn("Descripción");
		tablaFuncional.addColumn("Precio unitario");
		tablaFuncional.addColumn("Stock Minimo");
		tablaFuncional.addColumn("Stock");
		tablaFuncional.addColumn("Activo");
		table.setModel(tablaFuncional);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(2147483643);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		
		JButton btnModificarProducto = new JButton("Modificar Producto");
		btnModificarProducto.setBounds(588, 217, 152, 40);
		panel_1.add(btnModificarProducto);
		btnModificarProducto.setForeground(Color.BLACK);
		btnModificarProducto.setBackground(Color.WHITE);
		btnModificarProducto.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnEliminarProducto = new JButton("Eliminar Producto");
		btnEliminarProducto.setBounds(588, 150, 152, 40);
		panel_1.add(btnEliminarProducto);
		btnEliminarProducto.setForeground(Color.BLACK);
		btnEliminarProducto.setBackground(Color.WHITE);
		btnEliminarProducto.setFont(new Font("Arial", Font.BOLD, 12));
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(588, 81, 152, 40);
		panel_1.add(btnAgregarProducto);
		btnAgregarProducto.setFont(new Font("Arial", Font.BOLD, 12));
		btnAgregarProducto.setForeground(Color.BLACK);
		btnAgregarProducto.setBackground(new Color(255, 255, 255));
		btnAgregarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarProducto();
			}
		});
		btnEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarProducto();
			}
		});
		btnModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarProducto();
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_2.setBounds(10, 129, 774, 46);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nuestros productos");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBackground(SystemColor.menu);
		lblNewLabel_2.setBounds(269, 11, 233, 22);
		panel_2.add(lblNewLabel_2);
		
		actualizarTabla();

	}
	
	private void eliminarProducto() {
		Interfaz_EliminarProducto Inter = new Interfaz_EliminarProducto();
		Inter.setAlwaysOnTop(true);
		Inter.setVisible(true);
		actualizarTabla();
	}
	
	private void modificarProducto() {
		Interfaz_ModificarProducto Inter = new Interfaz_ModificarProducto();
		Inter.setAlwaysOnTop(true);
		Inter.setVisible(true);
		actualizarTabla();
	}
	
	private void agregarProducto() {
		Interfaz_AgregarProducto Inter = new Interfaz_AgregarProducto();
		Inter.setAlwaysOnTop(true);
		Inter.setVisible(true);
		actualizarTabla();
	}
	
	private void imprCat() {
		for(int i = 0; i < catalogo.getCatalogo().size(); i++) {
			System.out.println(catalogo.getCatalogo().get(i).getCodigo());
		}
	}
	
	public static void actualizarTabla() {
		tablaFuncional.setRowCount(0);
		
		for(int i=0;i<catalogo.getCatalogo().size();i++) {
			tablaFuncional.addRow(
					new Object[] {
						catalogo.getCatalogo().get(i).getCodigo(),
						catalogo.getCatalogo().get(i).getNombre(),
						catalogo.getCatalogo().get(i).getDescripcion(),
						catalogo.getCatalogo().get(i).getPrecio(),
						catalogo.getCatalogo().get(i).getStockMinimo(),
						catalogo.getCatalogo().get(i).getStock(),
						catalogo.getCatalogo().get(i).getActivo()
					});
		}
	}
}
