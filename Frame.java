import javax.swing.*;
import java.awt.*;
class Frame extends JFrame {
	public static void main(String args[]) {
		Frame ventana = new Frame();
		ventana.mkGUI();
	}
	public void mkGUI() {
		setSize(900,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Panel());
		setVisible(true);
	}
}
