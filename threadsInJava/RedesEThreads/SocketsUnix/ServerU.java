import java.io.IOException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class ServerU {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		// Socket file represents the path where the Unix Domain Socket will be created. It is created in the user's home directory.
		Path socketFile = Path.of(System.getProperty("user.home")).resolve("server.socket");

		// Socket address points to the socket file.
		UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketFile);
		
		// ServerSocketChannel is created with the Unix Domain protocol family and binds the address.
		ServerSocketChannel serverChannel = ServerSocketChannel.open(StandardProtocolFamily.UNIX);
		serverChannel.bind(address);
			
		while(true) {
			System.out.println("[SERVIDOR] Esperando por conexao de cliente...");
			SocketChannel channel = serverChannel.accept();
			System.out.println("[SERVIDOR] Cliente conectado!");
		
			try{
				while(true) {
					readMessageFromSocket(channel).ifPresent(message -> System.out.printf("[Mensagem do Cliente] %s \n", message));
					Thread.sleep(1000);
				}
			}catch (Exception se) {
	            System.out.println("[SERVIDOR] Conexao Encerrada!");
	            break;
	            
	       }
		}
		serverChannel.close();
		Files.deleteIfExists(socketFile);
		
	}
		
	private static Optional<String> readMessageFromSocket(SocketChannel channel) throws IOException {
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int bytesRead = channel.read(buffer);
		if (bytesRead < 0)
			return Optional.empty();

		byte[] bytes = new byte[bytesRead];
		buffer.flip();
		buffer.get(bytes);
		String message = new String(bytes);
		return Optional.of(message);
	}
}
