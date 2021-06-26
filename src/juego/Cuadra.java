package juego;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import entorno.Entorno;
import entorno.Herramientas;

public class Cuadra {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	private Image pasto;
	public Cuadra(int x, int y, int ancho, int alto) {

		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.pasto  = Herramientas.cargarImagen("pasto.jpg");
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	//	entorno.dibujarImagen(this.pasto, this.x, this.y, 0,0.28);
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
