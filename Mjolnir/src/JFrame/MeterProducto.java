package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hibernate.Categoria;
import hibernate.Editorial;
import hibernate.Producto;
import hibernate.Sesion;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.awt.event.ActionEvent;

public class MeterProducto extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JTextField textPVP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeterProducto frame = new MeterProducto();
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
	public MeterProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Registrar producto");
		lblTitulo.setBounds(10, 11, 774, 199);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 221, 64, 24);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblNombre);
		
		JLabel lblCategoria = new JLabel("Categor\u00EDa");
		lblCategoria.setBounds(10, 256, 77, 24);
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblCategoria);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setBounds(10, 291, 91, 24);
		lblEditorial.setHorizontalAlignment(SwingConstants.LEFT);
		lblEditorial.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblEditorial);
		
		JLabel lblPreciocoste = new JLabel("PrecioCoste");
		lblPreciocoste.setBounds(10, 326, 97, 24);
		lblPreciocoste.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreciocoste.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblPreciocoste);
		
		JLabel lblPvp = new JLabel("PVP");
		lblPvp.setBounds(10, 361, 97, 24);
		lblPvp.setHorizontalAlignment(SwingConstants.LEFT);
		lblPvp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		contentPane.add(lblPvp);
		
		textNombre = new JTextField();
		textNombre.setBounds(113, 226, 254, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JComboBox comboCat = new JComboBox();
		comboCat.setBounds(113, 261, 240, 20);
		contentPane.add(comboCat);
		
		for(int i=0;i<sacaCat().size();i++) {
			comboCat.addItem(sacaCat().get(i));
		}
		
		JComboBox comboEd = new JComboBox();
		comboEd.setBounds(113, 296, 237, 20);
		contentPane.add(comboEd);
		
		for(int i=0;i<sacaEd().size();i++) {
			comboEd.addItem(sacaEd().get(i));
		}
		
		textPrecio = new JTextField();
		textPrecio.setBounds(113, 331, 231, 20);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textPVP = new JTextField();
		textPVP.setBounds(113, 366, 231, 20);
		contentPane.add(textPVP);
		textPVP.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(10, 396, 774, 27);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Sesion s = new Sesion();
				Categoria c = (Categoria) comboCat.getSelectedItem();
				Editorial e = (Editorial) comboEd.getSelectedItem();
				
				s.comenzarTransaccion();
				
				BigDecimal codigo = new BigDecimal(0);
				String nombre = textNombre.getText().toUpperCase();
				
				BigDecimal precio = new BigDecimal(textPrecio.getText());
				BigDecimal pvp = new BigDecimal(textPVP.getText());
				
				Producto p = new Producto(codigo, c, e, nombre, precio, pvp);
				
				s.getSesion().save(p);
				s.confirmar();
			}
		});
		
		JButton button = new JButton("Inicio");
		button.setBounds(10, 566, 91, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu i = new Menu();
				i.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(button);
		btnRegistrar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		contentPane.add(btnRegistrar);
		
		JLabel lblUs = new JLabel((String) null);
		lblUs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUs.setBounds(670, 531, 120, 14);
		contentPane.add(lblUs);
		lblUs.setText(Inicio.Usuario);
	}
	
	private List sacaCat() {
		Sesion s = new Sesion();
		s.comenzarTransaccion();
		TypedQuery q = s.getSesion().createQuery("FROM Categoria");
		List l = q.getResultList();
		return l;
	}
	private List sacaEd() {
		Sesion s = new Sesion();
		s.comenzarTransaccion();
		TypedQuery q = s.getSesion().createQuery("FROM Editorial");
		List l = q.getResultList();
		return l;
	}
}
