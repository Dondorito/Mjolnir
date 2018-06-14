package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hibernate.Categoria;
import hibernate.Editorial;
import hibernate.Sesion;

import javax.swing.JLabel;
import java.awt.Font;

import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class MeterEditorial extends JFrame {

	private JPanel contentPane;
	private JTextField textEditorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MeterEditorial frame = new MeterEditorial();
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
	public MeterEditorial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblRegistrarEditorial = new JLabel("Registrar Editorial");
		lblRegistrarEditorial.setIcon(new ImageIcon("C:\\Users\\omega\\eclipse-workspace\\Mjolnir\\img\\mjolnirtres.png"));
		lblRegistrarEditorial.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblRegistrarEditorial.setBounds(10, 11, 764, 199);
		contentPane.add(lblRegistrarEditorial);
		
		JLabel lblError = new JLabel("");
		lblError.setBounds(10, 380, 524, 14);
		contentPane.add(lblError);
		
		JLabel lblEditorial = new JLabel("Editorial");
		lblEditorial.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblEditorial.setBounds(10, 221, 774, 49);
		contentPane.add(lblEditorial);
		
		textEditorial = new JTextField();
		textEditorial.setBounds(10, 284, 764, 20);
		contentPane.add(textEditorial);
		textEditorial.setColumns(10);
		
		JComboBox comboEd = new JComboBox();
		comboEd.setBounds(604, 360, 170, 20);
		contentPane.add(comboEd);
		
		for(int i=0;i<sacaEd().size();i++) {
			comboEd.addItem(sacaEd().get(i));
		}
		
		JLabel lblListaDeEditoriales = new JLabel("Lista de Editoriales");
		lblListaDeEditoriales.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblListaDeEditoriales.setBounds(594, 315, 180, 34);
		contentPane.add(lblListaDeEditoriales);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Sesion s = new Sesion();
					s.comenzarTransaccion();
					BigDecimal CodigoC = new BigDecimal(0);
					String NC = textEditorial.getText();
					String NombreC = NC.toUpperCase();
					
					Editorial e = new Editorial(CodigoC, NombreC);
					
					s.getSesion().save(e);
					s.confirmar();
					lblError.setText("Has introducido la editorial correctamente!");
					lblError.setForeground(Color.GREEN);
					}
					catch(NumberFormatException ex){
						lblError.setText("No puedes dejar campos vacios");
						lblError.setForeground(Color.RED);
					}
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 315, 120, 35);
		contentPane.add(btnNewButton);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu i = new Menu();
				i.setVisible(true);
				setVisible(false);
			}
		});
		btnInicio.setBounds(10, 527, 89, 23);
		contentPane.add(btnInicio);
		
		JLabel lblUs = new JLabel((String) null);
		lblUs.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUs.setBounds(670, 531, 120, 14);
		contentPane.add(lblUs);
		lblUs.setText(Inicio.Usuario);
	}
	
	private List sacaEd() {
		Sesion s = new Sesion();
		s.comenzarTransaccion();
		TypedQuery q = s.getSesion().createQuery("SELECT nombre FROM Editorial");
		List l = q.getResultList();
		return l;
	}
}
