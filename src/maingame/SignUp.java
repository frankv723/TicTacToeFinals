package maingame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Cursor;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Insets;


public class SignUp {

    // Global Variable declaration ----------------------------------------------
	Credentials id1;
	public JFrame frame;
	private JTextField txtname;
	private JTextField txtUsername;
	private JPasswordField textPass;
	private JPasswordField textreppass;
	private JTextField txtEmail;
	private JLabel Loginbtn;
	private JLabel pName;
	private JLabel userName;
	private JLabel mailE;
	private JLabel PasswordLbl;
	private JLabel RepPasswordlbl;
	private JCheckBox Agreechkbox;
	private JLabel playervalidation;
	private JLabel uservalidation;
	private JLabel emailvalidation;
	private JLabel passwordvalidation;
	private JLabel reppassvalidation;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp(null);
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
	public SignUp(Credentials id) {
		
		// initializes Credentials.java and/or receive its data ----------------------------------
		id1 =id;
		initialize();
	}
	

	public void callLogin() {
		
		// Calls Login Jframe Method ---------------------------------------------------------
		Login lg = new Login(id1);
		lg.frame.setVisible(true);
		frame.dispose();
		
	}
	public void openWebPage(String url){
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
	}
	public void setStuff() {
		
		// Sends data to Credentials to save user data -------------------------------------------
		String fName = txtname.getText();
		String uName = txtUsername.getText();
		String pass1 = String.valueOf(textPass.getPassword());
		String mail = txtEmail.getText();
		
		id1.setFname(fName);
		id1.setUname(uName);
		id1.setpass1(pass1);
		id1.setemail(mail);
	}
	
	
	public boolean checkFields(){ 
		/* 
		 * Checks all Fields if its empty and matches required format ------------------------------------
		 */
		String sName = txtname.getText();
		String uName = txtUsername.getText();
		String mail = txtEmail.getText();
		String pass1 = String.valueOf(textPass.getPassword());
		String pass2 = String.valueOf(textreppass.getPassword());

		String email = "^[^@\\s]+@[^@\\s\\.]+\\.[^@\\.\\s]+$";
		Pattern pattern = Pattern.compile(email, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txtEmail.getText());		

		
		if (sName.trim().equals("Player Name")) {
			playervalidation.setVisible(true);
		}
		if (uName.trim().equals("Username")) {
			uservalidation.setVisible(true);
		}
		if (mail.trim().equals("Email")) {
			emailvalidation.setVisible(true); 
		}
		if (pass1.trim().equals("Password")) {
			passwordvalidation.setVisible(true);
		}
		if (pass2.trim().equals("Repeat Password")) {
			reppassvalidation.setVisible(true);
		}
		else if (!matcher.matches()) {
			emailvalidation.setVisible(true);
			JOptionPane.showMessageDialog(null, "Improper Email Format", "Verify Email", 2);
		}
		else if (!pass1.equals(pass2)) {
			JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Confirm Password", 2); 
			 return false;
		}
		else if (Agreechkbox.isSelected() == false) {
			JOptionPane.showMessageDialog(null, "Agree to the Terms and Conditions", "Confirm Service Usage", 2); 
			return false;
		}
		else {
			return true;
		}
		return false;
		

	}
	
	private void initialize() {

		// JFrame location -------------------------------------------------------
		Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
		Dimension frameSize = new Dimension (900, 824);
	
		// JFrame initialization -------------------------------------------------
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		frame.setBounds (ss.width / 2 - frameSize.width / 2, ss.height/2 - frameSize.height/2,frameSize.width, frameSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Close Button -----------------------------------------------------------
		JButton Close = new JButton("X");
		Close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int exitconfirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "", JOptionPane.YES_NO_OPTION);
				if (exitconfirmation == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		Close.setFocusPainted(false);
		Close.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		Close.setBackground(new Color(62, 62, 62));
		Close.setForeground(new Color(255, 255, 255));
		Close.setBounds(845, 11, 45, 30);
		frame.getContentPane().add(Close);
		
		//Minimize Button --------------------------------------------------------
		JButton Mini = new JButton("_");
		Mini.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Mini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		Mini.setFocusPainted(false);
		Mini.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 15));
		Mini.setBackground(new Color(62, 62, 62));
		Mini.setForeground(new Color(255, 255, 255));
		Mini.setBounds(797, 11, 45, 30);
		frame.getContentPane().add(Mini);
		
		
		
