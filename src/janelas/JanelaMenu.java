package janelas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaMenu extends JanelaPadrao{
	
	private JanelaMenu janela = this;
	private class Ouvinte implements ActionListener, WindowListener{
		public void actionPerformed(ActionEvent evento) {
			String nameDoBotao = ((JButton)evento.getSource()).getName();
			if(nameDoBotao.equals("vsp2")) {
				setVisible(false);
				JanelaVsP2 jogo = new JanelaVsP2(janela);
				jogo.addWindowListener(new Ouvinte());//Ouvinte de janela para mudar visibilidade dessa janela menu para visivel quando a outra for fechada.
			}else if(nameDoBotao.equals("vscpu")) {
				setVisible(false);
				JanelaVsComputador jogo = new JanelaVsComputador();
				jogo.addWindowListener(new Ouvinte());
			}else if(nameDoBotao.equals("creditos")) {
				setVisible(false);
				JanelaCreditos creditos = new JanelaCreditos();
				creditos.addWindowListener(new Ouvinte());
			}
		}
		public void windowActivated(WindowEvent arg0) {
			
		}
		public void windowClosed(WindowEvent evento) {
			setVisible(true);
		}
		public void windowClosing(WindowEvent arg0) {
			
		}
		public void windowDeactivated(WindowEvent arg0) {
			
		}
		public void windowDeiconified(WindowEvent arg0) {
			
		}
		public void windowIconified(WindowEvent arg0) {
			
		}
		public void windowOpened(WindowEvent arg0) {
			
		}
	}
	
	public JanelaMenu() {
		super("menu");
		setVisible(true);
		setLayout(new GridLayout(2,1,1,1));
		
		JPanel panel = new JPanel();
		//label
		JLabel texto = new JLabel("Jogo da Velha",JLabel.CENTER);
		texto.setFont(new Font("Arial", Font.BOLD,50));
		add(texto);
		// botões
		adicionarBotao("P1VSP2", "vsp2", Color.red, panel);
		adicionarBotao("P1VSCPU", "vscpu", Color.gray, panel);
		adicionarBotao("Creditos", "creditos", Color.black, panel);
		add(panel);
	}
	public void adicionarBotao(String texto,String name,Color corF,JPanel panel) {
		JButton botao = new JButton(texto);
		botao.setName(name);
		botao.setBackground(corF);
		botao.setBorder(BorderFactory.createLineBorder(Color.black));
		botao.setPreferredSize(new Dimension(100,50));
		botao.addActionListener(new Ouvinte());
		panel.add(botao);
	}
}
