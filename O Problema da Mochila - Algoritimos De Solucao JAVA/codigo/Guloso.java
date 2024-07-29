public class Guloso {
    static public int Guloso(ItemMochila[] itens, int capacidade){
        quicksort(itens, 0, itens.length-1);
        Mochila m = new Mochila(capacidade);
        for (int index = 0; index < itens.length; index++) {
            m.add(itens[index]);
        }
        return m.getValorAtual();
    }

    static public int particao(ItemMochila[] dados, int inicio, int fim) {
        int posicao = inicio - 1;
        double pivot = dados[fim].getRazao();
        for (int i = inicio; i < fim; i++) {
            if (dados[i].getRazao() > pivot) {
                posicao++;
                Utils.trocar(dados, posicao, i);
            }
        }
        posicao++;
        Utils.trocar(dados, posicao, fim);
        return posicao;
    }

    static public void quicksort(ItemMochila[] dados, int inicio, int fim) {
        if (inicio >= fim)
            return;
        else {
            int particao = particao(dados, inicio, fim);
            quicksort(dados, inicio, particao - 1);
            quicksort(dados, particao + 1, fim);
        }
    }
}
