package janelas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JanelaVsP2 extends JanelaJogoPadrao{
	
	private class OuvinteBotao implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
				JButton botao = ((JButton)evento.getSource());
				String[] pos = botao.getName().split(",");
				setQtDeJogadas(getQtDeJogadas() + 1);
				if(isVezJog1()) {
					if(!getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("o")) {
						getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = "x";
						setVezJog1(false);
						botao.setText("X");
						botao.setBackground(Color.red);
						botao.setEnabled(false);
						getVez().setText("vez Jogador 2");
					}
					//verifica se o jogador 1 acertou alguma jogada.
					if(verificador("x")) {
						setVezJog1(true);;
						setPontosJog1(getPontosJog1() + 1);
						getPlacares()[0].setText(getPontosJog1()+"");
						setQtDeJogadas(0);
						ResetarBotoes();
					}
				}else {
					if(!getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("x")) {
						getTabuleiro()[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = "o";
						setVezJog1(true);
						botao.setText("O");
						botao.setBackground(Color.blue);
						botao.setEnabled(false);
						getVez().setText("vez Jogador 1");
					}
					
					if(verificador("o")) {
						setVezJog1(false);
						setPontosJog2(getPontosJog2() + 1);;
						getPlacares()[1].setText(getPontosJog2()+"");
						setQtDeJogadas(0);
						ResetarBotoes();
					}
				}
				//verifica se deu velha.
				if(getQtDeJogadas()==9) {
					ResetarBotoes();
					setQtDeJogadas(0);
				}
		}		
	}
	
	public JanelaVsP2(JFrame janela){
		super("Tic Tac Toe");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(janela);
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
		panel1.add(new JLabel("Pontos P2",JLabel.CENTER));
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
