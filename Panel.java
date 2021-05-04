import javax.swing.*;
import java.awt.*;
class Panel extends JPanel {
	private Isometrico iso;
	Panel() {
		setPreferredSize(new Dimension(200,50));
		setBackground(Color.BLACK);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		iso = new Isometrico(g, new Point(this.getWidth() / 2, 50));
		iso.iniciar();
	}
}
