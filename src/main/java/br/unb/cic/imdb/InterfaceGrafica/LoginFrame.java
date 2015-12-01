package br.unb.cic.imdb.InterfaceGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;

public class LoginFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginPanel currentPanel;
	
	public LoginFrame() {		
		currentPanel = new LoginPanel();
		
		setupFrame();
	}

	private void setupFrame() {
		
		this.setContentPane(currentPanel);
		this.setSize(900, 600);
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Usu\u00E1rios\\Edgar\\Documents\\GitHub\\IMDB\\assets\\IMDb_logo.svg.png"));
		setTitle("IMDB");
		
	}

}
