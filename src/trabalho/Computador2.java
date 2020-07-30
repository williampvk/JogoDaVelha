package trabalho;

public class Computador2 extends Computador {
	
	@Override //Método sobreescrito
	public String jogar(String[][] mat) {
		// Nesse nível, o computador irá seguir a coluna sequêncialmente até achar uma coordenada nula
		for (int i=0;i<3;i++){ 
			for (int j=0;j<3;j++){ 
				if (mat[j][i] == null) // Se o campo está nulo
					return (Integer.toString(j)) + (Integer.toString(i)); // retorna coordenada
			}
		}
		return null;
	}
	
}
