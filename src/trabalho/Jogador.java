package trabalho;

import java.util.Scanner;

public class Jogador {
	
	private Scanner tec; // Captura do teclado

	// Método construtor
	public Jogador(){
		
	}
	
	// Método para solicitar jogada
	public String jogar(){
		System.out.println("Digite as coordenadas da sua jogada: ");
		tec = new Scanner(System.in);
		String coordenada = tec.next();
		int controle = 0;
		
		do { // loop para validação
			if (coordenada.equalsIgnoreCase("00") ||
				coordenada.equalsIgnoreCase("01") ||
				coordenada.equalsIgnoreCase("02") ||
				coordenada.equalsIgnoreCase("10") ||
				coordenada.equalsIgnoreCase("11") ||
				coordenada.equalsIgnoreCase("12") ||
				coordenada.equalsIgnoreCase("20") ||
				coordenada.equalsIgnoreCase("21") ||
				coordenada.equalsIgnoreCase("22")){ // Coordenadas possíveis para jogada ser válida
				
				controle = 1;
				
			}else{
				// Caso coordenadas forem inválidas
				System.out.println("\n Coordenadas inválidas! ");
				System.out.println("Digite as coordenadas da sua jogada: ");
				// Guarda coordenadas digitadas
				coordenada = tec.next();
			}
		} while (controle == 0); // Enquanto "controle" for zero, mantém o loop
		
		return coordenada; // Retorna coordenda validada
	}

}