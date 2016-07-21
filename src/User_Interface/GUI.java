package User_Interface;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;

import Incarnation_1.Calculator;
import Incarnation_2.JavaCalculator;

import javax.swing.JTextArea;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {

	private JFrame frame;
	private JTextField textField_R;
	private JTextArea textArea;
	private JButton btnCalculate;
	private JButton btnExit;
	private JTextField textField_Precision;
	private JTextField textField_Tolerance;

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
		btnCalculate.setBounds(10, 186, 174, 31);
		frame.getContentPane().add(btnCalculate);

		btnExit = new JButton("Exit");
		btnExit.setBounds(10, 220, 174, 31);
		frame.getContentPane().add(btnExit);

		JLabel lblInput = new JLabel("Input:");
		lblInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInput.setBounds(10, 10, 63, 22);
		frame.getContentPane().add(lblInput);

		JLabel lblR = new JLabel("R =");
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblR.setBounds(10, 45, 46, 14);
		frame.getContentPane().add(lblR);

		textField_R = new JTextField();
		textField_R.setBounds(40, 44, 70, 20);
		frame.getContentPane().add(textField_R);
		textField_R.setColumns(10);

		textArea = new JTextArea();
		textArea.setBounds(202, 11, 160, 240);
		frame.getContentPane().add(textArea);

		JLabel lblParameter = new JLabel("Parameter:");
		lblParameter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblParameter.setBounds(10, 86, 100, 14);
		frame.getContentPane().add(lblParameter);

		JLabel lblNewLabel = new JLabel("Precision =");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 111, 79, 31);
		frame.getContentPane().add(lblNewLabel);

		textField_Precision = new JTextField();
		textField_Precision.setBounds(98, 117, 86, 20);
		frame.getContentPane().add(textField_Precision);
		textField_Precision.setColumns(10);
		textField_Precision.setText("50");	// default precision

		JLabel lblTolerence = new JLabel("Tolerance =");
		lblTolerence.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTolerence.setBounds(10, 139, 79, 36);
		frame.getContentPane().add(lblTolerence);

		textField_Tolerance = new JTextField();
		textField_Tolerance.setBounds(98, 148, 86, 20);
		frame.getContentPane().add(textField_Tolerance);
		textField_Tolerance.setColumns(10);
		textField_Tolerance.setText("0.0001");	//default tolerance

		// ------------------------ event handler -----------------------
		btnCalculate.addMouseListener(new MouseAdapter() {
			@Override
			// Associate with Calculator
			public void mouseReleased(MouseEvent e) {
				String s = textField_R.getText();
				String s1 = textField_Precision.getText(); // precision for sin and cos
				String s2 = textField_Tolerance.getText(); // tolerance for Newton's
													// Method

				if (s.isEmpty() || s.equals("0"))
					JOptionPane.showMessageDialog(null, "Please enter a number greater than 0");
				else {
					if (s.matches("^[0-9]*([\\.,]{1}[0-9]{0,9}){0,1}$") && s1.matches("^[1-9][0-9]{0,1}$")
							&& s2.matches("^[0-9]*([\\.,]{1}[0-9]{0,9}){0,1}$")) {
						
						// -------------- Computing Incarnation 1 ----------------
						long tStart = System.currentTimeMillis(); // start time
						int p = Integer.parseInt(s1);
						double t = Double.parseDouble(s2);
						double R = Double.parseDouble(s);
						textArea.setText("R = " + R + "\nPrecision = " + p + "\nTolerance = " + t + "\n\n");
						Calculator c = new Calculator(p, t);
						double result1 = c.getL(R);
						s = Double.toString(result1);
						textArea.append("Incarnation 1:\n" + s + "\n");
						long tEnd = System.currentTimeMillis(); // end time
						long tDelta = tEnd - tStart;
						double elapsedSeconds = tDelta / 1000.0;
						textArea.append("Used " + elapsedSeconds + " seconds.\n");
						// -------------------------------------------------------
						
						// -------------- Computing Incarnation 2 ----------------
						tStart = System.currentTimeMillis(); // start time
						JavaCalculator jc = new JavaCalculator();
						double result2 = jc.getL(R);
						s = Double.toString(result2);
						textArea.append("Incarnation 2:\n" + s + "\n");
						tEnd = System.currentTimeMillis(); // end time
						tDelta = tEnd - tStart;
						elapsedSeconds = tDelta / 1000.0;
						textArea.append("Used " + elapsedSeconds + " seconds.\n");
						// -------------------------------------------------------
						
						// -------------- Error Check ----------------
						double relativeError = Math.abs(result1 - result2) / result2;
						textArea.append("Relative Error:\n" + relativeError + "\n");
						
					} else {
						textArea.setText(
								"Notice:\nR: Positive Number\nPrecision: From 1 to 99\nTolerance: Positive Number");
					}
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
