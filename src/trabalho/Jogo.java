package trabalho;

import java.io.IOException;
import java.util.Scanner;

public class Jogo {

	private static Scanner tec; // Captura do teclado

	//M�todo Main
	public static void main(String[] args) throws InterruptedException, IOException {
		
		tec = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		Jogador	player = new Jogador();
		Computador comp = null;
		String mat[][] = new String[3][3];
		
		//Imprime mensagem de in�cio do jogo
		System.out.println("\n JOGO DA VELHA \n");
		System.out.println("Escolha o n�vel do advers�rio (1 , 2 ou 3): ");
		
		// Vari�veis de controle
		int opcao = tec.nextInt();
		int controle = 0;
		String resultado = "Velha!";
		Boolean venceu = false;
		
		do { // Loop para validar escolha digitada
			if (opcao != 1 && opcao != 2 && opcao != 3){
				// Se n�o for 1, 2 ou 3, solicita nova escolha
				System.out.println("\n N�vel inv�lido! ");
				System.out.println("Escolha o n�vel do advers�rio (1 , 2 ou 3): ");
				// Guarda a op��o v�lida
				opcao = tec.nextInt();
			}else{
				// Se for uma escolha v�lida, altera controle para 1
				controle = 1;
			}
		} while (controle == 0); // Enquanto "controle" for zero, mant�m o loop
		
		if(opcao == 1){ // Selec�o da classe que ser� instanciada no objeto "comp"
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
		
		// Vari�veis de controle
		int jogador = 1;
		String jogada;
		Boolean fim = false;
		
		do{ // Loop de controle do jogo
			if (jogador == 1){ // Se for a vez do jogador chama m�todo "jogar"
				jogada = player.jogar();
				
				while (!tab.validaCoordenada(jogada,jogador)){ // Loop para validar a jogada
					System.out.println("\n Coordenada j� est� preenchida! \n");
					jogada = player.jogar();
				}
				
				// Chama m�todo para valida��o se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se jogador venceu, seta a mensagem em "resultado" e finaliza o loop
					resultado = "Voc� ganhou!";
					fim = true;
				}
				else{
					// Chama m�todo para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 2; // Altera para o pr�ximo jogador
			}
			else{ // Se for a vez do computador
				// Carrega a matriz com as jogadas feitas at� o momento
				mat = tab.getMat(); 
				// Chama m�todo para carregar jogada do computador
				jogada = comp.jogar(mat);
				// Chama m�todo para validar e carregar a jogada
				tab.validaCoordenada(jogada,jogador);
				// Chama m�todo para valida��o se houve vencedor
				venceu = tab.validaJogada();
				
				if (venceu) { // Se a m�quina venceu, seta a mensagem em "resultado" e finaliza o loop
					resultado = "Voc� perdeu!";
					fim = true;
				}
				else{
					// Chama m�todo para validar fim do jogo
					fim = tab.proximaJogada();
				}
				
				jogador = 1; // Altera para o pr�ximo jogador
			}
			
			// Imprime tabuleiro preenchido at� o momento
			tab.preencheTabuleiro();
			
		}while(fim == false); // Enquanto fim n�o for setado, mant�m o loop
		
		// Imprime resultado do jogo
		System.out.println("\nFim de Jogo.");
		System.out.println("\n" + resultado);

	}

}	