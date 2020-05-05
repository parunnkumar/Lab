import java.rmi.*; 
import java.net.*;
public class RmiServer
{
	public static void main(String args[]) throws RemoteException
	{
		try
		{
			FactImplementation fi = new FactImplementation();
			Naming.rebind("server", fi);
			System.out.println("Server ready");
		}
		catch(Exception e)
		{
			System.out.println("Exception:" + e);
		}
	}
}
