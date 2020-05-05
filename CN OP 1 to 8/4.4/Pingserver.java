import java.io.*; 
import java.net.*; 
public class Pingserver
{
	public static void main(String args[])
	{
		try
		{
			String str;
			ServerSocket ss=new ServerSocket(6523); 
			Socket s=ss.accept();
			DataInputStream dis=new DataInputStream(s.getInputStream()); 
			PrintStream ps=new PrintStream(s.getOutputStream());
			System.out.println("Ping Server");
			System.out.println("----------------"); 
			for(int i=0;i<4;i++)
			{
				str=dis.readLine();
				System.out.println("Pinged By Client!");
				ps.println(str+": bytes=32 time<1ms TTL=128");
			}
			dis.close();
			ps.close();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
