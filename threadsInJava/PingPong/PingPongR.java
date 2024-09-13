package PingPong;


// Implementando a interface runnable, seguimos um padrão de projeto mais recomendado, que cobra do programador a implementação do método run

public class PingPongR implements Runnable {
    private String palavra;
    private int delay;

    public PingPongR(String oQueFalar, int tempoDelay){
        palavra = oQueFalar;
        delay = tempoDelay;
    }

    @Override
    public void run (){
        try {
            for (;;){
                System.out.println(palavra + "");
                Thread.sleep(delay);
            }
        }catch (Exception e){
            System.out.println("Erro");
            return;
        }

    }

    public static void main (String[] args){
        PingPongR ping = new PingPongR("ping", 500);
        PingPongR pong = new PingPongR("PONG", 1000);
        Thread t1 = new Thread(ping);
        Thread t2 = new Thread(pong);
        t1.start();
        t2.start();
    }
    
}
