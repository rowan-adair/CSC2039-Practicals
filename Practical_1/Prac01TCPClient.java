import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class Prac01TCPClient {

	private Socket socket;
	private ObjectInputStream iStream;
	private ObjectOutputStream oStream;
	private Scanner sc;
	private boolean validInput;

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

	}// constructor

	public void sendData()
		    { 
		    try{  	
		    	while(true)
		    	{	   			
					int input = 0;
					sc = new Scanner(System.in);
					while(!sc.hasNextInt() && (input > 4 || input < 1)){
						System.out.println("Enter some integer input to send to the server.");
						sc.nextLine();
					}
					input = sc.nextInt();
					sc.close();
			   		//	if user inputs a 4 break out of loop
					if(input == 4) break;
					//send to server
					oStream.writeInt(input);
					// read information sent back from server
					String document = iStream.readUTF();
					// output the document the server sends back - either to the console using System.out or to a JOptionpane
					System.out.print(document);
				}
				//when communications are complete close streams and socket
				System.out.println("Closing Client");
				if(!socket.isClosed()) socket.close();
				iStream.close();
				oStream.close();
		    	
		    }catch(ClassNotFoundException e){
				System.out.println(e.getMessage());
	          	System.exit(1);
		    }catch(............){
				//...........
	          	System.exit(1);
	    	}
	    	catch(IOException e) // thrown by method readObject
			{	
				System.out.println(e.getMessage())
				System.exit(1);
			}
		    	
	}

	public static void main(String args[]) {
		Prac01TCPClient client = new Prac01TCPClient();
		client.sendData();

	}

}
