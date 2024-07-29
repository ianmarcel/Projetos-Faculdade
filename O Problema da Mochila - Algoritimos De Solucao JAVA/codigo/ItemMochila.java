public class ItemMochila {

    private int valor;
    private int peso;

    public int getValor() {
        return valor;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double getRazao() {
        return (double) this.valor / this.peso;
    }

    public String toString() {
        return "peso : " + peso + " valor: " + valor + " razao: " + this.getRazao();
    }

}
