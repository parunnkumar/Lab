import java.rmi.*;
public class AirTicketServer 
{
	AirTicketServer() throws Exception
	{
		AirTicket t = new AirTicketImpl();
		Naming.rebind("rmi://localhost:1099/AirTicketDetails", t);
	}
	public static void main(String a[]) throws Exception
	{
		new AirTicketServer();
	}
}

