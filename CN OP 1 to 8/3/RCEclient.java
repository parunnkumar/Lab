import java.io.*;
import java.net.*; 
import java.lang.*; 
public class RCEclient
{
	public static void main(String a[])throws UnknownHostException,IOException
	{
		Socket c=new Socket("localhost",1680); 
		System.out.println("Enter the command:");
		DataInputStream dis=new DataInputStream(System.in); 
		String s=dis.readLine();
		OutputStream os=c.getOutputStream(); 
		DataOutputStream dos=new DataOutputStream(os);

		dos.write(s.getBytes()); 
		dos.close();
		dis.close();
		c.close();
	}
}
