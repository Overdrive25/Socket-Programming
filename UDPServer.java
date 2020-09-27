// Java Program to illustrate Server Side implementation 
import java.io.*; 
import java.net.*;
import java.util.StringTokenizer; 
  
public class UDPServer 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(1234); 
        System.out.println("Server Started");
		System.out.println("Waiting for Client.....");
		
        byte[] buf = null; 
        DatagramPacket DpReceive = null; 
        DatagramPacket DpSend = null; 
        while (true) 
        { 
            buf = new byte[65535]; 
  
            // create a DatgramPacket to receive the data. 
            DpReceive = new DatagramPacket(buf, buf.length); 
            
  
            // receive the data in byte buffer. 
            ds.receive(DpReceive); 
            System.out.println("Client accepted");
  
            String inp = new String(buf, 0, buf.length); 
  
            //To remove extra spaces. 
            inp=inp.trim(); 
            // Use StringTokenizer to break the 
            // equation into operand and operation 
            StringTokenizer st = new StringTokenizer(inp); 
  
            int p = Integer.parseInt(st.nextToken()); 
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            System.out.println("Values received ");
            System.out.println("p = "+p);
            System.out.println("r = "+r);
            System.out.println("n = "+n);
            System.out.println("t = "+t);
  
            // Exit the server if the client sends "bye" 
            if (inp.equals("exit")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            int result; 
  
            // perform the required operation. 
            result = p*(1+r/n)^(n*t);
  
            System.out.println("Sending the result..."); 
            String res = Integer.toString(result); 
  
            // Clear the buffer after every message. 
            buf = res.getBytes(); 
  
            // get the port of client. 
            int port = DpReceive.getPort(); 
  
            DpSend = new DatagramPacket(buf, buf.length, 
                          InetAddress.getLocalHost(), port); 
            ds.send(DpSend); 
        } 
    } 
} 

