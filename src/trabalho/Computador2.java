package trabalho;

public class Computador2 extends Computador {
	
	@Override //M�todo sobreescrito
	public String jogar(String[][] mat) {
		// Nesse n�vel, o computador ir� seguir a coluna sequ�ncialmente at� achar uma coordenada nula
		for (int i=0;i<3;i++){ 
			for (int j=0;j<3;j++){ 
				if (mat[j][i] == null) // Se o campo est� nulo
					return (Integer.toString(j)) + (Integer.toString(i)); // retorna coordenada
			}
		}
		return null;
	}
	
}
