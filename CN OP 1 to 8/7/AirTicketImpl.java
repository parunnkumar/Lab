import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class AirTicketImpl extends UnicastRemoteObject implements AirTicket 
{
	AirTicketImpl() throws RemoteException 
	{
	
	}
	public double getTicketCost(int op) throws RemoteException
	{
		switch(op)
		{
			case 1 :
			return(5000*1.10);
			case 2:
			return(7000*1.1);
			case 3:
			return(4000*1.10);
			case 4:
			return(10000*1.10); 
			case 5:
			return(9000*1.1);
			default:
			return(-1);
		}
	}
	public double getTotalCost(double cost, int n) throws RemoteException
	{
		return (cost*n);
	}
	public int getArrivalTime(int op, int departTime) throws RemoteException
	{
		int time;
		switch(op)
		{
			case 1:
			time = departTime + 700;
			break;
			case 2:
			time = departTime + 1000;
			break;
			case 3:
			time = departTime + 500; 
			break;
			case 4:
			time = departTime + 1400; 
			break;
			case 5:
			time = departTime + 1200; 
			break;
			default:	
			return (-1);
		}
		if(time >= 2400)
		{
			time -= 2400;
		}
		return time;
	}
}

