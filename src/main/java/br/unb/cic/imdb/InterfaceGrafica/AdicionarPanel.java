package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;

import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.Main;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

public class AdicionarPanel extends panels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField title;
	private JTextField year;
	private JTextField gen;
	private JTextField des_gen;
	private JTextField aut;
	private JTextField des_aut;
	
	private JButton adicionar;
	private JButton cancelar;
	
	public AdicionarPanel() {
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		
		JLabel lblAdicionarTrabalhoArtstico = new JLabel("Adicionar Trabalho Artístico");
		lblAdicionarTrabalhoArtstico.setForeground(Color.WHITE);
		lblAdicionarTrabalhoArtstico.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAdicionarTrabalhoArtstico.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarTrabalhoArtstico.setBounds(272, 25, 355, 51);
		add(lblAdicionarTrabalhoArtstico);
		
		title = new JTextField();
		title.setBounds(353, 117, 492, 28);
		add(title);
		title.setColumns(10);
		
		JLabel lblTitle = new JLabel("Título");
		lblTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitle.setBounds(128, 117, 213, 30);
		add(lblTitle);
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(353, 178, 492, 28);
		add(year);
		
		JLabel lblYear = new JLabel("Ano");
		lblYear.setHorizontalAlignment(SwingConstants.RIGHT);
		lblYear.setForeground(Color.WHITE);
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(128, 175, 213, 30);
		add(lblYear);
		
		gen = new JTextField();
		gen.setColumns(10);
		gen.setBounds(353, 236, 492, 28);
		add(gen);
		
		JLabel lblGnero = new JLabel("Gênero");
		lblGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGnero.setForeground(Color.WHITE);
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGnero.setBounds(128, 236, 213, 30);
		add(lblGnero);
		
		des_gen = new JTextField();
		des_gen.setColumns(10);
		des_gen.setBounds(353, 299, 492, 28);
		add(des_gen);
		
		JLabel lblDescrioDoGnero = new JLabel("Descrição do Gênero");
		lblDescrioDoGnero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrioDoGnero.setForeground(Color.WHITE);
		lblDescrioDoGnero.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrioDoGnero.setBounds(128, 296, 213, 30);
		add(lblDescrioDoGnero);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAutor.setForeground(Color.WHITE);
		lblAutor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAutor.setBounds(128, 359, 213, 30);
		add(lblAutor);
		
		aut = new JTextField();
		aut.setColumns(10);
		aut.setBounds(353, 359, 492, 28);
		add(aut);
		
		des_aut = new JTextField();
		des_aut.setColumns(10);
		des_aut.setBounds(353, 414, 492, 28);
		add(des_aut);
		
		JLabel lblDescrioDoAutor = new JLabel("Descrição do Autor");
		lblDescrioDoAutor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrioDoAutor.setForeground(Color.WHITE);
		lblDescrioDoAutor.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescrioDoAutor.setBounds(128, 411, 213, 30);
		add(lblDescrioDoAutor);
		
		adicionar = new JButton("Adicionar");
		adicionar.setBackground(Color.GREEN);
		adicionar.setBounds(455, 477, 97, 25);
		adicionar.addActionListener(this);
		add(adicionar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setBackground(Color.RED);
		cancelar.setBounds(317, 477, 97, 25);
		cancelar.addActionListener(this);
		add(cancelar);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == adicionar){
			Autor a;
			Genero g;
			TrabalhoArtistico t;
			if(Main.facade.recuperarAutorPorNome(aut.getText()) == null){
				a = new Autor(aut.getText(), des_aut.getText());
				Main.facade.adicionaAutor(a);
			}
			else{
				a = Main.facade.recuperarAutorPorNome(aut.getText());
			}
			
			if(Main.facade.recuperarGeneroPorTitulo(gen.getText()) == null){
				g = new Genero(gen.getText(), des_gen.getText());
				Main.facade.adicionaGenero(g);
			}
			else{
				g = Main.facade.recuperarGeneroPorTitulo(gen.getText());
			}
			
			t = new TrabalhoArtistico(title.getText(), Integer.parseInt(year.getText()),g, a);
			Main.facade.recuperarTrabalhosArtisticos().add(t);
			a.setProducaoArtistica(Main.facade.recuperarTrabalhoArtisticoPorAutor(a));
			
			this.setVisible(false);
			Main.Frame.setPanel(new TrabalhoPanel());
		}
		
		if(e.getSource() == cancelar){
			this.setVisible(false);
			Main.Frame.setPanel(new TrabalhoPanel());
		}
		
	}
}
