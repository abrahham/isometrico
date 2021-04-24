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
		iso.dibujarPlataforma();
		iso.dibujarCuadro(10,10,50,50);
		iso.dibujarPrisma(150,30,40,100,20);
		iso.dibujarPrisma(200,350,200,40,20);
	}
}
