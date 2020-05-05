import java.io.*; 
import java.net.*; 
public class TalkClient
{
	TalkClient()
	{
		try
		{
			System.out.println("Talk Client");
			Socket s = new Socket("LocalHost",3453);	
			BufferedReader brUser = new BufferedReader(new InputStreamReader(System.in)); 
			PrintStream ps = new PrintStream(s.getOutputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream())); 
			String str;
			while(true)
			{
				System.out.println("Enter the message to send: "); 
				str = brUser.readLine();
				ps.println(str); 
				if(str.equalsIgnoreCase("end"))
				{
					ps.close();
					br.close();
					s.close(); 
					System.exit(0);
				}
				str = br.readLine(); 
				System.out.println("Message received: " + str); 
				if(str.equalsIgnoreCase("end"))
				{
					ps.close();
					br.close();
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
	new TalkClient();
}	
}

