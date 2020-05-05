import java.io.*; 
import java.net.*;
public class EchoServer
{
	public static void main(String args[])throws Exception
	{
		String str;
		ServerSocket ss=new ServerSocket(5362); 
		System.out.println("Echo-Server"); 
		System.out.println("-------------------"); 
		Socket s=ss.accept();
		DataInputStream dis=new DataInputStream(s.getInputStream()); 
		PrintStream ps=new PrintStream(s.getOutputStream());
		while(true)
		{
			str=dis.readLine(); 
			if(str.equals("end"))
			{
				dis.close();
				ps.close(); 
				System.exit(0);
			}
			System.out.println("Message Received from Client : "+str); 
			ps.println(str);
			ps.flush();
			System.out.println("Message sent successfully!");
		}
	}
}
