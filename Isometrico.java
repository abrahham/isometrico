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
		int separacion = 20;
		this.g.setColor(Color.RED);
		dibujarCuadro(0,0, ancho, largo);
		Point a, b;
		for(int i = 1; i < ancho / separacion; i++) {
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
	public void trazarPrisma(Prisma prisma) {
	
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
	public void iniciar() {
		dibujarPlataforma();
		trazarPrisma(150,0,200,50, 100);
		trazarPrisma(50,0,70,200, 10);
		trazar(new int[][]{
				{50,500,0},{100,500,0},
				{100,300,50},{50,300,50}
			}, Color.BLUE, 1);
		trazar(new int[][]{{15,1,0}, {20,1,0}, {20,5,0}, {15,5,0}}, Color.YELLOW, 20);		
	}
	public void trazar(int[][] puntos, Color color, int separacion) {
		if(puntos.length > 4) return;
		this.g.setColor(color);
		for(int i = 0; i < puntos.length; i++) {
			if(i + 1 == puntos.length)
				trazarLinea(
					puntos[i][0] * separacion, puntos[i][1] * separacion, puntos[i][2] * separacion,
					puntos[0][0] * separacion, puntos[0][1] * separacion, puntos[0][2] * separacion
				);
			else
				trazarLinea(
					puntos[i][0] * separacion, puntos[i][1] * separacion, puntos[i][2] * separacion,
					puntos[i + 1][0] * separacion, puntos[i + 1][1] * separacion, puntos[i + 1][2] * separacion
				);
		}
		for(int i = 0; i <= (puntos[1][0] - puntos[0][0]) * separacion; i++) {
			trazarLinea(
				puntos[0][0] * separacion + i, puntos[0][1] * separacion, puntos[0][2] * separacion,
				puntos[3][0] * separacion + i, puntos[3][1] * separacion, puntos[3][2] * separacion
			);
		}
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
	protected void trazarLinea(int xi, int yi, int alturaInicial, int xf, int yf, int alturaFinal) {
		Point a = coordIso(xi, yi);
		Point b = coordIso(xf, yf);
		g.drawLine(xCart(a.x), yCart(a.y, alturaInicial), xCart(b.x), yCart(b.y, alturaFinal));
	}
}
