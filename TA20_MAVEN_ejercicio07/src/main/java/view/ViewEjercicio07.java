package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class ViewEjercicio07 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldResultado;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio07() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad a convertir:");
		lblNewLabel.setBounds(10, 42, 160, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(231, 42, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(120, 39, 86, 20);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setBounds(290, 39, 86, 20);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);
		
		btnNewButton = new JButton("Euros a ptas");
		btnNewButton.setBounds(80, 67, 110, 23);
		btnNewButton.addActionListener(conversor);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cambiar");
		btnNewButton_1.addActionListener(cambiar);
		btnNewButton_1.setBounds(200, 67, 89, 23);
		contentPane.add(btnNewButton_1);
	}
	
	ActionListener conversor = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			double valor = validarNumero(textFieldCantidad.getText());
			if(valor != Double.MIN_VALUE) {
				calcular(valor, btn.getText());
			}
		}
	};
	
	ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(btnNewButton.getText().equals("Euros a ptas")) {
				btnNewButton.setText("Ptas a euros");
			} else {
				btnNewButton.setText("Euros a ptas");
			}
		}
	};
	
	private double validarNumero(String text) {
		double num = Double.MIN_VALUE;
		if(!estaVacio(text)){
			JOptionPane.showMessageDialog(contentPane, "Los campos no pueden estar vacios");
		}
		
		num = esNumeroValido(text);
		return num;
	}
	
	private boolean estaVacio(String text) {
		return !text.isEmpty();
	}
	
	private double esNumeroValido(String text) {
		double valor = Double.MIN_VALUE;
		String textSinComa = comprobarComa(text);
		try {
			if(valor > 0) {
				valor = Double.parseDouble(textSinComa);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Has de introducir un número positivo");
		}
		return valor;
	}
	
	private String comprobarComa(String text) {

		text = text.replace(',', '.');
		text = text.replace('\'', '.');

		return text;
	}
	
	private void calcular(double valor, String opcion) {
		DecimalFormat df = new DecimalFormat("#.##");
		
		if(opcion.equals("Euros a ptas")) {
			valor = valor * 166.386;
		} else {
			valor = valor / 166.386;
		}
		
		textFieldResultado.setText(df.format(valor));
	}
}
