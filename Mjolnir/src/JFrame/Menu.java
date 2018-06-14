package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Mjolnir Comics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		
		JButton btnCat = new JButton("Categor\u00EDa");
		btnCat.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnCat.setBounds(434, 215, 350, 100);
		btnCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CrearCategoria c = new CrearCategoria();
				c.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnCat);
		
		JButton btnProd = new JButton("Producto");
		btnProd.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnProd.setBounds(16, 215, 350, 100);
		btnProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MeterProducto p = new MeterProducto();
				p.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnProd);
		
		JButton btnEd = new JButton("Editorial");
		btnEd.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnEd.setBounds(16, 329, 350, 100);
		btnEd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MeterEditorial ed = new MeterEditorial();
				ed.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.add(btnEd);
		
		JLabel lblMjolnirComics = new JLabel("Mjolnir Comics");
		lblMjolnirComics.setBounds(5, 5, 774, 199);
		lblMjolnirComics.setIcon(new ImageIcon("C:\\Users\\omega\\eclipse-workspace\\Mjolnir\\img\\mjolnirtres.png"));
		lblMjolnirComics.setHorizontalAlignment(SwingConstants.CENTER);
		lblMjolnirComics.setFont(new Font("Times New Roman", Font.BOLD, 60));
		contentPane.add(lblMjolnirComics);
		
		JButton btnClose = new JButton("Cerrar");
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.RED);
		btnClose.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnClose.setBounds(434, 329, 350, 100);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		contentPane.add(btnClose);
	}
}
