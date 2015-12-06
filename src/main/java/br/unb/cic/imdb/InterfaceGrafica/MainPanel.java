package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import br.unb.cic.imdb.negocio.Autor;
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
	private Label selecionado1 = new Label("Selecionado");
	private Label selecionado2;
	private Label selecionado3;
	private Label selecionado4;
	private JButton exit;
	private JButton logout;
	private JRadioButton autor;
	private JRadioButton titulo;
	private JRadioButton genero;
	
	public MainPanel() {
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(1200,800);
		setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 24));
		
		list.setBounds(52, 118, 429, 587);
				
		selecionado1.setForeground(Color.WHITE);
		selecionado1.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado1.setBounds(560, 128, 611, 43);
		add(selecionado1);
				
		
		for(int i = 0; i < Main.facade.recuperarAutores().size(); i++){
			list.add(Main.facade.recuperarAutores().get(i).getNome());
		}
		list.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	        	selecionado1.setText("Autor: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getNome());
	        	selecionado2.setText("Descrição: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getDescricao());
	        	selecionado3.setText("Produção artística: "+Main.facade.recuperarTrabalhoArtisticoPorAutor(Main.facade.recuperarAutores().get(list.getSelectedIndex())));
	        }
	    });
		
		
		add(list);
		
		exit = new JButton("Sair");
		exit.setBounds(929, 720, 97, 25);
		exit.addActionListener(this);
		exit.setVisible(true);
		add(exit);
		
		logout = new JButton("Fechar");
		logout.setBounds(1074, 720, 97, 25);
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
		
		genero = new JRadioButton("G\u00EAnero");
		genero.setForeground(Color.WHITE);
		genero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genero.setBackground(Color.DARK_GRAY);
		genero.setBounds(499, 58, 127, 25);
		genero.addActionListener(this);
		add(genero);
		
		selecionado2 = new Label("");
		selecionado2.setForeground(Color.WHITE);
		selecionado2.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado2.setBounds(560, 197, 611, 43);
		add(selecionado2);
		
		selecionado3 = new Label("");
		selecionado3.setForeground(Color.WHITE);
		selecionado3.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado3.setBounds(560, 268, 611, 219);
		add(selecionado3);
		
		selecionado4 = new Label("");
		selecionado4.setForeground(Color.WHITE);
		selecionado4.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado4.setBounds(560, 341, 611, 43);
		add(selecionado4);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == logout){
			System.exit(0);
		}
		if(e.getSource() == exit){
			Main.Frame.setPanel(new LoginPanel());
		}
		/*Ao filtrar por AUTOR*/
		if(e.getSource() == autor){
			titulo.setSelected(false);
			autor.setSelected(true);
			genero.setSelected(false);
			list.removeAll();
			selecionado1.setText("");
			for(int i = 0; i < Main.facade.recuperarAutores().size(); i++){
				list.add(Main.facade.recuperarAutores().get(i).getNome());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	selecionado1.setText("Autor: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getNome());
		        	selecionado2.setText("Descrição: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getDescricao());
		        	selecionado3.setText("Produção artística: "+Main.facade.recuperarTrabalhoArtisticoPorAutor(Main.facade.recuperarAutores().get(list.getSelectedIndex())));
		        }
		    });
		}
		/*Ao filtrar por TÍTULO*/
		if(e.getSource() == titulo){
			autor.setSelected(false);
			titulo.setSelected(true);
			genero.setSelected(false);
			list.removeAll();
			selecionado1.setText("");
			for(int i = 0; i < Main.facade.recuperarTrabalhosArtisticos().size(); i++){
				list.add(Main.facade.recuperarTrabalhosArtisticos().get(i).getTitulo());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	selecionado1.setText(Main.facade.recuperarTrabalhosArtisticos().get(list.getSelectedIndex()).getTitulo());
		        }
		    });
		}
		/*Ao filtrar por GÊNERO*/
		if(e.getSource() == genero){
			genero.setSelected(true);
			autor.setSelected(false);
			titulo.setSelected(false);
			list.removeAll();
			selecionado1.setText("");
			for(int i = 0; i < Main.facade.recuperarGeneros().size(); i++){
				list.add(Main.facade.recuperarGeneros().get(i).getTitulo());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	selecionado1.setText(Main.facade.recuperarGeneros().get(list.getSelectedIndex()).getTitulo());
		        }
		    });
		}
		
	}
}
