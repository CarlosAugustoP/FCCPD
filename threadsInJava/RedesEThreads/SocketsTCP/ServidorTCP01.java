import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorTCP01 {
	public static void main(String[] args) {
		try{
			//criando um servidor na porta 6700
			ServerSocket servidor = new ServerSocket(6700);
			System.out.println("[SERVIDOR] Esperando por conexao de cliente...");
			Socket socket = servidor.accept();
			System.out.println("[SERVIDOR] Cliente se conectou");

			// Cria um stream de entrada, lendo a mensagem do cliente
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String msg = in.readUTF();
			System.out.println("[SERVIDOR] Mensagem do cliente" 
			+ socket.getInetAddress() + ":" + socket.getPort()+ ": "+ msg);

			// Envia uma mensagem de volta para o cliente, confirmando que este recebeu uma mensagem
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Oi cliente, mensagem recebida!");
			
			in.close();
			out.close();
			servidor.close();			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("[SERVIDOR] Erro: " + e.getMessage());

		}
	}
	
}
