package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.List;
import java.awt.Label;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import br.unb.cic.imdb.negocio.*;

import javax.swing.JRadioButton;

import org.springframework.beans.factory.support.AutowireCandidateResolver;

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
	
	public MainPanel() {
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
				
		
//		for(int i = 0; i < Main.facade.recuperarAutores().size(); i++){
//			list.add(Main.facade.recuperarAutores().get(i).getNome());
//		}
//		list.addItemListener(new ItemListener(){
//	        public void itemStateChanged(ItemEvent ie){
//	        	selecionado1.setText("Autor: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getNome());
//	        	selecionado2.setText("Descrição: "+Main.facade.recuperarAutores().get(list.getSelectedIndex()).getDescricao());
//	        	
//	        	selecionado3.setText("Produção artística: "+Main.facade.recuperarTrabalhoArtisticoPorAutor(Main.facade.recuperarAutores().get(list.getSelectedIndex())));
//	        }
//	    });
		
		add(aux);
		add(list);
		
		logout = new JButton("Sair");
		logout.setBounds(929, 673, 97, 25);
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
		autor.setSelected(false);
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
		avaliar.setBounds(776, 673, 97, 25);
		avaliar.addActionListener(this);
		avaliar.setVisible(false);
		add(avaliar);
		
		label = new Label("Selecione um Filtro");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(52, 10, 611, 43);
		add(label);
		
		avaliacoes = new JButton("Avaliações");
		avaliacoes.setBounds(625, 673, 97, 25);
		avaliacoes.setVisible(false);
		add(avaliacoes);
		

	}
	
	public void avaliar(TrabalhoArtistico t){
		
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
			list.removeAll();
			selecionado1.setText("");
			selecionado2.setText("");
			selecionado3.setText("");
			for(int i = 0; i < Main.facade.recuperarAutores().size(); i++){
				list.add(Main.facade.recuperarAutores().get(i).getNome());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	Autor autor = Main.facade.recuperarAutorPorNome(list.getSelectedItem());
		        	selecionado1.setText("Autor: "+autor.getNome());
		        	selecionado2.setText("Descrição: "+autor.getDescricao());
		        	selecionado3.setText("");
		        	aux.removeAll();
		        	if(autor.getProducaoArtistica() != null){
			        	for(int i = 0; i < autor.getProducaoArtistica().size(); i++){
			        		System.out.println("\n\n\n"+autor.getProducaoArtistica().size()+"\n\n\n");
			        		aux.add(autor.getProducaoArtistica().get(i).getTitulo());//+"  "+autor.getProducaoArtistica().get(i).getAno() + "  "+autor.getProducaoArtistica().get(i).getGenero());
			        	}
			        }
		        	else{
			        	aux.add("Nenhuma produção artística");
			        }
		        }
		        
		    });
		}
		
		/*Ao filtrar por TRABALHO ARTISTICO*/
		if(e.getSource() == titulo){
			autor.setSelected(false);
			titulo.setSelected(true);
			genero.setSelected(false);
			aux.setVisible(false);
			selecionado1.setText("");
			selecionado2.setText("");
			selecionado3.setText("");
			selecionado1.setText("");
			for(int i = 0; i < Main.facade.recuperarTrabalhosArtisticos().size(); i++){
				list.add(Main.facade.recuperarTrabalhosArtisticos().get(i).getTitulo());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	trab = Main.facade.recuperarTrabalhoArtisticoPorTitulo(list.getSelectedItem());
		        	JFrame parent = new JFrame();
		        	avaliar.setVisible(true);
		        	avaliacoes.setVisible(true);
		        	selecionado1.setText(Integer.toString(trab.getAno()));
		        	selecionado2.setText(trab.getAutor().getNome());
		        	selecionado3.setText(trab.getGenero().getTitulo());
		        }
		    });
		}
		
		/*Ao filtrar por GÊNERO*/
		if(e.getSource() == genero){
			genero.setSelected(true);
			autor.setSelected(false);
			titulo.setSelected(false);
			list.removeAll();
			aux.removeAll();
			aux.setVisible(false);
			avaliar.setVisible(false);
			selecionado1.setText("");
			selecionado2.setText("");
			selecionado3.setText("");
			for(int i = 0; i < Main.facade.recuperarGeneros().size(); i++){
				list.add(Main.facade.recuperarGeneros().get(i).getTitulo());
			}
			list.addItemListener(new ItemListener(){
		        public void itemStateChanged(ItemEvent ie){
		        	Genero gen = Main.facade.recuperarGeneros().get(list.getSelectedIndex());
		        	selecionado1.setText(gen.getTitulo());
		        	selecionado2.setText(gen.getDescricao());
		        }
		    });
			avaliar.setVisible(false);
			avaliacoes.setVisible(false);
		}
		
		if(e.getSource() == avaliar){
			AvaliarPanel av = new AvaliarPanel(trab);
			this.setVisible(false);
			Main.Frame.setPanel(av);
		}
		
		if(e.getSource() == avaliacoes){
			
		}
		
	}
}
