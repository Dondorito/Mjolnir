package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hibernate.Categoria;
import hibernate.Sesion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class CrearCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCategoria frame = new CrearCategoria();
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
	public CrearCategoria() {
		setTitle("Creaci\u00F3n de categor\u00EDa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblCrearCategoria = new JLabel("Registrar Categor\u00EDa");
		lblCrearCategoria.setBounds(10, 11, 774, 199);
		lblCrearCategoria.setIcon(new ImageIcon("C:\\Users\\omega\\eclipse-workspace\\Mjolnir\\img\\mjolnirtres.png"));
		lblCrearCategoria.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblCrearCategoria.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblCrearCategoria);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 285, 764, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre Categoria");
		lblNombre.setBounds(10, 221, 774, 49);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNombre);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 380, 524, 14);
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblError);
		
		JComboBox comboCat = new JComboBox();
		comboCat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		comboCat.setBounds(604, 360, 170, 20);
		contentPane.add(comboCat);
		
		for(int i=0;i<sacaCat().size();i++) {
			comboCat.addItem(sacaCat().get(i));
		}
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 315, 120, 35);
		btnRegistrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Sesion s = new Sesion();
					s.comenzarTransaccion();
					BigDecimal CodigoC = new BigDecimal(0);
					String NC = textNombre.getText();
					String NombreC = NC.toUpperCase();
					
					Categoria c = new Categoria(CodigoC, NombreC);
					
					s.getSesion().save(c);
					s.confirmar();
					lblError.setText("Has creado la categoría correctamente!");
					lblError.setForeground(Color.GREEN);
					}
					catch(NumberFormatException ex){
						lblError.setText("No puedes dejar campos vacios");
						lblError.setForeground(Color.RED);
					}
			}
		});
		contentPane.add(btnRegistrar);
		
		JLabel lblLista = new JLabel("Lista de categor\u00EDas");
		lblLista.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblLista.setBounds(604, 316, 180, 34);
		contentPane.add(lblLista);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.setBounds(10, 527, 89, 23);
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu i = new Menu();
				i.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnInicio);
		
		JLabel lblUs = new JLabel("New label");
		lblUs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUs.setBounds(670, 531, 120, 14);
		contentPane.add(lblUs);
		lblUs.setText(Inicio.Usuario);
	}
	
	private List sacaCat() {
		Sesion s = new Sesion();
		s.comenzarTransaccion();
		TypedQuery q = s.getSesion().createQuery("SELECT nombre FROM Categoria");
		List l = q.getResultList();
		return l;
	}
}
