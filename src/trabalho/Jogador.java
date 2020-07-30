package trabalho;

import java.util.Scanner;

public class Jogador {
	
	private Scanner tec; // Captura do teclado

	// M�todo construtor
	public Jogador(){
		
	}
	
	// M�todo para solicitar jogada
	public String jogar(){
		System.out.println("Digite as coordenadas da sua jogada: ");
		tec = new Scanner(System.in);
		String coordenada = tec.next();
		int controle = 0;
		
		do { // loop para valida��o
			if (coordenada.equalsIgnoreCase("00") ||
				coordenada.equalsIgnoreCase("01") ||
				coordenada.equalsIgnoreCase("02") ||
				coordenada.equalsIgnoreCase("10") ||
				coordenada.equalsIgnoreCase("11") ||
				coordenada.equalsIgnoreCase("12") ||
				coordenada.equalsIgnoreCase("20") ||
				coordenada.equalsIgnoreCase("21") ||
				coordenada.equalsIgnoreCase("22")){ // Coordenadas poss�veis para jogada ser v�lida
				
				controle = 1;
				
			}else{
				// Caso coordenadas forem inv�lidas
				System.out.println("\n Coordenadas inv�lidas! ");
				System.out.println("Digite as coordenadas da sua jogada: ");
				// Guarda coordenadas digitadas
				coordenada = tec.next();
			}
		} while (controle == 0); // Enquanto "controle" for zero, mant�m o loop
		
		return coordenada; // Retorna coordenda validada
	}

}