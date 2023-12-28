package interfacesGraficas;

import clases.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Interface_Inicio extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface_Inicio frame = new Interface_Inicio();
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
	public Interface_Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 670, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 78, 654, 162);
		lblNewLabel.setIcon(new ImageIcon(Interface_Inicio.class.getResource("/img/MarketAll.png")));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 291, 654, 105);
		panel.setBackground(new Color(128, 0, 0));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnModoAdministrador = new JButton("Modo Administrador");
		btnModoAdministrador.setBackground(Color.WHITE);
		btnModoAdministrador.setFont(new Font("Arial", Font.PLAIN, 12));
		btnModoAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Interface_Catalogo newframe = new Interface_Catalogo();
				newframe.setVisible(true);                                     
				setVisible(false);
				//dispose();                                                     
			}
		});
		btnModoAdministrador.setBounds(116, 27, 153, 42);
		panel.add(btnModoAdministrador);
		
		JButton btnModoUsuario = new JButton("Modo Usuario");
		btnModoUsuario.setBackground(Color.WHITE);
		btnModoUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnModoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface_RegistrarVenta newframe = new Interface_RegistrarVenta();
				newframe.setVisible(true);
				dispose();
			}
		});
		btnModoUsuario.setBounds(376, 27, 153, 42);
		panel.add(btnModoUsuario);
	}

}
