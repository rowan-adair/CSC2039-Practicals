import java.io.*;
import java.net.*;

public class Prac01TCPServer {

	// declare variables
	// this socket enables the client to make a connection to the server
	ServerSocket serverSocket;

	// HINT: In TCP, what do we have to declare to receive communications from the
	// client?
	ObjectInputStream serverInputStream;

	// HINT: In TCP, what do we have to declare to send communications to the
	// client?
	ObjectOutputStream serverOutputStream;

	Socket client;
	// an array of Strings to represent four documents
	String document[] = {
			"The generic term 'TCP/IP' usually means anything and everything\n"
					+ "related to the specific protocols of TCP and IP.  It can include\n"
					+ "other protocols, applications, and even the network medium.  A sample\n"
					+ "of these protocols are: UDP, ARP, and ICMP.  A sample of these\n"
					+ "applications are: TELNET, FTP, and rcp.  A more accurate term is\n"
					+ "'internet technology'.  A network that uses internet technology is\n" + "called an 'internet'",
			"The TCP module, UDP module, and the Ethernet driver are n-to-1\n"
					+ "multiplexers.  As multiplexers they switch many inputs to one output.\n"
					+ "They are also 1-to-n de-multiplexers.  As de-multiplexers they switch\n"
					+ "one input to many outputs according to the type field in the protocol\n" + "header.",
			"If an Ethernet frame comes up into the Ethernet driver off the\n"
					+ "network, the packet can be passed upwards to either the ARP (Address\n"
					+ "Resolution Protocol) module or to the IP (Internet Protocol) module.\n"
					+ "The value of the type field in the Ethernet frame determines whether\n"
					+ "the Ethernet frame is passed to the ARP or the IP module.",
			"If an IP packet" + " comes up into IP, the unit of data is passed upwards\nto either TCP or UDP, "
					+ "as determined by the value of the protocol field in the IP header. " };

	public Prac01TCPServer() {
		try {
			/*
			 * HINT: What is required to be initialised which is an essential component of
			 * the server? This can be such a bind
			 */
			// get a server socket and bind to port 2000
			serverSocket = new ServerSocket(2000);
			System.out.println("Server is up and waiting.....");
		}
		// HINT: If it was thrown above, what do we capture?
		catch (IOException e) // thrown by method ServerSocket
		{ // HINT: What should we output as a result of the capture?
			System.out.println(e);
			System.exit(1);
		}
	}

	void waitForData() {
		try {// addOutput("Server is up and waiting for a connection...");

			/*
			 * client has attempted to get a connection to server, now create a socket to
			 * communicate with this client
			 */
			Socket client = serverSocket.accept();

			// get input and output streams
			ObjectInputStream serverInputStream = new ObjectInputStream(client.getInputStream());
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(client.getOutputStream());

			while (true) {
				int choice = (Integer) serverInputStream.readObject();

				System.out.println("Server has received the choice....." + choice);
				// if client has indicated that they want to quit, exit loop
				if (choice == 4)
					break;
				serverOutputStream.writeObject(document[choice]);

			} // end while

			serverInputStream.close();
			serverOutputStream.close();
			// Close socket
			client.close();
			System.out
					.println(" All information returned was copied from RFC1180 TCP/IP tutorial.  Server closing down");
		} catch (IOException e) {
			System.out.println("IO Exception error " + e);
			System.exit(0);
		} catch (ClassNotFoundException e) // thrown by method readObject
		{
			System.out.println(e);
			System.exit(1);
		}
	}// wait for Data

	public static void main(String[] args) {
		// create new instance of P1_server
		Prac01TCPServer server = new Prac01TCPServer();
		// call the waitForData() method
		server.waitForData();
	}

}
