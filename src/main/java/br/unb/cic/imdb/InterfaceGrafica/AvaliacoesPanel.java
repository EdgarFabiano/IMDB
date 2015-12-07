package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;

import br.unb.cic.imdb.negocio.Main;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

public class AvaliacoesPanel extends panels{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TrabalhoArtistico trab;
	private ArrayList<JLabel> lbl = new ArrayList<JLabel>();
	
	public AvaliacoesPanel(TrabalhoArtistico t) {
		this.trab = t;
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		
		JLabel label = new JLabel("Avaliações de "+trab.getTitulo());
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(272, 47, 355, 51);
		add(label);
		
		JLabel label_1 = new JLabel("Avalia\u00E7\u00F5es de <dynamic>");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(83, 140, 734, 28);
		add(label_1);
		
		if(trab.getAvaliacoesRecebidas().isEmpty()){
			for(int i = 0; i < trab.getAvaliacoesRecebidas().size(); i++){
				lbl.add(new JLabel("Comentário: "+trab.getAvaliacoesRecebidas().get(i).getComentario()+
						"." +"- "+trab.getAvaliacoesRecebidas().get(i).getAvaliacao()+" stars -"+
						" Por: "+trab.getAvaliacoesRecebidas().get(i).getAvaliador().getNome()));
				lbl.get(i).setHorizontalAlignment(SwingConstants.CENTER);
				lbl.get(i).setForeground(Color.WHITE);
				lbl.get(i).setFont(new Font("Tahoma", Font.PLAIN, 18));
				lbl.get(i).setBounds(83, 120+(35*i), 734, 28);
			}
		}
		else{
			lbl.add(new JLabel("Sem avaliações"));
			lbl.get(0).setHorizontalAlignment(SwingConstants.CENTER);
			lbl.get(0).setForeground(Color.WHITE);
			lbl.get(0).setFont(new Font("Tahoma", Font.PLAIN, 18));
			lbl.get(0).setBounds(83, 120+(35*0), 734, 28);
			
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
