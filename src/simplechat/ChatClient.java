/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechat;
import java.io.*;
import java.net.Socket;
/**
 *
 * @author Aman Nautiyal
 */
public class ChatClient
{
 void runner() throws Exception
 {
  BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));
  System.out.print("Enter Ip:");
  String ip=Br.readLine();
  System.out.print("Enter port:");
  int port=Integer.parseInt(Br.readLine());
  Socket s=new Socket(ip, port);
  System.out.print("Enter name:");
  String name=Br.readLine();
  BufferedReader reader=new BufferedReader(new InputStreamReader(s.getInputStream()));
  PrintWriter writer=new PrintWriter(s.getOutputStream(),true);
   System.out.println("Server:"+reader.readLine());
  while(true)
  {
      System.out.print(name+":");
      String clientSay=Br.readLine();
      writer.println(clientSay);
      if(clientSay.equalsIgnoreCase("quit"))
          break;
       System.out.println("Server:"+reader.readLine());
  }
 }
}
