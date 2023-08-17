package a06;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JMenu;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JRadioButton;

public class AirportGUI {

	private JFrame frame;
	private JTextField departureTextField;
	private JTextField destinationTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AirportGUI window = new AirportGUI();
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
	public AirportGUI() {
		initialize();
		departureTextField.setText("📍  Current Location");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.requestFocusInWindow();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1239, 680);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton findButton = new JButton("🔎");
		findButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		findButton.setBounds(541, 69, 60, 27);
		frame.getContentPane().add(findButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 114, 1233, 10);
		frame.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(716, 114, 1, 2);
		frame.getContentPane().add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 489, 717, 2);
		frame.getContentPane().add(separator_2);

		JLabel lblNewLabel = new JLabel("Trip Planner\r\n");

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(37, 11, 174, 47);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("List of Trips:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(726, 135, 140, 56);
		frame.getContentPane().add(lblNewLabel_1);

		departureTextField = new JTextField();
		departureTextField.setText("📍  Current Location");
		departureTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				departureTextField.setText("");
				departureTextField.removeFocusListener(this);
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});

		departureTextField.setBounds(37, 69, 242, 27);
		frame.getContentPane().add(departureTextField);
		departureTextField.setColumns(10);

		destinationTextField = new JTextField();
		destinationTextField.setText("🔎  Where would you like to go?");
		destinationTextField.setColumns(10);
		destinationTextField.setBounds(289, 69, 242, 27);
		frame.getContentPane().add(destinationTextField);

	}

	public void addNotify() {
		super.notify();
		this.departureTextField.requestFocus();
	}
}
