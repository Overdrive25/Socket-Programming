// Java program to illustrate Server Side Programming 
import java.io.DataInputStream; 
import java.io.DataOutputStream; 
import java.io.IOException; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.StringTokenizer; 
  
public class TCPServer
{ 
    public static void main(String args[]) throws IOException 
    { 
  
        //Establish the socket connection. 
        ServerSocket ss = new ServerSocket(4444); 
        System.out.println("Server Started");
		System.out.println("Waiting for Client.....");
        Socket s = ss.accept(); 
        System.out.println("Client accepted");
        
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
  
        while (true) 
        { 
            // wait for input 
            String input = dis.readUTF(); 
  
            if(input.equals("exit")) 
                break; 
  
            int result; 
  
            // Use StringTokenizer to break the equation into operand and 
            // operation 
            StringTokenizer st = new StringTokenizer(input); 
            
            int p = Integer.parseInt(st.nextToken()); 
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            System.out.println("Values received ");
            System.out.println("p = "+p);
            System.out.println("r = "+r);
            System.out.println("n = "+n);
            System.out.println("t = "+t);
  
            // perform the required operation. 
            result = p*(1+r/n)^(n*t);
            System.out.println("Sending the result..."); 
  
            // send the result back to the client. 
            dos.writeUTF(Integer.toString(result)); 
        } 
    } 
} 
