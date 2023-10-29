package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ViewEjercicio01 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Redimensioname");
		lblNewLabel.setBorder(new LineBorder(Color.BLACK));
		lblNewLabel.setBounds(163, 187, 209, 31);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(20, 26, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("x:");
		lblNewLabel_1.setBounds(10, 29, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("y:");
		lblNewLabel_2.setBounds(136, 29, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 26, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Redimensionar");
		btnNewButton.addActionListener(redimensionar);
		btnNewButton.setBounds(258, 25, 114, 23);
		contentPane.add(btnNewButton);
		
	}
	
	ActionListener redimensionar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int width = lblNewLabel.getWidth();
			int heigth = lblNewLabel.getHeight();
			if(!estaVacio(textField.getText()) && esEntero(textField.getText())) {
				width = Integer.parseInt(textField.getText());
			}
			if(!estaVacio(textField_1.getText()) && esEntero(textField_1.getText())) {
				heigth = Integer.parseInt(textField.getText());
			}
			
			lblNewLabel.setSize(width, heigth);
		}
	};
	
	private boolean estaVacio(String text) {
		return text.isEmpty();
	}
	
	private boolean esEntero(String text) {
		try {
			int num = Integer.parseInt(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
