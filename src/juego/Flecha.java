package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	private Image flecha;
	
	public Flecha(int x, int y, int ancho, int alto) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.flecha = Herramientas.cargarImagen("flecha.png");
	}
	
	public void dibujar(Entorno entorno) {
//		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.yellow);
		entorno.dibujarImagen(this.flecha, this.x, this.y, 0,0.035);
	}
	
	public int posicionX()
	{
		return this.x;
	}
	
	public int posicionY()
	{
		return this.y;
	}
	
	public int ancho()
	{
		return this.ancho;
	}
	
	public int alto()
	{
		return this.alto;
	}


	public boolean colisionFlechaSakura(double posSakuraX2 ,double posSakuraY2 , double posSakuraY1) {
		
		if( posSakuraX2 >= this.xIzquierdo() && posSakuraX2 <= this.xDerecho() && posSakuraY2 >= yTecho() && posSakuraY1 <= ySuelo()) {
			return true;
		}
		return false;
	}
	
	
	
	
	
	// posiciones del rectangulo para calcular colisiones
		public int xDerecho() {
			int xd = x + ancho /2;
			return xd;
		}
		public int xIzquierdo() {
			int xIz = x - ancho /2;
			return xIz;
		}		
		public int yTecho() {
			int yTc = y - alto /2;
			return yTc;
		}
		public int ySuelo() {
			int ySu = y + alto /2;
			return ySu;
		}

				

	
}
	
	
		


	
		


			
					
				
			







		
		
		





		
	




	
	
	

