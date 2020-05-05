import java.net.*;
class ARP
{
	public static void main(String args[])
	{ 
		InetAddress Ip;
		String Str;
		System.out.println("\t\tAddress Resolution Protocol"); 
		System.out.println("\t\t----------------------------");
		try
		{
			Ip = InetAddress.getLocalHost(); 
			System.out.println("IPAddress\n"+Ip);
			Str=Ip.toString();
			NetworkInterface Intf = NetworkInterface.getByInetAddress(Ip); 
			byte[] MAC =Intf.getHardwareAddress();
			StringBuilder sb = new StringBuilder(); 
			for (int i = 0; i < MAC.length; i++)
			{
				String s = ""+MAC[i]; 
				if(i < MAC.length - 1)
				{ 
					s = ""+MAC[i];
				}
				int j=Integer.parseInt(s);
				String s1=Integer.toHexString(j);
				if(s1.length()>2)
				{
					int l=s1.length()-2; 
					s1 = s1.substring(l);
				}
				if(i != 0)
				{
					s1 = "-"+s1;
				}
				sb.append(s1);
			}
			System.out.println("NetworkInterface Name \n" +Intf.getDisplayName()); 
			System.out.println("\nMACAddress");
			for (int i = 0; i < MAC.length; i++)
			{
				System.out.format("%02X%s", MAC[i], (i < MAC.length - 1) ? "-" : "");
			}
		}
		catch(Exception e)
		{ 
			System.out.println("Exception"+e);
		}
		System.out.println();
	}
}
