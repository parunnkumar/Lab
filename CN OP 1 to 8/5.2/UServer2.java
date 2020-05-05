import java.io.*;
import java.net.*;
class UServer2
{
	public static void main(String args[]) throws Exception
	{
		System.out.println("UDP SERVER"); 
		System.out.println("--------------");  
		DatagramSocket ds = new DatagramSocket(9876);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			byte[] rcvData = new byte[1024];
			byte[] sndData = new byte[1024];
			DatagramPacket rcvPacket = new DatagramPacket(rcvData,rcvData.length);
			ds.receive(rcvPacket);
			String str = new String(rcvPacket.getData(),0,0,rcvPacket.getLength());
			System.out.print("Message Received From Client: " + str);
			if(str.equalsIgnoreCase("end"))
			{
				ds.close(); System.exit(0);
			}
			System.out.print("\nEnter the Message to send to Client: ");
			str = br.readLine();
			InetAddress IPAddress = rcvPacket.getAddress();
			int port = rcvPacket.getPort();
			sndData = str.getBytes();
			DatagramPacket sndPacket = new DatagramPacket(sndData, sndData.length, IPAddress, port);
			ds.send(sndPacket);
			if(str.equalsIgnoreCase("end"))
			{
				ds.close();
				System.exit(0);
			}
		}
	}
}
