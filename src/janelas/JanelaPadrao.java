package janelas;
import javax.swing.JFrame;

public class JanelaPadrao extends JFrame{
	public JanelaPadrao(String titulo) {
		super(titulo);
		setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}
}
