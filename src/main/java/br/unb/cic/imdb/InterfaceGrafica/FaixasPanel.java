package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;

import br.unb.cic.imdb.negocio.AlbumMusical;
import br.unb.cic.imdb.negocio.FaixaMusical;
import br.unb.cic.imdb.negocio.Main;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class FaixasPanel extends panels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TrabalhoArtistico trab;
	private ArrayList<JLabel> lbl = new ArrayList<JLabel>();
	private JButton back;
	private List list = new List();
	private JButton evaluate = new JButton("Avaliar");
	
	public FaixasPanel(TrabalhoArtistico t) {
		this.trab = t;
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		list.setForeground(Color.WHITE);
		list.setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 18));
		list.setBounds(102, 135, 696, 366);
		add(list);
		
		
		JLabel label = new JLabel("Faixas musicais de "+trab.getTitulo());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(272, 47, 355, 51);
		add(label);
		
				
		back = new JButton("Voltar");
		back.setBackground(Color.RED);
		back.setBounds(322, 518, 97, 25);
		back.addActionListener(this);
		add(back);
		
		evaluate.setBackground(Color.GREEN);
		evaluate.addActionListener(this);
		evaluate.setBounds(464, 518, 97, 25);
		
		add(evaluate);
		java.util.List<FaixaMusical> l = Main.facade.recuperarFaixaMusicalPorAutor((AlbumMusical) trab);
		if(l != null){
			for(int i = 0; i < l.size(); i++){
				list.add(l.get(i).getTitulo()+" - "+
						l.get(i).getDuracao() +" minutos");
			}
		}
		else{
			list.add("Sem Faixas");			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			this.setVisible(false);
			Main.Frame.setPanel(new TrabalhoPanel());
		}
		if(e.getSource() == evaluate){
			this.setVisible(false);
			Main.Frame.setPanel(new AvaliarPanel(trab));
		}
		
	}

}
