import java.net.*;
import java.util.Scanner;

public class UDPSender {
	
	

	public static void main(String[] args) 
   {
		//Cmd line order is : hostname, port, n
	      // Check the arguments
		int count = Integer.parseInt(args[2]);
	      if( args.length != 3  && Integer.parseInt(args[2]) > 0)
	      {
	         System.out.println( "usage: java UDPSender host port n" ) ;
	         return ;
	      }
	      DatagramSocket socket = null ;
	      try
	      {
	         // Convert the arguments first, to ensure that they are valid
	         InetAddress host = InetAddress.getByName( args[0] ) ;
	         int port         = Integer.parseInt( args[1] ) ;
	         socket = new DatagramSocket() ;
  
	         String message = "Message";
	         
	      
	         for(int i = 1; i <= count; i++)
	         {
	        	 
	        		 //System.out.println("Enter text to be sent, ENTER to quit ");
	        		 //message = in.nextLine();
	     
	        			 String newMessage = message + i; 
	        			 byte [] data = newMessage.getBytes() ;
	        			 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
	        			 socket.send( packet ) ;
	        			 
	         } 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

