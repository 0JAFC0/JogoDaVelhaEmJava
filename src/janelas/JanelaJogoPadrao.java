package janelas;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaJogoPadrao extends JanelaPadrao{

	private String[][] tabuleiro = new String[3][3];
	private JLabel vez = new JLabel("vez Jogador 1");
	private boolean vezJog1 = true;
	private JLabel[] placares = new JLabel[2];
	private int pontosJog1 = 0;
	private int pontosJog2 = 0;
	private JButton[][] bottons = new JButton[3][3];
	private int qtDeJogadas = 0;
	
	public JanelaJogoPadrao(String titulo){
		super(titulo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public JPanel adicionaBotoesNoPainel(ActionListener ouvinte) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3, 1, 1));
		tabuleiro = new String[3][3];
		for(int i = 0;i < 3;i++) {
			for(int x = 0;x < 3;x++) {
				tabuleiro[i][x]="-";
				bottons[i][x] = new JButton();
				bottons[i][x].setName(i + "," + x);
				bottons[i][x].setOpaque(true);
				bottons[i][x].addActionListener(ouvinte);
				
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
				bottons[i][x].setBackground(null);
				bottons[i][x].setEnabled(true);
			}
		}
	}
	
	public boolean verificador(String vez) {
		//verifica linhas.
		if(tabuleiro[0][0].equals(vez) && tabuleiro[0][1].equals(vez) && tabuleiro[0][2].equals(vez)) {
			return true;
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
		}else if(tabuleiro[0][2].equals(vez) && tabuleiro[1][1].equals(vez) && tabuleiro[2][0].equals(vez)) {
			return true;
		}else {
			return false;
		}
	}
	public String[][] getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(String[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public JLabel getVez() {
		return vez;
	}

	public void setVez(JLabel vez) {
		this.vez = vez;
	}

	public boolean isVezJog1() {
		return vezJog1;
	}

	public void setVezJog1(boolean vezJog1) {
		this.vezJog1 = vezJog1;
	}

	public JLabel[] getPlacares() {
		return placares;
	}

	public void setPlacares(JLabel[] placares) {
		this.placares = placares;
	}

	public int getPontosJog1() {
		return pontosJog1;
	}

	public void setPontosJog1(int pontosJog1) {
		this.pontosJog1 = pontosJog1;
	}

	public int getPontosJog2() {
		return pontosJog2;
	}

	public void setPontosJog2(int pontosJog2) {
		this.pontosJog2 = pontosJog2;
	}

	public JButton[][] getBottons() {
		return bottons;
	}

	public void setBottons(JButton[][] bottons) {
		this.bottons = bottons;
	}

	public int getQtDeJogadas() {
		return qtDeJogadas;
	}

	public void setQtDeJogadas(int qtDeJogadas) {
		this.qtDeJogadas = qtDeJogadas;
	}
}
