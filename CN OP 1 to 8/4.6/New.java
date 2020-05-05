import java.net.*; 
import java.io.*;
public class FileClient 
{
	public static void main(String args[])
	{
		try
		{
			Socket s = new Socket("LocalHost", 3891);
			System.out.println("Connected with server "+s.getInetAddress()+ ":"+s.getPort()); 
			byte b[] = new byte[324];
			BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream(),1024); 
			System.out.println("Enter the file name to send: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
			String str = br.readLine();
			System.out.print("Press y if you want to view the file's contents: "); 
			String c = br.readLine();
			FileInputStream fis = new FileInputStream(str); 
			File f = new File(str); 
			if(c.equalsIgnoreCase("y"))
			{
				int total = 0, nRead = 0;
				while((nRead = fis.read(b)) != -1 && total<800)
				{
					System.out.println(new String(b));
					total += nRead;
				} 
				if(total<f.length())
				{
					System.out.println("...");
				}
				fis.close();
				fis = new FileInputStream(str);
			}	
			long len, bytecount=0; len=f.length();
			System.out.println("\nLength of the file to be transferred: " + len); 
			while((len=fis.read(b,0,1)) != -1)
			{
				bytecount++; bos.write(b,0,1); 
				bos.flush();
			}
			System.out.println("Bytes Sent: "+bytecount); 
			fis.close();
			bos.close();
			s.close(); 
			System.exit(0);
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
