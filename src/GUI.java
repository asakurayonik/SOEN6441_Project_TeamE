import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField;
	private JTextArea textArea;
	private JButton btnCalculate;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 320, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(10, 75, 100, 50);
		frame.getContentPane().add(btnCalculate);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(10, 135, 100, 50);
		frame.getContentPane().add(btnExit);
		
		JLabel lblInput = new JLabel("Input:");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInput.setBounds(10, 10, 63, 22);
		frame.getContentPane().add(lblInput);
		
		JLabel lblR = new JLabel("R =");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblR);
		
		textField = new JTextField();
		textField.setBounds(40, 44, 70, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(120, 12, 174, 173);
		frame.getContentPane().add(textArea);
		
		//------------------------ event handler -----------------------
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			// Associate with Calculator
			public void mouseReleased(MouseEvent e) {				
				String s = textField.getText();				
				if (s.matches("^[0-9]*([\\.,]{1}[0-9]*){0,1}$")){
					// -------------- do the computation here -----------------
					/*double rad = Double.parseDouble(textField.getText());
					Approximation a = new Approximation();
					s = Double.toString(a.getCos(rad));*/
					Calculator c = new Calculator();				
					s = Double.toString(c.getAlpha());
					textArea.setText(s);
				}
				else {
					textArea.setText("Please input a positive number.");
				}		
			}
		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
	}
}
