public class MainPrincipal {
    public static void main(String args[]) {
        long tempoExecucao = 0;
        int capacidade = 240;
        int quantItems = 5;
        ItemMochila[] itens;


        System.out.println("LETRA A");
        while(tempoExecucao<4000){
            System.out.println("Mochila com capacidade: " + capacidade + " e " + quantItems + " itens");
            tempoExecucao = System.currentTimeMillis();


            itens = Utils.geraVetor(quantItems, false, capacidade);

            System.out.println(ForcaBruta.forcaBruta(capacidade, itens, itens.length));



            tempoExecucao = (System.currentTimeMillis() - tempoExecucao);
            System.out.println("Tempo: " + tempoExecucao + "ms");
            quantItems++;
        }

        System.out.println("LETRA B");

        int iguais = 0;

        for (int i = 0; i < 500; i++) {
            System.out.println("Iteração: " + (i+1));
            itens = Utils.geraVetor((quantItems-2), false, capacidade);

            int fb = ForcaBruta.forcaBruta(capacidade, itens, itens.length);
            System.out.println("Forca Bruta: " + fb);

            int g = Guloso.Guloso(itens, capacidade);
            System.out.println("Guloso: " + g);

            if(fb == g) iguais++;
        }
        System.out.println("\n------------\n IGUAIS: " + iguais);
   }   
}
