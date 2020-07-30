package trabalho;

public class Computador1 extends Computador {

	@Override //M�todo sobreescrito
	public String jogar(String[][] mat) {
		// Nesse n�vel, o computador ir� seguir a linha sequ�ncialmente at� achar uma coordenada nula
		for (int i=0;i<3;i++){ // Abre loop para as linhas do tabuleiro
			for (int j=0;j<3;j++){ // Abre loop para as colunas do tabuleiro
				if (mat[i][j] == null) // Se o campo est� nulo
					return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
			}
		}
		return null;
	}

}