package janelas;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaCreditos extends JanelaPadrao{
	public JanelaCreditos() {
		super("Creditos");
		setLayout(new GridBagLayout());
		setVisible(true);
		
		//panel
		JPanel panel = new JPanel();
		
		//labels
		JLabel mensa = new JLabel("Desenvolvido por Joao Arthur");
		mensa.setFont(new Font("Arial", Font.BOLD, 20));
		mensa.setVisible(true);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(mensa,gbc);
		//botao
		JButton botao = new JButton("Voltar");
		//ouvinte do botao
		botao.setFont(new Font("Arial", Font.BOLD, 10));
		botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		botao.setVisible(true);
		gbc.anchor = GridBagConstraints.CENTER;
		panel.add(botao,gbc);
		add(panel);
	}
}
