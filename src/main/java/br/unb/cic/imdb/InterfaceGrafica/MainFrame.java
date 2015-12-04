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
		this.setSize(currentPanel.getWidth(), currentPanel.getHeight());
		this.setVisible(true);
	}

	private void setupFrame() {
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/com/sun/java/swing/plaf/motif/icons/Inform.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("IMDB");
		
	}

}
