
public class ForcaBruta {
    static int valorMaior(int num1, int num2) {
        return (num1 > num2) ? num1 : num2;
    }

    static int forcaBruta(int capacidade, ItemMochila vetorItem[], int tam) {

        if (tam == 0 || capacidade == 0) {
            return 0;
        }

        if (vetorItem[tam - 1].getPeso() > capacidade) {
            return forcaBruta(capacidade,vetorItem, tam - 1);
        }

        else {
            return valorMaior(vetorItem[tam - 1].getValor()
                    + forcaBruta(capacidade - vetorItem[tam - 1].getPeso(), vetorItem,
                    tam - 1),
                    forcaBruta(capacidade, vetorItem, tam - 1));
        }
    }

}