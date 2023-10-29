package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewEjercicio08 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCantidad;
	private JTextField textFieldResultado;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEjercicio08() {
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
		lblNewLabel_1.setBounds(244, 39, 129, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(133, 36, 86, 20);
		textFieldCantidad.addKeyListener(null);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		textFieldResultado = new JTextField();
		textFieldResultado.setEditable(false);
		textFieldResultado.setBounds(303, 36, 86, 20);
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
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.setBounds(300, 67, 89, 23);
		btnNewButton_2.addActionListener(borrar);
		contentPane.add(btnNewButton_2);
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
	
	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textFieldCantidad.setText("");
			textFieldResultado.setText("");
		}
	};
	
	KeyListener operarTeclado = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        	textFieldCantidad.setText(textFieldCantidad.getText() + e.getKeyChar());
        }

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
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
