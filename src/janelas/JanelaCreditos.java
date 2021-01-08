package janelas;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaCreditos extends JanelaPadrao{
	public JanelaCreditos() {
		super("Creditos");
		setLayout(new GridLayout(1, 1));
		setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//labels
		adicionarLabel("Criador: João Arthur", panel);
		//botao
		JButton botao = new JButton("Voltar");
		//ouvinte do botao
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel.add(botao);
		add(panel);
	}
	public void adicionarLabel(String texto, JPanel panel) {
		JLabel mensa = new JLabel(texto);
		panel.add(mensa);
	}
}
