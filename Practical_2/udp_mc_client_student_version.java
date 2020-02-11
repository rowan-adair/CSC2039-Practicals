//****************************************************************
//****************************************************************
//
//   Course CSC2039 - Architecture and Networks
//
//   UDP Multicast Example for laboratory practical
//
//   This code sets up a basic handler client to consume messages
//   from a UDP multicast feed. Students will be given the format
//   of the messages and are asked to complete the following:
//
//      (i)  Fill in the aprt sof the code that not complete
//      (ii) Add the content of the processMsg() method as
//           explained in the associated handout.
//
//   Copyright (c) Queen's University Belfast
//   All rights reserved
//
//****************************************************************
//****************************************************************
//
//--- Import required class definitions from Java
//

import java.io.*;
import java.net.*;

/**
 *
 */
public class udp_mc_client
  {
   /**
    *   Define the MC group to which we connect
    *
    *   Remember its a Class D address AND a UDP Port
    */
   int    multicastGroupIPPort_int = 6984;

   String multicastGroupIPAddress_String = "225.4.5.6";

   /**
    *   When we join the group we will need to keep an instance of
    *   the InetAddress class so that we can leave the group later.
    */
   InetAddress multicastGroup;

   /**
    *   We need a multicast UDP socket class instance
    */
   MulticastSocket s;

   /**
    *  Method: main()
    *
    *  Execution starts from this point
    *
    */
   static public void main(String args[])
     {
      System.out.println("\n");
      System.out.println("     UDP Multicast Client  ");
      System.out.println("     ====================  ");
      System.out.println("\n\n");

      //
      //---- Create an instance of the server class
      //

      udp_mc_client client = new udp_mc_client();

      //
      //---- We should join the MC group - is there a method for that ?
      //

      // ....

      //
      //---- Now execute the receiver process.
      //

      client.receiver();

      //
      //--- We should leave the MC group - is there a method for that ?
      //

      .....

      //
      //---- End of program
      //

      System.out.println("\n");
      System.out.println("     **** Completed - UDP Multicast Client ");
      System.out.println("\n\n");
     }
      // End of main

   /**
    *  Method: join_UDP_MulticastGrooup()
    *
    */
    public void join_UDP_MulticastGroup()
      {
       try
         {
		  multicastGroup = InetAddress.getByName(multicastGroupIPAddress_String);

          s = new MulticastSocket(multicastGroupIPPort_int);

          s.joinGroup(multicastGroup);
	     }
       catch(Exception e)
         {
		  //
		  //  Good practice to print some info to the log ...??
		  //
		  //......

		  System.exit(0);
	     }

	   return;
      }

   /**
    *  Method: leave_UDP_MulticastGrooup()
    *
    */
    public void leave_UDP_MulticastGroup()
      {
	   try
	      {
           s.leaveGroup(multicastGroup);

	       s.close();
	      }
	   catch(Exception e)
	      {
		   //
		   //--- What to do if we have an error ?
		   //
		   ....
	      }

	   return;
      }

   /**
    *  Method: processMsg()
    *
    *  We extract the business information from the message here
    *
    */
   private void processMsg(String msg_str)
     {
	  return;
     }

   /**
    *  Method: receiver()
    *
    *  So, we need to have joined the MC group before we enter here.
    *
    *  Loop over all messages received and process them.
    *
    *  If we find an error then we should retunr to the main and leave group
    *
    */
   private void receiver()
     {
	  final int MAX_BYTES_IN_BUF = 4096;

	  try
	     {
          bool zfinished = false;

          byte buf[] = new byte[MAX_BYTES_IN_BUF];

	      DatagramPacket pack = new DatagramPacket(buf, buf.length);

          while(!zfinished)
            {
   		     s.receive(pack);

             //
             //.... Printout to the log
             //

             System.out.println("     Received data from IP address: " + pack.getAddress().toString() +
  		                     " port: " + pack.getPort() + " length: " + pack.getLength() + " bytes ");

		     System.out.print("     Message:" ); System.out.write(pack.getData(),0,pack.getLength());

             System.out.println("\n");

             //
             //.... Convert message to string
             //

             String msg_str = new String(buf);

             //
             //.... Is this a terminator message
             //
             //     Finish, or process accordingly.
             //

             if(msg_str.contains("END-OF-FEED"))
               {
				zfinished = true;
		       }
             else
               {
				processMsg(msg_str)
		       }
		        // End of test on
		    }
		     // End of while loop on !zfinished
	     }
      catch(Exception e)
         {
          System.out.println("\n");
          System.out.println("     **** Error: in method receiver() of class udp_mc_receiver ");
          System.out.println("\n");
          System.out.println("  ... "); // What to print ??
          System.out.println("\n\n");
         }
          // End of try-catch block

      return;
     }
	  // End of method receiver
  }
   // End of class udp_mc_client
