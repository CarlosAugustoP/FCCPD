import java.io.IOException;
import java.net.SocketException;
import java.net.StandardProtocolFamily;
import java.net.UnixDomainSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.util.Scanner;

public class ClienteU {
	
	public static void main(String[] args) throws IOException, InterruptedException, SocketException {
		
		String cliName = "01"; 
	    
		Path socketFile = Path.of(System.getProperty("user.home")).resolve("server.socket");
		UnixDomainSocketAddress address = UnixDomainSocketAddress.of(socketFile);

		SocketChannel channel = SocketChannel.open(StandardProtocolFamily.UNIX);
		channel.connect(address);

		// start
		Thread.sleep(1000);
		writeMessageToSocket(channel, "Olar Servidor, sou o cliente: "+cliName);
		Thread.sleep(4000);
		writeMessageToSocket(channel, "Estou conectado");
		Thread.sleep(4000);
		writeMessageToSocket(channel, "Tchau! - ultima mensagem");
		
		channel.finishConnect();
				
		
	}


	// in Client.java
	private static void writeMessageToSocket(SocketChannel socketChannel, String message) throws IOException {
		ByteBuffer buffer= ByteBuffer.allocate(1024);
		buffer.clear();
		buffer.put(message.getBytes());
		buffer.flip();
		
		while(buffer.hasRemaining()) {
			socketChannel.write(buffer);
		}
	}
}
