import java.net.*;
import java.io.*;
class RandomPort
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket server=new ServerSocket(0);
			System.out.println("This server runs on port" + server.getLocalPort());
		}
		catch(IOException e)
		{
		System.err.println(e);
		}
	}
}
		