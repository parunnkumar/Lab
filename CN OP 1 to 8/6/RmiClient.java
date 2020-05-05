import java.rmi.*;
import java.io.*;
public class RmiClient
{ 
	public static void main(String args[]) throws RemoteException
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the server name or ip address");
			String url = br.readLine();
			String host="rmi://" + url + "/server";
			FactInterface serv = (FactInterface) Naming.lookup(host);
			System.out.println("Enter a number:");
			int n = Integer.parseInt(br.readLine());
			int fact = serv.fact(n);
			System.out.println("Factorial of " + n + " is " + fact);
		}
		catch(Exception e)
		{
			System.out.println("Error " + e);
		}
	}
}
