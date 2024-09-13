package AtividadeColheita;

public class Armazem {
    int capacidadeMaxima;
    int estoque;

    public Armazem(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
        this.estoque = 0;
    }

    public void armazenar (int producaoPorColheita){
        if (estoque + producaoPorColheita <= capacidadeMaxima){
            estoque += producaoPorColheita;
            System.out.println("Armazenou " + producaoPorColheita + " sacas. Estoque: " + estoque);
        } else {
            System.out.println("Armazem cheio. Estoque: " + estoque);
        }
    
}
}