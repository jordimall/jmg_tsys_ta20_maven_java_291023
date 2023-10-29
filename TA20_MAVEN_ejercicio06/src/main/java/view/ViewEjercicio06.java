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

public class ViewEjercicio06 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldMetros;
	private JTextField textFieldPeso;
	private JTextField textFieldResultado;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio06() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Altura (metros):");
		lblNewLabel.setBounds(24, 37, 117, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPesokg = new JLabel("peso (kg):");
		lblPesokg.setBounds(234, 37, 117, 14);
		contentPane.add(lblPesokg);

		JLabel lblImc = new JLabel("IMC");
		lblImc.setBounds(162, 69, 117, 14);
		contentPane.add(lblImc);

		textFieldMetros = new JTextField();
		textFieldMetros.setBounds(113, 34, 86, 20);
		contentPane.add(textFieldMetros);
		textFieldMetros.setColumns(10);

		textFieldPeso = new JTextField();
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(297, 34, 86, 20);
		contentPane.add(textFieldPeso);

		textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setBounds(184, 66, 86, 20);
		contentPane.add(textFieldResultado);
		textFieldResultado.setColumns(10);

		JButton btnNewButton = new JButton("Calcular IMC");
		btnNewButton.addActionListener(calcularIMC);
		btnNewButton.setBounds(24, 65, 129, 23);
		contentPane.add(btnNewButton);

	}

	ActionListener calcularIMC = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			double peso = validarNumero(textFieldPeso.getText());
			double altura = validarNumero(textFieldMetros.getText());
			if (peso != Double.MIN_VALUE && altura != Double.MIN_VALUE) {
				calcular(altura, peso);
			}
		}
	};

	private double validarNumero(String text) {
		double num = Double.MIN_VALUE;
		if (!estaVacio(text)) {
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
			if (valor > 0) {
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

	private void calcular(double altura, double peso) {
		DecimalFormat df = new DecimalFormat("#.##");
		double result = peso / (altura * altura);

		textFieldResultado.setText(df.format(result));
	}
}
