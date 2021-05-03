import java.awt.*;
class Isometrico {
	public Graphics g;
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
	protected void dibujarPrisma3D(int x, int y, int ancho, int largo, int altura) {
		Point b = coordIso(x + ancho, y);
		dibujarLinea(b.x, b.y, b.x, b.y - altura);
		Point c = coordIso(x, y + largo);
		dibujarLinea(c.x,c.y,c.x,c.y - altura);
		Point d = coordIso(x + ancho, y + largo);
		dibujarLinea(d.x,d.y,d.x,d.y - altura);
		dibujarCuadro(x, y, ancho, largo, altura);
		
		//Líneas de relleno
		Point a1 = coordIso(x, y + largo);
		Point a2 = coordIso(x + ancho, y + largo);
		Point a3 = coordIso(x + ancho, y);
		dibujarLinea(a1.x, a1.y, a2.x, a2.y);
		dibujarLinea(a2.x, a2.y, a3.x, a3.y);
		g.setColor(Color.YELLOW);
		for(int i = 1; i < altura; i++) {
			dibujarLinea(a1.x + 1, a1.y - i, a2.x - 1, a2.y - i);
			dibujarLinea(a2.x + 1, a2.y - i, a3.x - 1, a3.y - i);
		}
		g.setColor(Color.WHITE);
		for(int i = 1; i < 10; i++) {
			dibujarLinea(c.x + i, c.y, c.x + i, c.y - altura + i);
		
			dibujarLinea(a1.x + 1, a1.y - i, a2.x - 1, a2.y - i, altura - 10);
			dibujarLinea(a1.x + 1, a1.y - i, a2.x - 1, a2.y - i);
			
			dibujarLinea(a2.x + 1, a2.y - i, a3.x - 1, a3.y - i, altura - 10);				
			dibujarLinea(a2.x + 1, a2.y - i, a3.x - 1, a3.y - i);	
		}
		//dibujarLinea(c.x , c.y, d.x, d.y, 5,'Y',true, altura);
		//dibujarLinea(a1.x,a1.y,c.x,c.y, 25,'X',true, altura);
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
	
	protected void dibujarLinea(int xi, int yi, int xf, int yf) {
		this.g.drawLine(xCart(xi), yCart(yi), xCart(xf), yCart(yf));
	}
	protected void dibujarLinea(int xi, int yi, int xf, int yf, int altura) {
		this.g.drawLine(xCart(xi), yCart(yi,altura), xCart(xf), yCart(yf,altura));
	}	
}
