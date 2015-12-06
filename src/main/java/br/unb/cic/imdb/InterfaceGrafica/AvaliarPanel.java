package br.unb.cic.imdb.InterfaceGrafica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import br.unb.cic.imdb.negocio.*;

import javax.swing.JTextField;
import javax.swing.JButton;

import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

public class AvaliarPanel extends panels{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JRadioButton nota1;
	private JRadioButton nota2;
	private JRadioButton nota3;
	private JRadioButton nota4;
	private JRadioButton nota5;
	private TrabalhoArtistico trab;
	private JLabel lblComentrios;
	private JTextField comentario;
	private JButton evaluate;
	private int nota = 1;

	public AvaliarPanel(TrabalhoArtistico t) {
		this.trab = t;
		setup();
	}
	
	private void setup(){
		setLayout(null);
		this.setSize(900,600);
		setBackground(Color.DARK_GRAY);
		
		JLabel lblAvaliar = new JLabel("Avaliar "+trab.getTitulo());
		lblAvaliar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvaliar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAvaliar.setForeground(Color.WHITE);
		lblAvaliar.setBounds(271, 49, 358, 52);
		add(lblAvaliar);
		
		nota1 = new JRadioButton("1");
		nota1.setSelected(true);
		nota1.setForeground(Color.WHITE);
		nota1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nota1.setBackground(Color.DARK_GRAY);
		nota1.setBounds(300, 139, 43, 25);
		nota1.addActionListener(this);
		add(nota1);
		
		nota2 = new JRadioButton("2");
		nota2.setForeground(Color.WHITE);
		nota2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nota2.setBackground(Color.DARK_GRAY);
		nota2.setBounds(364, 139, 43, 25);
		nota2.addActionListener(this);
		add(nota2);
		
		nota3 = new JRadioButton("3");
		nota3.setForeground(Color.WHITE);
		nota3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nota3.setBackground(Color.DARK_GRAY);
		nota3.setBounds(432, 139, 43, 25);
		nota3.addActionListener(this);
		add(nota3);
		
		nota4 = new JRadioButton("4");
		nota4.setForeground(Color.WHITE);
		nota4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nota4.setBackground(Color.DARK_GRAY);
		nota4.setBounds(493, 139, 43, 25);
		nota4.addActionListener(this);
		add(nota4);
		
		nota5 = new JRadioButton("5");
		nota5.setForeground(Color.WHITE);
		nota5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nota5.setBackground(Color.DARK_GRAY);
		nota5.setBounds(554, 139, 43, 25);
		nota5.addActionListener(this);
		add(nota5);
		
		lblComentrios = new JLabel("Coment\u00E1rios");
		lblComentrios.setHorizontalAlignment(SwingConstants.CENTER);
		lblComentrios.setForeground(Color.WHITE);
		lblComentrios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblComentrios.setBounds(271, 203, 358, 52);
		add(lblComentrios);
		
		comentario = new JTextField();
		comentario.setBounds(226, 284, 448, 181);
		add(comentario);
		comentario.setColumns(10);
		
		evaluate = new JButton("Avaliar");
		evaluate.setBounds(401, 511, 97, 25);
		evaluate.addActionListener(this);
		add(evaluate);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == nota1){
			nota = 1;
			nota1.setSelected(true);
			nota2.setSelected(false);
			nota3.setSelected(false);
			nota4.setSelected(false);
			nota5.setSelected(false);
		}
		if(e.getSource() == nota2){
			nota = 2;
			nota1.setSelected(false);
			nota2.setSelected(true);
			nota3.setSelected(false);
			nota4.setSelected(false);
			nota5.setSelected(false);
		}
		if(e.getSource() == nota3){
			nota = 3;
			nota1.setSelected(false);
			nota2.setSelected(false);
			nota3.setSelected(true);
			nota4.setSelected(false);
			nota5.setSelected(false);
		}
		if(e.getSource() == nota4){
			nota = 4;
			nota1.setSelected(false);
			nota2.setSelected(false);
			nota3.setSelected(false);
			nota4.setSelected(true);
			nota5.setSelected(false);
		}
		if(e.getSource() == nota5){
			nota = 5;
			nota1.setSelected(false);
			nota2.setSelected(false);
			nota3.setSelected(false);
			nota4.setSelected(false);
			nota5.setSelected(true);
		}
		if(e.getSource() == evaluate){
			Avaliacao a = new Avaliacao(nota, comentario.getText(), Main.user, trab);
			this.setVisible(false);
			Main.Frame.setPanel(new MainPanel());
		}
	}
}
