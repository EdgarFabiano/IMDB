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
public class GeneroPanel extends panels{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List list = new List();
	private Label selecionado1;
	private Label selecionado2;
	private Label selecionado3;
	private JButton logout;
	private JButton close;
	private JRadioButton autor;
	private JRadioButton titulo;
	private JRadioButton genero;
	private TrabalhoArtistico trab;
	private Label label;
	private JButton adicionar;
	
	public GeneroPanel() {
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(1200,800);
		setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 24));
		list.setBounds(52, 118, 429, 501);
		
		selecionado1 = new Label("");
		selecionado1.setForeground(Color.WHITE);
		selecionado1.setFont(new Font("Dialog", Font.PLAIN, 18));
		selecionado1.setBounds(560, 128, 611, 43);
		add(selecionado1);
				
		
		PreencheGenero();
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
		autor.setSelected(false);
		autor.setBackground(Color.DARK_GRAY);
		autor.setBounds(52, 56, 127, 25);
		autor.addActionListener(this);
		add(autor);
		
		titulo = new JRadioButton("Trabalho artístico");
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titulo.setBackground(Color.DARK_GRAY);
		titulo.setSelected(false);
		titulo.setBounds(275, 56, 181, 25);
		titulo.addActionListener(this);
		add(titulo);
		
		genero = new JRadioButton("Gênero");
		genero.setForeground(Color.WHITE);
		genero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genero.setBackground(Color.DARK_GRAY);
		genero.setSelected(true);
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
		
		label = new Label("Selecione um Filtro");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(52, 10, 611, 43);
		add(label);
		
		adicionar = new JButton("Adicionar");
		adicionar.setBounds(834, 673, 97, 25);
		adicionar.addActionListener(this);
		add(adicionar);
		
		Label logado = new Label("Selecione um Filtro");
		logado.setAlignment(Label.RIGHT);
		logado.setForeground(Color.WHITE);
		logado.setFont(new Font("Dialog", Font.PLAIN, 18));
		logado.setBounds(722, 10, 449, 43);
		logado.setText("Olá, "+Main.user.getNome());
		add(logado);
		

	}
	
	private void PreencheGenero(){
		for(int i = 0; i < Main.facade.recuperarGeneros().size(); i++){
			list.add(Main.facade.recuperarGeneros().get(i).getTitulo());
		}
		list.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie){
	        	Genero gen = Main.facade.recuperarGeneros().get(list.getSelectedIndex());
	        	selecionado1.setText("Gênero: "+gen.getTitulo());
	        	selecionado2.setText("Descrição: "+gen.getDescricao());
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
			Main.Frame.setPanel(new AutorPanel());

		}
		
		/*Ao filtrar por TRABALHO ARTISTICO*/
		if(e.getSource() == titulo){
			Main.Frame.setPanel(new TrabalhoPanel());			
		}
		
		/*Ao filtrar por GÊNERO*/
		if(e.getSource() == genero){
			genero.setSelected(true);
			autor.setSelected(false);
			titulo.setSelected(false);
			list.removeAll();
			selecionado1.setText("");
			selecionado2.setText("");
			selecionado3.setText("");
			PreencheGenero();
		}
		
		if(e.getSource() == adicionar){
			this.setVisible(false);
			Main.Frame.setPanel(new AdicionarPanel());
		}
		
	}
}