		// *Sign up Form* 
		
		// Player Name Label and TextField--------------------------------------
		pName = new JLabel("Player Name");
		pName.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		pName.setForeground(new Color(255, 181, 0));
		pName.setBounds(450, 153, 142, 28);
		pName.setVisible(false);
		frame.getContentPane().add(pName);
		
		
		txtname = new JTextField();
		txtname.setText("Player Name");
		txtname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtname.getText().trim().equals("") || 
						txtname.getText().trim().toLowerCase().equals("player name")) {
				txtname.setFont(new Font("Tahoma", Font.PLAIN, 22));
				txtname.setText("");
				}
				playervalidation.setVisible(false);
				pName.setVisible(true);

			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtname.getText().trim().equals("") || 
						txtname.getText().trim().toLowerCase().equals("player name")) {
				txtname.setText("Player Name");
				txtname.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
				pName.setVisible(false);
				}
				
			}
		});
		txtname.setBorder(null);
		txtname.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtname.setBackground(Color.WHITE);
		txtname.setBounds(456, 189, 363, 43);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		//Username label and Text Field ---------------------------------------
		userName = new JLabel("Username");
		userName.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		userName.setForeground(new Color(255, 181, 0));
		userName.setVisible(false);
		userName.setBounds(450, 243, 126, 28);
		frame.getContentPane().add(userName);
		
		txtUsername = new JTextField();
		txtUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 22));
				txtUsername.setText("");
				
				}
				uservalidation.setVisible(false);
				userName.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txtUsername.getText().trim().equals("") || 
						txtUsername.getText().trim().toLowerCase().equals("username")) {
				txtUsername.setText("Username");
				txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
				userName.setVisible(false);
				}
			}
		});
		txtUsername.setText("Username");
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setBounds(456, 274, 363, 43);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		//Email Label and TextField ----------------------------------------------
		   mailE = new JLabel("Email");
			mailE.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			mailE.setForeground(new Color(255, 181, 0));
			mailE.setVisible(false);
			mailE.setBounds(450, 328, 86, 28);
			frame.getContentPane().add(mailE);
			
			txtEmail = new JTextField("");
			txtEmail.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (txtEmail.getText().trim().equals("") || 
							txtEmail.getText().trim().toLowerCase().equals("email")) {
						txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 22));
						txtEmail.setText("");
					}
					emailvalidation.setVisible(false);
					mailE.setVisible(true);
				}
				@Override
				public void focusLost(FocusEvent e) {
					if (txtEmail.getText().trim().equals("") || 
							txtEmail.getText().trim().toLowerCase().equals("email")) {
						txtEmail.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
						txtEmail.setText("Email");
					mailE.setVisible(false);
					}
				}
			});
			txtEmail.setText("Email");
			txtEmail.setBorder(null);
			txtEmail.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			txtEmail.setBackground(Color.WHITE);
			txtEmail.setBounds(456, 358, 363, 43);
			frame.getContentPane().add(txtEmail);
			txtEmail.setColumns(10);
			
			// Password Label and TextField ---------------------------------------------------
			PasswordLbl = new JLabel("Password");
			PasswordLbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			PasswordLbl.setForeground(new Color(255, 181, 0));
			PasswordLbl.setVisible(false);
			PasswordLbl.setBounds(450, 412, 120, 28);
			frame.getContentPane().add(PasswordLbl);
			
			textPass = new JPasswordField("Password");
			textPass.setEchoChar((char)0);
			textPass.addFocusListener(new FocusAdapter() {
				public void focusGained(FocusEvent e) {
					if (String.valueOf(textPass.getPassword()).trim().equals("") || 
							String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")) {
					textPass.setFont(new Font("Tahoma", Font.PLAIN, 22));
					textPass.setText("");
					}
					passwordvalidation.setVisible(false);
					PasswordLbl.setVisible(true);
					textPass.setEchoChar((char)0);
				}
				public void focusLost(FocusEvent e) {
					if (String.valueOf(textPass.getPassword()).trim().equals("") || 
							String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")) {
						textPass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
						textPass.setText("Password");
					PasswordLbl.setVisible(false);
					textPass.setEchoChar((char)0); 
					}else if(!String.valueOf(textPass.getPassword()).trim().equals("") || 
							!String.valueOf(textPass.getPassword()).trim().toLowerCase().equals("password")){
						textPass.setEchoChar('*'); 
					}
					reppassvalidation.setVisible(false);
				}
			});
			textPass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
			textPass.setBorder(null);
			textPass.setBackground(Color.WHITE);
			textPass.setBounds(456, 444, 363, 43);
			frame.getContentPane().add(textPass);
		
		// Repeat Password label and Textfield ---------------------------------------------------------
		RepPasswordlbl = new JLabel("Repeat Password");
		RepPasswordlbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		RepPasswordlbl.setForeground(new Color(255, 181, 0));
		RepPasswordlbl.setVisible(false);
		RepPasswordlbl.setBounds(450, 498, 257, 33);
		frame.getContentPane().add(RepPasswordlbl);
		
		textreppass = new JPasswordField("Repeat Password");
		textreppass.setEchoChar((char)0);
		textreppass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(textreppass.getPassword()).trim().equals("") || 
						String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")) {
					textreppass.setFont(new Font("Tahoma", Font.PLAIN, 22));
					textreppass.setText("");
					reppassvalidation.setVisible(false);
				}
				RepPasswordlbl.setVisible(true);
				textreppass.setEchoChar((char)0);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(textreppass.getPassword()).trim().equals("") || 
						String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")) {
					textreppass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
					textreppass.setText("Repeat Password");
				RepPasswordlbl.setVisible(false);
				textreppass.setEchoChar((char)0); 
				}else if(!String.valueOf(textreppass.getPassword()).trim().equals("") || 
						!String.valueOf(textreppass.getPassword()).trim().toLowerCase().equals("repeat password")){
					textreppass.setEchoChar('*'); 
				}
			}
		});
		textreppass.setFont(new Font("Luckiest Guy", Font.PLAIN, 22));
		textreppass.setBorder(null);
		textreppass.setBackground(Color.WHITE);
		textreppass.setBounds(456, 532, 358, 43);
		frame.getContentPane().add(textreppass);
		
		
		//Signup Label/Button ---------------------------------------------------
		JLabel SignupLbl = new JLabel("Sign Up");
		SignupLbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignupLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(checkFields()) {
					setStuff();
					JOptionPane.showMessageDialog(null, "Account Registered!");
					callLogin();
				}

			}
		});
		SignupLbl.setForeground(new Color(255, 181, 0));
		SignupLbl.setFont(new Font("Luckiest Guy", Font.PLAIN, 20));
		SignupLbl.setBounds(739, 727, 86, 28);
		frame.getContentPane().add(SignupLbl);
		
		// Signup Shape/ Button -------------------------------------------------
		JLabel SignUpbtn = new JLabel("");
		SignUpbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SignUpbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
					if(checkFields()) {
						setStuff();
						JOptionPane.showMessageDialog(null, "Account Registered!");
						callLogin();
					}
				
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/Ellipse60p.png")).getImage();
		SignUpbtn.setIcon(new ImageIcon(img2));
		SignUpbtn.setBounds(744, 662, 60, 60);
		frame.getContentPane().add(SignUpbtn);
		
		
		// Login Tab Label ------------------------------------------------------
		Loginbtn = new JLabel("Login");
		Loginbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Loginbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				callLogin();
			}
		});
		Loginbtn.setBounds(732, 77, 114, 43);
		Loginbtn.setForeground(new Color(0, 0, 0));
		Loginbtn.setFont(new Font("Luckiest Guy", Font.PLAIN, 33));
		frame.getContentPane().add(Loginbtn);
		
		// Agree Label -----------------------------------------------------------
		JLabel agree = new JLabel("I Agree to The ");
		agree.setForeground(new Color(255, 181, 0));
		agree.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		agree.setBounds(496, 596, 142, 30);
		frame.getContentPane().add(agree);
		
		JLabel lblNewLabel_2 = new JLabel("and");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setForeground(new Color(255, 181, 0));
		lblNewLabel_2.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(580, 616, 45, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("<HTML><U>Terms of Service</U></HTML>");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebPage("https://sites.google.com/view/tictactoeproject/terms?authuser=0");
				lblNewLabel.setForeground(new Color(255, 255, 255));
			}
		});
		lblNewLabel.setForeground(new Color(255, 181, 0));
		lblNewLabel.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		lblNewLabel.setBounds(631, 596, 181, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<HTML><U>Privacy Policy</U></HTML>");
		lblNewLabel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebPage("https://sites.google.com/view/tictactoeproject/privacy-policy?authuser=0");
				lblNewLabel_1.setForeground(new Color(255, 255, 255));
			}
		});
		lblNewLabel_1.setForeground(new Color(255, 181, 0));
		lblNewLabel_1.setFont(new Font("Luckiest Guy", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(631, 625, 212, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		// Tictac Toe gif -------------------------------------------------------
		JLabel gifXO = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/TicTac160p.gif")).getImage();
		gifXO.setIcon(new ImageIcon(img5));
		gifXO.setBounds(222, 40, 160, 160);
		frame.getContentPane().add(gifXO);
		
		// Agree Checkbox -------------------------------------------------------
				Agreechkbox = new JCheckBox("");
				Agreechkbox.setMinimumSize(new Dimension(30, 30));
				Agreechkbox.setMaximumSize(new Dimension(30, 30));
				Agreechkbox.setMargin(new Insets(0, 0, 0, 0));
				Agreechkbox.setSize(new Dimension(10, 10));
				Agreechkbox.setPreferredSize(new Dimension(30, 30));
				Agreechkbox.setBackground(new Color(62, 62, 62));
				Agreechkbox.setSelected(false);
				Agreechkbox.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						
					}
				});
				Agreechkbox.setBounds(471, 596, 21, 23);
				frame.getContentPane().add(Agreechkbox);
				
		//Form Validation Labels-----------------------------------------------------
		playervalidation = new JLabel("is required. *");
		playervalidation.setForeground(Color.ORANGE);
		playervalidation.setBackground(Color.WHITE);
		playervalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		playervalidation.setBounds(631, 161, 188, 14);
		playervalidation.setVisible(false);
		frame.getContentPane().add(playervalidation);	
		
		uservalidation = new JLabel("is required. *");
		uservalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		uservalidation.setForeground(Color.ORANGE);
		uservalidation.setBackground(Color.WHITE);
		uservalidation.setBounds(631, 251, 188, 14);
		uservalidation.setVisible(false);
		frame.getContentPane().add(uservalidation);
		
		emailvalidation = new JLabel("is required. *");
		emailvalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		emailvalidation.setForeground(Color.ORANGE);
		emailvalidation.setBackground(Color.WHITE);
		emailvalidation.setBounds(631, 336, 188, 14);
		emailvalidation.setVisible(false);
		frame.getContentPane().add(emailvalidation);
		
		passwordvalidation = new JLabel("is required. *");
		passwordvalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordvalidation.setForeground(Color.ORANGE);
		passwordvalidation.setBackground(Color.WHITE);
		passwordvalidation.setBounds(631, 420, 188, 14);
		passwordvalidation.setVisible(false);
		frame.getContentPane().add(passwordvalidation);
		
		reppassvalidation = new JLabel("is required. *");
		reppassvalidation.setHorizontalAlignment(SwingConstants.RIGHT);
		reppassvalidation.setForeground(Color.ORANGE);
		reppassvalidation.setBackground(Color.WHITE);
		reppassvalidation.setBounds(631, 508, 188, 14);
		reppassvalidation.setVisible(false);
		frame.getContentPane().add(reppassvalidation);
		
		JLabel haveaccount = new JLabel("Already have an account?");
		haveaccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		haveaccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				haveaccount.setForeground(new Color(208, 49, 45));
				Login in = new Login(id1);
				in.frame.setVisible(true);
				frame.dispose();
			}
			public void mouseEntered(MouseEvent e) {
				haveaccount.setText("<HTML><U>Already have an account?</U></HTML>");
			}
			public void mouseExited(MouseEvent e) {
				haveaccount.setText("Already have an account?");
			}
		});
		haveaccount.setFont(new Font("Luckiest Guy", Font.PLAIN, 15));
		haveaccount.setForeground(new Color(255, 181, 0));
		haveaccount.setBounds(456, 727, 212, 28);
		frame.getContentPane().add(haveaccount);
		
		// Jlabel Background ----------------------------------------------------
		JLabel Background = new JLabel("");
		Background.setHorizontalTextPosition(SwingConstants.RIGHT);
		Background.setFont(new Font("Luckiest Guy", Font.PLAIN, 23));
		Image img = new ImageIcon(this.getClass().getResource("/SignUp2.png")).getImage();
		Background.setIcon(new ImageIcon(img));
		Background.setBounds(0, 0, 900, 824);
		frame.getContentPane().add(Background);		
		
	}
}
