import java.io.*; 
import java.net.*; 
class TClient2
{
	public static void main(String a[])throws IOException
	{
		Socket s=new Socket("LocalHost",5555);
		DataInputStream in=new DataInputStream(s.getInputStream()); 
		DataInputStream inn=new DataInputStream(System.in); 
		PrintStream dos=new PrintStream(s.getOutputStream());
		while(true)
		{
			String str=in.readLine(); 
			System.out.println("Message received :"+str);
			if(str.equals("end"))
			{
				s.close(); 
				break;
			}
			System.out.println("Enter the msg to send : "); 
			String str1=inn.readLine();
			dos.println(str1);
			if(str1.equals("end"))
			{	
				s.close(); 
				break;
			}
		}
	}
}
