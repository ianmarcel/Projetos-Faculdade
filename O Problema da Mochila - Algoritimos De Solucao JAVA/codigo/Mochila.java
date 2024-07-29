import java.util.ArrayList;
import java.util.List;

public class Mochila {
    private List<ItemMochila> itemLista;
    private int capacidade;

    public Mochila(int capacidade) {
        this.itemLista = new ArrayList<ItemMochila>();
        this.capacidade = capacidade;
    }

    public boolean add(ItemMochila item) {
        if (item.getPeso() + this.getPesoAtual() <= this.capacidade) {
            itemLista.add(item);
            return true;
        } else {
            return false;
        }
    }

    public List<ItemMochila> getListaDeItens() {
        return this.itemLista;
    }

    public int getPesoAtual() {
        int peso = 0;
        for(ItemMochila item : this.itemLista){
            peso += item.getPeso();
        }
        return peso;
    }

    public int getValorAtual() {
        int valor = 0;
        for(ItemMochila item : this.itemLista){
            valor += item.getValor();
        }
        return valor;
    }

}
