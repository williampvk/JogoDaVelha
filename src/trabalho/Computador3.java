package trabalho;

import java.util.Random;

public class Computador3 extends Computador{
	
	@Override //M�todo sobreescrito
	public String jogar(String[][] mat) {
		// Nesse n�vel, o computador ir� gerar uma coordenada aleat�ria
		
		Random random = new Random();
		int i,j;
		
		while (true){ //Abre loop at� localizar uma coordenada v�lida
			i = random.nextInt(3); // Gera n�mero alet�rio de 0 a 2
			j = random.nextInt(3); 
			
			if (mat[i][j] == null) // Se o campo est� nulo
				return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
		}
	}
}
