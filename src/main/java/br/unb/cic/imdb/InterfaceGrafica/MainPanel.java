package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;

import javax.swing.JButton;

import br.unb.cic.imdb.negocio.Main;
import javax.swing.JRadioButton;

/** Painel principal do programa
 * 
 * @author EdgarFabiano
 *
 */
public class MainPanel extends panels{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List list = new List();
	private Label selecionado = new Label("Selecionado");
	private JButton exit;
	private JButton logout;
	private JRadioButton autor;
	private JRadioButton titulo;
	
	public MainPanel() {
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(1200,800);
		setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 24));
		
		list.setBounds(52, 118, 429, 587);
				
		selecionado.setForeground(Color.WHITE);
		selecionado.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado.setBounds(560, 128, 212, 61);
		add(selecionado);
		
		for(int i = 0; i < 130; i++){
			list.add("Item "+Integer.toString(i));
			list.getItem(i);
		}
		list.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	        	selecionado.setText("Você selecionou o "+list.getSelectedItem());
	        }
	    });
		add(list);
		
		exit = new JButton("Sair");
		exit.setBounds(933, 680, 97, 25);
		exit.addActionListener(this);
		exit.setVisible(true);
		add(exit);
		
		logout = new JButton("Fechar");
		logout.setBounds(1073, 680, 97, 25);
		logout.addActionListener(this);
		add(logout);
		
		autor = new JRadioButton("Autor");
		autor.setForeground(Color.WHITE);
		autor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		autor.setSelected(true);
		autor.setBackground(Color.DARK_GRAY);
		autor.setBounds(52, 56, 127, 25);
		autor.addActionListener(this);
		add(autor);
		
		titulo = new JRadioButton("Título");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBackground(Color.DARK_GRAY);
		titulo.setBounds(275, 56, 127, 25);
		titulo.addActionListener(this);
		add(titulo);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout){
			System.exit(0);
		}
		if(e.getSource() == exit){
			Main.Frame.setPanel(new LoginPanel());
		}
		if(e.getSource() == autor){
			titulo.setSelected(false);
			autor.setSelected(true);
		}
		if(e.getSource() == titulo){
			autor.setSelected(false);
			titulo.setSelected(true);
		}
		
	}
}
