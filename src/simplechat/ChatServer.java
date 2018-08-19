/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;

import java.io.*;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Aman Nautiyal
 */
public class ChatServer 
{
    Inet4Address serverIp;
    ServerSocket s;
    BufferedReader Br;
    public ChatServer() throws IOException
    {
      Br=new BufferedReader(new InputStreamReader(System.in));
      initialise();
    }
    private void initialise() throws IOException
    {
     System.out.print("Enter the port:");
     int port=Integer.parseInt(Br.readLine());
     s=new ServerSocket(port);
    }
    public void process() throws Exception
    {
     while(true)
     {
      System.out.println("Waiting..");
      Socket client=s.accept();
      System.out.println("Connection made.");
      BufferedReader reader=new BufferedReader(new InputStreamReader(client.getInputStream()));
      PrintWriter writer=new PrintWriter(client.getOutputStream(),true);
      writer.println("Connected to Server.Your IP is "+client.getInetAddress().getHostAddress());
      while(true)
      {
        System.out.print("Client:");
        String clientSay=reader.readLine();
        System.out.println(clientSay);
        if(clientSay.equalsIgnoreCase("quit"))
            break;
        System.out.print("Server: ");
        String serverSay=Br.readLine();
        writer.println(serverSay);
      }
     }
    }
}
