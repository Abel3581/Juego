package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
public class Ninja {
	
	private Image ninja;
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private double velocidad;
	
	public Ninja (double x,double y,double ancho,double alto,double velocidad) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.ninja = Herramientas.cargarImagen("ninja.gif");
	}
	
	public void dibujar(Entorno e) {
		
		//e.dibujarRectangulo(x, y, ancho, alto, 0, Color.CYAN);
		e.dibujarImagen(ninja, x, y, 0, 0.35);
	}
	
	// Movimiento del ninja
	public void mover() {
		this.y += (0.5);
		
	}
	
	public void moverEjeX() {
		this.x -= (0.5);
	}
	
	
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

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	

	// posiciones del rectangulo para calcular colisiones
	public double xDerecho() {
		double xd = x + ancho /2;
		return xd;
	}
	
	public double xIzquierdo() {
		double xIz = x - ancho /2;
		return xIz;
	}
	
	public double yTecho() {
		double yTc = y - alto /2;
		return yTc;
	}
	
	public double ySuelo() {
		double ySu = y + alto /2;
		return ySu;
	}

		//#######################################################
		//			METODO DE CONTROL DE COLISION		       //
		//#######################################################
			

		public boolean colisionNinjaSakura(double fireX2 ,double fireY2 , double fireY1) {
			
			if( fireX2 >= this.xIzquierdo() && fireX2 <= this.xDerecho() && fireY2 >= yTecho() && fireY1 <= ySuelo()) {
				return true;
			}
			return false;
		}
		public boolean colisionFireballNinja(double fireX2 ,double fireY2 , double fireY1 ) {
			
			if( fireX2 >= this.xIzquierdo() && fireX2 <= this.xDerecho() && fireY2 >= yTecho() && fireY1 <= ySuelo()) {
				return true;
			}
			return false;
		}

}
