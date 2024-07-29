import java.util.Random;

public  class Utils {
    static Random sorteio = new Random(42);

	static void trocar(ItemMochila[] dados, int pos1, int pos2) {
		ItemMochila aux = dados[pos1];
		dados[pos1] = dados[pos2];
		dados[pos2] = aux;
	}


	static public ItemMochila[] geraVetor(int qtdItems, boolean ordenado, int capacidade) {
		int somaPeso = capacidade * 3;
		int mediaDosItens = somaPeso/qtdItems;  // n é double 

		ItemMochila[] dados = new ItemMochila[qtdItems];
		for (int i = 0; i < dados.length; i++) {
			dados[i] = new ItemMochila();
		}

		for (int i = 0; i < dados.length; i++) {
			dados[i].setPeso(1+ sorteio.nextInt(mediaDosItens*2));
			dados[i].setValor(1+ sorteio.nextInt(50));
			somaPeso += dados[i].getPeso();
		}
		if (!ordenado) {
			for (int i = 0; i < dados.length * 3; i++) {
				int pos1 = sorteio.nextInt(dados.length);
				int pos2 = sorteio.nextInt(dados.length);
				trocar(dados, pos1, pos2);
			}
		}
		return dados;
	}
}
