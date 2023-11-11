package act2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serveur {
	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];
    
	private static String getTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date currentTime = new Date();
		return dateFormat.format(currentTime);
	}

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(PORT);
		System.out.println("demarrage du serveur:");
		while (true) {
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
			socket.receive(packet);
			String time = getTime();
			DatagramPacket packetToSend = new DatagramPacket(time.getBytes(), time.length(),
					packet.getAddress(), packet.getPort());
			socket.send(packetToSend);

		}

	}

}
