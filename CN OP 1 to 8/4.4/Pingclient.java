import  java.io.*;
import java.net.*;
public class Pingclient
{
	public static void main(String args[]) throws Exception
	{ 
		int i,j,k;
		System.out.println("Ping Client"); System.out.println("---------------");
		System.out.print("Enter the IP address:");
		DataInputStream disUser=new DataInputStream(System.in);
		String ip=disUser.readLine();
		Socket s=new Socket(ip,6523);
		BufferedReader br=new BufferedReader(new  InputStreamReader(s.getInputStream()));
		PrintWriter pw=new PrintWriter(s.getOutputStream());
		System.out.println("\n Pinging ["+ip+"] with 32 bytes of data:\n");
		String str;
		for(i=0;i<4;i++)
		{
			pw.println(ip);
			pw.flush();
			str=br.readLine();
			if(str!=null) 
			{
				for(j=0;j<20000;j++)
				{
					for(k=0;k<50000;k++);
				}	
				System.out.println("Reply from "+str);
			}
			else
			{
			for(i=0;i<4;i++)
			{
				for(j=0;j<10000;j++)
				{
					for(k=0;k<50000;k++);
				}
				System.out.println("\n Request Timed Out!");
				}
			}
		}
		if(br!=null)
			br.close(); 
		if(pw!=null) 
			pw.close();
		s.close();
	}
}
