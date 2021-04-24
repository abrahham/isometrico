import java.awt.*;
class Isometrico {
	private Graphics g;
	private Point puntoInicio;
	Isometrico(Graphics g, Point puntoInicio) {
		this.g = g;
		this.puntoInicio = puntoInicio;
	}
	protected void dibujarPrisma(int x, int y, int ancho, int largo, int altura) {
		dibujarCuadro(x, y, ancho, largo);
		Point a = coordIso(x, y);
		dibujarLinea(a.x,a.y,a.x,a.y - altura);
		Point b = coordIso(x + ancho, y);
		dibujarLinea(b.x, b.y, b.x, b.y - altura);
		Point c = coordIso(x, y + largo);
		dibujarLinea(c.x,c.y,c.x,c.y - altura);
		Point d = coordIso(x + ancho, y + largo);
		dibujarLinea(d.x,d.y,d.x,d.y - altura);
		dibujarCuadro(x, y, ancho, largo, altura);
	}
	protected void dibujarCuadro(int x, int y, int ancho, int largo) {
		Point a = coordIso(x, y);
		Point b = coordIso(x + ancho,y);
		Point c = coordIso(x + ancho, y + largo);
		Point d = coordIso(x, y + largo);
		dibujarLinea(a.x, a.y, b.x, b.y);
		dibujarLinea(b.x, b.y, c.x, c.y);
		dibujarLinea(c.x, c.y, d.x, d.y);
		dibujarLinea(d.x, d.y, a.x, a.y);
	}
	protected void dibujarCuadro(int x, int y, int ancho, int largo, int altura) {
		Point a = coordIso(x, y);
		Point b = coordIso(x + ancho,y);
		Point c = coordIso(x + ancho, y + largo);
		Point d = coordIso(x, y + largo);
		dibujarLinea(a.x, a.y, b.x, b.y, altura);
		dibujarLinea(b.x, b.y, c.x, c.y, altura);
		dibujarLinea(c.x, c.y, d.x, d.y, altura);
		dibujarLinea(d.x, d.y, a.x, a.y, altura);
	}
	protected void dibujarPlataforma() {
		int ancho = 500, largo = 500;
		int separacion = ancho / 10;
		this.g.setColor(Color.RED);
		dibujarCuadro(0,0, ancho, largo);		
		Point a, b;
		for(int i = 1; i<10; i++) {
			a = coordIso(0,i * separacion);
			b = coordIso(largo, i * separacion);
			dibujarLinea(a.x, a.y, b.x, b.y);
			a = coordIso(i * separacion, 0);
			b = coordIso(i * separacion, largo);
			dibujarLinea(a.x, a.y, b.x, b.y);
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
	protected void dibujarLinea(int xi, int yi, int xf, int yf) {
		this.g.drawLine(xCart(xi), yCart(yi), xCart(xf), yCart(yf));
	}
	protected void dibujarLinea(int xi, int yi, int xf, int yf, int altura) {
		this.g.drawLine(xCart(xi), yCart(yi,altura), xCart(xf), yCart(yf,altura));
	}
	protected Point coordIso(int px, int py) {
  		int x = px - py;
  		int y = (px + py) / 2;
		return new Point(x,y);
	}
}
