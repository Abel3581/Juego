package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Casa {
	
	private Image casa;
	private double x;
	private double y;
	private double alto;
	private double ancho;
	
	public Casa(double x, double y,double alto, double ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.casa = Herramientas.cargarImagen("casa-3.png");
	}
	
	
	public void dibujar(Entorno e) {
		//e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
		e.dibujarImagen(casa, x, y, 0, 0.2);
	}
	
	// Matrizes para la creacion de las casas del rectangulos
	public static Casa[][] matrizDeCasasVerticalDerecho() {
		Casa[][] c = new Casa[5][4];
		
		double posInicialX = 110;
		double posInicialY = 44;	//pos en Y de la cuadra inicial
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				c[i][j] = new Casa(posInicialX,posInicialY,20,20);
				posInicialX += 168;	//DISTANCIA ENTRE X DE CADA CASA = 168
			}
			posInicialX = 110;	//se REINICIA para ubicar las casas de abajo en el mismo X de los de arriba
			posInicialY += 128;	//DISTANCIA ENTRE Y DE CADA CUADRA = 128
		}
		
		return c;
	}
	
	public static Casa[][] matrizDeCasasVerticalIzquierdo() {
		Casa[][] c = new Casa[5][4];
		
		double posInicialX = 186;
		double posInicialY = 44;	//pos en Y de la cuadra inicial
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				c[i][j] = new Casa(posInicialX,posInicialY,20,20);
				posInicialX += 168;	//DISTANCIA ENTRE X DE CADA CASA = 168
			}
			posInicialX = 186;	//se REINICIA para ubicar las casas de abajo en el mismo X de los de arriba
			posInicialY += 128;	//DISTANCIA ENTRE Y DE CADA CUADRA = 128
		}
		
		return c;
	}
	
	public static Casa[][] matrizDeCasasHorizontalArriba() {
		Casa[][] c = new Casa[4][5];
		
		double posInicialX = 64;	//pos en X de la cuadra inicial
		double posInicialY = 140;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				c[i][j] = new Casa(posInicialX,posInicialY,20,40);
				posInicialX += 168;	//DISTANCIA ENTRE X DE CADA CASA = 168
			}
			posInicialX = 64;	//se REINICIA para ubicar las casas de abajo en el mismo X de los de arriba
			posInicialY += 128;	//DISTANCIA ENTRE Y DE CADA CUADRA = 128
		}
		
		return c;
	}
	
	public static Casa[][] matrizDeCasasHorizontalAbajo() {
		Casa[][] c = new Casa[4][5];
		
		double posInicialX = 64;	//pos en X de la cuadra inicial
		double posInicialY = 76;
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				c[i][j] = new Casa(posInicialX,posInicialY,20,40);
				posInicialX += 168;	//DISTANCIA ENTRE X DE CADA CASA = 168
			}
			posInicialX = 64;	//se REINICIA para ubicar las casas de abajo en el mismo X de los de arriba
			posInicialY += 128;	//DISTANCIA ENTRE Y DE CADA CUADRA = 128
		}
		
		return c;
	}
	
	

	//GETTERS

	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getAlto() {
		return alto;
	}
	public double getAncho() {
		return ancho;
	}
}
