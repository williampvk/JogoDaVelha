package trabalho;

public class Computador1 extends Computador {

	@Override //Método sobreescrito
	public String jogar(String[][] mat) {
		// Nesse nível, o computador irá seguir a linha sequêncialmente até achar uma coordenada nula
		for (int i=0;i<3;i++){ // Abre loop para as linhas do tabuleiro
			for (int j=0;j<3;j++){ // Abre loop para as colunas do tabuleiro
				if (mat[i][j] == null) // Se o campo está nulo
					return (Integer.toString(i)) + (Integer.toString(j)); // retorna coordenada
			}
		}
		return null;
	}

}