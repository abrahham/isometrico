import java.awt.*;
class Isometrico {
	public Graphics g;
	private Point puntoInicio;
	Isometrico(Graphics g, Point puntoInicio) {
		this.g = g;
		this.puntoInicio = puntoInicio;
	}
	protected void dibujarCuadro(int x, int y, int ancho, int largo) {
		trazarLinea(x, y, x + ancho, y);
		trazarLinea(x + ancho, y, x + ancho, y + largo);
		trazarLinea(x + ancho, y + largo, x, y + largo);
		trazarLinea(x, y + largo, x, y);		
	}
	protected void dibujarPlataforma() {
		int ancho = 500, largo = 500;
		int separacion = ancho / 10;
		this.g.setColor(Color.RED);
		dibujarCuadro(0,0, ancho, largo);
		Point a, b;
		for(int i = 1; i<10; i++) {
			trazarLinea(0, i * separacion, largo, i * separacion);
			trazarLinea(i * separacion, 0, i * separacion, largo);			
		}
	}
	protected Point puntoInicio() {
		return this.puntoInicio;
	}
	protected int xCart(int xCart) {
		return puntoInicio().x + xCart;
	}
	protected int yCart(int yCart) {
		return puntoInicio().y + yCart;
	}
	protected int yCart(int yCart, int altura) {
		//Valor de y en el plano, con una altura estimada en altura
		return puntoInicio().y + yCart - altura;
	}	
	protected Point coordIso(int px, int py) {
  		int x = px - py;
  		int y = (px + py) / 2;
		return new Point(x,y);
	}
	public void trazarPrisma(int xi, int yi, int xf, int yf, int altura) {
		for(int i = 0; i <= yf - yi; i++) {
			this.g.setColor(Color.GREEN);
			trazarLinea(xi, yi + i, xf, yi + i, altura);
		}
		for(int i = 0; i < altura; i++) {
			this.g.setColor(Color.BLUE);
			trazarLinea(xi, yf, xf, yf, i);				
			this.g.setColor(Color.YELLOW);
			trazarLinea(xf, yi, xf, yf, i);
		}
	}
	public void k() {
		trazarPrisma(150,0,200,50, 100);
		trazarPrisma(50,0,70,200, 10);
	}
	protected void trazarLinea(int xi, int yi, int xf, int yf) {
		Point a = coordIso(xi, yi);
		Point b = coordIso(xf, yf);
		g.drawLine(xCart(a.x), yCart(a.y), xCart(b.x), yCart(b.y));
	}
	protected void trazarLinea(int xi, int yi, int xf, int yf, int altura) {
		Point a = coordIso(xi, yi);
		Point b = coordIso(xf, yf);
		g.drawLine(xCart(a.x), yCart(a.y, altura), xCart(b.x), yCart(b.y, altura));
	}
}
