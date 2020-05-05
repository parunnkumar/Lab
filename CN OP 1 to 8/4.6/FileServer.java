import java.net.*; 
import java.io.*;
public class FileServer 
{	
	public static void main(String args[])
	{
		try 
		{
			ServerSocket ss = new ServerSocket(3891); 
			byte b[] = new byte[1024];
			System.out.println("\nServer is listening on port "+ss.getLocalPort()+"..."); 
			while(true)
			{
				Socket s = ss.accept();
				System.out.println("New connection accepted " + s.getInetAddress() + ":" + s.getPort()); 
				int len=0, bytecount=0;
				System.out.println("Enter the name of the file to be saved: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
				String str = br.readLine();
				FileOutputStream fos = new FileOutputStream(str);
				BufferedInputStream bis = new BufferedInputStream(s.getInputStream(),1024); 
				while( (len = bis.read(b,0,1)) != -1)
				{
					fos.write(b,0,1); bytecount++;
				}
				System.out.println("Bytes Written: "+bytecount); 
				bis.close();
				fos.close();
				s.close();
				System.out.print("Press y if you want to exit: "); 
				str =  br.readLine(); 
				if(str.equalsIgnoreCase("y"))
				{
					ss.close(); 
					System.exit(0);
				}
			}
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
	}
}
