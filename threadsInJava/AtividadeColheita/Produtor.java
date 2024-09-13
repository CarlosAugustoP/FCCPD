package AtividadeColheita;

// Questão 1 Atividade dos dois produtores 
public class Produtor implements Runnable {

    int codigo; //codigo do produtor
    int producaoPorColheita; //quantidade de sacas produzidas por colheita
    int intervaloColheita; //intervalo de tempo entre colheitas
    int qtdSacas; //quantidade de sacas produzidas no total
    Armazem armazem; //armazem onde as sacas serão armazenadas

    public Produtor(int codigo, int producaoPorColheita, int intervaloColheita, Armazem armazem){ 
        this.codigo = codigo;
        this.producaoPorColheita = producaoPorColheita;
        this.intervaloColheita = intervaloColheita;
        this.qtdSacas = 0;
        this.armazem = armazem;
    }

    public void run(){
        try {
            for(int i = 0; i < 10; i++){
                Thread.sleep(intervaloColheita);
                qtdSacas += producaoPorColheita;
                System.out.println("Produtor: " + codigo + " produziu " + producaoPorColheita + " sacas. Total: " + qtdSacas);       
                armazem.armazenar(producaoPorColheita);
            }
        }catch (Exception e){
            System.out.println("Erro");
            return;
        }
    }

    public static void main(String[] args){
        Armazem armazem = new Armazem(150);
        
        Produtor produtor1 = new Produtor(111,10,1, armazem);
        Produtor produtor2 = new Produtor(222, 20, 10, armazem);
        
        Thread t1 = new Thread(produtor1);
        Thread t2 = new Thread(produtor2);

        t2.setPriority(9);

        t1.start();
        t2.start();


    }
    
}
