package juego;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.sound.sampled.Clip;

import java.awt.Rectangle;

import java.util.Arrays;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego 
{
	
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	private Clip musiquita;
	//Imagenes
	private Image imagenFondo;
	private Image fueguillos;
	private Image gameOver;
	private Image Corazon;
	private Sakura sakura;
	//arreglos y matriz 
	private Fireball[] fireballs;
	private Ninja [] ninjas ;
	private Ninja [] ninjas2 ;
	private Casa[][] casasVerticalDerecho;
	private Casa[][] casasVerticalIzquierdo;
	private Casa[][] casasHorizontalArriba;
	private Casa[][] casasHorizontalAbajo;
	private int direccion=1;
	private int unaBola;
	private int maxFire;
	private int vidasTotal;
	private int cantidadNinjas;
	Random rand = new Random();
	private boolean siChoco;
	private int puntaje;
	private int ninjasEliminados; 
	private int time;
	private boolean esInmune;
	private double ticks;
	private double	velocidad;
	private boolean izquierda;
	private boolean derecha;
	private boolean arriba;
	private boolean abajo;
	private Flecha[] flecha;//AGREGADO::::
	private static Cuadra[] cuadras; //AGREGADO::::
	private Cuadra cuadraElegida; //AGREGADO::::

	

	
	// Crea un array con posiciones nulas del disparo
	public Fireball[] fireListNull(int cantidad) {
		Fireball[] fuegos = new Fireball[cantidad];
		Arrays.fill(fuegos, null);
		return fuegos;
	}	
	

		// Determina la altura del Piso por donde salen los ninjas del eje vertical
		double damePisoAlto() {
			double piso = (this.entorno.alto() - this.entorno.alto());
			return piso;
		}
		
		double damePisoAncho() {  // Ancho de la pantalla
			double piso = (this.entorno.ancho());
			return piso;
		}
		
		public Ninja dameNinjasEnY(double separadorX, double separadorY) {  // Creo ninjas en y
			
			Ninja ladoVertical= new Ninja(148 + separadorX, damePisoAlto() + separadorY , 35 , 35 ,velocidad);
			
			return ladoVertical;
		}
		
		public Ninja dameNinjasEnX(double separaX, double separaY) {  // Creo ninjas en x
			
			Ninja ladoHorizontal= new Ninja(damePisoAncho() + separaX,separaY ,35 ,35 ,velocidad);
		
			return ladoHorizontal;
		}
		// Arreglo de objeto ninja q salen del eje x 600
		public Ninja [] dameNinjaXList(int num) {    
			Ninja [] peloton= new Ninja[num];
			double separaX = 400;
			double separaY = 236;
			
			for (int i = 0; i < peloton.length; i++) {
				
					peloton[i] = dameNinjasEnX(separaX, separaY);
					
					separaX = separaX + (rand.nextInt(2) - 50);
					separaY = separaY + 256;
			}
			return peloton;
		}
		 // Arreglo de objeto ninja q salen del eje y 0
		public Ninja [] dameNinjaYList(int num) {           
			Ninja [] peloton= new Ninja[num];
			double separadorX = 0;
			double separadorY = -90;
			
			for (int i = 0; i < peloton.length; i++) {
				
					peloton[i] = dameNinjasEnY(separadorX, separadorY);
					separadorX = separadorX + 503;
					separadorY = separadorY + (rand.nextInt(2) - 100);
			}
			return peloton;
		}
		// Comprueba si los ninjas murieron	
		public boolean todosMuertos(Ninja [] lista) { 
			for (Ninja soldado : lista) {
				if(soldado !=null) {
					return false;
				}
			}
			return true;
		}
		


		// Determina la altura del Corazon
		double posicionCorazon() {
			double piso = (this.entorno.alto() - this.entorno.alto() / 6) - 30;
			return piso;
		}
		
		//		SELECCIONA CASA PARA DEJAR EL RAMO
		public Cuadra elegirCuadra() {  //AGREGADO::::
			Random cuadraElegida = new Random();
			int aleatorio = cuadraElegida .nextInt(20);
			
			System.out.println(aleatorio);
		    return cuadras[aleatorio];
			}

		public void crearCuadras() { 		//AGREGADO::::
			
			//creo cuadrados “pasto” en cada posición del arreglo cuadra
			Juego.cuadras[0]= new Cuadra(64, 44, 128, 88);       
			Juego.cuadras[1] = new Cuadra(232, 44, 128, 88);
			Juego.cuadras[2] = new Cuadra(400, 44, 128, 88);
			Juego.cuadras[3] = new Cuadra(568, 44, 128, 88);
			Juego.cuadras[4] = new Cuadra(736, 44, 128, 88);
			Juego.cuadras[5]= new Cuadra(64, 172, 128, 88);       
			Juego.cuadras[6] = new Cuadra(232, 172, 128, 88);
			Juego.cuadras[7] = new Cuadra(400, 172, 128, 88);
			Juego.cuadras[8] = new Cuadra(568, 172, 128, 88);
			Juego.cuadras[9] = new Cuadra(736, 172, 128, 88);
			Juego.cuadras[10]= new Cuadra(64, 300, 128, 88);       
			Juego.cuadras[11] = new Cuadra(232, 300, 128, 88);
			Juego.cuadras[12] = new Cuadra(400, 300, 128, 88);
			Juego.cuadras[13] = new Cuadra(568, 300, 128, 88);
			Juego.cuadras[14] = new Cuadra(736, 300, 128, 88);
			Juego.cuadras[15]= new Cuadra(64, 428, 128, 88);       
			Juego.cuadras[16] = new Cuadra(232, 428, 128, 88);
			Juego.cuadras[17] = new Cuadra(400, 428, 128, 88);
			Juego.cuadras[18] = new Cuadra(568, 428, 128, 88);
			Juego.cuadras[19] = new Cuadra(736, 428, 128, 88);
			Juego.cuadras[20]= new Cuadra(64, 556, 128, 88);       
			Juego.cuadras[21] = new Cuadra(232, 556, 128, 88);
			Juego.cuadras[22] = new Cuadra(400, 556, 128, 88);
			Juego.cuadras[23] = new Cuadra(568, 556, 128, 88);
			Juego.cuadras[24] = new Cuadra(736, 556, 128, 88);
			
		}
		public void dibujarCuadras() { 
			for (int i=0; i < cuadras.length; i++)
				Juego.cuadras[i].dibujar(entorno);			
		}

		


	Juego()
	{
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Sakura Ikebana Delivery - Grupo 11 - v1", 800, 600);
		
		
	// Inicializar lo que haga falta para el juego
		
	//	musiquita = Herramientas.cargarSonido("prelude.wav");	//Musiquita 1 
		musiquita = Herramientas.cargarSonido("gravity-falls.wav");	//Musiquita 2
		
		
		musiquita.loop(Clip.LOOP_CONTINUOUSLY);
		
		
		//IMAGENES 
		this.imagenFondo = Herramientas.cargarImagen("fondo-3.gif");
		this.fueguillos = Herramientas.cargarImagen("fireball1.png");
		this.Corazon = Herramientas.cargarImagen("corazon.png");
		this.gameOver = Herramientas.cargarImagen("gameOver.gif");
		

		// SE ASIGNA VALORES A LA VARIABLE  FIREBALL 
		
		maxFire = 1;
		unaBola = 0;
		fireballs = fireListNull(maxFire); 
	
		time = 3;		// TIEMPO DE INMUNIDAD DESPUES DE SUFRIR DAÑO
		cantidadNinjas = 2;		// CANTIDAD DE NINJAS
		this.ninjas = dameNinjaYList(cantidadNinjas);  //CREA UN ARREGLO DE NINJAS EN EL EJE Y
		this.ninjas2 = dameNinjaXList(cantidadNinjas);//CREA UN ARREGLO DE NINJAS EN EL EJE X
		esInmune = false;	// PARA CONTROLAR LA INMUNIDAD LUEGO DE UNA COLISION


		puntaje = 0;				// PUNTAJES ACTUALES 
		ninjasEliminados = 0;
		vidasTotal = 3;	  			// CANTIDAD DE VIDAS INICIALES
		// Crea los objetos
		this.sakura = new Sakura(400, 365, 25, 25, 0);

		//cuadras = new Cuadra[25];
	
			
		
		
		//CREA OBJETOS CASAS 
		//VERTICAL DERECHO
		this.casasVerticalDerecho = new Casa[5][4];
		this.casasVerticalDerecho = Casa.matrizDeCasasVerticalDerecho();
				
		//VERTICAL IZQUIERDO
		this.casasVerticalIzquierdo = new Casa[5][4];
		this.casasVerticalIzquierdo =  Casa.matrizDeCasasVerticalIzquierdo();
				
		//HORIZONTAL ARRIBA
		this.casasHorizontalArriba = new Casa[4][5];
		this.casasHorizontalArriba = Casa.matrizDeCasasHorizontalArriba();
				
		//HORIZONTAL ABAJO
		this.casasHorizontalAbajo = new Casa[4][5];
		this.casasHorizontalAbajo = Casa.matrizDeCasasHorizontalAbajo();
	

		siChoco = false; 	// Controla si chocan a sakura
		ticks = 3; 			// se usa para retardar algunos sucesos
		
		izquierda = false;  // Booleanos para el movimiento del disparo
		derecha = false;
		arriba = false;
		abajo = false;
		

		//AGREGADO::::
		this.flecha = new Flecha[1];
		Juego.cuadras = new Cuadra [25];
		crearCuadras();

		
	
		//CREO OBJETOS FLECHA
		
		
		// Inicia el juego!
		this.entorno.iniciar();
	}


	

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo

		
		//	BLOQUE PARA LAS IMAGENS DE FONDO
	
		
		// CONDICIONAL QUE SE EJECUTA MIENTRAS LAS VIDAS SEAN MAYORES A CERO	
		if(vidasTotal > 0) {
			this.entorno.dibujarImagen(imagenFondo, 400, 300, 0, 1.3);
			
			this.sakura.dibujar(entorno);
			dibujarCuadras();  // AGREGADO::::
			
			//###############################################
			// Compruebo colision sakura flecha y creo flecha  AGREGADO::::
			//###############################################
			if (cuadraElegida==null)
				cuadraElegida=elegirCuadra();
			for (int i=0; i<cuadras.length; i++) {
				if (cuadraElegida == cuadras[i]) {
					this.flecha[0] = new Flecha(Juego.cuadras[i].posicionX(), Juego.cuadras[i].posicionY()+Juego.cuadras[i].alto()/2 + 12, 10, 40);
					this.flecha[0].dibujar(entorno);
				}
			}
			if(this.flecha[0].colisionFlechaSakura(this.sakura.x2(), this.sakura.y2(), this.sakura.y1())){
				this.cuadraElegida = null;
				this.flecha[0] = null;
				puntaje += 5;
			}			
	 

		
			//*******************************************
			//RECORRO CASAS VERTICALES DERECHO PARA PODER DIBUJARLAS
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					this.casasVerticalDerecho[i][j].dibujar(entorno);
				}
			}
			
			//RECORRO CASAS VERTICALES IZQUIERDO PARA PODER DIBUJARLAS
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					this.casasVerticalIzquierdo[i][j].dibujar(entorno);
				}
			}
			
			//RECORRO CASAS HORIZONTAL ARRIBA PARA PODER DIBUJARLAS
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 5; j++) {
					this.casasHorizontalArriba[i][j].dibujar(entorno);
				}
			}
			
			//RECORRO CASAS HORIZONTAL ABAJO PARA PODER DIBUJARLAS
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 5; j++) {
					this.casasHorizontalAbajo[i][j].dibujar(entorno);
				}
			}
			
			
			
			// MOVIMIENTO SAKURA PARA Q NO CHOQUE LAS CASAS //
			//SI NO CHOCA CON LOS BORDES VERTICALES DE CUADRA, NI CON EL ENTORNO; PERMITE MOV DE SAKURA
			if (this.sakura.noChocasteConBordeVerticalDeCuadra()) {
				
				if ((this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)  && !this.sakura.chocasteBordeSuperior())) {
					this.sakura.mover("arriba");
				}
			}
			
			//SI NO CHOCA CON LOS BORDES VERTICALES DE CUADRA, NI CON EL ENTORNO; PERMITE MOV DE SAKURA
			if (this.sakura.noChocasteConBordeVerticalDeCuadra()) {
				
				if ((this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && !this.sakura.chocasteBordeInferior())) {
					this.sakura.mover("abajo");
				}
			
			}	
			
			//SI NO CHOCA CON LOS BORDES HORIZONTALES DE CUADRA, NI CON EL ENTORNO; PERMITE MOV DE SAKURA
			if (this.sakura.noChocasteConBordeHorizontalDeCuadra()) {
				if ((this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA)&& !this.sakura.chocasteBordeIzquierdo())) {
					this.sakura.mover("izquierda");
				}
			}
			
			//SI NO CHOCA CON LOS BORDES HORIZONTALES DE CUADRA, NI CON EL ENTORNO; PERMITE MOV DE SAKURA
			if (this.sakura.noChocasteConBordeHorizontalDeCuadra()) {
				if ((this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& !this.sakura.chocasteBordeDerecho())) {
					this.sakura.mover("derecha");
				}
			}
				
		
			
			//#######################################################
			//					BLOQUE NINJAS			  		   //
			//#######################################################
			
	
			// 	NINJA QUE APARECEN DE ARRIBA 
				for(int i = 0; i < ninjas.length; i++) {
					if (ninjas[i] != null) {
						this.ninjas[i].mover();
						//Comprueba colision ninjas sakura
						if(this.ninjas[i].colisionNinjaSakura(this.sakura.x2(), this.sakura.y2(), this.sakura.y1())){
							siChoco = true;
							
						}
						ninjas[i].dibujar(this.entorno);
						
					}
					
					if(unaBola > 0) {
						for (int j = 0; j < fireballs.length; j++) {
							if(this.fireballs[j] !=null && this.ninjas[i] !=null) {
								//Comprueba colision ninjas en eje y con fireball
								if(this.ninjas[i].colisionFireballNinja(this.fireballs[j].x2(), this.fireballs[j].y2(), this.fireballs[j].y1())) {
									this.fireballs[j] = null;
									
									unaBola -=1;
									this.ninjas[i] = null;
									Herramientas.play("burning.wav");
								//	puntaje = puntaje + 5;
									ninjasEliminados ++;
								}
							}
						}
					}
					
				
					if(this.ninjas[i] != null && this.ninjas[i].getY() > 900) {
						this.ninjas[i] = null;
					}
					
				}
				
				if(todosMuertos(ninjas)) {	//CONTROLA SI TODOS LOS SOLDADOS MURIERON DE SER ASI CREA UNA NUEVA LISTA
					ninjas = dameNinjaYList(cantidadNinjas);
					
					
					
				}
				
			
				// NINJAS QUE APARECEN DE DERECHA A IZQUIERDA
				for(int i = 0; i < ninjas2.length; i++) {
					if (ninjas2[i] != null) {
						this.ninjas2[i].moverEjeX();
						//Comprueba colision ninjas sakura
						if(this.ninjas2[i].colisionNinjaSakura(this.sakura.x2(), this.sakura.y2(), this.sakura.y1())){
							siChoco = true;
						//	System.out.println(siChoco);
							
						}				
						ninjas2[i].dibujar(this.entorno);
						
					}
					
					if(unaBola > 0) {
						for (int j = 0; j < fireballs.length; j++) {
							if(this.fireballs[j] !=null && this.ninjas2[i] !=null) {
								//Comprueba colision ninjas fireballs
								if(this.ninjas2[i].colisionFireballNinja(this.fireballs[j].x2(), this.fireballs[j].y2(), this.fireballs[j].y1())) {
									this.fireballs[j] = null;  	// Si hubo colision elimino fireball
									
									unaBola -=1;
									this.ninjas2[i] = null;		// Si hubo colision elimino 
									Herramientas.play("burning.wav");
								//	puntaje = puntaje + 5;
									ninjasEliminados ++;
								}
							}
						}
					}
					
				
					if(this.ninjas2[i] != null && this.ninjas2[i].getX() < - 200) {
						this.ninjas2[i] = null;
					}
					
				}
				
				if(todosMuertos(ninjas2)) {	//CONTROLA SI TODOS LOS SOLDADOS MURIERON DE SER ASI CREA UNA NUEVA LISTA
					ninjas2 = dameNinjaXList(cantidadNinjas);
					
					
					
				}
	
				
			
				//###############################################################
				//				BLOQUE DE CONTROL DE FIREBALL	 		       //
				//###############################################################
				
					if(this.entorno.sePresiono(entorno.TECLA_ESPACIO) && unaBola < maxFire) {
						Herramientas.play("fireball.wav");
						unaBola = unaBola + 1;
						int disponible = 0;
						if(disponible < 1) {
							for (int i = 0; i < fireballs.length; i++) {
								if(fireballs[i] == null && disponible == 0) {
									
									//preguntamos la direccion en la que esta apuntando el personaje principal y guardo esa direccion
					if( entorno.estaPresionada(this.entorno.TECLA_ARRIBA)) 
					{
						arriba = true;
						abajo = false;
						derecha = false;
						izquierda = false;
						fireballs[i] = this.sakura.disparar();	//Llamo a disparo desde el objeto sakura
						this.direccion = 1;
					}
					else if(entorno.estaPresionada(this.entorno.TECLA_DERECHA))  
					{
						arriba = false;
						abajo = false;
						derecha = true;
						izquierda = false;
						fireballs[i] = this.sakura.disparar();	//Llamo a disparo desde el objeto sakura
						this.direccion = 2;
					}
					else if( entorno.estaPresionada(this.entorno.TECLA_ABAJO)) 
					{
						arriba = false;
						abajo = true;
						derecha = false;
						izquierda = false;
						fireballs[i] = this.sakura.disparar();	//Llamo a disparo desde el objeto sakura
						this.direccion = 3;
					}
					else if(entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA))  
					{
						arriba = false;
						abajo = false;
						derecha = false;
						izquierda = true;
						fireballs[i] = this.sakura.disparar();	//Llamo a disparo desde el objeto sakura
						this.direccion = 4;
					}
					else if(entorno.estaPresionada(this.entorno.TECLA_ESPACIO))  
					{
						arriba = false;
						abajo = false;
						derecha = false;
						izquierda = false;
						fireballs[i] = this.sakura.disparar();	//Llamo a disparo desde el objeto sakura
						this.direccion = 5;
					}
									disponible +=1;
								}
							}	
						}
						disponible = 0;
					}
					
					
					
				if(unaBola > 0) {
					// Disparamos en la direccion que camina el personaje
					for (int i = 0; i < fireballs.length; i++) {
						if(fireballs[i] !=null) {
							if(derecha == true && izquierda == false && arriba == false && abajo == false) {
							fireballs[i].disparar(this.direccion);
							fireballs[i].dibujar(this.entorno);
						
							}
							if(izquierda == true && derecha == false && arriba == false && abajo == false) {
								fireballs[i].disparar(this.direccion);
								fireballs[i].dibujar(this.entorno);
								
								}
							if(arriba == true && derecha == false && izquierda == false && abajo == false) {
								fireballs[i].disparar(this.direccion);
								fireballs[i].dibujar(this.entorno);
								
								}
							if(abajo == true && derecha == false && izquierda == false && arriba == false) {
								fireballs[i].disparar(this.direccion);
								fireballs[i].dibujar(this.entorno);
								
								}
							if(abajo == false && derecha == false && izquierda == false && arriba == false) {
								fireballs[i].disparar(this.direccion);
								fireballs[i].dibujar(this.entorno);
								
								}
							
							// Si el fireball pasa los limetes maximos y minimos de la pantalla se elimina
							if(fireballs[i].getX() > 800 || fireballs[i].getY() < 0 || fireballs[i].getX() < 0 || fireballs[i].getY() > 600) {
								fireballs[i] = null;
							
								if(unaBola > 0) {
									unaBola -=1;
								}
									
							}
							
						}
					}
				}


		
			//###############################################################
			//					DIBUJA LAS BALAS Y LOS CORAZONES		   //
			//###############################################################
			
		
			if(vidasTotal > 0) {
				int separacion = 0;
				for(int i = 0; i < vidasTotal ; i++) {
					this.entorno.dibujarImagen(Corazon, 450 - separacion, 20, 0, 0.1);
					separacion = separacion + 60;
				}
			}
			
			if((maxFire - unaBola) > 0) {
				int separacion = 0;
				for(int i = 0; i < (maxFire - unaBola) ; i++) {
					this.entorno.dibujarImagen(fueguillos, 40 + separacion, 100, 0, 0.8);
						separacion = separacion + 60;
				}
			}
	

			// SUMA DE VARIABLE TICKS USADA COMO CONTROL DE TIEMPO
			ticks++;
						
			//###################################################################
			//	CONTROL DE COLISION SAKURA, INMUNIDAD Y DISMINUCION DE VIDAS  //
			//###################################################################
			
			if(siChoco && !esInmune ) {	// AL SUFRIR UN DANIO SE OTORGA 3 SEG DE INMUNIDAD
				Herramientas.play("ooh.wav");
				siChoco = false;
				esInmune = true;
				time = 0;
				vidasTotal --;
			}
			
			if(esInmune && time < 3 ) {			//CONTROLA EL TIEMPO DE INMUNIDAD 
				siChoco = false;
				if(ticks% 100 == 0) {
					time = time + 1;
	
				}
			}else {
				esInmune = false;
			}
			
			//###############################################################
			//					MUESTRA EL PUNTAJE ACTUAL			 	   //
			//###############################################################
			
			
			this.entorno.cambiarFont(Font.SANS_SERIF, 30, Color.WHITE);
			this.entorno.escribirTexto("Puntos  " + puntaje, 10, 50);
			this.entorno.escribirTexto("Muertos  " + ninjasEliminados, 640, 50);
		
		}

		else{	
			
			//###############################################################
			//							GAME OVER					 	   //
			//###############################################################
			musiquita.stop();
			Herramientas.play("smb_gameover.wav");
			this.entorno.dibujarImagen(gameOver, 400, 300, 0);
			this.entorno.cambiarFont(Font.SANS_SERIF, 40, Color.WHITE);
			this.entorno.escribirTexto(" Presione Enter para salir " , 145, 545);
			
		}
		
			//###############################################################
			//		SI SE PRESIONA ENTER , CIERRA EL ENTORNO               //
			//###############################################################
		
		if(this.entorno.sePresiono(this.entorno.TECLA_ENTER)) {
			
			this.entorno.dispose();
		}
	
	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		
		Juego juego = new Juego();
	}
	


	
}
