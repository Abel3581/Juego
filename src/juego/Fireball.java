package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Fireball{
	private Image disparo;
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double diametro;
	
	
	public Fireball(double x, double y, double alto, double ancho, double diametro) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.disparo = Herramientas.cargarImagen("disparo.png");
	}


	public void dibujar(Entorno e) {
	//	e.dibujarRectangulo(x, y, ancho, alto, 0, Color.YELLOW);
		e.dibujarImagen(disparo, this.x, this.y, 0);
	}
	//Direccion del disparo se toma en sentido de las agujas del reloj (arriba = 1, derecha = 2,etc)
		
	public void disparar(int i){
	{
		if(i==1)//arriba
		{
			this.y -= 4;
		}
		if(i==2)//derecha
		{
			this.x += 4;
		}
		if(i==3 )//abajo
		{
			this.y += 4;
		}
		if(i==4)//izquierda
		{
			this.x -= 4;
		}
		if(i==5)// Por defecto derecha
		{
			this.x += 4;
		}	
	}
}
	public void disparoDerecha() {
		this.x += 4;
	}

	
	// Setter and Getter
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	
	public double getDiametro() {
		return diametro;
	}
	
	
	// Para calcular colisiones
	public double y2() {
		double y2 = y + (diametro /2);
		return y2;
	}
	public double x2() {
		double x2 = x + (diametro/2) ;
		return x2;
	}
	public double y1() {
		double y1 = y - (diametro /2);
		return y1;
	}
	

	
	
	
}
