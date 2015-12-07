package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.Main;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

public class AutorPanel extends panels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List list = new List();
	private List aux = new List();
	private Label selecionado1;
	private Label selecionado2;
	private Label selecionado3;
	private JButton logout;
	private JButton close;
	private JButton avaliar;
	private JRadioButton autor;
	private JRadioButton titulo;
	private JRadioButton genero;
	private TrabalhoArtistico trab;
	private Label label;
	private JButton avaliacoes;
	private JButton adicionar;
	
	public AutorPanel() {
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(1200,800);
		setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 24));
		list.setBounds(52, 118, 429, 501);
		
		aux.setFont(new Font("Arial", Font.PLAIN, 24));
		aux.setBounds(560, 307, 611, 312);
		
		selecionado1 = new Label("");
		selecionado1.setForeground(Color.WHITE);
		selecionado1.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado1.setBounds(560, 128, 611, 43);
		add(selecionado1);
				
		
		PreencheAutor();
		
		add(aux);
		add(list);
		
		logout = new JButton("Logout");
		logout.setBounds(952, 673, 97, 25);
		logout.addActionListener(this);
		logout.setVisible(true);
		add(logout);
		
		close = new JButton("Fechar");
		close.setBounds(1074, 673, 97, 25);
		close.addActionListener(this);
		add(close);
		
		autor = new JRadioButton("Autor");
		autor.setForeground(Color.WHITE);
		autor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		autor.setSelected(true);
		autor.setBackground(Color.DARK_GRAY);
		autor.setBounds(52, 56, 127, 25);
		autor.addActionListener(this);
		add(autor);
		
		titulo = new JRadioButton("Trabalho artístico");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBackground(Color.DARK_GRAY);
		titulo.setBounds(275, 56, 181, 25);
		titulo.addActionListener(this);
		add(titulo);
		
		genero = new JRadioButton("Gênero");
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
		selecionado3.setBounds(560, 268, 611, 55);
		add(selecionado3);
		
		avaliar = new JButton("Avaliar");
		avaliar.setBounds(711, 673, 97, 25);
		avaliar.addActionListener(this);
		avaliar.setVisible(false);
		add(avaliar);
		
		label = new Label("Selecione um Filtro");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(52, 10, 611, 43);
		add(label);
		
		avaliacoes = new JButton("Avaliações");
		avaliacoes.setBounds(578, 673, 97, 25);
		avaliacoes.setVisible(false);
		avaliacoes.addActionListener(this);
		add(avaliacoes);
		
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(834, 673, 97, 25);
		adicionar.addActionListener(this);
		add(adicionar);
		

	}
		
	private void PreencheAutor(){
		for(int i = 0; i < Main.facade.recuperarAutores().size(); i++){
			list.add(Main.facade.recuperarAutores().get(i).getNome());
		}
		list.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	        	Autor aut = Main.facade.recuperarAutorPorNome(list.getSelectedItem());
	        	avaliacoes.setVisible(false);
				avaliar.setVisible(false);
	        	selecionado1.setText("Autor: "+aut.getNome());
	        	selecionado2.setText("Descrição: "+aut.getDescricao());
	        	selecionado3.setText("Trabalhos Artísticos");
	        	aux.removeAll();
	        	if(aut.getProducaoArtistica() != null){
		        	for(int i = 0; i < aut.getProducaoArtistica().size(); i++){
		        		aux.add(aut.getProducaoArtistica().get(i).getTitulo()+" - "+aut.getProducaoArtistica().get(i).getAno() + " - "+aut.getProducaoArtistica().get(i).getGenero().getTitulo());
		        	}
		        	aux.addItemListener(new ItemListener(){
		    	        public void itemStateChanged(ItemEvent ie){
		    	        	avaliacoes.setVisible(true);
		    				avaliar.setVisible(true);
		    				trab = Main.facade.recuperarTrabalhoArtisticoPorTitulo(aux.getSelectedItem());
			        }
			    });
		        }
	        	else{
	        		System.out.println("não foi");
		        	aux.add("Nenhuma produção artística");
		        }
	        }
	        
	    });
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close){
			System.exit(0);
		}
		if(e.getSource() == logout){
			Main.Frame.setPanel(new LoginPanel());
		}
		/*Ao filtrar por AUTOR*/
		if(e.getSource() == autor){
			titulo.setSelected(false);
			autor.setSelected(true);
			genero.setSelected(false);
			avaliar.setVisible(false);
			avaliacoes.setVisible(false);
			aux.setVisible(true);
			aux.removeAll();
			list.removeAll();
			selecionado1.setText("");
			selecionado2.setText("");
			selecionado3.setText("");
			PreencheAutor();
		}
		
		/*Ao filtrar por TRABALHO ARTISTICO*/
		if(e.getSource() == titulo){
			Main.Frame.setPanel(new TrabalhoPanel());
			
		}
		
		/*Ao filtrar por GÊNERO*/
		if(e.getSource() == genero){
			Main.Frame.setPanel(new GeneroPanel());	
		}
		
		if(e.getSource() == avaliar){
			AvaliarPanel av = new AvaliarPanel(trab);
			this.setVisible(false);
			Main.Frame.setPanel(av);
		}
		
		if(e.getSource() == avaliacoes){
			this.setVisible(false);
			Main.Frame.setPanel(new AvaliacoesPanel(trab));
		}
		
		if(e.getSource() == adicionar){
			this.setVisible(false);
			Main.Frame.setPanel(new AdicionarPanel());
		}
		
	}
}
