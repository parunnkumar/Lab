import java.io.*; 
import java.net.*; 
class TServer1
{
	public static void main(String a[])throws IOException
	{
		ServerSocket ss=new ServerSocket(8000);
		Socket s=ss.accept();
		DataInputStream in=new DataInputStream(System.in);
		PrintStream dos=new PrintStream(s.getOutputStream()); 
		System.out.println("Server ready....!");
		while(true)
		{
			System.out.println("Enter message to send:"); 
			String str=in.readLine();
			dos.println(str);
 
			if(str.equals("end"))
			{
				ss.close(); 
				break;
			}
		}
	}
}
