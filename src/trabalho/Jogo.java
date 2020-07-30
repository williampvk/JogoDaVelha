package trabalho;

import java.io.IOException;
import java.util.Scanner;

public class Jogo {

	private static Scanner tec; // Captura do teclado

	//Método Main
	public static void main(String[] args) throws InterruptedException, IOException {
		
		tec = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		Jogador	player = new Jogador();
		Computador comp = null;
		String mat[][] = new String[3][3];
		
		//Imprime mensagem de início do jogo
		System.out.println("\n JOGO DA VELHA \n");
		System.out.println("Escolha o nível do adversário (1 , 2 ou 3): ");
		
		// Variáveis de controle
		int opcao = tec.nextInt();
		int controle = 0;
		String resultado = "Velha!";
		Boolean venceu = false;
		
		do { // Loop para validar escolha digitada
			if (opcao != 1 && opcao != 2 && opcao != 3){
				// Se não for 1, 2 ou 3, solicita nova escolha
				System.out.println("\n Nível inválido! ");
				System.out.println("Escolha o nível do adversário (1 , 2 ou 3): ");
				// Guarda a opção válida
				opcao = tec.nextInt();
			}else{
				// Se for uma escolha válida, altera controle para 1
				controle = 1;
			}
		} while (controle == 0); // Enquanto "controle" for zero, mantém o loop
		
		if(opcao == 1){ // Selecão da classe que será instanciada no objeto "comp"
			comp = new Computador1();
		}	
		if(opcao == 2) {
			comp = new Computador2();
		}	
		if(opcao == 3) {
			comp = new Computador3();
		}

		// Imprime o tabuleiro
		tab.mostrarTab();
		
		// Variáveis de controle
		int jogador = 1;
		String jogada;
		Boolean fim = false;
		
		do{ // Loop de controle do jogo
			if (jogador == 1){ // Se for a vez do jogador chama método "jogar"
				jogada = player.jogar();
				
				while (!tab.validaCoordenada(jogada,jogador)){ // Loop para validar a jogada
					System.out.println("\n Coordenada já está preenchida! \n");
					jogada = player.jogar();
				}
				
				// Chama método para validação se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se jogador venceu, seta a mensagem em "resultado" e finaliza o loop
					resultado = "Você ganhou!";
					fim = true;
				}
				else{
					// Chama método para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 2; // Altera para o próximo jogador
			}
			else{ // Se for a vez do computador
				// Carrega a matriz com as jogadas feitas até o momento
				mat = tab.getMat(); 
				// Chama método para carregar jogada do computador
				jogada = comp.jogar(mat);
				// Chama método para validar e carregar a jogada
				tab.validaCoordenada(jogada,jogador);
				// Chama método para validação se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se a máquina venceu, seta a mensagem em "resultado" e finaliza o loop
					resultado = "Você perdeu!";
					fim = true;
				}
				else{
					// Chama método para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 1; // Altera para o próximo jogador
			}
			
			// Imprime tabuleiro preenchido até o momento
			tab.preencheTabuleiro();
			
		}while(fim == false); // Enquanto fim não for setado, mantém o loop
		
		// Imprime resultado do jogo
		System.out.println("\nFim de Jogo.");
		System.out.println("\n" + resultado);

	}

}	