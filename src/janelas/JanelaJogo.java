package janelas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class JanelaJogo extends JanelaPadrao{
	
	private String[][] tabuleiro = new String[3][3];
	private JLabel vez = new JLabel("vez Jogador 1");
	private boolean vezJog1 = true;
	private JLabel[] placares = new JLabel[2];
	private int pontosJog1 = 0;
	private int pontosJog2 = 0;
	private JButton[][] bottons = new JButton[3][3];
	private int qtDeJogadas = 0;
			
	private class OuvinteBotao implements ActionListener{

		public void actionPerformed(ActionEvent evento) {
				JButton botao = (JButton)evento.getSource();
				String[] pos = botao.getName().split(",");
				qtDeJogadas += 1;
				if(vezJog1) {
					if(!tabuleiro[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("o")) {
						tabuleiro[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = "x";
						vezJog1 = false;
						botao.setText("X");
						vez.setText("vez Jogador 2");
					}
					
					if(verificador("x")) {
						vezJog1 = true;
						placares[0].setText((pontosJog1 += 1)+"");
						ResetarBotoes();
					}	
				}else {
					if(!tabuleiro[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])].equals("x")) {
						tabuleiro[Integer.parseInt(pos[0])][Integer.parseInt(pos[1])] = "o";
						vezJog1 = true;
						botao.setText("O");
						vez.setText("vez Jogador 1");
					}
					
					if(verificador("o")) {
						vezJog1 = false;
						placares[1].setText((pontosJog2 += 1)+"");
						ResetarBotoes();
					}
				}
				if(qtDeJogadas==9) {
					ResetarBotoes();
					qtDeJogadas = 0;
				}
		}		
	}
	
	public JanelaJogo(){
		super("Tic Toc");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		setLayout(new GridLayout(1,1));
		
		JPanel cont1 = new JPanel();
		placares[0] = new JLabel(""+pontosJog1,JLabel.CENTER);
		placares[1] = new JLabel(""+pontosJog2,JLabel.CENTER);
		cont1.setLayout(new GridLayout(1,5));
		cont1.add(new JLabel("Pontos P1",JLabel.CENTER));
		cont1.add(placares[0]);
		cont1.add(vez);
		cont1.add(new JLabel("Pontos P2",JLabel.CENTER));
		cont1.add(placares[1]);
		
		JPanel panel = new JPanel();
		JPanel panel2 = adicionaBotoesNoPainel();
		panel.add(cont1);
		panel.add(panel2);
		panel.setLayout(new FlowLayout());
		cont1.setPreferredSize(new Dimension(500, 50));
		panel2.setPreferredSize(new Dimension(500, 430));
		add(panel);
	}
	
	public JPanel adicionaBotoesNoPainel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 1, 1));
		tabuleiro = new String[3][3];
		for(int i = 0;i < 3;i++) {
			for(int x = 0;x < 3;x++) {
				tabuleiro[i][x]="-";
				bottons[i][x] = new JButton();
				bottons[i][x].setName(i + "," + x);
				bottons[i][x].setOpaque(true);
				bottons[i][x].addActionListener(new OuvinteBotao());
				
				panel.add(bottons[i][x]);
			}
		}
		return panel;
	}
	public void ResetarBotoes() {
		for(int i = 0;i < 3;i++) {
			for(int x = 0;x < 3;x++) {
				tabuleiro[i][x]="-";
				bottons[i][x].setText("");
			}
		}
	}
	
	public boolean verificador(String vez) {
		//verifica linhas.
		if(tabuleiro[0][0].equals(vez) && tabuleiro[0][1].equals(vez) && tabuleiro[0][2].equals(vez)) {
			return true;// se a primeira linha for toda igual o jogador venceu.
		}else if(tabuleiro[1][0].equals(vez) && tabuleiro[1][1].equals(vez) && tabuleiro[1][2].equals(vez)) {
			return true;
		}else if(tabuleiro[2][0].equals(vez) && tabuleiro[2][1].equals(vez) && tabuleiro[2][2].equals(vez)) {
			return true;
		//verifica colunas.
		}else if(tabuleiro[0][0].equals(vez) && tabuleiro[1][0].equals(vez) && tabuleiro[2][0].equals(vez)) {
			return true;
		}else if(tabuleiro[0][1].equals(vez) && tabuleiro[1][1].equals(vez) && tabuleiro[2][1].equals(vez)) {
			return true;
		}else if(tabuleiro[0][2].equals(vez) && tabuleiro[1][2].equals(vez) && tabuleiro[2][2].equals(vez)) {
			return true;
		//verifica diagonais.
		}else if(tabuleiro[0][0].equals(vez) && tabuleiro[1][1].equals(vez) && tabuleiro[2][2].equals(vez)) {
			return true;
		}else if(tabuleiro[2][0].equals(vez) && tabuleiro[1][1].equals(vez) && tabuleiro[0][2].equals(vez)) {
			return true;
		}else {
			return false;
		}
	}
}
