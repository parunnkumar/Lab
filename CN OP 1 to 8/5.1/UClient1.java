import java.io.*;
import java.net.*;
class UClient1 
{
	public static void main(String args[]) throws Exception,BindException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		System.out.println("UDP Client");
		System.out.println("--------------");
		while(true)
		{
			byte[] b = new byte[1024];
			System.out.print("Enter the message to server: ");
			String str = br.readLine();
			b = str.getBytes();
			DatagramPacket dp = new DatagramPacket(b, b.length, IPAddress, 9875);
			ds.send(dp);
			if(str.equalsIgnoreCase("end"))
			{
				ds.close();
				System.exit(0);
			}
		}
	}
}