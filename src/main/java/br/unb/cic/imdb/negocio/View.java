package br.unb.cic.imdb.negocio;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Atua como um componente de apresentacao (view), 
 * exibindo a interface gráfica com as opções para o usuário.
 * 
 * @author EdgarFabiano
 */
public class View extends JFrame implements ActionListener{
	
	private JLabel Title = new JLabel();
	private JPanel panel; 
	public static Container contentArea;
	
	/**
	 * Construtor da classe View
	 */
	public View(){
		super("Internet Media Data Bank");
		
		Title.setText("IMDB");
		
		contentArea = getContentPane ();
		
		setSize (900, 900);  
		setVisible(true);
		contentArea.setBackground(Color.black); 
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		 
//		panel = new JPanel (); 
//		GridLayout experimentLayout = new GridLayout (4, 5); 
//		panel.setLayout (experimentLayout); 
//		panel.setBackground (Color.black); 
//		panel.add(Title);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
