import java.io.*;
import java.net.*;
class UClient2
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("UDP CLIENT");
		System.out.println("--------------");
		DatagramSocket ds = new DatagramSocket();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		InetAddress IPAddress = InetAddress.getByName("localhost");
		while(true)
		{
			byte[] sndData = new byte[1024];
			byte[] rcvData = new byte[1024];
			System.out.print("Enter the Message to send to Server: ");
			String str = br.readLine();
			sndData = str.getBytes();
			DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length,IPAddress, 9876);
			ds.send(sndPacket);
			if(str.equalsIgnoreCase("end"))
			{
				ds.close();
				System.exit(0);
			}
			DatagramPacket rcvPacket = new DatagramPacket(rcvData, rcvData.length);
			ds.receive(rcvPacket);
			str = new String(rcvPacket.getData(),0,0,rcvPacket.getLength());
			System.out.println("Message received from server: " + str);
			if(str.equalsIgnoreCase("end"))
			{
				ds.close();
				System.exit(0);
			}	
		}
	}	
}
 
