package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEjercicio02 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	final private String TEXTLABELDEFECT="Has pulsado: ";

	/**
	 * Create the frame.
	 */
	public ViewEjercicio02() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel(TEXTLABELDEFECT);
		lblNewLabel.setBounds(100, 112, 135, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Boton 1");
		btnNewButton.addActionListener(mostrarUltimoBotonPulsado);
		btnNewButton.setBounds(56, 59, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBoton = new JButton("Boton 2");
		btnBoton.addActionListener(mostrarUltimoBotonPulsado);
		btnBoton.setBounds(168, 59, 89, 23);
		contentPane.add(btnBoton);
	}
	
	ActionListener mostrarUltimoBotonPulsado = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton botonPulsado = (JButton) e.getSource();
			lblNewLabel.setText(TEXTLABELDEFECT + botonPulsado.getText());
		}
		
	};
}
