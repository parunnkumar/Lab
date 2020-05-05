import java.io.*;
import java.net.*;
class TServer2
{
	public static void main(String a[])throws IOException
	{
		ServerSocket ss=new ServerSocket(5555); 
		Socket s=ss.accept();
		PrintStream dos=new PrintStream(s.getOutputStream()); 
		DataInputStream in=new DataInputStream(System.in); 
		DataInputStream inn=new DataInputStream(s.getInputStream()); 
		System.out.println("Server Ready!! ");
		while(true)
		{
			System.out.println("Enter the msg to send: "); 
			String str=in.readLine();
			dos.println(str); 
			if(str.equals("end"))
			{	
				ss.close(); 
				break;
			}
			String str1=inn.readLine(); 
			System.out.println("Msg received :"+str1);
			if(str1.equals("end"))
			{
				ss.close(); 
				break;
			}
		}
	}
}
