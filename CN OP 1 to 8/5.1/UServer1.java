import java.net.*;
class UServer1
 {
   public static void main(String args[]) 
   throws Exception
   {
    DatagramSocket ds = new DatagramSocket(9875);    
    System.out.println("UDP Server");
    System.out.println("--------------");
    System.out.println("Server Ready...!");
    while(true)
	{
		byte[] b=new byte[1024];
		DatagramPacket dp=new DatagramPacket(b,b.length);
		ds.receive(dp);
		String str=new String(dp.getData(),0,0,dp.getLength());
		System.out.print("\nMessage Received from Client: " + str);
        if(str.equalsIgnoreCase("end")) 
		{
         break;
        }
    }
     ds.close();
     System.exit(0);
   }
}
		
		