package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewEjercicio03 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblBoton;
	private int countBtn1 = 0;
	private int countBtn2 = 0;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio03() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Boton 1: 0 veces");
		lblNewLabel.setBounds(38, 33, 135, 14);
		contentPane.add(lblNewLabel);

		lblBoton = new JLabel("Boton 2: 0 veces");
		lblBoton.setBounds(242, 33, 135, 14);
		contentPane.add(lblBoton);

		JButton btnNewButton = new JButton("Boton 1");
		btnNewButton.addActionListener(mostrarUltimoBotonPulsado);
		btnNewButton.setBounds(56, 59, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnBoton = new JButton("Boton 2");
		btnBoton.addActionListener(mostrarUltimoBotonPulsado);
		btnBoton.setBounds(260, 59, 89, 23);
		contentPane.add(btnBoton);

	}

	ActionListener mostrarUltimoBotonPulsado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton botonPulsado = (JButton) e.getSource();
			if (botonPulsado.getText().equals("Boton 1")) {
				countBtn1++;
				lblNewLabel.setText(botonPulsado.getText() + ": " + countBtn1 + " veces");
			} else {
				countBtn2++;
				lblBoton.setText(botonPulsado.getText() + ": " + countBtn2 + " veces");
			}
		}

	};
}
