package view;

import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ViewEjercicio04 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public ViewEjercicio04() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Eventos:");
		lblNewLabel.setBounds(10, 114, 128, 14);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(65, 11, 359, 239);
		textArea.addMouseListener(eventoClicar);
		contentPane.addMouseListener(eventoClicar);
		contentPane.add(textArea);
		
	    addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowOpened(WindowEvent e) {
	            textArea.append("La ventana ha sido abierta\n");
	        }

	        @Override
	        public void windowClosing(WindowEvent e) {
	            textArea.append("La ventana está siendo cerrada\n");
	        }

	        @Override
	        public void windowClosed(WindowEvent e) {
	            textArea.append("La ventana ha sido cerrada\n");
	        }
	    });
	    
	    addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                textArea.append("Ventana redimensionada\n");
            }
        });
	    

	}
	
	MouseAdapter eventoClicar = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            textArea.append("Clic en la ventana en (" + e.getX() + ", " + e.getY() + ")\n");
        }
    };
}
