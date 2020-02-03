import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Prac01TCPClient {

	private Socket socket;
	private ObjectInputStream iStream;
	private ObjectOutputStream oStream;

	public Prac01TCPClient() {
		// get connections etc
		try {
			// initialise a socket and get a connection to the server on port 2000
			socket = new Socket(InetAddress.getLocalHost(), 2000);
			// HINT: How does information flow along through TCP to the server?
			// get output stream
			oStream = new ObjectOutputStream(socket.getOutputStream());
			// HINT: How does information flow along through TCP from the server?
			// get input stream
			iStream = new ObjectInputStream(socket.getInputStream());
			// add message to text output area - use System.out.println if you prefer
			System.out.println();
			JOptionPane.showMessageDialog(null, "\nClient Started.");
		} // try
			// HINT: What do we have to catch?
		catch (UnknownHostException e)
		// thrown by method getLocalHost
		{ // HINT: What should we output as a result of the catch?
			System.out.println(e.getMessage());
			System.exit(1);
		}
		// HINT: What do we have to catch?
		catch (IOException e) { // HINT: What should we output as a result of the catch?
			System.out.println(e.getMessage());
			System.exit(1);
		}

	}

	public void sendData()
		    { 
		    try{  	
		    	while(true)
		    	{	   			
					String input = JOptionPane.showInputDialog("\nEnter a document number 0 to 3 (4 to exit)");
					int n = Integer.parseInt(input);			
					oStream.writeObject(n);
					if(n == 4) break;
					String document = (String)iStream.readObject();
					JOptionPane.showMessageDialog(null, "Document : " + n + "\n" + document);
				}
				System.out.println("Closing Client");
				if(!socket.isClosed()) socket.close();
		    	
		    }catch(ClassNotFoundException e){
				System.out.println(e.getMessage());
	          	System.exit(1);
		    }catch(UnknownHostException e){
				System.out.println("Unknown Host " + e);
	          	System.exit(1);
	    	}
	    	catch(IOException e)
			{	
				System.out.println(e.getMessage());
				System.exit(1);
			}
		    	
	}

	public static void main(String args[]) {
		Prac01TCPClient client = new Prac01TCPClient();
		client.sendData();

	}

}
