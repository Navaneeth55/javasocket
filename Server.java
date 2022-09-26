/*
 * Server.java
 */

import java.io.*;
import java.net.*;

public class Server {

    public static final int SERVER_PORT = 5432;

    public static void main(String args[]) 
    {
	ServerSocket myServerice = null;
	String line;
	BufferedReader is;
	PrintStream os;
	Socket serviceSocket = null;

	// Try to open a server socket 
	try {
	    myServerice = new ServerSocket(SERVER_PORT);
	}
	catch (IOException e) {
	    System.out.println(e);
	}   

	// Create a socket object from the ServerSocket to listen and accept connections.
	// Open input and output streams

	while (true)
	{
	    try 
	    {
		serviceSocket = myServerice.accept();
          System.out.println("Client Connected");
		is = new BufferedReader (new InputStreamReader(serviceSocket.getInputStream()));
		os = new PrintStream(serviceSocket.getOutputStream());

		// As long as we receive data, echo that data back to the client.
		while ((line = is.readLine()) != null) 
		{
		    System.out.println(line);
		    os.println(line); 

PrintWriter pr = new PrintWriter(serviceSocket.getOutputStream());
        
           if(line.contains("ADD"))
          pr.println("200 OK The new Record ID is 1001");
           pr.flush();
   if(line.contains("DELETE"))
          pr.println("200 OK");
           pr.flush();
 if(line.contains("LIST"))
          pr.println("The list of records in the book:");
pr.println("1001 	Jinhua Guo 		313-583-6439");
pr.println("1002 	John Smith 		313-583-1234");
pr.println("1003 	Mary Miller 		313-594-4567");
           pr.flush();
 if(line.contains("SHUTDOWN"))
pr.println("200 OK");
           pr.flush();
 if(line.contains("QUIT"))
pr.println("200 OK");
           pr.flush();
		}



          
		//close input and output stream and socket
		is.close();
		os.close();
		serviceSocket.close();
	    }   
	    catch (IOException e) 
	    {
		System.out.println(e);
	    }
	}
    }
}
