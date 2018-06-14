package JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	public static String Usuario;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
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
	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		JLabel lblIntroduceElUsuario = new JLabel("Introducir Usuario");
		lblIntroduceElUsuario.setIcon(new ImageIcon("C:\\Users\\omega\\eclipse-workspace\\Mjolnir\\img\\mjolnirtres.png"));
		lblIntroduceElUsuario.setBounds(0, 5, 784, 166);
		lblIntroduceElUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblIntroduceElUsuario.setFont(new Font("Times New Roman", Font.BOLD, 50));
		contentPane.add(lblIntroduceElUsuario);
		
		textField = new JTextField();
		textField.setBounds(185, 182, 414, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(180, 220, 424, 14);
		contentPane.add(lblError);
		
		btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario = textField.getText();
				if(Usuario.equals("")) {
					lblError.setText("Tienes que meterte una ralla de coca");
					lblError.setForeground(Color.RED);
				}
				else {
				lblError.setText("Has insertado el usuario correctamente!");
				lblError.setForeground(Color.GREEN);
				Menu m = new Menu();
				m.setVisible(true);
				setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(348, 245, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btnCerrar.setForeground(Color.WHITE);
		btnCerrar.setBackground(Color.RED);
		btnCerrar.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnCerrar.setBounds(10, 566, 89, 23);
		contentPane.add(btnCerrar);
	}
}
