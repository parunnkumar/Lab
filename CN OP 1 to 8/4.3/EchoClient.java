import  java.io.*; 
import java.net.*; 
public class EchoClient
{	
	public static void main(String args[])
	{
		try
		{
			Socket s=new Socket("LocalHost",5362);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			BufferedReader brUser=new BufferedReader(new InputStreamReader(System.in)); 
			PrintWriter pw=new PrintWriter(s.getOutputStream());
			String str; 
			System.out.println("Echo-Client"); 
			System.out.println("--------------");
			while(true)
			{
				System.out.println("\nSend message to server: "); 
				str=brUser.readLine();
				pw.println(str); 
				pw.flush();
				if(str.equals("end"))
				{
					if(br!=null) br.close(); 
					if(pw!=null) pw.close(); 
					System.exit(0);
				}
				System.out.println("Message sent successfully!"); 
				System.out.println("Echo Message from server:"+br.readLine());
			}
		}
		catch(IOException e)
		{
			System.err.println(e);
		}
	}	
}
