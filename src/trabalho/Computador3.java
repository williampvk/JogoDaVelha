package trabalho;

import java.util.Random;

public class Computador3 extends Computador{
	
	@Override //Método sobreescrito
	public String jogar(String[][] mat) {
		// Nesse nível, o computador irá gerar uma coordenada aleatória
		
		Random random = new Random();
		int i,j;
		
		while (true){ //Abre loop até localizar uma coordenada válida
			i = random.nextInt(3); // Gera número aletório de 0 a 2
			j = random.nextInt(3); 
			
			if (mat[i][j] == null) // Se o campo está nulo
				return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
		}
	}
}
