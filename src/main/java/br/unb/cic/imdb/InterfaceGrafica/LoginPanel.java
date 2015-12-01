package br.unb.cic.imdb.InterfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import java.awt.Color;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class LoginPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	private JTextField userField;
	private JTextField senhaField;
	
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	private String password;
	private JLabel lbl;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**Construtor da classe LoginPanel
	 * Gera o painel que será inserido no LoginFrame
	 */
	public LoginPanel() {
		
		enterButton = new JButton("Entrar");
		enterButton.setFont(new Font("Arial", Font.PLAIN, 18));
		enterButton.setBackground(Color.yellow);
		enterButton.addActionListener(this);
		enterButton.setBounds(394, 343, 111, 40);
		
		setup();
		
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		this.add(enterButton);
		
		setBackground(Color.DARK_GRAY);
		
		userField = new JTextField();
		userField.setToolTipText("Digite seu usu\u00E1rio aqui");
		userField.setBounds(342, 234, 215, 22);
		add(userField);
		userField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Usu\u00E1rio");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogin.setBounds(247, 237, 83, 16);
		add(lblLogin);
		
		senhaField = new JPasswordField();
		senhaField.setToolTipText("Digite sua senha aqui");
		senhaField.setBounds(342, 282, 215, 22);
		add(senhaField);
		senhaField.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(247, 285, 56, 16);
		add(lblSenha);
		
		JLabel logo = new JLabel();
		logo.setToolTipText("IMDB");
		//Image img = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		//logo.setIcon(new ImageIcon(img));
		logo.setBounds(342, 49, 200, 103);
		add(logo);
		
		lbl = new JLabel("Login");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl.setBounds(414, 170, 71, 30);
		lbl.setForeground(Color.WHITE);
		add(lbl);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == enterButton){
			setPassword(senhaField.getText());
			setUser(userField.getText());
			lbl.setText("Foi!");
			System.out.println(getUser()+" "+getPassword());
			System.exit(0);
		}
		
	}

}
