package view;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewEjercicio05 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio05() {
		setTitle("Ejercicio 5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Borrar");
		btnNewButton.addActionListener(borrar);
		btnNewButton.setBounds(160, 11, 89, 23);
		contentPane.add(btnNewButton);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 45, 414, 205);
		textArea.addMouseListener(eventosRaton);
		contentPane.add(textArea);
	}
	
	MouseAdapter eventosRaton = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Clic del ratón,");
        }

        @Override
        public void mousePressed(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Ratón presionado,");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Ratón liberado,");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Ratón entró,");
        }

        @Override
        public void mouseExited(MouseEvent e) {
        	textArea.setText(textArea.getText() + " El ratón salió,");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Ratón arrastrado,");
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        	textArea.setText(textArea.getText() + " Ratón movido,");
        }
    };
    
    ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
		}
	};
}
