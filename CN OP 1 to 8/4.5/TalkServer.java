import java.io.*; 
import java.net.*;
public class TalkServer{ TalkServer()
{
	try
	{
		ServerSocket ss = new ServerSocket(3453); 
		System.out.println("Talk Server\nServer is listening..."); 
		Socket s = ss.accept();
		PrintStream ps = new PrintStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
		BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in)); 
		String str;
		while(true)
		{
			str = br.readLine(); 
			System.out.println("Message received: "+ str); 
			if(str.equalsIgnoreCase("end"))
			{
				ps.close();
				br.close();
				ss.close();
				s.close(); 
				System.exit(0);
			}
			System.out.println("Enter the message to send: "); 
			str = brUser.readLine();
			ps.println(str); 
			if(str.equalsIgnoreCase("end"))
			{
				ps.close();
				br.close();
				ss.close();
				s.close(); 
				System.exit(0);
			}
		}
	}
	catch(Exception e)
	{
		System.err.println(e);
	}	
}
public static void main(String a[])
{
	new TalkServer();
}	
}

