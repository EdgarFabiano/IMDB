package br.unb.cic.imdb.InterfaceGrafica;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;

import br.unb.cic.imdb.negocio.Main;

import java.awt.event.ActionEvent;
import java.awt.Font;


/** Painel de cadastro do novo usuário
 * 
 * @author EdgarFabiano
 *
 */
public class CadastroPanel extends panels {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton CadastroButton;
	private JButton backButton;
	private JTextField newUserField;
	private JTextField senhaField;
	private JTextField ConfirmaSenhaField;
	private JLabel lbl;
	
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String Confimapassword;
	public String getConfirmaPassword() {
		return Confimapassword;
	}
	public void setConfirmaPassword(String password) {
		this.Confimapassword = password;
	}

	/**Construtor da classe CadastroPanel
	 * Gera o painel que será inserido na MainFrame
	 */
	public CadastroPanel() {
				
		setup();
		
	}
	
	private void setup(){		
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		
		CadastroButton = new JButton("Cadastrar");
		CadastroButton.setFont(new Font("Arial", Font.PLAIN, 18));
		CadastroButton.setBackground(Color.WHITE);
		CadastroButton.addActionListener(this);
		CadastroButton.setBounds(387, 394, 125, 40);
		this.add(CadastroButton);
		
		
		newUserField = new JTextField();
		newUserField.setToolTipText("Informar novo Login");
		newUserField.setBounds(342, 234, 215, 22);
		add(newUserField);
		newUserField.setColumns(10);
		
		JLabel lblLogin = new JLabel("Novo Usu\u00E1rio");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogin.setBounds(214, 237, 116, 16);
		add(lblLogin);
		
		senhaField = new JPasswordField();
		senhaField.setToolTipText("Informar nova senha");
		senhaField.setBounds(342, 282, 215, 22);
		add(senhaField);
		senhaField.setColumns(10);
		
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(260, 284, 56, 16);
		add(lblSenha);
		
		JLabel logo = new JLabel();
		logo.setToolTipText("IMDB");
		//Image img = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		//logo.setIcon(new ImageIcon(img));
		logo.setBounds(342, 49, 200, 103);
		add(logo);
		
		lbl = new JLabel("Cadastro");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl.setBounds(392, 170, 116, 30);
		lbl.setForeground(Color.WHITE);
		add(lbl);
		
		ConfirmaSenhaField = new JPasswordField();
		ConfirmaSenhaField.setToolTipText("Confirmar nova senha");
		ConfirmaSenhaField.setBounds(342, 330, 215, 22);
		add(ConfirmaSenhaField);
		ConfirmaSenhaField.setColumns(10);
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar Senha");
		lblConfirmarSenha.setForeground(Color.WHITE);
		lblConfirmarSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConfirmarSenha.setBounds(184, 333, 146, 16);
		add(lblConfirmarSenha);
		
		backButton = new JButton("Voltar");
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		backButton.addActionListener(this);
		backButton.setBounds(401, 464, 97, 25);
		add(backButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == CadastroButton){
			setPassword(senhaField.getText());
			setUser(newUserField.getText());
			setConfirmaPassword(ConfirmaSenhaField.getText());
			lbl.setText("Foi!");
			System.out.println(getUser()+" "+getPassword()+" "+getConfirmaPassword());
		}
		
		if(e.getSource() == backButton){
			this.setVisible(false);
			Main.Frame.setPanel(new LoginPanel());
		}
		
	}
}
