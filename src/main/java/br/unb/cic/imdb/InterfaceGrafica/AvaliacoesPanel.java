package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;

import br.unb.cic.imdb.negocio.Main;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AvaliacoesPanel extends panels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TrabalhoArtistico trab;
	private ArrayList<JLabel> lbl = new ArrayList<JLabel>();
	private JButton back;
	private List list = new List();
	
	public AvaliacoesPanel(TrabalhoArtistico t) {
		this.trab = t;
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		list.setMultipleSelections(true);
		list.setForeground(Color.WHITE);
		list.setBackground(Color.DARK_GRAY);
		list.setFont(new Font("Arial", Font.PLAIN, 18));
		list.setBounds(102, 135, 696, 366);
		add(list);
		
		
		JLabel label = new JLabel("Avaliações de "+trab.getTitulo());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(272, 47, 355, 51);
		add(label);
		
				
		back = new JButton("Voltar");
		back.setBounds(401, 518, 97, 25);
		back.addActionListener(this);
		add(back);
		
		if(trab.getAvaliacoesRecebidas() != null){
			for(int i = 0; i < trab.getAvaliacoesRecebidas().size(); i++){
				list.add(trab.getAvaliacoesRecebidas().get(i).getComentario()+" - "+
						" Por: "+trab.getAvaliacoesRecebidas().get(i).getAvaliador().getNome()+
						" - "+trab.getAvaliacoesRecebidas().get(i).getAvaliacao()+" stars ");
			}
		}
		else{
			list.add("Sem avaliações");			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			this.setVisible(false);
			Main.Frame.setPanel(new TrabalhoPanel());
		}
		
	}

}
