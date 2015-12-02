package br.unb.cic.imdb.InterfaceGrafica;

import javax.swing.JFrame;
import java.awt.Toolkit;


/**Janela principal do programa, onde os novos painéis que herdam panels
 * podem ser facilmente instanciados e colocados aqui nas trocas de telas
 * 
 * @author EdgarFabiano
 *
 */
public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private panels currentPanel;
	
	public MainFrame(panels p) {		
		setPanel(p);
		setupFrame();
	}
	
	public void setPanel(panels p){
		currentPanel = p;
		this.setContentPane(currentPanel);
		currentPanel.setVisible(true);
	}

	private void setupFrame() {
		
		this.setSize(900, 600);
		this.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Usu\u00E1rios\\Edgar\\Documents\\GitHub\\IMDB\\assets\\IMDb_logo.svg.png"));
		setTitle("IMDB");
		
	}

}
