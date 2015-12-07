package br.unb.cic.imdb.InterfaceGrafica;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JLabel;

import br.unb.cic.imdb.negocio.Main;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.SwingConstants;

import org.hibernate.cfg.naming.ImprovedNamingStrategyDelegator;


/** Painel de Login do usuário
 * @author Edgar Fabiano
 *
 */
@SuppressWarnings("unused")
public class LoginPanel extends panels implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton enterButton;
	public JTextField userField;
	public JTextField senhaField;
	public JLabel lblSenha;
	public JLabel lblLogin;
	
	private String user;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}

	private String password;
	public JLabel lbl;
	private JButton cadastroButton;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**Construtor da classe LoginPanel
	 * Gera o painel que será inserido na MainFrame
	 */
	public LoginPanel() {
		
		setup();
		
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);	
		setBackground(Color.DARK_GRAY);
		
		userField = new JTextField();
		userField.setToolTipText("Digite seu Login aqui");
		userField.setBounds(342, 234, 215, 22);
		add(userField);
		userField.setColumns(10);
		
		lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLogin.setBounds(247, 237, 83, 16);
		add(lblLogin);
		
		senhaField = new JPasswordField();
		senhaField.setToolTipText("Digite sua senha aqui");
		senhaField.setBounds(342, 282, 215, 22);
		add(senhaField);
		senhaField.setColumns(10);
		
		
		lblSenha = new JLabel("Senha");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(274, 284, 56, 16);
		add(lblSenha);
		
		enterButton = new JButton("Entrar");
		enterButton.setFont(new Font("Arial", Font.PLAIN, 18));
		enterButton.setBackground(Color.yellow);
		enterButton.addActionListener(this);
		enterButton.setBounds(394, 343, 111, 40);
		this.add(enterButton);
				
		lbl = new JLabel("Login");
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbl.setBounds(288, 170, 324, 30);
		lbl.setForeground(Color.WHITE);
		add(lbl);
		
		cadastroButton = new JButton("Cadastrar!");
		cadastroButton.setToolTipText("Não possui um cadastro ainda?");
		cadastroButton.addActionListener(this);
		cadastroButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cadastroButton.setBounds(384, 444, 132, 30);
		this.add(cadastroButton);
		cadastroButton.setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == enterButton){
			setPassword(senhaField.getText());
			setUser(userField.getText());
			/*Colocar as condições caso o usuário não esteja no BD*/
			try {
				if(Main.facade.autenticarUsuario(getUser(), getPassword())){
					Main.user = Main.facade.recuperarUsuarioPorLogin(getUser());
				
					lbl.setText("Foi");
					Main.Frame.setPanel(new AutorPanel());
				}
				else{
					lbl.setText("Login Inválido");
				}
			}
			catch (NullPointerException exception) {
				lbl.setText("Conta Inexistente");
				cadastroButton.setVisible(true);
			}

		}
		if(e.getSource() == cadastroButton){
			this.setVisible(false);
			Main.Frame.setPanel(new CadastroPanel());
		}
		
	}

}
