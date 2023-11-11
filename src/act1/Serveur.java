package act1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Serveur {
	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket(PORT);
		System.out.println("demarrage du serveur:");
		while (true) {
			DatagramPacket userNamePacket = new DatagramPacket(buffer, buffer.length);
			socket.receive(userNamePacket);
			String userName = new String(userNamePacket.getData(), 0, userNamePacket.getLength());
			System.out.println("client" + userNamePacket.getAddress() + " userName=" + userName);
			String msgToSend = "Bienvenu " + userName;
			DatagramPacket packetToSend = new DatagramPacket(msgToSend.getBytes(), msgToSend.length(),
					userNamePacket.getAddress(), userNamePacket.getPort());
			socket.send(packetToSend);

		}

	}

}
