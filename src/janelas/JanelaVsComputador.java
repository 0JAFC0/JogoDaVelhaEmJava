package janelas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaVsComputador extends JanelaJogoPadrao{
	
	private class OuvinteBotao implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
				
			if(isVezJog1()) {
				JButton botao = ((JButton)evento.getSource());
				String[] pos = botao.getName().split(",");
				
				if(!getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("o") && !getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("x")) {
					getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = "x";
					setVezJog1(false);
					botao.setText("X");
					botao.setBackground(Color.red);
					botao.setEnabled(false);
					setQtDeJogadas(getQtDeJogadas() + 1);
				}
				//verifica se o jogador 1 acertou alguma jogada.
				if(verificador("x")) {
					setPontosJog1(getPontosJog1() + 1);
					getPlacares()[0].setText(getPontosJog1()+"");
					setQtDeJogadas(0);
					ResetarBotoes();
				}
			}
			while(isVezJog1()==false) {
				int l = new Random().nextInt(3);
				int c = new Random().nextInt(3);
				
				if(!getTabuleiro()[l][c].equals("x") && !getTabuleiro()[l][c].equals("o")) {
					getTabuleiro()[l][c] = "o";
					setVezJog1(true);
					getBottons()[l][c].setText("O");
					getBottons()[l][c].setBackground(Color.blue);
					getBottons()[l][c].setEnabled(false);
					getVez().setText("vez Jogador 1");
					setQtDeJogadas(getQtDeJogadas()+1);
				}
				//verifica se o jogador 2 acertou alguma jogada.
				if(verificador("o")) {
					setPontosJog2(getPontosJog2() + 1);;
					getPlacares()[1].setText(getPontosJog2()+"");
					setQtDeJogadas(0);
					ResetarBotoes();
				}
				//se der velha o tabuleiro é resetado.
				if(getQtDeJogadas()==9) {
					setVezJog1(true);
					ResetarBotoes();
					setQtDeJogadas(0);
				}
			}
			if(getQtDeJogadas()==9) {
				setVezJog1(true);
				ResetarBotoes();
				setQtDeJogadas(0);
			}
		}		
	}
	public JanelaVsComputador() {
		super("Tic Tac Toe");
		setLayout(new GridLayout(1,1));
		setVisible(true);
		
		JPanel panel = new JPanel();
		
		JPanel panel1 = new JPanel();
		getPlacares()[0] = new JLabel(""+getPontosJog1(),JLabel.CENTER);
		getPlacares()[1] = new JLabel(""+getPontosJog2(),JLabel.CENTER);
		panel1.setLayout(new GridLayout(1,5));
		panel1.add(new JLabel("Pontos P1",JLabel.CENTER));
		panel1.add(getPlacares()[0]);
		panel1.add(getVez());
		panel1.add(new JLabel("Pontos CPU",JLabel.CENTER));
		panel1.add(getPlacares()[1]);
		
		JPanel panel2 = adicionaBotoesNoPainel(new OuvinteBotao());
		panel.add(panel1);
		panel.add(panel2);
		panel.setLayout(new FlowLayout());
		panel1.setPreferredSize(new Dimension(500, 50));
		panel2.setPreferredSize(new Dimension(500, 430));
		add(panel);
	}
}
