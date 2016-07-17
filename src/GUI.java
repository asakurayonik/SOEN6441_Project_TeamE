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
	private JTextField textField_1;
	private JTextField textField_2;

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
		frame = new JFrame("CHEERS (Team-E)");
		frame.setBounds(100, 100, 400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(10, 186, 160, 50);
		frame.getContentPane().add(btnCalculate);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(202, 186, 160, 50);
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
		textArea.setBounds(202, 11, 160, 157);
		frame.getContentPane().add(textArea);
		
		JLabel lblParameter = new JLabel("Parameter:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParameter.setBounds(10, 86, 100, 14);
		frame.getContentPane().add(lblParameter);
		
		JLabel lblNewLabel = new JLabel("Precision =");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 111, 79, 31);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(98, 117, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText("10");
		
		JLabel lblTolerence = new JLabel("Tolerance =");
		lblTolerence.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTolerence.setBounds(10, 139, 79, 36);
		frame.getContentPane().add(lblTolerence);
		
		textField_2 = new JTextField();
		textField_2.setBounds(98, 148, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText("0.0001");
		
		//------------------------ event handler -----------------------
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			// Associate with Calculator
			public void mouseReleased(MouseEvent e) {			
				String s = textField.getText();		
				String s1 = textField_1.getText(); // precision for sin and cos
				String s2 = textField_2.getText(); //tolerance for Newton's Method
				
				if (s.matches("^[0-9]*([\\.,]{1}[0-9]*){0,1}$")
						&& s1.matches("^[1-9][0-9]{0,1}$")
						&& s2.matches("^[0-9]*([\\.,]{1}[0-9]*){0,1}$")){
					long tStart = System.currentTimeMillis(); //start time
					
					// -------------- Computing ----------------
					int p = Integer.parseInt(s1); 
					double t = Double.parseDouble(s2); 
					double R = Double.parseDouble(s);
					textArea.setText("R = " + R +"\nPrecision = " + p + "\nTolerance = " + t + "\n\n");
					Calculator c = new Calculator(p, t);			
					s = Double.toString(c.getL(R));
					textArea.append(s + "\n");
					// -------------- Computing ----------------
					
					long tEnd = System.currentTimeMillis(); //end time
					long tDelta = tEnd - tStart;
					double elapsedSeconds = tDelta / 1000.0;
					textArea.append("Used " + elapsedSeconds + " seconds.");
				}
				else {
					textArea.setText("Notice:\nR: Positive Number\nPrecision: From 1 to 99\nTolerance: Positive Number");
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
