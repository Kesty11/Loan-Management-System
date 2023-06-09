package Loan_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class Loan_System {

	private JFrame frame;
	private JTextField txtInterest;
	private JTextField txtYear;
	private JTextField txtAmount;
	private JTextField txtMPayment;
	private JTextField txtTPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan_System window = new Loan_System();
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
	public Loan_System() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(27, 25, 1302, 60);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("LOAN MANAGEMENT SYSTEMS CALCULATOR");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Enter Interest Rate e.g. 4.5");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(27, 143, 367, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterNumberOf = new JLabel("Enter Number of Year e.g. 4 as integer");
		lblEnterNumberOf.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterNumberOf.setBounds(27, 221, 492, 36);
		frame.getContentPane().add(lblEnterNumberOf);
		
		JLabel lblEnterAmountOf = new JLabel("Enter Amount of Loan");
		lblEnterAmountOf.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterAmountOf.setBounds(27, 293, 367, 36);
		frame.getContentPane().add(lblEnterAmountOf);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment");
		lblMonthlyPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblMonthlyPayment.setBounds(27, 372, 367, 36);
		frame.getContentPane().add(lblMonthlyPayment);
		
		JLabel lblTotalPayment = new JLabel("Total Payment");
		lblTotalPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTotalPayment.setBounds(27, 450, 367, 36);
		frame.getContentPane().add(lblTotalPayment);
		
		txtInterest = new JTextField();
		txtInterest.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtInterest.setBounds(569, 150, 214, 36);
		frame.getContentPane().add(txtInterest);
		txtInterest.setColumns(10);
		
		JTextArea txtReceipt = new JTextArea();
		txtReceipt.setBounds(896, 143, 413, 371);
		frame.getContentPane().add(txtReceipt);
		
		txtYear = new JTextField();
		txtYear.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtYear.setColumns(10);
		txtYear.setBounds(569, 221, 214, 36);
		frame.getContentPane().add(txtYear);
		
		txtAmount = new JTextField();
		txtAmount.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtAmount.setColumns(10);
		txtAmount.setBounds(569, 293, 214, 36);
		frame.getContentPane().add(txtAmount);
		
		txtMPayment = new JTextField();
		txtMPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtMPayment.setColumns(10);
		txtMPayment.setBounds(569, 369, 214, 36);
		frame.getContentPane().add(txtMPayment);
		
		txtTPayment = new JTextField();
		txtTPayment.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtTPayment.setColumns(10);
		txtTPayment.setBounds(569, 450, 214, 36);
		frame.getContentPane().add(txtTPayment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(27, 562, 1319, 25);
		frame.getContentPane().add(separator);
		
		JButton btnLoan = new JButton("Loan Calculator");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double Interest = Double.parseDouble(txtInterest.getText());
			    double monthlyInterest = Interest / 1200;
			    int Year = Integer.parseInt(txtYear.getText());
			    double loan = Double.parseDouble(txtAmount.getText());
			    
			    double MPayment = loan * monthlyInterest/(1-1/Math.pow(1+monthlyInterest, Year * 12));
			    String iMPayment;
			    iMPayment = Double.toString(MPayment);
			    iMPayment = String.format("£%.2f",MPayment);
			    txtMPayment.setText(iMPayment);
			    
			    double TPayment = MPayment * Year * 12;
			    String iTPayment;
			    iTPayment = String.format("£%.2f",TPayment);
			    txtTPayment.setText(iTPayment);
			}
		});
		btnLoan.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLoan.setBounds(37, 585, 259, 45);
		frame.getContentPane().add(btnLoan);
		
		JButton btnGenerateReceipt = new JButton("Generate Receipt");
		btnGenerateReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Interest = String.format(txtInterest.getText());
				String Year = String.format(txtYear.getText());
				String Loan = String.format(txtAmount.getText());
				String MPayment = String.format(txtMPayment.getText());
				String TPayment = String.format(txtTPayment.getText());
				
				int refs = 1325 + (int) (Math.random()*4328);
				
				     Calendar timer = Calendar.getInstance();
				     timer.getTime();
				     SimpleDateFormat tTime = new SimpleDateFormat("HH:mm:ss");
				     tTime.format(timer.getTime());
				     SimpleDateFormat Tdate = new SimpleDateFormat("dd-MMM-yyyy");
				     Tdate.format(timer.getTime());
				     
				     
				     
				     txtReceipt.append("\tLoan Management Systems\n" +
				     "Reference:\t\t\t" + refs +
				     "\n===================================\t" +
				     "\nInterest:\t\t\t" + Interest +
				     "\nRepayment years:\t\t" + Year +
				     "\nAmount of Loan:\t\t\t" + "£" + Loan +
				     "\nMonthly Payment:\t\t" + MPayment + 
				     "\nTotal Payment:\t\t\t" + TPayment +
				     "\n========================================\t" + 
				     "\nDate: " + Tdate.format(timer.getTime())+
				     "\t\tTime: " + tTime.format(timer.getTime())+
				     "\n\n\t\tThank You\n" );
			}
		});
		btnGenerateReceipt.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnGenerateReceipt.setBounds(367, 585, 259, 45);
		frame.getContentPane().add(btnGenerateReceipt);
		
		JButton btnResetCalculator = new JButton("Reset Calculator");
		btnResetCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtInterest.setText(null);
				txtYear.setText(null);
				txtAmount.setText(null);
				txtMPayment.setText(null);
				txtTPayment.setText(null);
			}
		});
		btnResetCalculator.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnResetCalculator.setBounds(700, 585, 259, 45);
		frame.getContentPane().add(btnResetCalculator);
		
		JButton btnExitCalculator = new JButton("Exit Calculator");
		btnExitCalculator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Loan Management Systems",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExitCalculator.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnExitCalculator.setBounds(1040, 585, 259, 45);
		frame.getContentPane().add(btnExitCalculator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(27, 648, 1319, 5);
		frame.getContentPane().add(separator_1);
		

	}
}
