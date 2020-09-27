// Java Program to illustrate Client Side implementation 
import java.io.*; 
import java.net.*;
import java.util.Scanner; 
  
public class UDPClient 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
  
        //Create the socket object for carrying the data 
        DatagramSocket ds = new DatagramSocket(); 
  
        InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
  
        // loop while user not enters "bye" 
        while (true) 
        { 
            System.out.println("Enter 'bye' to exit or enter values as: "); 
            System.out.println("'p r n t'"); 
            String inp = sc.nextLine(); 
            buf = new byte[65535]; 
  
            // convert the String input into the byte array. 
            buf = inp.getBytes(); 
  
            // Create the datagramPacket for sending the data. 
            DatagramPacket DpSend = 
                      new DatagramPacket(buf, buf.length, ip, 1234); 
  
            // invoke the send call to actually send the data. 
            ds.send(DpSend); 
  
            // break the loop if user enters "bye" 
            if (inp.equals("exit")) 
                break; 
  
            buf = new byte[65535]; 
            DatagramPacket DpReceive = 
                                 new DatagramPacket(buf, buf.length); 
            ds.receive(DpReceive); 
  
            System.out.println("Compound Interest = " + 
                                new String(buf,0,buf.length)); 
        } 
    } 
} 
