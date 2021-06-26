package juego;

import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;

import entorno.Entorno;
import entorno.Herramientas;

public class Sakura {

	
// Variables de instancia
	
	private Image sakura;
	private int x;
	private int y;
	private double ancho;
	private double alto;
	private double diametro;


	// Constructor
	public Sakura(int x, int y, double ancho, double alto, double diametro) {
		
		
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.diametro = diametro;
		this.sakura = Herramientas.cargarImagen("fantasma.png");
	
	}
	

	public void dibujar(Entorno e) {
		//e.dibujarRectangulo(x, y, ancho, alto, 0, Color.BLUE);
		e.dibujarImagen(sakura, this.x, this.y, 0, 0.35);
	
	}

	
	//MUEVE A SAKURA SEGUN DIRECCIONES 
		public void mover(String palabra) {
			if (palabra.equals("arriba")) {			//mover arriba
				this.y = this.y - 3 ;
			}
			if (palabra.equals("abajo")) {			//mover abajo
				this.y = this.y + 3;
			} 
			if (palabra.equals("izquierda")) {			//mover izquierda
				this.x = this.x - 3;
			} 
			if (palabra.equals("derecha")) {			//mover derecha
				this.x = this.x + 3;
			}
		}
		
		//DEFINE LIMITE DE MOV CON EL ENTORNO
		public boolean chocasteBordeSuperior() {
			if (this.y - this.alto/2 < 0) {
				return true;	//CHOQUE
			} else {
				return false;	//NO CHOQUE
			}
		}
		
		//DEFINE LIMITE DE MOV CON EL ENTORNO
		public boolean chocasteBordeInferior() {
			if (this.y + this.alto/2 > 600) {
				return true;
			} else {
				return false;
			}
		}
		
		//DEFINE LIMITE DE MOV CON EL ENTORNO
		public boolean chocasteBordeIzquierdo() {
			if (this.x - this.ancho/2 < 0) {
				return true;
			} else {
				return false;
			}
		}
		
		//DEFINE LIMITE DE MOV CON EL ENTORNO
		public boolean chocasteBordeDerecho() {
			if (this.x + this.ancho/2 > 800) {
				return true;
			} else {
				return false;
			}
		}
		
		//DEFINE LIMITE DE MOV CON BORDE VERTICAL DE CUADRAS
		public boolean noChocasteConBordeVerticalDeCuadra() {
			if (this.x > 138 && this.x < 154 || this.x > 307 && this.x < 323 ||	this.x > 476 && this.x < 492 || this.x > 645 && this.x < 661) { 
				return true;
			} else {
				return false;
			}
		}
		
		//DEFINE LIMITE DE MOV CON BORDE HORIZONTAL DE CUADRAS
		public boolean noChocasteConBordeHorizontalDeCuadra() {
			if (this.y > 100 && this.y < 116 || this.y > 228 && this.y < 244 || this.y > 356 && this.y < 372 || this.y > 484 && this.y < 500 ) {	
				return true;
			} else {
				return false;
			}
		}
	
	
	// Creo disparo 
	
	
	public Fireball disparar() {
		
		return new Fireball(this.x, this.y - this.alto / 5, 10,10,0);
	}
	
	
	
	
	// Setter and Getter
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
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
	public double getDiametro() {
		return diametro;
	}
	
	
	// posiciones del rectangulo para calcular colisiones
	public double y1() {
		double y1 = y - (diametro /2);
		return y1;
	}
	
	public double y2() {
		double y2 = y + (diametro /2);
		return y2;
	}
	public double x2() {
		double x2 = x + (diametro/2) ;
		return x2;
	}
	public double x1() {
		double x1 = x - (diametro/2);
		return x1;
	}
	
	
}
