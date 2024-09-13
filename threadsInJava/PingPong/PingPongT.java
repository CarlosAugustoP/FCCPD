package PingPong;

// Implementação simples de um "ping pong" usando Threads sem runnable
public class PingPongT extends Thread  {
    private String palavra;
    private int delay;

    public PingPongT(String oQueFalar, int tempoDelay){
        palavra = oQueFalar;
        delay = tempoDelay;
    }

    public void run() {
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
       PingPongT ping = new PingPongT("ping", 500);
       PingPongT pong = new PingPongT("PONG", 1000);
       ping.start();
       pong.start();     
    }
}
