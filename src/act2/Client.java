package act2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

	private static final int PORT = 1234;
	private static byte[] buffer = new byte[1024];

	public static void main(String[] args) throws Exception {
		DatagramSocket socket = new DatagramSocket();
		System.out.println("demarrage du client:");
		DatagramPacket userNamePacket = new DatagramPacket(buffer, buffer.length,
				InetAddress.getByName("localhost"), PORT);
		socket.send(userNamePacket);
		DatagramPacket packetToReceive = new DatagramPacket(buffer, buffer.length);
		socket.receive(packetToReceive);
		System.out.println("serveur: " + new String(packetToReceive.getData(), 0, packetToReceive.getLength()));

	}

}
