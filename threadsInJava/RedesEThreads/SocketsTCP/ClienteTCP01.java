import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
// Importando o pacote socket.


public class ClienteTCP01 {

	public static void main(String[] args) {
		
		try {
			// Definindo uma conexão TCP entre um cliente e um servidor que está rodando no endereço. O servidor escuta na porta 6700.
			Socket s = new Socket("127.0.0.1", 6700);
			
			// Criar um stream de saída. a função writeUTF() envia uma string para o servidor usando o Socket
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF("Oi servidor");
			
			// Criar um stream de entrada. A função readUTF() lê uma string do servidor usando o Socket.
			DataInputStream in = new DataInputStream(s.getInputStream());
			System.out.println("[CLIENTE] Recebi do Servidor: "+ in.readUTF());

			in.close();
			out.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
